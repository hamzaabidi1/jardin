/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.IService;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author berssellou
 */
public interface IMetier <user>{
    List<user> SearchByNameParent(String name) throws SQLException;
    List<user> SearchByNameStaff(String nom) throws SQLException;
    int nbrParent()throws SQLException;
    int nbrStaff()throws SQLException;
    user findById(int idUser)throws SQLException;
    
    
}
