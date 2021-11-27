/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking.database;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Farhan Fadila
 */
public abstract class DatabaseClient {
    final String databaseName = "parking";
    public Connection con;
    public Statement statement;
    
    
    public void start() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName, "root", "");
            createStatement();
        } catch(ClassNotFoundException | SQLException ex) {
            System.out.println("DATABASE ERROR" + ex);
        }
    }
    
    public ResultSet executeQuery(String query) {
       ResultSet rs = null;
       if(statement == null) {
           try {
               createStatement();
               
           } catch (SQLException ex) {
               Logger.getLogger(DatabaseClient.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       
        try {
           rs = statement.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return rs;
    }
    
       
    public void executeQuery2(String query) {
     
       if(statement == null) {
           try {
               createStatement();
               
           } catch (SQLException ex) {
               Logger.getLogger(DatabaseClient.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       
        try {
            statement.execute(query);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    private void createStatement() throws SQLException {
        if(con == null) {
            start();
        }
        
        statement = con.createStatement();
    }
}
