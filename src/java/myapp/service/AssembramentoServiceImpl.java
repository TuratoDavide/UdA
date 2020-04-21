/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.service;

import java.util.List;
import myapp.dao.AssembramentoDao;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import myapp.model.Assembramento;
 
@Service("AssembramentoService")
@Transactional
public class AssembramentoServiceImpl implements AssembramentoService {
 
    @Autowired
    private AssembramentoDao dao;
     
    public Assembramento findById(int idAzione){
        return dao.findById(idAzione);
    }
 
    public void saveAssembramento(Assembramento a) {
        dao.saveAssembramento(a);
    }
 
    public void updateAssembramento(Assembramento a) {
        Assembramento entity = dao.findById(a.getIdTeam().getIdTeam());
        if(entity!=null){
            entity.setRuolo(a.getRuolo());
        }
    }
 
    public void deleteAssembramento(int id) {
        dao.deleteAssembramento(id);
    }
     
    public List<Assembramento> findAllAssembramento() {
        return dao.findAllAssembramento();
    }
 
   
}
