/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.dao;

import java.util.List;
 
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 
import myapp.model.Segnalazioni;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
 
@Repository("SegnalazioniDao")
public class SegnalazioniDaoImpl implements SegnalazioniDao {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    public Segnalazioni findById(int idSegnalazione) {
            return (Segnalazioni) getSession().get(Segnalazioni.class, idSegnalazione);
    }
 
    public void saveSegnalazione(Segnalazioni segnalazione) {
        getSession().persist(segnalazione);
    }
 
    public void deleteSegnalazione(int id) {
        Segnalazioni e = (Segnalazioni) getSession().load(Segnalazioni.class, id);
	if(e!=null) getSession().delete(e);
    }
 
    @SuppressWarnings("unchecked")
    public List<Segnalazioni> findAllSegnalazioni() {
       Criteria criteria = getSession().createCriteria(Segnalazioni.class);
       return (List<Segnalazioni>) criteria.list();
    }
    
 
}