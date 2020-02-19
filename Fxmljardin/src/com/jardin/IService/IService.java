/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jardin.IService;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author berssellou
 */
public interface IService <user>{
     void ajouter(user t) throws SQLException;
    boolean delete(user t) throws SQLException;
    boolean update(user t) throws SQLException;
    List<user> readAllParent() throws SQLException;
    List<user> readAllStaff() throws SQLException;
    public boolean search(user t) throws SQLException;

    
}
