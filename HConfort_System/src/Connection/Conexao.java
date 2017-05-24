
package Connection;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexao {
    public static Connection AbrirConexao(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/hconfortsystem";
            String user = "admin";
            String PASS = "root";
            con = DriverManager.getConnection(url,"admin", "root");
                   
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na Conexão com o Banco","hconfortsystem", JOptionPane.ERROR_MESSAGE );
        }
        return con;
    }
    
    public static void FecharConexao(Connection con){
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
        
    }

    public void getConnection() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}