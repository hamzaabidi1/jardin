/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

import javafx.scene.control.Button;

/**
 *
 * @author hamza
 */
public class Reclamation {

    private user Staff;
    private user parent;
    private int id_reclamation;
    private String statut;
    private String description;
    private String date;
    private String nom_reclamation;
    private Button buttonEditer;    
    private Button buttonSupprimer;

    public Reclamation(user Staff, user parent, int id_reclamation, String statut, String description, String date,String nom_reclamation) {
        this.Staff = Staff;
        this.parent = parent;
        this.id_reclamation = id_reclamation;
        this.statut = statut;
        this.description = description;
        this.date = date;
        this.nom_reclamation=nom_reclamation;
        this.buttonEditer=new Button("Editer");
        this.buttonSupprimer=new Button("Supprimer");
    }

    public Reclamation() {
    }

    public Button getButtonEditer() {
        return buttonEditer;
    }

    public void setButtonEditer(Button buttonEditer) {
        this.buttonEditer = buttonEditer;
    }

    public Button getButtonSupprimer() {
        return buttonSupprimer;
    }

    public void setButtonSupprimer(Button buttonSupprimer) {
        this.buttonSupprimer = buttonSupprimer;
    }
    
    

    public String getNom_reclamation() {
        return nom_reclamation;
    }

    public void setNom_reclamation(String nom_reclamation) {
        this.nom_reclamation = nom_reclamation;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public user getStaff() {
        return Staff;
    }

    public void setStaff(user Staff) {
        this.Staff = Staff;
    }

    public user getParent() {
        return parent;
    }

    public void setParent(user parent) {
        this.parent = parent;
    }



    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    @Override
    public String toString() {
        return "Reclamer{" + "Staff=" + Staff + ", parent=" + parent + ", id_reclamation=" + id_reclamation + ", statut=" + statut + ", description=" + description + ", date=" + date + '}';
    }

}
