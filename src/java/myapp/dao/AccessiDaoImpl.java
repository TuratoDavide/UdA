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
import myapp.model.Utenti;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
 
@Repository("AccessiDao")
public class AccessiDaoImpl implements AccessiDao {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    public Accessi findById(int idAccesso){
        return (Accessi) getSession().get(Accessi.class, idAccesso);
    }
 
    public void saveAccesso(Accessi accesso) {
        getSession().persist(accesso);
    }
 
    public void deleteAccesso(int id) {
        Accessi e = (Accessi) getSession().load(Accessi.class, id);
	if(e!=null) getSession().delete(e);
    }
 
    @SuppressWarnings("unchecked")
    public List<Accessi> findAllAccessi() {
       Criteria criteria = getSession().createCriteria(Accessi.class);
       return (List<Accessi>) criteria.list();
    }
 
}
