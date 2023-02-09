/*
CONEXION A LA BASE DE DATOS
 */
package BaseDeDatos;
import java.sql.*;
import javax.swing.JOptionPane;
public class ConexionMySQL {

    public String db = "farmacia_sanrafael";
    public String url = "jdbc:mysql://localhost/"+db;
    public String user = "root";
    public String pass = "bryan";

    public ConexionMySQL()
    {
        
    }

    public Connection getConnection()
    {
        Connection link = null;
        try
        {
            //Cargamos el Driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Creamos un enlace hacia la base de datos
            link = DriverManager.getConnection(this.url, this.user, this.pass);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return link;  
    }    
}

