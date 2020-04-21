/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TEAM")
public class Team implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "IdTeam")
    private int idTeam;
    
    @Column(name = "Attivo")
    private int at;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTeam")
    private List<Assembramento> assembramenti;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Azione")
    private AzioniCorrettive acs;
    
    public Team() {
        this.at = 1;
    }

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public int getAt() {
        return at;
    }

    public void setAt(int at) {
        this.at = at;
    }

    public List<Assembramento> getAssembramenti() {
        return assembramenti;
    }

    public void setAssembramenti(List<Assembramento> assembramenti) {
        this.assembramenti = assembramenti;
    }

    public AzioniCorrettive getAcs() {
        return acs;
    }

    public void setAcs(AzioniCorrettive acs) {
        this.acs = acs;
    }
    
    
    

 
}