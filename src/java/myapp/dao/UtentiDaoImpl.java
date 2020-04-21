/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package myapp.dao;
 
import java.util.List;
 
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
 
import myapp.model.Utenti;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
 
@Repository("UtentiDao")
public class UtentiDaoImpl implements UtentiDao {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    public Utenti findById(String username) {
        return (Utenti) getSession().get(Utenti.class , username);
    }
 
    public void saveUtenti(Utenti utente) {
        getSession().persist(utente);
    }
 
    public void deleteUtenti(String id) {
        Utenti e = (Utenti) getSession().load(Utenti.class, id);
	if(e!=null) getSession().delete(e);
    }
 
    @SuppressWarnings("unchecked")
    public List<Utenti> findAllUtenti() {
        Criteria criteria = getSession().createCriteria(Utenti.class);
        return (List<Utenti>) criteria.list();
    }
 
}