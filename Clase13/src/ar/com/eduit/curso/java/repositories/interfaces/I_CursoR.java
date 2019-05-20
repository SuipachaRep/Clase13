package ar.com.eduit.curso.java.repositories.interfaces;
import ar.com.eduit.curso.java.entities.Alumno;
import ar.com.eduit.curso.java.entities.Curso;
import ar.com.eduit.curso.java.enumerados.Dia;
import ar.com.eduit.curso.java.enumerados.Turno;
import java.util.List;
import java.util.stream.Collectors;
public interface I_CursoR {
    void save(Curso curso);
    void remove(Curso curso);
    void update(Curso curso);
    default Curso getById(int id){
        List<Curso>lista=getAll()
                .stream()
                .filter(c->c.getId()==id)
                .collect(Collectors.toList());
        return (lista.isEmpty())?null:lista.get(0);
    }
    default Curso getByAlumno(Alumno alumno){
        List<Curso>lista=getAll()
                .stream()
                .filter(c->c.getId()==alumno.getIdCurso())
                .collect(Collectors.toList());
        return (lista.isEmpty())?null:lista.get(0);
    }
    List<Curso> getAll();
    default List<Curso> getLikeTitulo(String titulo){
        return getAll()
                .stream()
                .filter(c->c.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .collect(Collectors.toList());
    }
    default List<Curso> getLikeProfesor(String profesor){
        return getAll()
                .stream()
                .filter(c->c.getProfesor().toLowerCase().contains(profesor.toLowerCase()))
                .collect(Collectors.toList());
    }
    default List<Curso> getLikeTituloProfesor(String titulo,String profesor){
        return getAll()
                .stream()
                .filter(c->c.getTitulo().toLowerCase().contains(titulo.toLowerCase())
                        || c.getProfesor().toLowerCase().contains(profesor.toLowerCase()))
                .collect(Collectors.toList());
    }
    default List<Curso> getLikeTituloProfesorDiaTurno(String titulo,String profesor,Dia dia,Turno turno){
        return getAll()
                .stream()
                .filter(c->c.getTitulo().toLowerCase().contains(titulo.toLowerCase())
                        && c.getProfesor().toLowerCase().contains(profesor.toLowerCase())
                        && c.getDia()==dia && c.getTurnos()==turno)
                .collect(Collectors.toList());
    }
}