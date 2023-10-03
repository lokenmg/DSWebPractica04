/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author loken
 */
public class Conexion {
    private Connection con = null;
    private static Conexion s=null;
    public static Conexion getInstance() {
        if(s==null){
            s=new Conexion();
        }
        return s;
    }
   
    public Conexion(){
        try{
            String url = "jdbc:postgresql://172.17.0.2:5432/mydb";
            String pws = "postgres";
            String user = "postgres";
            
            Class.forName("org.postgresql.Driver");
            try {
                con = DriverManager.getConnection(url, user, pws);
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            Logger.getLogger(Conexion.class.getName()).log(Level.INFO, "se conecto");
        }catch (ClassNotFoundException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getConnection(){
        return con;
    }
}
