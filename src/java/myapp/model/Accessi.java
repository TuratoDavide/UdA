/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="ACCESSI")
public class Accessi implements Serializable{
    @Id
    @Column(name="IdAccesso")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int IdAccesso;
    
    @Column(name="Data")
    private Date data;
    
    @ManyToOne
    @JoinColumn(name="Username")
    private Utenti utente;
  
    @OneToMany(mappedBy = "ac", fetch = FetchType.EAGER)
    private List<Operazioni> operazioni;

    public Accessi(Date data,Utenti utente) {
        this.data = data;
        this.utente = utente;
    }

    public Accessi(){
    
    }
    
    public Utenti getUtente() {
        return utente;
    }

    public void setUtente(Utenti utente) {
        this.utente = utente;
    }

    public List<Operazioni> getOperazioni() {
        return operazioni;
    }

    public void setOperazioni(List<Operazioni> operazioni) {
        this.operazioni = operazioni;
    }
    
    public int getIdAccesso() {
        return IdAccesso;
    }

    public void setIdAccesso(int IdAccesso) {
        this.IdAccesso = IdAccesso;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
}
