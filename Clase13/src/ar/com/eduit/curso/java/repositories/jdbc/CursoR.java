package ar.com.eduit.curso.java.repositories.jdbc;
import ar.com.eduit.curso.java.entities.Alumno;
import ar.com.eduit.curso.java.entities.Curso;
import ar.com.eduit.curso.java.enumerados.Dia;
import ar.com.eduit.curso.java.enumerados.Turno;
import ar.com.eduit.curso.java.repositories.interfaces.I_CursoR;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class CursoR implements I_CursoR {
    private Connection conn;
    public CursoR(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public void save(Curso curso) {
        if(curso==null) return;
        //String query="insert into curso (titulo,profesor,dia,turno) values "
        //        + "('"+curso.getTitulo()+"','"+curso.getProfesor()
        //        +"','"+curso.getDia()+"','"+curso.getTurnos()+"')";
        
        //PreparedStatement
        String query="insert into cursos (titulo,profesor,dia,turno) values (?,?,?,?)";
        try (PreparedStatement ps=conn.prepareStatement(
                query,PreparedStatement.RETURN_GENERATED_KEYS
        )){
            ps.setString(1, curso.getTitulo());
            ps.setString(2, curso.getProfesor());
            ps.setString(3, curso.getDia().toString());
            ps.setString(4, curso.getTurnos().toString());
            ps.execute();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()) curso.setId(rs.getInt(1));
        } catch (Exception e) { e.printStackTrace(); }
    }
    @Override public void remove(Curso curso) {
        if(curso==null) return;
        String query="delete from cursos where id="+curso.getId();
        try (Statement st=conn.createStatement()){
            st.execute(query);
        } catch (Exception e) { e.printStackTrace(); }
    }
    @Override public void update(Curso curso) {
        if(curso==null) return;
        String query="update cursos set titulo=?, profesor=?, dia=?, turno=? where id=?";
        try (PreparedStatement ps=conn.prepareStatement(query)){
            ps.setString(1, curso.getTitulo());
            ps.setString(2, curso.getProfesor());
            ps.setString(3, curso.getDia().toString());
            ps.setString(4, curso.getTurnos().toString());
            ps.setInt(5, curso.getId());
            ps.execute();
        } catch (Exception e) { e.printStackTrace(); }
    }
    @Override
    public List<Curso> getAll() {
        String query="select * from cursos";
        List<Curso>lista=new ArrayList();
        try(ResultSet rs=conn.createStatement().executeQuery(query)){
            while(rs.next()){
                lista.add(new Curso(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("profesor"),
                        Dia.valueOf(rs.getString("dia")),
                        Turno.valueOf(rs.getString("turno"))
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return lista;
    }
}