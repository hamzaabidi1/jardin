/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Entite;

/**
 *
 * @author yosrb
 */
public class Garde {
    
    private String Type_garde;
    private String Heure_debut_Garde;
    private String Heure_fin_Garde;
    private String Date_Garde;
    private int Id_Staff;
    private int Id_Enfant;
    private int id;

    public Garde(String Type_garde, String Heure_debut_Garde, String Heure_fin_Garde, String Date_Garde, int Id_Staff, int Id_Enfant, int id) {
        this.Type_garde = Type_garde;
        this.Heure_debut_Garde = Heure_debut_Garde;
        this.Heure_fin_Garde = Heure_fin_Garde;
        this.Date_Garde = Date_Garde;
        this.Id_Staff = Id_Staff;
        this.Id_Enfant = Id_Enfant;
        this.id = id;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getType_garde() {
        return Type_garde;
    }

    public void setType_garde(String Type_garde) {
        this.Type_garde = Type_garde;
    }

    public String getHeure_debut_Garde() {
        return Heure_debut_Garde;
    }

    public void setHeure_debut_Garde(String Heure_debut_Garde) {
        this.Heure_debut_Garde = Heure_debut_Garde;
    }

    public String getHeure_fin_Garde() {
        return Heure_fin_Garde;
    }

    public void setHeure_fin_Garde(String Heure_fin_Garde) {
        this.Heure_fin_Garde = Heure_fin_Garde;
    }

    public String getDate_Garde() {
        return Date_Garde;
    }

    public void setDate_Garde(String Date_Garde) {
        this.Date_Garde = Date_Garde;
    }

    public int getId_Staff() {
        return Id_Staff;
    }

    public void setId_Staff(int Id_Staff) {
        this.Id_Staff = Id_Staff;
    }

    public int getId_Enfant() {
        return Id_Enfant;
    }

    public void setId_Enfant(int Id_Enfant) {
        this.Id_Enfant = Id_Enfant;
    }

    @Override
    public String toString() {
        return "Garde{" + "id=" + id + ", Type_garde=" + Type_garde + ", Heure_debut_Garde=" + Heure_debut_Garde + ", Heure_fin_Garde=" + Heure_fin_Garde + ", Date_Garde=" + Date_Garde + ", Id_Staff=" + Id_Staff + ", Id_Enfant=" + Id_Enfant + '}';
    }


    
    
    
    
}
