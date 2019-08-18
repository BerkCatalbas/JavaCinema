/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinema;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Berk
 */
public class DataCon {
  private  Connection conn;
  private  PreparedStatement s;

 
 
 public void InData(String SalonName,String kno,String durum)
 {
    try {
 conn=DriverManager.getConnection( 
                  "jdbc:ucanaccess://Sinemadata.accdb");
      s = conn.prepareStatement("update "+SalonName+" SET Durum=? WHERE KoltukNo=?");
      
      s.setString(1, durum);
      s.setString(2, kno);
     
      s.executeUpdate();
      
       s.close();
      conn.close();
     
     }
    
     catch(Exception e){
     System.err.println("Exception: "+e.getMessage());
     }    
 }
    
 public String[][] GetData(String SalonName)         
         {
             String[][] k=new String[44][2];
          int c=0;
      try { 
          
                  conn=DriverManager.getConnection(
                  "jdbc:ucanaccess://Sinemadata.accdb");
          String table = "SELECT * FROM " + SalonName;
          Statement s;
          s=conn.createStatement();
                  s.execute(table);
                  ResultSet rs = s.getResultSet();
                  while((rs!=null) && (rs.next()))
                  {
                     
                     k[c][0]=rs.getString(2);
                     k[c][1]=rs.getString(1);
                     c++;                      
                  }
           
      } catch (SQLException ex) {
          Logger.getLogger(DataCon.class.getName()).log(Level.SEVERE, null, ex);
      }
      return k;       
         }
 public void InData(String SalonName,String kno)
 {
  try {
 conn=DriverManager.getConnection( 
                  "jdbc:ucanaccess://Sinemadata.accdb");
      s = conn.prepareStatement("update "+SalonName+" SET Durum=? WHERE KoltukNo=?");
      
      s.setString(1, null);
      s.setString(2, kno);
     
      s.executeUpdate();
      
       s.close();
      conn.close();
     
     }
    
     catch(Exception e){
     System.err.println("Exception: "+e.getMessage());
 
 }
 }
}
