package entidades;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="personas")
//Implementa serializable para  que haya persistencia
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="nombre")
    private String nombre;
    
    // Creamos una relacion 1:N indicando que la persona puede tener varios motes
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id")
    private Set<Motes> motes;

    public Persona() {
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public Persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Motes> getMotes() {
        return motes;
    }

    public void setMotes(Set<Motes> motes) {
        this.motes = motes;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", motes=" + motes + '}';
    }
    
    
}