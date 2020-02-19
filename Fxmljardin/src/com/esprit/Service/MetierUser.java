/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service ;

import com.esprit.Entite.user;
import com.esprit.Utils.SingletonConnexion;
import com.esprit.IService.IMetier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author berssellou
 */
public class MetierUser implements IMetier<user> {

    Connection con=SingletonConnexion.getCnx();
    private Statement ste;

   

    @Override
    public List<user> SearchByNameParent(String name) throws SQLException {
        List<user> arr = new ArrayList<>();
        PreparedStatement pre = con.prepareStatement("select * from user WHERE nom LIKE ? and role='Parent'");
        pre.setString(1, "%" + name + "%");
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);
            String role = rs.getString(2);
            String nom = rs.getString(3);
            String prenom = rs.getString(4);
            String mail = rs.getString(5);
            int num = rs.getInt(6);
            String mdp = rs.getString(7);
            String adresse = rs.getString(8);
            String emploi = rs.getString(9);

            user p = new user(id, role, nom, prenom, mail, num, mdp, adresse, emploi);
            arr.add(p);
        }
        return arr;

    }

    @Override
    public List<user> SearchByNameStaff(String name) throws SQLException {
        List<user> arr = new ArrayList<>();
        PreparedStatement pre = con.prepareStatement("select * from user WHERE nom LIKE ? and role='Staff'");
        pre.setString(1, "%" + name + "%");
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);
            String role = rs.getString(2);
            String nom = rs.getString(3);
            String prenom = rs.getString(4);
            String mail = rs.getString(5);
            int num = rs.getInt(6);
            String mdp = rs.getString(7);
            String adresse = rs.getString(8);
            String emploi = rs.getString(9);

            user p = new user(id, role, nom, prenom, mail, num, mdp, adresse, emploi);
            arr.add(p);
        }
        return arr;
    }

    @Override
    public int nbrParent() throws SQLException {
        int nbr = 0;
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select count(Id) from user WHERE role='Parent'");
        while (rs.next()) {
            nbr = rs.getInt(1);

        }
        return nbr;

    }

    @Override
    public int nbrStaff() throws SQLException {
        int nbr = 0;
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select count(Id) from user WHERE role='Staff'");
        while (rs.next()) {
            nbr = rs.getInt(1);

        }
        return nbr;
    }

    @Override
    public user findById(int idUser) throws SQLException {
        user p=new user();
        PreparedStatement pre = con.prepareStatement("select * from user WHERE id=? ");
        pre.setInt(1, idUser);
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);
            String role = rs.getString(2);
            String nom = rs.getString(3);
            String prenom = rs.getString(4);
            String mail = rs.getString(5);
            int num = rs.getInt(6);
            String mdp = rs.getString(7);
            String adresse = rs.getString(8);
            String emploi = rs.getString(9);

            p = new user(id, role, nom, prenom, mail, num, mdp, adresse, emploi);
        }
        return p;

    }

}
