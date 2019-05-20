package ar.com.eduit.curso.java.repositories.jdbc;
import ar.com.eduit.curso.java.entities.Alumno;
import ar.com.eduit.curso.java.repositories.interfaces.I_AlumnoR;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class AlumnoR implements I_AlumnoR {
    private Connection conn;
    public AlumnoR(Connection conn) { this.conn = conn; }
    @Override public void save(Alumno alumno) {
        if(alumno==null) return;
        String query="insert into alumnos (nombre,apellido,edad,idCurso) values (?,?,?,?)";
        try (PreparedStatement ps=conn.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS)){
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setInt(3, alumno.getEdad());
            ps.setInt(4, alumno.getIdCurso());
            ps.execute();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()) alumno.setId(rs.getInt(1));
        } catch (Exception e) { e.printStackTrace(); }
    }
    @Override public void remove(Alumno alumno) {
        if(alumno==null) return;
        String query="delete from alumnos where id="+alumno.getId();
        try (Statement st=conn.createStatement()){
            st.execute(query);
        } catch (Exception e) { e.printStackTrace(); }
    }
    @Override public void update(Alumno alumno) {
        if(alumno==null) return;
        String query="update alumnos set nombre=?, apellido=?, edad=?, idCurso=? where id=?";
        try (PreparedStatement ps=conn.prepareStatement(query)) {
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setInt(3, alumno.getEdad());
            ps.setInt(4, alumno.getIdCurso());
            ps.setInt(5, alumno.getId());
            ps.execute();
        } catch (Exception e) { e.printStackTrace(); }
    }
    @Override public List<Alumno> getAll() {
        String query="select * from alumnos";
        List<Alumno>lista=new ArrayList();
        try (ResultSet rs=conn.createStatement().executeQuery(query)){
            while(rs.next()){
                lista.add(new Alumno(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("edad"),
                        rs.getInt("idCurso")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return lista;
    }
    
}
