/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.dao;

import java.util.List;
 
import myapp.model.AzioniCorrettive;
import myapp.model.Segnalazioni;
 
public interface AzioniCorrettiveDao {
    AzioniCorrettive findById(int idAzione);
    AzioniCorrettive findBySeg(Segnalazioni seg);
    void saveAzioniCorrettive(AzioniCorrettive azione);
    void deleteAzioniCorrrettive(int id);
    List<AzioniCorrettive> findAllAzioniCorrettive();
 }
