
package DAO;

import hconfort_system.modelo.Hospede;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.spi.DirStateFactory;
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
      public boolean Testar_Hospede ( int cod) throws SQLException{
       boolean Resultado = false;
       
       try {
           String sql = "select * from hospede where cpf= ?";
            PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs  = ps.executeQuery();
                   
            
            if(rs != null){
                while (rs.next());
                Resultado = true;
                
            }
        } catch (SQLException ex) {
           ex.getMessage();
        }
       return Resultado;  
      }  
      
      
      
       public List<Hospede> Listar_Hospede(){
        String sql = "SELECT cpf FROM hospede";
        List<Hospede> lista = new ArrayList<Hospede>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Hospede h = new Hospede();
                    h.setCpf(rs.getString(sql));
                    
                    
                    lista.add(h);
                }
            return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        
    }
 
     public void Alterar_Hospede(Hospede h){
        String sql = "UPDATE hospede SET nome = ?"
                + "WHERE cpf = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, h.getNome());
            ps.setString(2, "" + h.getCpf());
            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"Hóspede Atualizado com Sucesso!");
            }else{
                JOptionPane.showMessageDialog(null,"Erro ao Atualizar o Hóspede!");
            }
        } catch (Exception e) {
           e.getMessage();
        }
    }
     
      public void Consulta_Hospede(String cpf){
        
         Hospede h = new Hospede();
         
        try {
            
            String sql = "SELECT * FROM hospede set cpf = ?";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            
            if(rs != null){
                while(rs.next()){
                                      
                    h.setCpf(rs.getString(1));
                    h.setNome(rs.getString(2));
                   
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        if(h.getCpf() == cpf ){
            JOptionPane.showMessageDialog(null, "Hóspede encontrado com sucesso!");
        }else{
        JOptionPane.showMessageDialog(null, "Hóspede Não encontrado com sucesso!");    
        }
        
      }

    
}



