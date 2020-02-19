/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

/**
 *
 * @author House
 */
public class Menu {
    private int id_menu;
    private String entree;
    private String plat;
    private String dessert;
    private user user;
    
    public Menu(int id_menu, String entree, String plat, String dessert, user user) {
        this.id_menu = id_menu;
        this.entree = entree;
        this.plat = plat;
        this.dessert = dessert;
        this.user = user;
    }

    public Menu(String entree, String plat, String dessert) {
        this.entree= entree;
        this.plat = plat;
        this.dessert = dessert;
    }

    public int getId_menu() {
        return id_menu;
    }

    public void setId_menu(int id_menu) {
        this.id_menu = id_menu;
    }

    public String getEntree() {
        return entree;
    }

    public void setEntree(String entree) {
        this.entree = entree;
    }

    public String getPlat() {
        return plat;
    }

    public void setPlat(String plat) {
        this.plat = plat;
    }

    public String getDessert() {
        return dessert;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    public user getUser() {
        return user;
    }

    public void setUser(user user_id) {
        this.user = user_id;
    }
    @Override
    public String toString() {
        return "Menu{" + "id_menu=" + id_menu + ", entree=" + entree + ", plat=" + plat + ", dessert=" + dessert +", user_id=" + user + '}';
    }
    
}
