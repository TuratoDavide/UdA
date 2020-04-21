/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.dao;

import java.util.List;
 
import myapp.model.Segnalazioni;
 
public interface SegnalazioniDao {
    Segnalazioni findById(int idSegnalazione);
    void saveSegnalazione(Segnalazioni segnalazione);
    void deleteSegnalazione(int id);
    List<Segnalazioni> findAllSegnalazioni();
 }
