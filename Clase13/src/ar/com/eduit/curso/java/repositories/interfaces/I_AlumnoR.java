package ar.com.eduit.curso.java.repositories.interfaces;
import ar.com.eduit.curso.java.entities.Alumno;
import ar.com.eduit.curso.java.entities.Curso;
import java.util.List;
import java.util.stream.Collectors;
public interface I_AlumnoR {
    void save(Alumno alumno);
    void remove(Alumno alumno);
    void update(Alumno alumno);
    default Alumno getById(int id){
        List<Alumno>lista=getAll()
                .stream()
                .filter(a->a.getId()==id)
                .collect(Collectors.toList());
        return (lista.isEmpty())?null:lista.get(0);
    }
    List<Alumno> getAll();
    default List<Alumno> getLikeApellidoNombre(String apellido,String nombre){
        return getAll()
                .stream()
                .filter(a->a.getApellido().toLowerCase().contains(apellido.toLowerCase())
                    || a.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }
    default List<Alumno> getByCurso(Curso curso){
        return getAll()
                .stream()
                .filter(a->a.getIdCurso()==curso.getId())
                .collect(Collectors.toList());
    }
}