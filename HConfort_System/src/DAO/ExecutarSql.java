
package DAO;

import java.sql.Connection;



public class ExecutarSql {

    
   private Connection con;
    
    public ExecutarSql(Connection con){
        setCon(con);
    }
    
     public Connection getCon(){
        return con;
    }
    
    public void setCon(Connection con){
        this.con = con;
    }
}
    

