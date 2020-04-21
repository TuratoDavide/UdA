/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.dao;

import java.util.List;
 
import myapp.model.Team;
 
public interface TeamDao {
    Team findById(int idTeam);
    Team saveTeam(Team team);
    void deleteTeam(int id);
    List<Team> findAllTeam();
    int getLast();
 }
