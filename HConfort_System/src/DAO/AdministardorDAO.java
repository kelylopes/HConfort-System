
package DAO;

import hconfort_system.modelo.Administrador;
import java.sql.Connection;




public class AdministardorDAO extends ExecutarSql{

    public AdministardorDAO(Connection con) {
        super(con);
    }
   
       public String Inserir_A (Administrador a){
           String sql = "INSERT INTO administardor VALUES (0,?,?,?)";
        return null;
           
   }
    

 }
