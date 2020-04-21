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
 
import myapp.model.AzioniCorrettive;
import myapp.model.Segnalazioni;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
 
@Repository("AzioniCorrettiveDao")
public class AzioniCorrettiveDaoImpl implements AzioniCorrettiveDao {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    public AzioniCorrettive findById(int idAzione) {
            return (AzioniCorrettive) getSession().get(AzioniCorrettive.class, idAzione);
    }
    
    public AzioniCorrettive findBySeg(Segnalazioni seg) {
            return (AzioniCorrettive) getSession().get(AzioniCorrettive.class, seg);
    }
 
    public void saveAzioniCorrettive(AzioniCorrettive azione) {
        getSession().persist(azione);
    }
 
    public void deleteAzioniCorrrettive(int id) {
        AzioniCorrettive e = (AzioniCorrettive) getSession().load(AzioniCorrettive.class, id);
	if(e!=null) getSession().delete(e);
    }
 
    @SuppressWarnings("unchecked")
    public List<AzioniCorrettive> findAllAzioniCorrettive() {
       Criteria criteria = getSession().createCriteria(AzioniCorrettive.class);
        return (List<AzioniCorrettive>) criteria.list();
    }
 
}