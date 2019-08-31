/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejopersonas;

import datos.Conexion;
import datos.PersonasJDBC;
import java.sql.*;
/**
 *
 * @author maxim
 */
public class ManejoPersonas {

    public static void main(String[] args) {
 
         PersonasJDBC personasJDBC = new PersonasJDBC();

         Connection conn = null;
         
         try{
             conn = Conexion.getConnection();
             if (conn.getAutoCommit()){
                 conn.setAutoCommit(false);
             }
             PersonasJDBC personas = new PersonasJDBC(conn);
             personas.update(3,"Regreso2", "Regreso");
             personas.insert("Miguel12",
                     "655555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555");
             conn.commit();
         }catch(SQLException e){
             try{
                 System.out.println("Entreamos al rollback");
                 e.printStackTrace(System.out);
                 conn.rollback();
             }catch(SQLException el){
                 el.printStackTrace(System.out);
             }
         }
       
      }
    }
    

