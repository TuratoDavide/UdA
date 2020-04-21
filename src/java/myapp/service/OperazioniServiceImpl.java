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
 
import myapp.dao.OperazioniDao;
import myapp.model.Operazioni;
 
@Service("OperazioniService")
@Transactional
public class OperazioniServiceImpl implements OperazioniService {
 
    @Autowired
    private OperazioniDao dao;
     
    public Operazioni findById(int idOperazione) {
        return dao.findById(idOperazione);
    }
 
    public void saveOperazione(Operazioni operazione) {
        dao.saveOperazione(operazione);
    }
 
    public void updateOperazione(Operazioni operazione) {
        Operazioni entity = dao.findById(operazione.getIdOperazione());
        if(entity!=null){
            entity.setTipo(operazione.getTipo());
            entity.setIdOperazione(operazione.getIdOperazione());
        }
    }
 
    public void deleteOperazione(int id) {
        dao.deleteOperazione(id);
    }
     
    public List<Operazioni> findAllOperazioni() {
        return dao.findAllOperazioni();
    }
 
   
}
