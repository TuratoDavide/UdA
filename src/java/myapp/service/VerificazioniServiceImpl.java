/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.service;

import java.util.List;
import myapp.dao.AssembramentoDao;
import myapp.dao.VerificazioniDao;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import myapp.model.Assembramento;
import myapp.model.Verificazioni;
import myapp.model.VerificazioniId;
 
@Service("VerificazioniService")
@Transactional
public class VerificazioniServiceImpl implements VerificazioniService {
 
    @Autowired
    private VerificazioniDao dao;
     
    public Verificazioni findById(VerificazioniId idAzione){
        return dao.findById(idAzione);
    }
 
    public void saveVerificazioni(Verificazioni a) {
        dao.saveVerificazioni(a);
    }
 
    public void updateVerificazioni(Verificazioni a) {
        Verificazioni entity = dao.findById(a.getId());
        if(entity!=null){
            entity.setNote(a.getNote());
            entity.setResponso(a.getResponso());
            entity.setUsername(a.getUsername());
            
        }
    }
 
    public void deleteVerificazioni(VerificazioniId id) {
        dao.deleteVerificazioni(id);
    }
     
    public List<Verificazioni> findAllVerificazioni() {
        return dao.findAllVerificazioni();
    }
}
