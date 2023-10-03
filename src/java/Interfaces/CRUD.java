/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Modelo.Persona;
import java.util.List;
/**
 *
 * @author loken
 */
public interface CRUD {
    public List listar();
    public Persona list(String id);
    boolean add(Persona per);
    boolean edit(Persona per);
    boolean eliminar(String id);
}
