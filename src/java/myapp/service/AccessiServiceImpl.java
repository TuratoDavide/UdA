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
 
import myapp.dao.AccessiDao;
import myapp.model.Accessi;
import myapp.model.Utenti;
 
@Service("AccessiService")
@Transactional
public class AccessiServiceImpl implements AccessiService {
 
    @Autowired
    private AccessiDao dao;
     
    public Accessi findById(int idAccesso) {
        return dao.findById(idAccesso);
    }
 
    public void saveAccesso(Accessi accesso) {
        dao.saveAccesso(accesso);
    }
 
    public void updateAccesso(Accessi accesso) {
        Accessi entity = dao.findById(accesso.getIdAccesso());
        if(entity!=null){
            entity.setData(accesso.getData());
            entity.setIdAccesso(accesso.getIdAccesso());
        }
    }
 
    public void deleteAccesso(int id) {
        dao.deleteAccesso(id);
    }
     
    public List<Accessi> findAllAccessi() {
        return dao.findAllAccessi();
    }
 
   
}
