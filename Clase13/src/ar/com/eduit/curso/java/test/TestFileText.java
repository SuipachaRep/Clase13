package ar.com.eduit.curso.java.test;
import ar.com.eduit.curso.java.utils.files.FileText;
import ar.com.eduit.curso.java.utils.files.I_File;
import java.util.ArrayList;
import java.util.List;
public class TestFileText {
    public static void main(String[] args) {
        //String file="c:/texto.txt";
        String file="texto.txt";
        I_File fileText=new FileText(file);
        
        fileText.setText("Curso de Java Mayo 2019.\n");
        fileText.appendText("Primavera.\n");
        fileText.appendText("Verano.\n");
        fileText.appendText("Otoño.\n");
        fileText.appendText("Invierno.\n");
        
        //fileText.clear();
        List<String>semana=new ArrayList();
        semana.add("Lunes");
        semana.add("Lunes");
        semana.add("Martes");
        semana.add("Miércoles");
        semana.add("Jueves");
        semana.add("Viernes");
        semana.add("Viernes");
        semana.add("Sábado");
        semana.add("Domingo");
        
        fileText.addLines(semana);
        
        //fileText.print();
        //System.out.println(fileText.getText());
        
        //fileText.getLines("l").forEach(System.out::println);
        //fileText.getSortedLines().forEach(System.out::println);
        //fileText.getReversedLines().forEach(System.out::println);
        //fileText.getLinkedHashSetLines().forEach(System.out::println);
        fileText.getTreeSetLines().forEach(System.out::println);
        //fileText.getLines().forEach(System.out::println);
        
    }
}