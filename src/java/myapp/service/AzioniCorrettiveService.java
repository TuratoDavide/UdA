/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.service;

import java.util.List;
import myapp.model.AzioniCorrettive;
import myapp.model.Segnalazioni;

public interface AzioniCorrettiveService {
    AzioniCorrettive findById(int idAzione);
    AzioniCorrettive findBySeg(Segnalazioni seg);
    void saveAzioneCorrettiva(AzioniCorrettive azione);
    void updateAzioneCorrettiva(AzioniCorrettive azione);
    void deleteAzioneCorrrettiva(int id);
    List<AzioniCorrettive> findAllAzioniCorrettive();
}
