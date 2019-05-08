/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author shashilaheshan
 */
/**
 *
 * MySQL Connection class
 * 
 * 
 **/
public class Connect {
    
    
    public Connection connect() throws ClassNotFoundException, SQLException{
        
        Connection con=null;

        Class.forName("com.mysql.jdbc.Driver");  
        con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/pdsa","root","");  
        //here sonoo is database name, root is username and password  



          return con;
    }
}
