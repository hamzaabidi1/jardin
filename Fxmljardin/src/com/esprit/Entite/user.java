/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite ;

/**
 *
 * @author berssellou
 */
public class user {
    private int id;
    private String role;
    private String nom;
    private String prenom;
    private String mail;
    private int num;
    private String mdp;
    private String adresse;
    private String emploi;

    public user(int id, String role, String nom, String prenom, String mail, int num, String mdp, String adresse, String emploi) {
        this.id = id;
        this.role = role;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.num = num;
        this.mdp = mdp;
        this.adresse = adresse;
        this.emploi = emploi;
    }

    public user(String role, String nom, String prenom, String mail, int num, String mdp, String adresse, String emploi) {
        this.role = role;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.num = num;
        this.mdp = mdp;
        this.adresse = adresse;
        this.emploi = emploi;
    }

    public user() {
    }

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMail() {
        return mail;
    }

    public int getNum() {
        return num;
    }

    public String getMdp() {
        return mdp;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmploi() {
        return emploi;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmploi(String emploi) {
        this.emploi = emploi;
    }

    @Override
    public String toString() {
        return "user{" + "id=" + id + ", role=" + role + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", num=" + num + ", mdp=" + mdp + ", adresse=" + adresse + ", emploi=" + emploi + '}';
    }
    
}
