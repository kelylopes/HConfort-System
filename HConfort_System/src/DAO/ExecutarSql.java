
package DAO;

import java.sql.Connection;

<<<<<<< HEAD

public class ExecutarSql {
=======
/**
 *
 * @author HConfort-System
 */
public final class ExecutarSql {
>>>>>>> origin/master
    
    Connection con;
    
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
    

