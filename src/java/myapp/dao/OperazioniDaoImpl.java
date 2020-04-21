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
 
import myapp.model.Operazioni;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
 
@Repository("OperazioniDao")
public class OperazioniDaoImpl implements OperazioniDao {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    public Operazioni findById(int idOperazione){
        return (Operazioni) getSession().get(Operazioni.class, idOperazione);
    }
 
    public void saveOperazione(Operazioni operazione) {
        getSession().persist(operazione);
    }
 
    public void deleteOperazione(int id) {
        Operazioni e = (Operazioni) getSession().load(Operazioni.class, id);
	if(e!=null) getSession().delete(e);
    }
 
    @SuppressWarnings("unchecked")
    public List<Operazioni> findAllOperazioni() {
       Criteria criteria = getSession().createCriteria(Operazioni.class);
        return (List<Operazioni>) criteria.list();
    }
 
}
