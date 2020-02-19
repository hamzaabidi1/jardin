/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.jardin.IService.IService;
import com.esprit.Entite.Garde;
import com.esprit.Utils.SingletonConnexion;
//import com.esprit.Utils.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yosrb
 */
public class ServiceGarde implements IService<Garde> {

    private Statement ste;
    Connection con = SingletonConnexion.getCnx();

    public ServiceGarde() {

    }

    @Override
    public void ajouter(Garde t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert;
        requeteInsert = "INSERT INTO `garde` (`id`,`Type_garde`, `Heure_debut_Garde`, `Heure_fin_Garde`, `Date_Garde`, `Id_Staff`, `Id_Enfant` ) VALUES (NULL,'" + t.getType_garde() + "', '" + t.getHeure_debut_Garde() + "', '" + t.getHeure_fin_Garde() + "', '" + t.getDate_Garde() + "', '" + t.getId_Staff() + "', '" + t.getId_Enfant() + "');";
        ste.executeUpdate(requeteInsert);
    }

    @Override
    public boolean delete(Garde t) throws SQLException {
        ste = con.createStatement();
        String requeteDelete;
        requeteDelete = "delete from garde where Id_Staff ='" + t.getId_Staff() + "' and Id_Enfant =' " + t.getId_Enfant() + "';";
        ste.executeUpdate(requeteDelete);
        return true;
    }

    @Override
    public boolean update(Garde t) throws SQLException {

        ste = con.createStatement();
        String requeteDelete;
        requeteDelete = "UPDATE garde SET Heure_debut_Garde='"+t.getHeure_debut_Garde()+"' ,Heure_fin_Garde='"+t.getHeure_fin_Garde()+"'  WHERE Id='"+t.getId()+"';";
        ste.executeUpdate(requeteDelete);
        return true;
    }

       public List<Garde> afficher(){
    List<Garde> myList= new ArrayList<>();
     String req="SELECT * FROM  garde ";
           
        try {
            ste=con.createStatement();
            ResultSet rs= ste.executeQuery(req);
            while(rs.next()){
                Garde c =new Garde(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6),rs.getInt(7));                
                myList.add(c);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceGarde.class.getName()).log(Level.SEVERE, null, ex);
        }

    return myList;
}
    @Override
    public List<Garde> readAllParent() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Garde> readAllStaff() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean search(Garde t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
