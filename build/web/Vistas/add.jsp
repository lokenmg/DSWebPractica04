<%-- 
    Document   : add
    Created on : 28 sep 2023, 17:20:28
    Author     : loken
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>Agregar Persona</h1>
            <form action="Controlador">
                ID:<br>
                <input type="text" name="txtclave">
                <br>Nombre:<br>
                <input type="text" name="txtnombre">
                <br>Direccion:<br>
                <input type="text" name="txtdireccion">
                <br>telefono:<br>
                <input type="text" name="txttelefono">
                <input type="submit" name="accion" value="Agregar"><br>
            </form>
        </div>
    </body>
</html>
