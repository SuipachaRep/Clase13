package ar.com.eduit.curso.java.utils.files;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeSet;
public interface I_File {
    void print();
    String getText();
    void setText(String text);
    void appendText(String text);
    void clear();
    void addLine(String line);
    void addLines(Collection<String> lines);
    List<String> getLines();
    List<String> getLines(String filter);
    List<String> getSortedLines();
    List<String> getReversedLines();
    LinkedHashSet<String> getLinkedHashSetLines();
    TreeSet<String> getTreeSetLines();
    void removeLine(String line);
}