
package DAO;

import hconfort_system.modelo.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

;

public class Administrador extends ExecutarSql{

    public Administrador(Connection con) {
        super(con);
    }

    
    public String Inserir_Administrador(Administrador a){
        String sql = "INSERT INTO funcionario VALUES (0,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            
            ps.setString(1, a.getLogin());
            ps.setString(2, a.getSenha());
            
            if(ps.executeUpdate() > 0){
                return "Administrador Cadastrado com Sucesso!";
            }else{
                return "Erro ao Cadastrar Administrador!";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public List<Administrador> Listar_Administrador(){
        String sql = "SELECT login,senha FROM ";
        List<Administrador> lista = new ArrayList<Administrador>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Administrador a = new Administrador(a);
                    
                    a.setLogin(rs.getString(3));
                    a.setSenha(rs.getString(4));
                    
                    lista.add(a);
                }
            return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        
    }
    
    public List<Administrador> Pesquisar_Nome_Administrador(String nome){
        String sql = "SELECT codigo, nome, login, senha FROM cadastrar_administrador WHERE nome LIKE '" + nome + "%'";
        List<Administrador> lista = new ArrayList<Administrador>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Administrador a = new Administrador((Connection) a);
                   
                    a.setLogin(rs.getString(3));
                    a.setSenha(rs.getString(4));
                    
                    lista.add(a);
                }
            return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Administrador> Pesquisar_Cod_Administrador(int cod){
        String sql = "SELECT codigo, nome, login, senha FROM funcionario WHERE codigo = '" + cod + "'" ;
        List<Administrador> lista = new ArrayList<Administrador>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Administrador a = new Administrador();
                    
                    a.setLogin(rs.getString(3));
                    a.setSenha(rs.getString(4));
                    
                    lista.add(a);
                }
            return lista;
            }else{
                return null;
            }
        } catch (Exception e){
            return null;
        }
    }
    

    
    public Administrador Consulta_Administrador(int cod){
        
         Administrador f = new Administrador();
        Administrador a = null;
         
        try {
            
            String sql = "SELECT * FROM funcionario WHERE codigo =  " + cod + "";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            
            if(rs != null){
                while(rs.next()){
                                      
                   
                    a.setLogin(rs.getString(1));
                    a.setSenha(rs.getString(2));
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        if(a.getCod() == cod){
            JOptionPane.showMessageDialog(null, "Funcionário encontrado com sucesso!");
        }else{
        JOptionPane.showMessageDialog(null, "Funcionário Não encontrado com sucesso!");    
        }
        return a;
    }
    
    
    
    
    public void Alterar_Administrador(Administrador f){
        String sql = "UPDATE funcionario SET nome = ?, login = ?, senha = ?"
                + "WHERE codigo = ?";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
           
            ps.setString(2, a.getLogin());
            ps.setString(3, a.getSenha());
            ps.setString(4, "" + a.getCod());
            
            if(ps.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null,"Administrador Atualizado com Sucesso!");
            }else{
                JOptionPane.showMessageDialog(null,"Erro ao Atualizar o Funcionário!");
            }
        } catch (Exception e) {
           e.getMessage();
        }
    }
    
    public List<Administrador> ListaComboAdministrador(){
        String sql = "SELECT nome FROM funcionario ORDER BY nome";
        List<Administrador> lista = new ArrayList<Administrador>();
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Administrador a = new Administrador();
                    a.setNome(rs.getString(1));
                    lista.add(a);
                }
                return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
    
    public String Excluir_Administrador(Administrador f){
        String sql = "DELETE FROM funcionario WHERE codigo = ?";
    
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setInt(1, f.getCod());
            
            if(ps.executeUpdate() > 0){
                return "Funcionário Excluído com Sucesso!";
            }else{
                return "Erro ao Excluir!";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    
    }

    private void setLogin(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setSenha(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int getCod() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

    
    
    
    
    
