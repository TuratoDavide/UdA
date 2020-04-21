package myapp.service;
 
import java.util.List;
 

 
import myapp.dao.UtentiDao;
import myapp.model.Utenti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

 
@Service("UtentiService")
@Transactional
public class UtentiServiceImpl implements UtentiService {
 
    @Autowired
    private UtentiDao dao;
     
    @Override
    public Utenti findById(String id) {
        return dao.findById(id);
    }
 
    @Override
    public void saveUtenti(Utenti utente) {
        dao.saveUtenti(utente);
    }
 
    @Override
    public void updateUtenti(Utenti utente) {
        Utenti entity = dao.findById(utente.getUsername());
        if(entity!=null){
            entity.setUsername(utente.getUsername());
            entity.setPassword(utente.getPassword());
            entity.setTipo(utente.getTipo());
        }
    }
 
    @Override
    public void deleteUtenti(String id) {
        dao.deleteUtenti(id);
    }
     
    @Override
    public List<Utenti> findAllUtenti() {
        return dao.findAllUtenti();
    }
 
   
}