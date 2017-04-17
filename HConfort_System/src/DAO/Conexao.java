
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Conexao {
    
    public static Connection AbrirConexao(){
        Connection Connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "";
            Connection = DriverManager.getConnection(url,"admin", "");
                   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro em conectar ao Banco de Dados","Funcionario", JOptionPane.ERROR_MESSAGE );
        }
        return Connection;
    }
    
    public static void FecharConexao(Connection Connection){
        try {
             Connection.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        
    }
    
}
