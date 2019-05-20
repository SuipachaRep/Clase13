package ar.com.eduit.curso.java.utils.swing;
import java.lang.reflect.Field;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Table <E>{
    public void cargar(JTable tbl,List<E> lista){
        if(tbl==null) return;
        DefaultTableModel dtm = new DefaultTableModel();
        tbl.setModel(dtm);
        if(lista==null  || lista.isEmpty()) return;
        E e=lista.get(0); 
        Field[] campos = e.getClass().getDeclaredFields();
        for(int a=0;a<campos.length;a++){
            dtm.addColumn(campos[a].getName());
            
        }
        for(E i:lista){
         Object[] fila = new Object[campos.length];
         for(int a=0; a<campos.length;a++){
             String metodo = "get"
                     +campos[a].getName().substring(0,1).toUpperCase()
                     +campos[a].getName().substring(1);
             try{
                   fila[a]=e.getClass().getMethod(metodo, null).invoke(i, null);
                }catch(Exception ee){ ee.printStackTrace();}
             dtm.addRow(fila);
         } 
        }
        
        
    }
}