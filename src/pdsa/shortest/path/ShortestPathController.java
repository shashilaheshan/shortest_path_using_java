/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsa.shortest.path;

import Algorithms.GetLocationData;
import Algorithms.HashMapDistances;
import Algorithms.MST;
import Algorithms.shortestPath;
import DB.Connect;

import com.jfoenix.controls.JFXComboBox;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


/**
 * FXML Controller class
 *
 * @author shashilaheshan
 */
public class ShortestPathController implements Initializable {

    @FXML
    private JFXComboBox<String> cmbFromBranch;
    @FXML
    private JFXComboBox<String> cmbToBranch;
    int [][] arr=null;
    
    shortestPath  path=null;
    
    HashMapDistances outs=null;

 String [] branches=null;
 ObservableList<String> stationsList=null;
    @FXML
    private Label txtDistance;
    @FXML
    private Label txtDetails;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       getCombo();
        GetLocationData obj=new GetLocationData();
       // int length=obj.PrintArray().length;
        String [][]ss = null;
        
        try {
            branches=getArray();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ShortestPathController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ShortestPathController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ss = obj.PrintArray();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ShortestPathController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ShortestPathController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            path=new shortestPath(ss.length,getArray());
            outs=new HashMapDistances(ss.length, getArray());
            //System.out.println(obj.PrintArray()[0][1]);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ShortestPathController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ShortestPathController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       arr=new int[ss.length][ss.length];
        for(int i=0;i<ss.length;i++){
          for(int y=0;y<ss.length;y++){
              int val=0;
              if(ss[i][y]!=null){
               
              val=Integer.parseInt(ss[i][y]);
              }else{
              val=0;
              }
           arr[i][y]=val;
              
          }
        
        }
        
        
    }    
       void getCombo(){
        try {
            Connect obj=new Connect();
        Connection con=obj.connect();
             Statement stmt=(Statement) con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from branch"); 
          stationsList = FXCollections.observableArrayList();
        while(rs.next()) {
            
            //cmbBranchName.setItems(value);
              
        
 
        
                 stationsList.add(rs.getString("branchname"));
                 
        
     
    
            
        }
          
        cmbFromBranch.setItems(stationsList);
        cmbToBranch.setItems(stationsList);
            
        } catch (Exception e) {
        }
    }
       
       
 public static int findIndex(String arr[], String t) 
    { 
  
        // if array is Null 
        if (arr == null) { 
            return -1; 
        } 
  
        // find length of array 
        int len = arr.length; 
        int i = 0; 
  
        // traverse in the array 
        while (i < len) { 
  
            // if the i-th element is t 
            // then return the index 
            if (arr[i].equals(t)) { 
                return i; 
            } 
            else { 
                i = i + 1; 
            } 
        } 
        return -1; 
    } 
    @FXML
    private void FindDistance(ActionEvent event) throws ClassNotFoundException, SQLException {
         
        
        
        int index=findIndex(branches,cmbFromBranch.getSelectionModel().getSelectedItem().toString());
        
  
        StringBuilder out=path.dijkstra(arr, index);
        System.out.println(out);
        
        Map<String,Integer> data=outs.dijkstra(arr, index);
        
        
        txtDetails.setText(out.toString());
        String to=cmbToBranch.getSelectionModel().getSelectedItem().toString();
        txtDistance.setText("The Minimum Distance from "+cmbFromBranch.getSelectionModel().getSelectedItem().toString()+" to "+" "+to+" is "+data.get(to).toString()+" KM");
        
        //System.out.println(data.get());
        MST obj=new MST(11);
        obj.primMST(arr);
      
        
    }
    
    String [] getArray() throws ClassNotFoundException, SQLException{
     Connect obj=new Connect();
            Connection con=obj.connect();
            String[] branches=null;
            ArrayList<String> list=new ArrayList<>();
            
            String sql="SELECT DISTINCT(from_b) from distance_detail";
             Statement stmt=(Statement) con.createStatement();  
                ResultSet rs=stmt.executeQuery(sql);  
                while(rs.next()) {
                     list.add(rs.getString("from_b"));
                }
                
 branches = list.toArray(new String[list.size()]);  
        
return branches; 
    }
    
}
