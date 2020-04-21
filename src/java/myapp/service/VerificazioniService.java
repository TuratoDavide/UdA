/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.service;

import java.util.List;
import myapp.model.Assembramento;
import myapp.model.Verificazioni;
import myapp.model.VerificazioniId;

public interface VerificazioniService {
    Verificazioni findById(VerificazioniId idTeam);
    void saveVerificazioni(Verificazioni team);
    void updateVerificazioni(Verificazioni a);
    void deleteVerificazioni(VerificazioniId id);
    List<Verificazioni> findAllVerificazioni();
}
