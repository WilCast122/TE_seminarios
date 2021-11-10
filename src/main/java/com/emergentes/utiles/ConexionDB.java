package com.emergentes.utiles;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/bd_eventos";
    String usuario = "root";
    String password = "";

    Connection conn = null;
    
    public ConexionDB(){
        try{
            Class.forName(driver);
            conn=DriverManager.getConnection(url,usuario,password);
            if(conn != null){
                System.out.println("Conexion OK : "+ conn);
            }
         } catch (ClassNotFoundException ex){
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE,null,ex);    
        } catch (SQLException ex){
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE,null,ex);  
        }
    }
    public Connection conectar()
    {
        return conn;
    }
    public void desconectar()
    {
        try{
            conn.close();
        }catch (SQLException ex){
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}