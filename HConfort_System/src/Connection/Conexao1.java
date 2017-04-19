
package Connection;

import DAO.*;
import java.sql.*;
import javax.swing.JOptionPane;


public class Conexao1 {
    public static Connection AbrirConexao(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql//localhost:3333/dbhconfortsystem";
            con = DriverManager.getConnection("jdbc:mysql//localhost:3333/dbhconfortsystem","root", "admin");
                   
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro na Conexão com o Banco","Funcionario", JOptionPane.ERROR_MESSAGE );
        }
        return con;
    }
    
    public static void FecharConexao(Connection con){
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        
    }

    public static Connection getConexao1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}