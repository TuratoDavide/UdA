/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.service;

import java.util.List;
import myapp.model.Assembramento;

public interface AssembramentoService {
    Assembramento findById(int idTeam);
    void saveAssembramento(Assembramento team);
    void updateAssembramento(Assembramento team);
    void deleteAssembramento(int id);
    List<Assembramento> findAllAssembramento();
}
