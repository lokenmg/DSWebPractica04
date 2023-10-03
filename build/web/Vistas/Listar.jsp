<%-- 
    Document   : Listar
    Created on : 28 sep 2023, 17:20:19
    Author     : loken
--%>

<%@page import="Modelo.Persona"%>
<%@page import="ModeloDao.PersonaDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <a href="Controlador?accion=add">Agregar</a>
            <h1>Tabla</h1>
            <table border="1">
                <thead>
                    <tr>
                        <th>Clave</th>
                        <th>Nombre</th>
                        <th>Dirección</th>
                        <th>Teléfono</th>
                        <th>accion </th>
                    </tr>
                </thead>
                <%
                    PersonaDAO dao=new PersonaDAO();
                    List<Persona>list =dao.listar();
                    Iterator<Persona>iter=list.iterator();
                    Persona per = null;
                    while (iter.hasNext()) {
                            per=iter.next();
                            
                %>
                <tbody>
                    <tr>
                        <td><%= per.getClave() %></td>
                        <td><%= per.getNombre() %></td>
                        <td><%= per.getDireccion() %></td>
                        <td><%= per.getTelefono() %></td>
                        <td>
                            <a href="Controlador?accion=editar&clave=<%= per.getClave() %>">Edit</a>
                            <a href="Controlador?accion=eliminar&clave=<%= per.getClave() %>">Remove</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
