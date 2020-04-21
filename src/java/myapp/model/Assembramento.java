/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


@Entity
@Table(name="ASSEMBRAMENTO")
public class Assembramento implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public enum Ruolo{Responsabile,Segretario,Operatore};
    
    @EmbeddedId
    private AssembramentoId id;
    
    @JoinColumn(name="username", referencedColumnName = "Username")
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("username")
    private Utenti username;
    
    @JoinColumn(name="idTeam", referencedColumnName = "IdTeam")
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @MapsId("idTeam")
    private Team idTeam;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "ruolo")
    private Ruolo ruolo;

    public Assembramento(Utenti username, Team idTeam, Ruolo ruolo) {
        this.id = new AssembramentoId(username.getUsername(), idTeam.getIdTeam());
        this.username = username;
        this.idTeam = idTeam;
        this.ruolo = ruolo;
    }

    public Assembramento() {
    }

    public AssembramentoId getId() {
        return id;
    }

    public void setId(AssembramentoId id) {
        this.id = id;
    }

    public Utenti getUsername() {
        return username;
    }

    public void setUsername(Utenti username) {
        this.username = username;
    }

    public Team getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Team idTeam) {
        this.idTeam = idTeam;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }
    
    
    
}
