/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.service;

import java.util.List;
import myapp.model.Team;

public interface TeamService {
    Team findById(int idTeam);
    int getLast();
    Team saveTeam(Team team);
    void updateTeam(Team team);
    void deleteTeam(int id);
    List<Team> findAllTeam();
}
