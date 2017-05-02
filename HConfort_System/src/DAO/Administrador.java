
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Administrador extends ExecutarSql{

    public Administrador(Connection con) {
        super(con);
    }
    
      public String Inserir_Administrador(Administrador a){
        String sql = "INSERT INTO funcionario VALUES (0,?,?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            
            ps.setString(1, a.getLogin());
            ps.setString(1, a.getSenha());
            
            if(ps.executeUpdate() > 0){
                return " Cadastro com Sucesso!";
            }else{
                return "Erro ao cadastrastar o Administrador!";
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    private String getLogin() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    private String getSenha() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    
    public List<Administrador> Listar_Administrador(){
        String sql = "SELECT codigo,nome,login,senha FROM ";
        List<Administrador> lista = new ArrayList<Administrador>();
        
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Administrador f = new Administrador(null);
                   
                    f.setLogin(rs.getString(3));
                    f.setSenha(rs.getString(4));
                    
                    lista.add(f);
                }
            return lista;
            }else{
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        
    }

    private void setLogin(String string) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    private void setSenha(String string) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    
    
}



