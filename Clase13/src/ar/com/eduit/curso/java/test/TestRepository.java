package ar.com.eduit.curso.java.test;
import ar.com.eduit.curso.java.connector.ConnectorMySQL;
import ar.com.eduit.curso.java.entities.Alumno;
import ar.com.eduit.curso.java.entities.Curso;
import ar.com.eduit.curso.java.enumerados.Dia;
import ar.com.eduit.curso.java.enumerados.Turno;
import ar.com.eduit.curso.java.repositories.jdbc.AlumnoR;
import ar.com.eduit.curso.java.repositories.jdbc.CursoR;
public class TestRepository {
    public static void main(String[] args) {
        //CursoR cr=new CursoR(ConnectorMySQL.getConnection());
        //Curso curso=new Curso("C++", "Uriel", Dia.lunes, Turno.tarde);
        //cr.save(curso);
        //System.out.println(curso);
        
        //cr.remove(cr.getById(3));
        /*
        Curso cursoX=cr.getById(4);
        if(cursoX!=null){
            cursoX.setTitulo("C#");
            cr.update(cursoX);
        }
        */
        //cr.getAll().forEach(System.out::println);
        
        //cr.getLikeTitulo("ja").forEach(System.out::println);
        
        //cr.getLikeProfesor("G").forEach(System.out::println);
        
        //cr.getLikeTituloProfesorDiaTurno("", "", Dia.martes, Turno.tarde).forEach(System.out::println);
        
        AlumnoR ar=new AlumnoR(ConnectorMySQL.getConnection());
        Alumno alumno=new Alumno("Gabriel","Lopez",22,1);
        ar.save(alumno);
        ar.getAll().forEach(System.out::println);
        
        
    }
}