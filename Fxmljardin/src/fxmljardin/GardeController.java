/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmljardin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class GardeController implements Initializable {

    @FXML
    private ChoiceBox<String> choiceViewType;
    @FXML
    private ChoiceBox<String> choiceViewHeureDeb;
    @FXML
    private ChoiceBox<String> choiceViewHeureFin;
    @FXML
    private DatePicker DteDate;
    @FXML
    private Button btnAjout;
    @FXML
    private Button btnAnnuler;
    @FXML
    private Button btnConsulter;
    @FXML
    private ImageView imgHome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         imgHome.setImage(new Image("/resources/images/home.png"));
         ObservableList<String> time ;//
              time  = FXCollections.observableArrayList(
    "00h00", "01h00", "03h00", "04h00", "05h00", "06h00", "07h00", "08h00", "09h00"
         , "10h00", "11h00", "12h00", "13h00", "14h00", "15h00", "16h00", "17h00"
         , "18h00", "19h00", "20h00", "21h00", "22h00", "23h00");
       
            choiceViewHeureDeb.setItems(time);
            choiceViewHeureFin.setItems(time);
 
      
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
    }

    @FXML
    private void gohome(MouseEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Acceuil.fxml"));
            Parent root = loader.load();
            AcceuilController dc = loader.getController();
            imgHome.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(GardeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void annuler(ActionEvent event) {
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Acceuil.fxml"));
            Parent root = loader.load();
            AcceuilController dc = loader.getController();
            btnAnnuler.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(GardeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void consulter(ActionEvent event) {
                 try {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("ListeGarde.fxml"));
            Parent root = loader.load();
            ListeGardeController dc=loader.getController();
            btnConsulter.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(GardeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
