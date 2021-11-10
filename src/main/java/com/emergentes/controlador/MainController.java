package com.emergentes.controlador;

import com.emergentes.modelo.Registro;
import com.emergentes.utiles.ConexionDB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String op;
            op = (request.getParameter("op") != null) ? request.getParameter("op") : "list";
            ArrayList<Registro> lista = new ArrayList<Registro>();
            ConexionDB canal = new ConexionDB();
            Connection conn = canal.conectar();
            PreparedStatement ps;
            ResultSet rs;
            if (op.equals("list")){
                String sql = "select * from seminarios";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Registro pro = new Registro();
                    pro.setId(rs.getInt("id"));
                    pro.setTitulo(rs.getString("titulo"));
                    pro.setExpositor(rs.getString("expositor"));
                    pro.setFecha(rs.getString("fecha"));
                    pro.setHora(rs.getString("hora"));
                    pro.setCupo(rs.getInt("cupo"));
                    lista.add(pro);
                }
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            if  
                (op.equals("nuevo")){
                Registro li = new Registro();
                    System.out.println(li.toString());
                    request.setAttribute("pro", li);
                    request.getRequestDispatcher("editar.jsp").forward(request, response);
                }
            if 
                (op.equals("eliminar")) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    String sql = "delete from seminarios where id = ?";
                    ps = conn.prepareStatement(sql);
                    ps.setInt(1, id);
                    ps.executeUpdate();
                    
                    response.sendRedirect("MainController");
            }
           if (op.equals("editar")) {
           int id = Integer.parseInt(request.getParameter("id"));
         
               Registro pro1= new Registro();
               ps=conn.prepareStatement("select * from seminarios where id=?");
               ps.setInt(1, id);
               rs= ps.executeQuery();
               if(rs.next()){
                   pro1.setId(rs.getInt("id"));
                   pro1.setTitulo(rs.getString("titulo"));
                   pro1.setExpositor(rs.getString("expositor"));
                   pro1.setFecha(rs.getString("fecha"));
                   pro1.setHora(rs.getString("hora"));
                   pro1.setCupo(rs.getInt("cupo"));
                   
               request.setAttribute("pro", pro1);
               request.getRequestDispatcher("editar.jsp").forward(request, response);
               }
           }
        }
        catch (SQLException ex){
               System.out.println("ERROR AL CONECTAR"+ex.getMessage());
              }
        }
        
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println("Valor de ID " + id);
            String titulo = request.getParameter("titulo");
            String expositor = request.getParameter("expositor");
            String fecha = request.getParameter("fecha");
            String hora = request.getParameter("hora");
            int cupo = Integer.parseInt(request.getParameter("cupo"));
            
           
            Registro pro = new Registro();
            pro.setId(id);
            pro.setTitulo(titulo);
            pro.setExpositor(expositor);
            pro.setFecha(fecha);
            pro.setHora(hora);
            pro.setCupo(cupo);
            
            ConexionDB canal = new ConexionDB ();
            Connection conn = canal.conectar ();
            PreparedStatement ps;
            ResultSet rs;
            if(id == 0){
            String sql = "insert into seminarios (titulo,expositor,fecha,hora,cupo) values(?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,pro.getTitulo());
            ps.setString(2, pro.getExpositor());
            ps.setString(3,pro.getFecha());
            ps.setString(4, pro.getHora());
            ps.setInt(5,pro.getCupo());
            ps.executeUpdate();
        }
            else{
                String sql1= "update seminarios set titulo=?,expositor=?,fecha=?,hora=?,cupo=? where id=?";
                
                ps= conn.prepareStatement(sql1);
                ps.setString(1, pro.getTitulo());
                ps.setString(2, pro.getExpositor());
                ps.setString(3, pro.getFecha());
                ps.setString(4, pro.getHora());
                ps.setInt(5, pro.getCupo());
                ps.setInt(6, pro.getId());
               
                
                ps.executeUpdate(); 
          
            }
            
            response.sendRedirect("MainController");
        }catch (SQLException ex){
            System.out.println("Error en SQL " + ex.getMessage());
        }
    }
}
