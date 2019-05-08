/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsa.shortest.path;

import DB.Connect;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shashilaheshan
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    Connect obj=new Connect();
    
    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXButton btnClear;

    @FXML
    void Clear(ActionEvent event) {

    }

    @FXML
    void Login(ActionEvent event) throws SQLException, ClassNotFoundException {
     
        Connection con=obj.connect();
        String username=txtUsername.getText().trim();
        String password=txtPassword.getText().trim();
        
        if(username!=""&&password!=""){
         if(con!=null){
        
           try{
               Statement stmt=(Statement) con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from users where username='"+username+"' and password='"+password+"'");  
        if(!rs.next()) {
               Alert alert = new Alert(AlertType.ERROR);
               alert.setTitle("Error");
               alert.setHeaderText("Wrong Credentials");
               String s ="Username or password is wrong try again.";
               alert.setContentText(s);
               alert.show();
        }else{
                Stage primaryStage=new Stage();
                URL url = getClass().getResource("Home.fxml");
                 //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("../login/login.fxml"));
                Parent root = FXMLLoader.load(url);
                Scene scene = new Scene(root, 900, 500);

                primaryStage.setTitle("Home");
                primaryStage.setScene(scene);
                primaryStage.show();
        } 

            con.close();  
               
               
               
           }catch(Exception ex){
           
           
           }
        
        }else{
            
        }
        
        }else{
         Alert alert = new Alert(AlertType.ERROR);
       alert.setTitle("Error");
       alert.setHeaderText("Please Enter the username and password");
       String s ="Username and password is required";
       alert.setContentText(s);
       alert.show();
        
        }
        
       
        
        
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    
}
