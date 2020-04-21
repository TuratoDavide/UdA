/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.dao;

import java.util.List;
 
import myapp.model.Accessi;
import myapp.model.Utenti;
 
public interface AccessiDao {
    Accessi findById(int idAccesso);
    void saveAccesso(Accessi accesso);
    void deleteAccesso(int id);
    List<Accessi> findAllAccessi();
 }