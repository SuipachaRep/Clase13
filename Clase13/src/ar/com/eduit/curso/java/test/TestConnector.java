package ar.com.eduit.curso.java.test;
import ar.com.eduit.curso.java.connector.ConnectorMySQL;
import java.sql.Connection;
import java.sql.Statement;
public class TestConnector {
    public static void main(String[] args) throws Exception {
        Connection conn=ConnectorMySQL.getConnection();
        Statement st=conn.createStatement();
        String query="insert into cursos (titulo,profesor,dia,turno) values "
                + "('HTML','Gomez','martes','tarde')";
        st.execute(query);
        st.close();
        
        ConnectorMySQL.getConnection().createStatement().execute(
                "insert into cursos (titulo,profesor,dia,turno) values "
                        + "('Java','Torres','jueves','noche')"
        );
        
    }
}