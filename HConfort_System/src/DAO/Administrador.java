
package DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

;

public class Administrador extends ExecutarSql{

    public Administrador(Connection con) {
        super(con);
    }

    
    public String   Inserir_Administrador (Administrador admin){
        String sql = "INSERT INTO funcionario VALUES (?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            
            ps.setString(1, admin.getLogin());
            ps.setString(2, admin.getSenha());
            
            if(ps.executeUpdate() > 0){
                return "Administrador Cadastrado com Sucesso!";
            }else{
                return "Erro ao Cadastrar Administrador!";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
    public List<Administrador> Listar_Administrador(){
        String sql = "SELECT  FROM Administrador";
        List<Administrador> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Administrador admin = null;
                    admin = new Administrador((Connection) admin);
                    
                    admin.setLogin(rs.getString(3));
                    admin.setSenha(rs.getString(4));
                    
                    lista.add(admin);
                }
            return lista;
            }else{
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
        
    }
    
    public List<Administrador> Pesquisar_login_Administrador(String nome){
        String sql = "SELECT  login, senha FROM cadastrar_administrador WHERE nome LIKE '" + nome + "%'";
        List<Administrador> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Administrador admin = null ;
                    admin = new Administrador((Connection)admin);
                   
                    admin.setLogin(rs.getString(3));
                    admin.setSenha(rs.getString(4));
                    
                    lista.add(admin);
                }
            return lista;
            }else{
                return null;
            }
        } catch (SQLException e) {
            return null;
        }
    }
    
    public List<Administrador> Pesquisar_Cod_Administrador(int cod){
        String sql = "SELECT codigo, nome, login, senha FROM funcionario WHERE codigo = '" + cod + "'" ;
        List<Administrador> lista = new ArrayList<>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Administrador admin = new Administrador(admin);
                    
                    admin.setLogin(rs.getString(3));
                    admin.setSenha(rs.getString(4));
                    
                    lista.add(admin);
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
        
         Administrador admin = new Administrador(admin);
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
        } catch (SQLException e) {
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
           
            ps.setString(1, admin.getLogin());
            ps.setString(2, admin.getSenha());
          
            
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
                    Administrador admin = new Administrador();
                    lista.add(admin);
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

    private String getLogin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String getSenha() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

    
    
    
    
    
