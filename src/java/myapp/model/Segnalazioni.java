/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.model;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "SEGNALAZIONI")
public class Segnalazioni implements Serializable {
    
    public enum RiferitaA{Fornitori, Clienti, Reparti};

    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "IdSegnalazione")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idSegnalazione;

    @Column(name = "Data")
    private Date data;

    @Column(name = "Prodotto")
    private String prodotto;

    @Column(name = "Descrizione")
    private String descrizione;

    @Enumerated(EnumType.STRING)
    @Column(name = "RiferitaA")
    private RiferitaA riferitaA;

    @Column(name = "Quantita")
    private int quantita;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Operazione")
    private Operazioni op;

    @OneToOne(mappedBy = "seg", cascade = CascadeType.ALL,fetch = FetchType.EAGER, optional = true)
    private AzioniCorrettive ac;

    public Segnalazioni(String prodotto, String descrizione, int quantita, RiferitaA riferitaA) {
        this.prodotto = prodotto;
        this.descrizione = descrizione;
        this.riferitaA = riferitaA;
        this.quantita = quantita;
    }
    
    public Segnalazioni() {
    
    }
 
    public int getIdSegnalazione() {
        return idSegnalazione;
    }

    public void setIdSegnalazione(int idSegnalazione) {
        this.idSegnalazione = idSegnalazione;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getProdotto() {
        return prodotto;
    }

    public void setProdotto(String prodotto) {
        this.prodotto = prodotto;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public RiferitaA getRiferitaA() {
        return riferitaA;
    }

    public void setRiferitaA(RiferitaA riferitaA) {
        this.riferitaA = riferitaA;
    }

    public int getQuantita() {
        return quantita;
    }

    public Operazioni getOp() {
        return op;
    }

    public void setOp(Operazioni op) {
        this.op = op;
    }

    public AzioniCorrettive getAc() {
        return ac;
    }

    public void setAc(AzioniCorrettive ac) {
        this.ac = ac;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }
    
}