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
@Table(name="VERIFICAZIONI")
public class Verificazioni implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public enum Responso{Risolto,Irrisolto};
    
    @EmbeddedId
    private VerificazioniId id;
    
    @JoinColumn(name="username", referencedColumnName = "Username")
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("username")
    private Utenti username;
    
    @JoinColumn(name="azione", referencedColumnName = "IdAzione")
    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("azione")
    private AzioniCorrettive azione;
    
    @Column(name = "Note")
    private String note;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "Responso")
    private Responso responso;

    public Verificazioni(Utenti username, AzioniCorrettive azione, String note, Responso responso) {
        id = new VerificazioniId(username.getUsername(), azione.getIdAzione());
        this.username = username;
        this.azione = azione;
        this.note = note;
        this.responso = responso;
    }

    public Verificazioni() {
    }

    public VerificazioniId getId() {
        return id;
    }

    public void setId(VerificazioniId id) {
        this.id = id;
    }

    public Utenti getUsername() {
        return username;
    }

    public void setUsername(Utenti username) {
        this.username = username;
    }

    public AzioniCorrettive getAzione() {
        return azione;
    }

    public void setAzione(AzioniCorrettive azione) {
        this.azione = azione;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Responso getResponso() {
        return responso;
    }

    public void setResponso(Responso responso) {
        this.responso = responso;
    }
    
    

    
    
}
