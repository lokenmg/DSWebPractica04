/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author loken
 */
public class Pool {
    private static BasicDataSource ds = null;
    public static BasicDataSource getDataSource(){
        if (ds==null){
            ds = new BasicDataSource();
            ds.setDriverClassName("org.postgresql.Driver");
            ds.setUsername("postgres");
            ds.setPassword("postgres");
            ds.setUrl("jdbc:postgresql://172.17.0.2:5432/mydb");
            ds.setInitialSize(50);
            ds.setMaxIdle(10);
            ds.setMaxTotal(20);
            ds.setMaxWaitMillis(5000);
        }
        return ds;
    }
    
    public static Connection getConexion() throws SQLException {
        return getDataSource().getConnection();
    }
}
