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
 
import myapp.model.Team;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
 
@Repository("TeamDao")
public class TeamDaoImpl implements TeamDao {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    public Team findById(int idTeam) {
            return (Team) getSession().get(Team.class, idTeam);
    }
 
    public Team saveTeam(Team team) {
        getSession().persist(team);
        getSession().flush();
        return team;
    }
 
    public void deleteTeam(int id) {
        Team e = (Team) getSession().load(Team.class, id);
	if(e!=null) getSession().delete(e);
    }
 
    @SuppressWarnings("unchecked")
    public List<Team> findAllTeam() {
       Criteria criteria = getSession().createCriteria(Team.class);
        return (List<Team>) criteria.list();
    }
    
    public int getLast() {
        //String hql = "SELECT MAX(IdTeam) FROM Team";
        String hql2 = "SELECT IdTeam FROM TEAM ORDER BY IdTeam DESC LIMIT 0,1";
        Query q = getSession().createSQLQuery(hql2);
        
        if(q.uniqueResult() == null) {
            return 0;
        }
        int t = (int) q.uniqueResult();
        return t;
    }
 
    
    
}
