/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.dao;

import java.util.List;
 
import myapp.model.Operazioni;
 
public interface OperazioniDao {
    Operazioni findById(int idOperazione);
    void saveOperazione(Operazioni operazione);
    void deleteOperazione(int id);
    List<Operazioni> findAllOperazioni();
 }