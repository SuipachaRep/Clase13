package ar.com.eduit.curso.java.entities;
import ar.com.eduit.curso.java.enumerados.Dia;
import ar.com.eduit.curso.java.enumerados.Turno;
public class Curso {
    private int id;
    private String titulo;
    private String profesor;
    private Dia dia;
    private Turno turnos;

    public Curso() {
    }

    public Curso(String titulo, String profesor, Dia dia, Turno turnos) {
        this.titulo = titulo;
        this.profesor = profesor;
        this.dia = dia;
        this.turnos = turnos;
    }

    public Curso(int id, String titulo, String profesor, Dia dia, Turno turnos) {
        this.id = id;
        this.titulo = titulo;
        this.profesor = profesor;
        this.dia = dia;
        this.turnos = turnos;
    }

    @Override
    public String toString() {
        return "Curso{" + "id=" + id + ", titulo=" + titulo + ", profesor=" + profesor + ", dia=" + dia + ", turnos=" + turnos + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public Turno getTurnos() {
        return turnos;
    }

    public void setTurnos(Turno turnos) {
        this.turnos = turnos;
    }
    
}