<%-- 
    Document   : edit
    Created on : 28 sep 2023, 17:20:36
    Author     : loken
--%>

<%@page import="Modelo.Persona"%>
<%@page import="ModeloDao.PersonaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            PersonaDAO dao=new PersonaDAO();
             String clave = (String)request.getAttribute("claveEmp");
             System.out.println(clave);
             Persona p = dao.list(clave);
        %>
            <form action="Controlador">
                ID:<br>
                <input type="text" name="txtclave" value="<%= p.getClave() %>">
                <br>Nombre:<br>
                <input type="text" name="txtnombre" value="<%= p.getNombre() %>">
                <br>Direccion:<br>
                <input type="text" name="txtdireccion" value="<%= p.getDireccion() %>">
                <br>telefono:<br>
                <input type="text" name="txttelefono" value="<%= p.getTelefono() %>">
                <input type="hidden" name="txtClave" value="" >
                <input type="submit" name="accion" value="Actualizar"><br>
                <a href="Controlador?accion=listar">Regresar</a>
            </form>
    </body>
</html>
