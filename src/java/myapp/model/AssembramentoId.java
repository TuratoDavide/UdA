package myapp.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AssembramentoId implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "idTeam")
    private int idTeam;
    
    private AssembramentoId() {}

    public AssembramentoId(String username, int idTeam) {
        this.username = username;
        this.idTeam = idTeam;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }
 
    
}
