
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionFactory {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL    = "jdbc:mysql:3333/hconfortsystem";
    private static final String USER   = "root";
    private static final String PASS   = "admin";
    
    public static Connection getConnection(){
        
        try {
            Class.forName(DRIVER);
            
            return DriverManager.getConnection(URL, USER, PASS);
            
            
        }
        
        catch (ClassNotFoundException ex) {
           throw new RuntimeException("Erro na conexão", ex);
           
        }
        
        
    }
    
    /**
     *
     * @param con
     */
    public static void closeConnection(Connection con){
        
        if(con != null){
            
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
}