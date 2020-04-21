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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UTENTI")
public class Utenti implements Serializable {

    @Id
    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "Tipo")
    private Tipo tipo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utente")
    private List<Accessi> accessi;
    /*
    @ManyToMany(mappedBy = "listaUtenti")
    private List<AzioniCorrettive> lac;
    */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    private List<Verificazioni> verificazioni;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    private List<Assembramento> assembramenti;

    public Utenti(String username, String password, Tipo tipo) {
        this.username = username;
        this.password = password;
        this.tipo = tipo;
    }
    
    public Utenti() {
    }

    public List<Accessi> getAccessi() {
        return accessi;
    }

    public void setAccessi(List<Accessi> accessi) {
        this.accessi = accessi;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Utenti{" + "username=" + username + ", password=" + password + ", tipo=" + tipo + '}';
    }

    public List<Verificazioni> getVerificazioni() {
        return verificazioni;
    }

    public void setVerificazioni(List<Verificazioni> verificazioni) {
        this.verificazioni = verificazioni;
    }

    public List<Assembramento> getAssembramenti() {
        return assembramenti;
    }

    public void setAssembramenti(List<Assembramento> assembramenti) {
        this.assembramenti = assembramenti;
    }
 
}

