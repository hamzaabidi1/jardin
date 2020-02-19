/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.user;
import com.esprit.Utils.SingletonConnexion;
import com.jardin.IService.IService;

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
public class ServiceUser implements IService<user> {
     Connection con=SingletonConnexion.getCnx();
    private Statement ste;

 

    @Override
    public void ajouter(user t) throws SQLException {
         ste = con.createStatement();
         String requeteInsert = "INSERT INTO `jardin`.`user` (`id`, `role`,`nom`, `prenom`,`mail`,`num`,`mdp`,`adresse`,`emploi`) VALUES (NULL, '" + t.getRole()+"', '" + t.getNom() + "', '" + t.getPrenom() + "', '" + t.getMail()+"', '" + t.getNum()+"', '" + t.getMdp()+"', '" + t.getAdresse()+"', '" + t.getEmploi()+ "');";
        ste.executeUpdate(requeteInsert);
    }
    
    

    @Override
    public boolean delete(user t) throws SQLException {
        if (search(t)==true){
         ste = con.createStatement();
         String requeteDelete ="DELETE FROM `user` WHERE id="+ t.getId();
         ste.executeUpdate(requeteDelete);}
         else{
           System.out.println("L'utulisateur n'existe pas");
        }
         return true;
    }

    @Override
    public boolean update(user t) throws SQLException {
         if (search(t)==true){
             PreparedStatement pre=con.prepareStatement("UPDATE jardin.`user` SET ID = ?, `role` = ?,nom = ?,`prenom` = ?,`mail` = ?,`num` = ?,`mdp` = ?,`adresse` = ?,`emploi` = ? WHERE `Id`=? ;");
        pre.setInt(1,t.getId());
        pre.setString(2,t.getRole());
        pre.setString(3,t.getNom()); 
        pre.setString(4,t.getPrenom());
        pre.setString(5,t.getMail());
        pre.setInt(6,t.getNum());
        pre.setString(7,t.getMdp());
        pre.setString(8,t.getAdresse());
        pre.setString(9,t.getEmploi());
        pre.setInt(10,t.getId());
        pre.executeUpdate();
return true;}
          else{
           System.out.println("L'utulisateur n'existe pas");
           return true;
        }
    }

    @Override
    public List<user> readAllParent() throws SQLException {
         List<user> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from user WHERE role='Parent'");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String role=rs.getString(2);
               String nom=rs.getString(3);
               String prenom=rs.getString(4);
               String mail=rs.getString(5);
               int num=rs.getInt(6);
               String mdp=rs.getString(7);
               String adresse=rs.getString(8);
               String emploi=rs.getString(9);
               
               
               user p=new user(id,role,nom,prenom,mail,num,mdp,adresse,emploi);
     arr.add(p);
     }
    return arr;

    }

    @Override
    public List<user> readAllStaff() throws SQLException {
        List<user> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from user WHERE role='Staff'");
     while (rs.next()) {                
               int id=rs.getInt(1);
               String role=rs.getString(2);
               String nom=rs.getString(3);
               String prenom=rs.getString(4);
               String mail=rs.getString(5);
               int num=rs.getInt(6);
               String mdp=rs.getString(7);
               String adresse=rs.getString(8);
               String emploi=rs.getString(9);
               
               
               user p=new user(id,role,nom,prenom,mail,num,mdp,adresse,emploi);
     arr.add(p);
     }
    return arr;

    }

    @Override
    public boolean search(user u) throws SQLException {
     
        ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from user");
    boolean ok=false; 
    while (rs.next()&&(ok==false)) {         
         if (rs.getInt(1)==u.getId())
             ok=true;
     }
     return ok;
    }
    
}
