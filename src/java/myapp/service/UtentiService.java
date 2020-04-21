/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.service;
 
import java.util.List;
 
import myapp.model.Utenti;
 
public interface UtentiService {
    Utenti findById(String id);
    void saveUtenti(Utenti utente);
    void updateUtenti(Utenti utente);
    void deleteUtenti(String id);
    List<Utenti> findAllUtenti(); 
}