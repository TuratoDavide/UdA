/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.service;

import java.util.List;
import myapp.model.Segnalazioni;

public interface SegnalazioniService {
    Segnalazioni findById(int idSegnalazione);
    void saveSegnalazione(Segnalazioni segnalazione);
    void updateSegnalazione(Segnalazioni segnalazione);
    void deleteSegnalazione(int id);
    List<Segnalazioni> findAllSegnalazioni();
}
