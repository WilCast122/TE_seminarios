<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Registro"%>
<%@page import="java.util.List"%>
<%
  List<Registro> lista = (List<Registro>) request.getAttribute("lista");  
 %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center> <table border ="1">
            <tr>
                    <td>SEGUNDO PARCIAL TEM-742
                        <br>
                        Nombre: Fidel Wilmer Castro Rocha
                        <br>
                        Carnet: 8269102 LP</td>
                </tr></table></center>
        
    <center><h1>Registro de Seminarios</h1>
        <p><a href="MainController?op=nuevo">Nuevo Registro</a></p>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Titulo</th>
                <th>Expositor</th>
                <th>Fecha</th>
                <th>Horas</th>
                <th>Cupos</th>
                <th></th>
                <th></th>
            </tr>
            
            <c:forEach var="item" items="${lista}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.titulo}</td>
                    <td>${item.expositor}</td>
                    <td>${item.fecha}</td>
                    <td>${item.hora}</td>
                    <td>${item.cupo}</td>
                    <td><a href="MainController?op=editar&id=${item.id}">Editar</a></td>
                    <td><a href="MainController?op=eliminar&id=${item.id}"
                   onclick="return(confirm('Esta seguro ???'))">Eliminar</a></td>
                   
                </tr>   
            </c:forEach>
        </table>
        </center>
    </body>
</html>