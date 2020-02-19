/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmljardin;

import com.esprit.Entite.Demande;
import com.esprit.Entite.Statut;
import com.esprit.Entite.user;
import com.esprit.Service.ServiceDemande;
import static java.awt.SystemColor.window;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class ListeDemandeController implements Initializable {

    @FXML
    private TableView<Demande> lstDemande;
    @FXML
    private ImageView imghome;
    @FXML
    private ImageView imgreturn;
    @FXML
    private TableColumn<Demande, String> champStatut;
    @FXML
    private TableColumn<Demande, String> champReponse;
    @FXML
    private TableColumn<Demande, String> champNom;
    @FXML
    private TableColumn<Demande, String> description;
    @FXML
    private ImageView editer;
    @FXML
    private ImageView delete;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtDescription;
    
    @FXML
    private TextField search;
    
    
    user u = new user(1, "eleve", "hamza", "abidi", "okoko", 0, "mdp", "mourouj", "emploi");
    List<Demande> list = new ArrayList();
    Demande demande = new Demande();
    Demande demandeselectinnee = new Demande();
    ServiceDemande serviceDemande = new ServiceDemande();
    ObservableList<Demande> l = FXCollections.observableArrayList();
  
    

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        imghome.setImage(new Image("/resources/images/home.png"));
        imgreturn.setImage(new Image("/resources/images/return.png"));
        delete.setImage(new Image("/resources/images/delete.jpg"));
        editer.setImage(new Image("/resources/images/edit.png"));
        list = serviceDemande.getAllDemandeUser(u);
       
        ObservableList<Demande> l = FXCollections.observableArrayList(list);
        lstDemande.setEditable(true);
        champNom.setCellValueFactory(new PropertyValueFactory<>("nom_demande"));
        champStatut.setCellValueFactory(new PropertyValueFactory<>("Statut"));
        champReponse.setCellValueFactory(new PropertyValueFactory<>("Reponse"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        lstDemande.setItems(l);

        FilteredList<Demande> filteredData = new FilteredList<>(l, b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        search.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(demande -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (demande.getNom_demande().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches first name.
                } else if (String.valueOf(demande.getStatut()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                } else if (demande.getReponse().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false; // Does not match.
                }
            });
        });

		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Demande> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(lstDemande.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		lstDemande.setItems(sortedData);
               
        
    }    




    @FXML
    private void gohome(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Acceuil.fxml"));
            Parent root = loader.load();
            AcceuilController dc = loader.getController();
            imghome.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ListeDemandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void retour(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Demande.fxml"));
            Parent root = loader.load();
            DemandeController dc = loader.getController();
            imghome.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ListeDemandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void editer(MouseEvent event) {
        demandeselectinnee=lstDemande.getSelectionModel().getSelectedItem();
        if((txtDescription.getText()!="") || (txtNom.getText()!=""))
        {
        demandeselectinnee.setNom_demande(txtNom.getText());
        demandeselectinnee.setDescription(txtDescription.getText());
        serviceDemande.editerDemande(demandeselectinnee);
        }
        if(txtDescription.getText()==""){
            demandeselectinnee.setNom_demande(txtNom.getText());      
        serviceDemande.editerDemande(demandeselectinnee);
        }
        if(txtNom.getText()==""){
        demandeselectinnee.setDescription(txtDescription.getText());
        serviceDemande.editerDemande(demandeselectinnee);  
        }
        else{
          serviceDemande.editerDemande(demandeselectinnee);   
        }
        
    }

    @FXML
    private void supprimer(MouseEvent event) {
        demandeselectinnee=lstDemande.getSelectionModel().getSelectedItem();
        lstDemande.getItems().removeAll(demandeselectinnee);
        serviceDemande.supprimerDemande(demandeselectinnee);
    }


}
