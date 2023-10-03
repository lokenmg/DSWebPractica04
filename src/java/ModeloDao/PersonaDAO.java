/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDao;

import Config.Conexion;
import Interfaces.CRUD;
import Modelo.Persona;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author loken
 */
public class PersonaDAO implements CRUD {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Persona p = new Persona();

    @Override
    public List listar() {
        ArrayList<Persona> list = new ArrayList<>();
        String sql = "select * from empleado";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Persona per = new Persona();
                per.setClave(rs.getString("clave"));
                per.setNombre(rs.getString("nombre"));
                per.setDireccion(rs.getString("direccion"));
                per.setTelefono(rs.getString("telefono"));
                list.add(per);
            }
        } catch (Exception e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    @Override
    public Persona list(String id) {
        
        String sql = "select * from empleado where clave=" + id;
        Persona per = new Persona();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                per.setClave(rs.getString("clave"));
                per.setNombre(rs.getString("nombre"));
                per.setDireccion(rs.getString("direccion"));
                per.setTelefono(rs.getString("telefono"));
            }
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
        return per;
    }

    @Override
    public boolean add(Persona per) {
        String sql = "insert into empleado(clave, nombre, direccion, telefono) values('"
                + per.getClave() + "','" + per.getNombre() + "','" + per.getDireccion() + "','" + per.getTelefono() + "');";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    @Override
    public boolean edit(Persona per) {
        if (per != null) {

            try {
                String sql = "UPDATE  empleado SET nombre='" + per.getNombre() + "',direccion='" + per.getDireccion() + "',telefono = '"+ 
                        per.getTelefono() + "' WHERE clave= '" + per.getClave() +"'";
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                ps.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(String id) {
        try {
            String sql="DELETE FROM empleado WHERE clave= '"+ id + "'";
            
            con= cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
