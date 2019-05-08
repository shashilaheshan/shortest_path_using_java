/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdsa.shortest.path;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author shashilaheshan
 */
public class HomeController implements Initializable {

     @FXML
    private Label txtUser;

     /**
 *
 * Logout from system
 * 
 **/
    @FXML
    void Logout(MouseEvent event) throws IOException {

        Stage primaryStage=new Stage();
        Stage stage = (Stage) txtUser.getScene().getWindow();
    // do what you have to do
    stage.close();
        URL url = getClass().getResource("Login.fxml");
         //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("../login/login.fxml"));
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root, 700, 400);
    
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }

    @FXML
    void OpenBranchView(MouseEvent event) throws IOException {
        Stage primaryStage=new Stage();
         URL url = getClass().getResource("BranchView.fxml");
         //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("../login/login.fxml"));
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root, 900, 600);
    
        primaryStage.setTitle("Branch View");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    @FXML
    void OpenDistanceCalView(MouseEvent event) throws IOException {
        Stage primaryStage=new Stage();
        URL url = getClass().getResource("Route.fxml");
         //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("../login/login.fxml"));
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root, 900, 600);
    
        primaryStage.setTitle("Route Controller");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
    }   
    @FXML
    void OpenDistanceCal(MouseEvent event) throws IOException {
        Stage primaryStage=new Stage();
        URL url = getClass().getResource("ShortestPath.fxml");
         //Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("../login/login.fxml"));
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root, 900, 600);
    
        primaryStage.setTitle("Shortest Distance");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
