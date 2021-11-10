<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Registro"%>

<%
    Registro pro = (Registro)request.getAttribute("pro");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> 
            <c:if test="${pro.id == 0}">
                Nuevo Registro
            </c:if>
            <c:if test="${pro.id != 0}">
                 Editar Registro
            </c:if>
            
        </h1>
        <form action ="MainController" method="post">
            <table>
                <input type="hidden" name="id" value="${pro.id}">
                <tr>
                <td>Titulo</td>
                <td><input type="text" name="titulo" value="${pro.titulo}"></td>
                </tr>
                <tr>
                <td>Expositor</td>
                <td><input type="text" name="expositor" value="${pro.expositor}"></td>
                </tr>
                <tr>
                <td>Fecha</td>
                <td><input type="date" name="fecha" value="${pro.fecha}"></td>  
                </tr>
                <tr>
                    <td>Horas</td>
                   <td><select name="hora" value="${pro.hora}">

                    <option>7:00 - 8:00</option>

                    <option>8:00 - 10:00</option>
                    
                    <option>10:00 - 12:00</option>
                    
                    <option>14:00 - 15:00</option>

                    <option>16:00 - 17:00</option>
                    
                    <option>18:00 - 19:00</option>

                    <option>20:00 - 21:00</option>

                    <option selected>21:00 - 22:00</option>

                    </select>
                       
                </select></td>
                </tr>
                <tr>
                <td>Cupos</td>
                <td><input type="text" name="cupo" value="${pro.cupo}"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Enviar"></td>
                </tr>
            </table>  
        </form>
   
    </body>
</html>
