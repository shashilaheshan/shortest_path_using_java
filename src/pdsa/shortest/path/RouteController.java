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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author shashilaheshan
 */
public class RouteController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
      @FXML
    private JFXComboBox<String> cmbFromBranch;

    @FXML
    private JFXComboBox<String> cmbToBranch;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXTreeTableView<Distances> distanceTable;

    @FXML
    private JFXTextField txtDistance;

    //Adding diatance data after checking
    @FXML
    void AddDistance(ActionEvent event) throws ClassNotFoundException, SQLException {
        try {
             Connect obj=new Connect();
             
             
             
             
        String f_branch=cmbFromBranch.getSelectionModel().getSelectedItem().toString();
        String t_branch=cmbToBranch.getSelectionModel().getSelectedItem().toString();
        
        
        String distance=txtDistance.getText().trim();
        if(!CheckBranch_distances(f_branch,t_branch)){
          try{
        Connection con=obj.connect();
        
        // create a Statement from the connection
            Statement statement = (Statement) con.createStatement();

            // insert the data
            statement.executeUpdate("INSERT INTO distance_detail(from_b,to_b,distance) VALUES ('"+f_branch+"','"+t_branch+"','"+distance+"')");
            con.close();
            GetTable();
            
            
        }catch(Exception ex){
        
            System.out.println(ex);
        }
             
        }else{
         Alert alert = new Alert(Alert.AlertType.ERROR);
       alert.setTitle("Error");
       alert.setHeaderText("Branch Distance Details Exists In Database ");
       String s ="Branch Distance Details Exists In Database";
       alert.setContentText(s);
       alert.show();
        }
        
         
        } catch (Exception e) {
        }
        GetTable();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
          try {
              // TODO
              getCombo();
              GetTable();
              
            txtDistance.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(!newValue.matches("[0-9]*")){
                    txtDistance.setText(oldValue);
                }

            }
        });
              
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(RouteController.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SQLException ex) {
              Logger.getLogger(RouteController.class.getName()).log(Level.SEVERE, null, ex);
          }
    } 
    
    
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
          
        cmbFromBranch.setItems(stationsList);
        cmbToBranch.setItems(stationsList);
            
        } catch (Exception e) {
        }
    }
    
    
    public boolean CheckBranch_distances(String f_b,String t_b) throws ClassNotFoundException, SQLException{
        
        Connect obj=new Connect();
        boolean is_valid=true;
        Connection con=obj.connect();
        
        String sql="select * from distance_detail where from_b='"+f_b+"' and to_b='"+t_b+"'";
        
        Statement st=(Statement) con.createStatement();
        
        ResultSet rs=st.executeQuery(sql);
        if(!rs.next()){
        is_valid=false;
            
        }else{
        is_valid=true;
        }
        return is_valid;
        
        
        
    
    }
     public void GetTable() throws ClassNotFoundException, SQLException{
         Stage stage=new Stage();
        Connect obj=new Connect();
        Connection con=obj.connect();
        JFXTreeTableColumn<RouteController.Distances,String> idColumn=new JFXTreeTableColumn<>("Distance ID");
        idColumn.setPrefWidth(100);
        idColumn.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<RouteController.Distances, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<RouteController.Distances, String> param) {
               return param.getValue().getValue().id;
            }
        });
        JFXTreeTableColumn<RouteController.Distances,String> distance=new JFXTreeTableColumn<>("Distance ID");
        distance.setPrefWidth(300);
        distance.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<RouteController.Distances, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<RouteController.Distances, String> param) {
               return param.getValue().getValue().distance;
            }
        });
        JFXTreeTableColumn<RouteController.Distances,String> fromBranch=new JFXTreeTableColumn<>("Distance ID");
        fromBranch.setPrefWidth(300);
        fromBranch.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<RouteController.Distances, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<RouteController.Distances, String> param) {
               return param.getValue().getValue().frombranch;
            }
        });
        JFXTreeTableColumn<RouteController.Distances,String> toBranch=new JFXTreeTableColumn<>("Distance ID");
        toBranch.setPrefWidth(200);
        toBranch.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<RouteController.Distances, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<RouteController.Distances, String> param) {
               return param.getValue().getValue().tobranch;
            }
        });
        

        
        ObservableList<RouteController.Distances> distances=FXCollections.observableArrayList();
        
        Statement stmt=(Statement) con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from distance_detail");  
        while(rs.next()) {
             distances.add(new RouteController.Distances(Integer.toString(rs.getInt("id")),rs.getString("from_b"),rs.getString("to_b"),rs.getString("distance") ));
        }
        
        final TreeItem<RouteController.Distances> roots=new RecursiveTreeItem<RouteController.Distances>(distances,RecursiveTreeObject::getChildren);
        distanceTable.getColumns().setAll(idColumn,fromBranch,toBranch,distance);
        
        distanceTable.setRoot(roots);
        distanceTable.setShowRoot(false);
    }
    class Distances extends RecursiveTreeObject<Distances>{
        StringProperty id;
        StringProperty tobranch;
        StringProperty frombranch;
        StringProperty distance;
        

        public Distances(String id, String frombranch,String tobranch,String distance) {
            this.id = new SimpleStringProperty (id);
            this.frombranch = new SimpleStringProperty(frombranch);
            this.tobranch = new SimpleStringProperty(tobranch);
            this.distance = new SimpleStringProperty(distance);
        }
        
        
    }
    
}
