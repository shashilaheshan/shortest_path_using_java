/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsa.shortest.path;

import DB.Connect;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author shashilaheshan
 */
public class BranchViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXTextField txtBranchName;

    @FXML
    private JFXTextField txtBranchNameUpdate;

    @FXML
    private JFXComboBox<String> cmbBranchName;

    @FXML
    private JFXComboBox<String> cmbBranchDelete;

    @FXML
    private JFXButton btnAddBranch;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXTreeTableView<Branch> branchTable;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        try {
            // TODO
            GetTable();
            getCombo();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BranchViewController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BranchViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    /**
 *
 * Adding branch data to Database
 * 
 * 
 **/
    public void addBranch() throws ClassNotFoundException, SQLException{
        
     
        Connect obj=new Connect();
        String b_name=txtBranchName.getText();
        
           if(!checkBranch(b_name)){
           
           try{
        Connection con=obj.connect();
        
        // create a Statement from the connection
            Statement statement = (Statement) con.createStatement();

            // insert the data
            statement.executeUpdate("INSERT INTO branch(branchname) VALUES ('"+b_name+"')");
            con.close();
            GetTable();
            
            
        }catch(Exception ex){
        
            System.out.println(ex);
        }
           
           }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
       alert.setTitle("Error");
       alert.setHeaderText("Branch Exists In Database ");
       String s ="Branch Exists in the database.";
       alert.setContentText(s);
       alert.show();
           
           }
        
    
    }
    /**
 *
 * Check the brach details before storing inside database
 * 
 * 
 **/
    public boolean checkBranch(String branch_name) throws ClassNotFoundException, SQLException{
        
        Connect obj=new Connect();
        boolean is_valid=true;
        Connection con=obj.connect();
        
        String sql="select * from branch where branchname='"+branch_name+"'";
        Statement st=(Statement) con.createStatement();
        
        ResultSet rs=st.executeQuery(sql);
        if(!rs.next()){
        is_valid=false;
            
        }else{
        is_valid=true;
        }
        return is_valid;
        
        
        
    
    }
    /**
 *
 * Populate Material JavafX Table View with Observable Lists
 * 
 * 
 **/
    public void GetTable() throws ClassNotFoundException, SQLException{
        Connect obj=new Connect();
        Connection con=obj.connect();
        JFXTreeTableColumn<Branch,String> idColumn=new JFXTreeTableColumn<>("Department ID");
        idColumn.setPrefWidth(450);
        idColumn.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Branch, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Branch, String> param) {
               return param.getValue().getValue().id;
            }
        });
        JFXTreeTableColumn<Branch,String> nameColumn=new JFXTreeTableColumn<>("Name");
        nameColumn.setPrefWidth(450);
        nameColumn.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Branch, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<Branch, String> param) {
               return param.getValue().getValue().name;
            }
        });
        ObservableList<Branch> branches=FXCollections.observableArrayList();
        
        Statement stmt=(Statement) con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from branch");  
        while(rs.next()) {
             branches.add(new Branch(Integer.toString(rs.getInt("id")),rs.getString("branchname") ));
        }
        
        final TreeItem<Branch> roots=new RecursiveTreeItem<Branch>(branches,RecursiveTreeObject::getChildren);
        branchTable.getColumns().setAll(idColumn,nameColumn);
        getCombo();
        branchTable.setRoot(roots);
        branchTable.setShowRoot(false);
    }
    
    /**
 *
 * Branch Model For Material Table 
 * 
 * 
 **/
    class Branch extends RecursiveTreeObject<Branch>{
        StringProperty id;
        StringProperty name;

        public Branch(String depid, String name) {
            this.id = new SimpleStringProperty (depid);
            this.name = new SimpleStringProperty(name);
        }
        
        
    }
    /**
 *
 * Branch Data model for storing the data in database mapping the data
 * 
 * 
 **/
    public class BranchData {
    private String name;
   
    public String getName() {
        return name;
    }

    public BranchData(String name) {
        this.name = name;
        
    }
    
    
}
    
    /**
 *
 * A method to update the database data
 * 
 * 
 **/
    public void UpdateBranch(){
     Connect obj=new Connect();
        String b_name=cmbBranchName.getSelectionModel().getSelectedItem().toString();
        String u_b=txtBranchNameUpdate.getText();
        String query="UPDATE branch set branchname=? where branchname=?";
        try{
        Connection con=obj.connect();
        
        // create a Statement from the connection
           

            // insert the data
            
            
             PreparedStatement preparedStmt = con.prepareStatement(query);
             preparedStmt.setString   (1,u_b);
             preparedStmt.setString   (2,b_name);
     
      

      // execute the java preparedstatement
           preparedStmt.executeUpdate();
            
            con.close();
            GetTable();
            
            
        }catch(Exception ex){
        
            System.out.println(ex);
        }
    txtBranchNameUpdate.setText("");
    }
    
    /**
 *
 *combo box generate and adding to stage
 * 
 * 
 **/
    void getCombo(){
        try {
            Connect obj=new Connect();
        Connection con=obj.connect();
             Statement stmt=(Statement) con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from branch"); 
          ObservableList<String> stationsList = FXCollections.observableArrayList();
        while(rs.next()) {
            
            //cmbBranchName.setItems(value);
              
        
 
        
                 stationsList.add(rs.getString("branchname"));
                 
        
     
    
            
        }
          
        cmbBranchName.setItems(stationsList);
        cmbBranchDelete.setItems(stationsList);
            
        } catch (Exception e) {
        }
    }
    /**
 *
 * Delete branch from branch name
 * 
 * 
 **/
    public void deleteBranch(){
    
        try{
            String b_name=cmbBranchDelete.getSelectionModel().getSelectedItem().toString();
        Connect obj=new Connect();
        Connection con=obj.connect();
        Statement st=(Statement) con.createStatement();
        String query="Delete from branch where branchname='"+b_name+"'";
        
        st.execute(query);
        con.close();
         GetTable();
            
            
        }catch(Exception ex){
        
            System.out.println(ex);
        }
        
    }
}
