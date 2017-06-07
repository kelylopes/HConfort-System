
package DAO;
import hconfort_system.modelo.Recepcionista;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;



public class RecepcionistaDAO extends ExecutarSql{
 
    public RecepcionistaDAO(Connection con) {
        super(con);
    }
    
    public boolean Logar (String login, String senha){
        
        boolean finalResult = false; 
        try {
            String consulta = "select login, senha from recepcionista" + "where login = '" + login + "' and senha = '" + senha + "'";
             PreparedStatement ps = getCon().prepareStatement(consulta);
             ResultSet rs = ps.executeQuery();
             
             if (rs!= null)
                 while (rs.next()){
                     Recepcionista r;
                r = new Recepcionista();
                     r.setLogin(rs.getString(1));
                     r.setSenha(rs.getString(2));
                     finalResult = true;
                 }
        } catch (SQLException ex) {
            ex.getMessage();
        }
        return finalResult;
    }
    
    
      
    
    public String cadastrar_Hospede(Recepcionista r){
        String sql = "INSERT INTO hospede VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, r.getNome());
            ps.setString(2, r.getEmail());
            ps.setString(3, r.getCpf());
            ps.setString(4, r.getRg());
            ps.setString(5, r.getEndereço());
            ps.setString(6, r.getTelefone());
           ps.setString(7, r.getHorario());
            ps.setString(8, r.getLogin());
            ps.setString(9, r.getSenha());
            
            
            if(ps.executeUpdate() > 0){
                return "Recepcionista Cadastrado com Sucesso!";
            }else{
                return "Erro ao Cadastrar Recepcionista!";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
    public String Excluir_Recepcionista(Recepcionista r){
        String sql = "DELETE FROM hospede WHERE nome = ?";
    
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, r.getNome());
            
            if(ps.executeUpdate() > 0){
                return "Recepcionista Excluído com Sucesso!";
            }else{
                return "Erro ao Excluir Recepcionista!";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    
    }
    @SuppressWarnings("empty-statement")
      public boolean Testar_Recepcionista ( int cod) throws SQLException{
       boolean Resultado = false;
       
       try {
           String sql = "select * from Recepcionista where cpf= ?";
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
      
      
      
       public List<Recepcionista> Listar_Recepcionista(){
        String sql = "SELECT cpf FROM hospede";
        List<Recepcionista> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Recepcionista r = new Recepcionista();
                    r.setCpf(rs.getString(sql));
                    
                    
                    lista.add(r);
                }
            return lista;
            }else{
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
        
    }
 
     public void Alterar_Recepcionista(Recepcionista r){
        String sql = "UPDATE hospede SET nome = ?"
                + "WHERE cpf = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, r.getNome());
            ps.setString(2, "" + r.getCpf());
            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"Recepcionista Atualizado com Sucesso!");
            }else{
                JOptionPane.showMessageDialog(null,"Erro ao Atualizar o Recepcionista!");
            }
        } catch (HeadlessException | SQLException e) {
           e.getMessage();
        }
    }
     
      public void Consulta_Recepcionista(String cpf){
        
         Recepcionista r = new Recepcionista();
         
        try {
            
            String sql = "SELECT * FROM Recepcionista set cpf = ?";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            
            if(rs != null){
                while(rs.next()){
                                      
                    r.setCpf(rs.getString(1));
                    r.setNome(rs.getString(2));
                   
                }
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        if(r.getCpf() == null ? cpf == null : r.getCpf().equals(cpf) ){
            JOptionPane.showMessageDialog(null, "Recepcionista encontrado com sucesso!");
        }else{
        JOptionPane.showMessageDialog(null, "Recepcionista Não encontrado com sucesso!");    
        }
        
      }

    public void cadastrar_Recepcionista(Recepcionista r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}