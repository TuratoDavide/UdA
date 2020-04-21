/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.dao;

import java.util.List;
 
import myapp.model.Utenti;
 
public interface UtentiDao {
    Utenti findById(String username);
    void saveUtenti(Utenti utente);
    void deleteUtenti(String id);
    List<Utenti> findAllUtenti();
 }
