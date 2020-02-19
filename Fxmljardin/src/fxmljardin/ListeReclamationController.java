/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmljardin;

import com.esprit.Entite.Demande;
import com.esprit.Entite.Reclamation;
import com.esprit.Entite.user;
import com.esprit.Service.ServiceDemande;
import com.esprit.Service.ServiceReclamation;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author hamza
 */
public class ListeReclamationController implements Initializable {

    @FXML
    private TableView<Reclamation> tabView;
    @FXML
    private TableColumn<Reclamation, String> champnom;
    @FXML
    private TableColumn<Reclamation, String> champdate;
    @FXML
    private TableColumn<Reclamation, String> champStatut;
    
    @FXML
    private ImageView imgretour;
    @FXML
    private ImageView imghome;
    
    @FXML
    private TableColumn<?, ?> champDescription;
    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtDescription;
    
     @FXML
    private ImageView supprimer;
    @FXML
    private ImageView edit;
    
   
    user u = new user(1, "eleve", "hamza", "abidi", "okoko", 0, "mdp", "mourouj", "emploi");
    List<Reclamation> list = new ArrayList();
    Reclamation reclamation = new Reclamation();
    Reclamation reclamationSelectionnee = new Reclamation();
    ServiceReclamation serviceReclamation = new ServiceReclamation();
    @FXML
    private TextField search;
   
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imghome.setImage(new Image("/resources/images/home.png"));
        imgretour.setImage(new Image("/resources/images/return.png"));
        supprimer.setImage(new Image("/resources/images/delete.jpg"));
        edit.setImage(new Image("/resources/images/edit.png"));
        list = serviceReclamation.getAllReclamationUser(u);
        ServiceReclamation serviceReclamation = new ServiceReclamation();
        user u = new user(1, "eleve", "hamza", "abidi", "okoko", 0, "mdp", "mourouj", "emploi");
        List list = serviceReclamation.getAllReclamationUser(u);
        ObservableList<Reclamation> l = FXCollections.observableArrayList(list);
        tabView.setEditable(true);
        champnom.setCellValueFactory(new PropertyValueFactory<>("nom_reclamation"));
        champStatut.setCellValueFactory(new PropertyValueFactory<>("statut"));
        champdate.setCellValueFactory(new PropertyValueFactory<>("date"));
        champDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tabView.setItems(l);
        
    FilteredList<Reclamation> filteredData = new FilteredList<>(l, b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        search.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(reclamation -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (reclamation.getNom_reclamation().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches first name.
                } else if (String.valueOf(reclamation.getStatut()).toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                } else if (reclamation.getDate().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false; // Does not match.
                }
            });
        });

		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Reclamation> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tabView.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tabView.setItems(sortedData);
               
        //todo
    }


    @FXML
    private void retour(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Reclamation.fxml"));
            Parent root = loader.load();
            ReclamationController dc = loader.getController();
            imgretour.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ListeReclamationController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ListeDemandeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void supprimer(MouseEvent event) {
        reclamationSelectionnee=tabView.getSelectionModel().getSelectedItem();
        tabView.getItems().removeAll(reclamationSelectionnee);
        serviceReclamation.supprimerReclamation(reclamationSelectionnee);
    }

    @FXML
    private void edit(ContextMenuEvent event) {
            reclamationSelectionnee=tabView.getSelectionModel().getSelectedItem();
        if((txtDescription.getText()!="") || (txtNom.getText()!=""))
        {
        reclamationSelectionnee.setNom_reclamation(txtNom.getText());
        reclamationSelectionnee.setDescription(txtDescription.getText());
        serviceReclamation.editerReclamation(reclamationSelectionnee);
        }
        if(txtDescription.getText()==""){
            reclamationSelectionnee.setNom_reclamation(txtNom.getText());      
        serviceReclamation.editerReclamation(reclamationSelectionnee);
        }
        if(txtNom.getText()==""){
        reclamationSelectionnee.setDescription(txtDescription.getText());
        serviceReclamation.editerReclamation(reclamationSelectionnee);  
        }
        else{
          serviceReclamation.editerReclamation(reclamationSelectionnee);   
        }
    }

    @FXML
    private void search(ActionEvent event) {
    }

}
