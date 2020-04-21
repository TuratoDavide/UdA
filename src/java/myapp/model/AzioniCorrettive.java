/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AZIONI_CORRETTIVE")
public class AzioniCorrettive implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "IdAzione")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int idAzione;

    @Column(name = "Descrizione")
    private String descrizione;

    @Column(name = "DataInizio")
    private Date dataInizio;

    @Column(name = "DataFine")
    private Date dataFine;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Segnalazione")
    private Segnalazioni seg;
    
    
    @OneToOne(mappedBy="acs")
    private Team ts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "azione")
    private List<Verificazioni> verificazioni;
   

    public AzioniCorrettive(Date dataInizio, Segnalazioni seg) {
        this.dataInizio = dataInizio;
        this.seg = seg;
    }
    
    public AzioniCorrettive(){}

    public int getIdAzione() {
        return idAzione;
    }

    public void setIdAzione(int idAzione) {
        this.idAzione = idAzione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    public Segnalazioni getSeg() {
        return seg;
    }

    public void setSeg(Segnalazioni seg) {
        this.seg = seg;
    }
    public Team getTs() {
        return ts;
    }

    public void setTs(Team ts) {
        this.ts = ts;
    }

    public List<Verificazioni> getVerificazioni() {
        return verificazioni;
    }

    public void setVerificazioni(List<Verificazioni> verificazioni) {
        this.verificazioni = verificazioni;
    }
    
    
}
 
