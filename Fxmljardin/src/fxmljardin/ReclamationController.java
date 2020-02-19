/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmljardin;

import com.esprit.Entite.Demande;
import com.esprit.Entite.Reclamation;
import com.esprit.Entite.Statut;
import com.esprit.Entite.user;
import com.esprit.Service.MetierUser;
import com.esprit.Service.ServiceDemande;
import com.esprit.Service.ServiceReclamation;
import com.esprit.Service.ServiceUser;
import com.esprit.Utils.SendMail;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class ReclamationController implements Initializable {

    @FXML
    private TextField txtNom;
    @FXML
    private ChoiceBox<String> lstMembre;
    @FXML
    private TextArea txtDescription;
    @FXML
    private Button btnReclamer;
    @FXML
    private Button btnAnnuler;
    @FXML
    private Button btnConsulter;
    @FXML
    private ImageView imghome;
    List<user> list;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imghome.setImage(new Image("/resources/images/home.png"));
        ServiceUser serviceUser = new ServiceUser();
        
        List<String> staffName = new  ArrayList<>();
        ObservableList<String> l;
        
        try {

            list = serviceUser.readAllStaff();
            for (int i = 0; i < list.size(); i++) {
                staffName.add(list.get(i).getNom());
            }
            l = FXCollections.observableArrayList(staffName);
            lstMembre.setItems(l);
            
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public TextField getTxtNom() {
        return txtNom;
    }

    public ChoiceBox<?> getLstMembre() {
        return lstMembre;
    }

    public TextArea getTxtDescription() {
        return txtDescription;
    }

    @FXML
    private void Reclamer(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("confirmer");
        alert.setContentText("veuillez confirmez la demande");
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(this.getClass().getResource("/resources/images/iconApp.png").toString()));
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {

            Reclamation reclamation = new Reclamation();
            ServiceReclamation serviceReclamation = new ServiceReclamation();
            user u = new user(1, "Parent", "mehdi", "hiii", "labidihamza099@gmail.com", 21365897, "mmmm", "mdmdmdm", null);
          
          user user = new user() ;
           MetierUser metierUser = new MetierUser();
           Date date=new Date();
                   
           try {
          int index =    lstMembre
                      .getSelectionModel().getSelectedIndex() ;
          user Staffselectionner=null ;
          for (int i=0;i<list.size();i++)
          if (index==i)
              
          Staffselectionner= list.get(i);
                  reclamation.setDate(date.toString());
                  reclamation.setNom_reclamation(txtNom.getText());
                  reclamation.setDescription(txtDescription.getText());
                  reclamation.setStatut(Statut.en_cours.toString());
                  reclamation.setStaff(metierUser.findById(Staffselectionner.getId()));
                  reclamation.setParent(metierUser.findById(u.getId()));
                  serviceReclamation.Reclamer(reclamation);
                  SendMail.sendMail(u.getMail(), "Reclamation", "Votre Reclamation est effectée avec succée"
                          + "nous resoudrons le probléme plus prochainement ");

            } catch (Exception ex) {
               Logger.getLogger(DemandeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Reclamation");
                alert1.setContentText("votre Reclamation a été ajoutée avec succées");
                Stage stage1 = (Stage) alert1.getDialogPane().getScene().getWindow();
                stage1.getIcons().add(new Image(this.getClass().getResource("/resources/images/iconApp.png").toString()));
                Optional<ButtonType> result1 = alert1.showAndWait();
                if (result1.get() == ButtonType.OK) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Acceuil.fxml"));
                    Parent root;

                    root = loader.load();

                    AcceuilController dc = loader.getController();
                    imghome.getScene().setRoot(root);
                }
            } catch (IOException ex) {
                Logger.getLogger(DemandeController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @FXML
    private void Annuler(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Acceuil.fxml"));
            Parent root = loader.load();
            AcceuilController dc = loader.getController();
            imghome.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(DemandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Consulter(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeReclamation.fxml"));
            Parent root = loader.load();
            ListeReclamationController dc = loader.getController();
            btnConsulter.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void gohome(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Acceuil.fxml"));
            Parent root = loader.load();
            AcceuilController dc = loader.getController();
            imghome.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(DemandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
