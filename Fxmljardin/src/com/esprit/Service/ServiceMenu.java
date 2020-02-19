/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;

import com.esprit.Entite.Menu;
import com.esprit.Entite.user;
import com.esprit.Utils.SingletonConnexion;

import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author House
 */
public class ServiceMenu  {

    private Connection con;
    private Statement ste;
    MetierUser metierUser ;
    public ServiceMenu() {
        con = SingletonConnexion.getCnx();
        

    }

 
    public void ajouter(Menu t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `menu` (`id_menu`, `entree`, `plat`, `dessert`,`user_id`) VALUES (NULL, '" + t.getEntree() + "', '" + t.getPlat() + "', '" + t.getDessert() +"', '" + t.getUser().getId() + "');";
        ste.executeUpdate(requeteInsert);
    }
   
    
     public void editerMenu(int id, String entree, String plat, String dessert) {
     Connection cnx=SingletonConnexion.getCnx();
        try{
            PreparedStatement ps=cnx.prepareStatement("UPDATE menu SET entree ='"+entree+"',plat ='"+plat+"',dessert ='"+dessert+"' where id_menu="+id+";" );
                   
            ps.executeUpdate();
            
        }
        catch(SQLException er)
        {
            System.err.println("probleme de requete Sql"+er.getMessage());
        }
    }
     
     public void supprimerMenu(Menu m) {
            Connection cnx=SingletonConnexion.getCnx();
        try{
            PreparedStatement ps=cnx.prepareStatement("delete from `menu` where id_menu ='"+m.getId_menu()+"' ;" );
                   
            ps.executeUpdate();
            
        }
        catch(SQLException er)
        {
            System.err.println("probleme de requete Sql"+er.getMessage());
        }
    }

     
    public List<Menu> getAllMenu() {
         Connection cnx =SingletonConnexion.getCnx();
         ArrayList<Menu> list=new ArrayList<Menu>();
        try{
            PreparedStatement ps=cnx.prepareStatement("select * from menu,user where user.Id=menu.id_user ; ;");
            ResultSet res=ps.executeQuery();
            while (res.next())
            {
            int id_user = res.getInt("id_user");
            user user = metierUser.findById(id_user);
            int id=res.getInt("id_menu");
            String entree=res.getString("entree");
            String plat=res.getString("plat");
            String dessert=res.getString("dessert");
           
           
             list.add(new Menu(id,entree,plat,dessert,user));
             
            }
        }
             catch(SQLException er)
        {
            System.err.println("probleme de requete Sql"+er.getMessage());
        }
        return list;
    }
    
     
    
}