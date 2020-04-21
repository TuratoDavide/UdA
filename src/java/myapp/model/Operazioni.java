/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OPERAZIONI")
public class Operazioni implements Serializable {
    
    public enum Tipi{Inserimento,Cancellazione,Modifica,Selezione};

    private static final long serialVersionUID = 1L;
 

    @Id
    @Column(name = "IdOperazione")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idOperazione;

    @Enumerated(EnumType.STRING)
    @Column(name = "Tipo")
    private Tipi tipo;
    
    @ManyToOne
    @JoinColumn(name = "Accesso")
    private Accessi ac;

    @OneToOne(mappedBy = "op", cascade = CascadeType.ALL,fetch = FetchType.EAGER, optional = true)
    private Segnalazioni segnalazioni;
 
    public Operazioni() {
    
    }

    public Operazioni(Tipi tipo, Accessi ac) {
        this.tipo = tipo;
        this.ac = ac;
    }

    public int getIdOperazione() {
        return idOperazione;
    }

    public void setIdOperazione(int idOperazzione) {
        this.idOperazione = idOperazzione;
    }

    public Tipi getTipo() {
        return tipo;
    }

    public void setTipo(Tipi tipo) {
        this.tipo = tipo;
    }
 
    public Accessi getAc() {
        return ac;
    }

    public void setAc(Accessi ac) {
        this.ac = ac;
    }

    public Segnalazioni getSegnalazioni() {
        return segnalazioni;
    }

    public void setSegnalazioni(Segnalazioni segnalazioni) {
        this.segnalazioni = segnalazioni;
    }

 
}

 
