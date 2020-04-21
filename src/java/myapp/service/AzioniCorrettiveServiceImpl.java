/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.service;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import myapp.dao.AzioniCorrettiveDao;
import myapp.model.AzioniCorrettive;
import myapp.model.Segnalazioni;
 
@Service("AzioniCorrettiveService")
@Transactional
public class AzioniCorrettiveServiceImpl implements AzioniCorrettiveService {
 
    @Autowired
    private AzioniCorrettiveDao dao;
     
    public AzioniCorrettive findById(int idAzione){
        return dao.findById(idAzione);
    }
    
    public AzioniCorrettive findBySeg(Segnalazioni seg){
        return dao.findBySeg(seg);
    }
 
    public void saveAzioneCorrettiva(AzioniCorrettive azione) {
        dao.saveAzioniCorrettive(azione);
    }
 
    public void updateAzioneCorrettiva(AzioniCorrettive azione) {
        AzioniCorrettive entity = dao.findById(azione.getIdAzione());
        if(entity!=null){
            entity.setDescrizione(azione.getDescrizione());
            entity.setDataInizio(azione.getDataInizio());
            entity.setDataFine(azione.getDataFine());
        }
    }
 
    public void deleteAzioneCorrrettiva(int id) {
        dao.deleteAzioniCorrrettive(id);
    }
     
    public List<AzioniCorrettive> findAllAzioniCorrettive() {
        return dao.findAllAzioniCorrettive();
    }
 
   
}
