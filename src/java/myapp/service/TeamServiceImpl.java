package myapp.service;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import myapp.dao.TeamDao;
import myapp.model.Team;
 
@Service("TeamService")
@Transactional
public class TeamServiceImpl implements TeamService {
 
    @Autowired
    private TeamDao dao;
     
    public Team findById(int idTeam) {
        return dao.findById(idTeam);
    }
 
    public Team saveTeam(Team team) {
        return dao.saveTeam(team);
    }
 
    public void updateTeam(Team team) {
        Team entity = dao.findById(team.getIdTeam());
        if(entity!=null){
            entity.setAt(team.getAt());
            entity.setAssembramenti(team.getAssembramenti());
        }
    }
 
    public void deleteTeam(int id) {
        dao.deleteTeam(id);
    }
     
    public List<Team> findAllTeam() {
        return dao.findAllTeam();
    }
    
    public int getLast(){
        return dao.getLast();
    }
 
   
}