/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.IService;

import com.esprit.Entite.Demande;
import com.esprit.Entite.Statut;
import com.esprit.Entite.user;
import java.util.List;

/**
 *
 * @author hamza
 */
public interface IserviceDemande {
    public void ajouterDemande(Demande r);
    public void editerDemande(Demande d);
    public void supprimerDemande(Demande r);
    public List<Demande> getAllDemandeUser(user u);
    public Demande getDemande(int iddem);
    
}
