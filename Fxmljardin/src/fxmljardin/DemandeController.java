/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmljardin;

import com.esprit.Entite.Demande;
import com.esprit.Entite.Statut;
import com.esprit.Entite.user;
import com.esprit.Service.*;
import com.esprit.Utils.SendMail;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.mail.MessagingException;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class DemandeController implements Initializable {

    @FXML
    private TextArea txtDescriptionDemande;
    @FXML
    private Button btnDemander;
    @FXML
    private Button btnAnnuler;
    @FXML
    private Button btnConsulter;
    @FXML
    private TextField txtNomdemande;
    @FXML
    private ImageView imghome;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imghome.setImage(new Image("/resources/images/home.png"));
    }

    public TextArea getTxtDescriptionDemande() {
        return txtDescriptionDemande;
    }

    public TextField getTxtNomdemande() {
        return txtNomdemande;
    }
    
    user u = new user(1, "Parent", "mehdi", "hiii", "labidihamza099@gmail.com", 21365897, "mmmm", "mdmdmdm", null);


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

    @FXML
    private void consultation(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ListeDemande.fxml"));
            Parent root = loader.load();
            ListeDemandeController dc = loader.getController();
            btnConsulter.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(DemandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void confirmerDemande(ActionEvent event) throws MessagingException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("confirmer");
        alert.setContentText("veuillez confirmez la demande");
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(this.getClass().getResource("/resources/images/iconApp.png").toString()));
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {

            Demande d = new Demande(Statut.en_cours);
            ServiceDemande serviceDemande = new ServiceDemande();
            MetierUser metierUser = new MetierUser();
            try {
                d.setDescription(getTxtDescriptionDemande().getText());
                d.setNom_demande(getTxtNomdemande().getText());
                d.setReponse(null);

                d.setUser(metierUser.findById(u.getId()));
                serviceDemande.ajouterDemande(d);
                
            } catch (Exception ex) {
                Logger.getLogger(DemandeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert1.setTitle("Demande");
                alert1.setContentText("votre demande a été ajouter avec succées");
                Stage stage1 = (Stage) alert1.getDialogPane().getScene().getWindow();
                stage1.getIcons().add(new Image(this.getClass().getResource("/resources/images/iconApp.png").toString()));
                Optional<ButtonType> result1 = alert1.showAndWait();
                if (result1.get() == ButtonType.OK) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Acceuil.fxml"));
                    Parent root;

                    root = loader.load();

                    AcceuilController dc = loader.getController();
                    imghome.getScene().setRoot(root);
                    SendMail.sendMail(u.getMail(), "Demande", "Votre demande a été bien enregistrer merci ");
                }
            } catch (IOException ex) {
                Logger.getLogger(DemandeController.class.getName()).log(Level.SEVERE, null, ex);
            }

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
            Logger.getLogger(DemandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
