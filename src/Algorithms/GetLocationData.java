/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import DB.Connect;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author shashilaheshan
 */

/**
 *
 * Get all branch distance data to multidimentional array(Adjencency matrix[Graph]
 * 
 * 
 **/
public class GetLocationData {
    public String[][] PrintArray() throws ClassNotFoundException, SQLException{
       ArrayList<String> f_cities = new ArrayList<String>();
    
        
            
            Connect obj=new Connect();
            Connection con=obj.connect();
            
            String sql="SELECT DISTINCT(from_b) from distance_detail";
             Statement stmt=(Statement) con.createStatement();  
                ResultSet rs=stmt.executeQuery(sql);  
                while(rs.next()) {
                     f_cities.add(rs.getString("from_b"));
                }

        String[] nameArr = new String[f_cities.size()];
        nameArr = f_cities.toArray(nameArr);
        ArrayList<String[]> aa=new ArrayList<String[]>();

        String[][] shades = new String[nameArr.length][nameArr.length];
            for(int i = 0; i < nameArr.length; i++)
            {
              for(int y = 0; y < nameArr.length; y++)
              {
                shades[i][y] = find_location_between_cities(nameArr[i], nameArr[y]);
                  //System.out.println(find_location_between_cities(nameArr[i], nameArr[y]));
              }
            }
            
//     return graph;
       return shades;
    }
    /**
 *
 * return single Array object for multi dimentional array
 * 
 * 
 **/
    String find_location_between_cities(String f_city,String to_city) throws ClassNotFoundException, SQLException{
    
        
            Connect obj=new Connect();
            Connection con=obj.connect();
            String disString=null;
            
            String sql="SELECT distance from distance_detail where from_b='"+f_city+"' and to_b='"+to_city+"'";
             Statement stmt=(Statement) con.createStatement();  
            ResultSet rs=stmt.executeQuery(sql);  
            while(rs.next()) {
                 disString=rs.getString("distance");
            }
            
       
        
        return disString;
            
            
           

        
        
        
    }
}
