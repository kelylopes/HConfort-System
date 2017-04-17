
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;




public class Conexao {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql//localhost:3333/dbhconfortsystem";
    private static final String USER = "root";
    private static final String PASE = "admin";
    
    
    public static Connection getConnection(){
        
        try {
            Class.forName(DRIVER);
            
            return DriverManager.getConnection(URL, URL, DRIVER);
            
         
        } catch (ClassNotFoundException | SQLException ex) {
           throw new RuntimeException("Erro na conexão com o Banco de Dados", ex);
        }
    }
    
    public void closeConnection( Connection con){
        
        if (con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
         public void closeConnection (Connection con, PreparedStatement stmt){
        
        if (con != null){
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
