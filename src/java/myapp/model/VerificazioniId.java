package myapp.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class VerificazioniId implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Column(name = "Username")
    private String username;
    
    @Column(name = "Azione")
    private int idAzione;
    
    private VerificazioniId() {}

    public VerificazioniId(String username, int idAzione) {
        this.username = username;
        this.idAzione = idAzione;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdAzione() {
        return idAzione;
    }

    public void setIdAzione(int idAzione) {
        this.idAzione = idAzione;
    }

    
 
    
}
