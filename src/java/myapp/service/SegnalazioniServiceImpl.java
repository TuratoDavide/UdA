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
 
import myapp.dao.SegnalazioniDao;
import myapp.model.Segnalazioni;
 
@Service("SegnalazioniService")
@Transactional
public class SegnalazioniServiceImpl implements SegnalazioniService {
 
    @Autowired
    private SegnalazioniDao dao;
     
    public Segnalazioni findById(int idSegnalazione) {
        return dao.findById(idSegnalazione);
    }
 
    public void saveSegnalazione(Segnalazioni segnalazione) {
        dao.saveSegnalazione(segnalazione);
    }
 
    public void updateSegnalazione(Segnalazioni segnalazione) {
        Segnalazioni entity = dao.findById(segnalazione.getIdSegnalazione());
        if(entity!=null){
            entity.setData(segnalazione.getData());
            entity.setProdotto(segnalazione.getProdotto());
            entity.setDescrizione(segnalazione.getDescrizione());
            entity.setRiferitaA(segnalazione.getRiferitaA());
            entity.setQuantita(segnalazione.getQuantita());
        }
    }
 
    public void deleteSegnalazione(int id) {
        dao.deleteSegnalazione(id);
    }
     
    public List<Segnalazioni> findAllSegnalazioni() {
        return dao.findAllSegnalazioni();
    }

 
   
}