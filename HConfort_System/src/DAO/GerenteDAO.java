
package DAO;

import hconfort_system.modelo.Gerente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class GerenteDAO extends ExecutarSql{

    public GerenteDAO(Connection con) {
        super(con);
    }
    
      
    
    public String Inserir_Funcionario(Gerente g){
        String sql = "INSERT INTO Gerente VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, g.getNome());
            ps.setString(2, g.getEmail());
            ps.setString(3, g.getCpf());
            ps.setString(4, g.getEndereço());
            ps.setString(5, g.getTelefone());
            ps.setString(6,g.getLogin());
            ps.setString(7,g.getSenha());
            
            if(ps.executeUpdate() > 0){
                return "Gerente Cadastrado com Sucesso!";
            }else{
                return "Erro ao Cadastrar Funcionario!";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public List<Gerente> Listar_Gerente(){
        String sql = "SELECT nome,email,cpf,endereco,telefone,login,senha FROM gerente";
        List<Gerente> lista = new ArrayList<Gerente>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Gerente g = new Gerente();
                    g.setNome(rs.getString(1));
                    g.setEmail(rs.getString(2));
                    g.setCpf(rs.getString(3));
                    g.setEndereco(rs.getString(4));
                    g.setTelefone(rs.getString(5));
                   
                   
                  
                }
            return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        
    }
    
    public List<Gerente> Pesquisar_Nome_Funcionario(String nome){
        String sql = "SELECT codigo, nome, login, senha FROM funcionario WHERE nome LIKE '" + nome + "%'";
        List<Gerente> lista = new ArrayList<Gerente>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Gerente g = new Gerente();
                   
                    g.setNome(rs.getString(1));
                    g.setEmail(rs.getString(2));
                    g.setCpf(rs.getString(3));
                    g.setEndereco(rs.getString(4));
                    g.setTelefone(rs.getString(5));
                    g.setLogin(rs.getString(6));
                    g.setSenha(rs.getString(7));
                    
                    lista.add(g);
                }
            return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Gerente> Pesquisar_Cod_Funcionario(String nome){
        String sql = "SELECT codigo, nome, login, senha FROM funcionario WHERE nome = '" + nome+ "'" ;
        List<Gerente> lista = new ArrayList<Gerente>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Gerente g = new Gerente();
                    g.setNome(rs.getString(1));
                    g.setEmail(rs.getString(2));
                    g.setCpf(rs.getString(3));
                    g.setEndereco(rs.getString(4));
                    g.setTelefone(rs.getString(5));
                    g.setLogin(rs.getString(6));
                    g.setSenha(rs.getString(7));
                    
                    
                    lista.add(g);
                }
            return lista;
            }else{
                return null;
            }
        } catch (Exception e){
            return null;
        }
    }
    

    
    public Gerente Consulta_Gerente(String nome){
        
         Gerente g = new Gerente();
         
        try {
            
            String sql = "SELECT * FROM gerente WHERE nome =  " + nome + "";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            
            if(rs != null){
                while(rs.next()){
                                      
                   
                    g.setNome(rs.getString(1));
                    g.setEmail(rs.getString(2));
                    g.setCpf(rs.getString(3));
                    g.setEndereco(rs.getString(4));
                    g.setTelefone(rs.getString(5));
                    g.setLogin(rs.getString(6));
                    g.setSenha(rs.getString(7));
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        if(g.getNome() == nome){
            JOptionPane.showMessageDialog(null, "Gerente encontrado com sucesso!");
        }else{
        JOptionPane.showMessageDialog(null, "Gerente Não encontrado com sucesso!");    
        }
        return g;
    }
    
    
    
    
    public void Alterar_Funcionario(Gerente g){
        String sql = "UPDATE gerente SET nome = ?, email = ?, cpf = ? , endereco = ?, telefone = ?, login = ?, senha = ?"
                + "WHERE nome = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, g.getNome());
            ps.setString(2,g.getEmail());
            ps.setString(3, g.getCpf());
            ps.setString(4, g.getEndereço());
            ps.setString(5, g.getTelefone());
            ps.setString(6, g.getLogin());
            ps.setString(7, g.getSenha());
            ps.setString(8, "" + g.getNome());
            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"Gerente Atualizado!");
            }else{
                JOptionPane.showMessageDialog(null,"Erro ao Atualizar o Gerente!");
            }
        } catch (Exception e) {
           e.getMessage();
        }
    }
    
    public List<Gerente> ListaComboFuncionario(){
        String sql = "SELECT nome FROM funcionario ORDER BY nome";
        List<Gerente> lista = new ArrayList<Gerente>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Gerente g = new Gerente();
                    g.setNome(rs.getString(1));
                    lista.add(g);
                }
                return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public String Excluir_Gerente(Gerente g){
        String sql = "DELETE FROM funcionario WHERE codigo = ?";
    
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1, g.getNome());
            
            if(ps.executeUpdate() > 0){
                return "Funcionário Excluído com Sucesso!";
            }else{
                return "Erro ao Excluir!";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    
    }
}

