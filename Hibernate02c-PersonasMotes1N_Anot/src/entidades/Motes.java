package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "motes")
public class Motes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String mote;

    public Motes() {
    }

    public Motes(String mote) {
        this.mote = mote;
    }

    public Motes(int id, String mote) {
        this.id = id;
        this.mote = mote;
    }

    public String getMote() {
        return mote;
    }

    public void setMote(String mote) {
        this.mote = mote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Motes{" + "id=" + id + ", mote=" + mote + '}';
    }
    
    
}
