package com.esprit.test;


import com.esprit.Service.ServiceDemande;
import com.esprit.Service.ServiceReclamation;
import com.esprit.Entite.Demande;
import com.esprit.Entite.Reclamation;
import com.esprit.Utils.SendMail;
import com.esprit.Entite.Statut;
import com.esprit.Entite.user;
import com.esprit.Service.MetierUser;
import com.esprit.Service.ServiceUser;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hamza
 */
public class test {
  
    
    public static void main(String[] args) {
        try {
            //        try{
//        SendMail.sendMail("labidihamza099@gmail.com","subject", "message");
//        }catch(Exception e){
//           e.getMessage();
//        }
//        
//        Date d=new Date(); System.out.println(d);
List l=new ArrayList();
user user = new user(4, "eleve", "hamza", "abidi",  "okoko", 0, "mdp",   "mourouj", "emploi") ;

//ServiceDemande s= new ServiceDemande();
ServiceReclamation r=new ServiceReclamation();
Reclamation req=new Reclamation(user, user, 3," statut", "description", "date", "nom_reclamation");
r.supprimerReclamation(req);

//        l= s.getAllDemandeUser(user);
//        System.out.print(l);
//      
//         Reclamation r=new Reclamation(user,user,1,"att","645","ukhgiuk");
//        ServiceUser Su=new ServiceUser();
////        try {
////            Su.ajouter(user);
////        } catch (SQLException ex) {
////            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
////       }
//ServiceReclamation s = new ServiceReclamation();
// //  s.Reclamer(r);
//l = s.getAllReclamationUser(user);
//System.out.println("bonjour"+l);
//MetierUser u = new MetierUser() ;
//            System.out.println(u.findById(4));   
//  System.out.println("jkfdvbs");
////       r2=s.getReclamation (1);
////        System.out.println(r2);
//   // s.editerReclamation(1,"en cours");
// // s.supprimerReclamation(r);
//   Demande d = new Demande(2,"party", Statut.accepte, null, "jhjh", user);
// //  List l;
//        ServiceDemande dd =new ServiceDemande();
//     //  dd.ajouterDemande(d);
//        //  dd.supprimerDemande(d); 
//    //    l=dd.getAllDemande();
//      //   System.out.println(l);
//  Demande d1=dd.getDemande(1);
//   System.out.println(d1);
//  //dd.editerDemande(1, Statut.accepte,"jawek behi");
// //  l=dd.getAllDemande();
//     //    System.out.println(l);
//  
        } catch (Exception ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
}
