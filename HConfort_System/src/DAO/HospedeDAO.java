
package DAO;

import hconfort_system.modelo.Hospede;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class HospedeDAO extends ExecutarSql{
 
    public HospedeDAO(Connection con) {
        super(con);
    }
    
    public boolean Logar (String login, String senha){
        
        boolean finalResult = false; 
        try {
            String consulta = "select login, senha from hospede" + "where login = '" + login + "' and senha = '" + senha + "'";
             PreparedStatement ps = getCon().prepareStatement(consulta);
             ResultSet rs = ps.executeQuery();
             
             if (rs!= null)
                 while (rs.next()){
                     Hospede h = new Hospede();
                     h.setLogin(rs.getString(1));
                     h.setSenha(rs.getString(2));
                     finalResult = true;
                 }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return finalResult;
    }
    
    
      
    
    public String cadastrar_Hospede(Hospede h){
        String sql = "INSERT INTO hospede VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, h.getNome());
            ps.setString(2, h.getEmail());
            ps.setString(3, h.getCpf());
            ps.setString(4, h.getRg());
            ps.setString(5, h.getEndereço());
            ps.setString(6, h.getTelefone());
           ps.setString(7,h.getHorario());
            ps.setString(8,h.getLogin());
            ps.setString(9,h.getSenha());
            
            if(ps.executeUpdate() > 0){
                return "Hospede Cadastrado com Sucesso!";
            }else{
                return "Erro ao Cadastrar!";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String Excluir_Hospede(Hospede h){
        String sql = "DELETE FROM hospede WHERE nome = ?";
    
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, h.getNome());
            
            if(ps.executeUpdate() > 0){
                return "Hóspede Excluído com Sucesso!";
            }else{
                return "Erro ao Excluir!";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    
    }
    
}



