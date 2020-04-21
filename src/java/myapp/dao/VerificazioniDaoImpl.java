/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.dao;

import java.util.List;
import java.util.ListIterator;
 
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 
import myapp.model.Accessi;
import myapp.model.Assembramento;
import myapp.model.Utenti;
import myapp.model.Verificazioni;
import myapp.model.VerificazioniId;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
 
@Repository("VerificazioniDao")
public class VerificazioniDaoImpl implements VerificazioniDao {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    public Verificazioni findById(VerificazioniId id){
        return (Verificazioni) getSession().get(Verificazioni.class, id);
    }
 
    public void saveVerificazioni(Verificazioni v) {
        getSession().saveOrUpdate(v);
    }
 
    public void deleteVerificazioni(VerificazioniId id) {
        Assembramento e = (Assembramento) getSession().load(Verificazioni.class, id);
	if(e!=null) getSession().delete(e);
    }
 
    @SuppressWarnings("unchecked")
    public List<Verificazioni> findAllVerificazioni() {
       Criteria criteria = getSession().createCriteria(Verificazioni.class);
       return (List<Verificazioni>) criteria.list();
    }
 
}
