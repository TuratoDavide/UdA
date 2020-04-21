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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
 
@Repository("AssembramentoDao")
public class AssembramentoDaoImpl implements AssembramentoDao {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    public Assembramento findById(int idTeam){
        return (Assembramento) getSession().get(Assembramento.class, idTeam);
    }
 
    public void saveAssembramento(Assembramento assembramento) {
        getSession().persist(assembramento);
    }
 
    public void deleteAssembramento(int id) {
        Assembramento e = (Assembramento) getSession().load(Assembramento.class, id);
	if(e!=null) getSession().delete(e);
    }
 
    @SuppressWarnings("unchecked")
    public List<Assembramento> findAllAssembramento() {
       Criteria criteria = getSession().createCriteria(Assembramento.class);
       return (List<Assembramento>) criteria.list();
    }
 
}
