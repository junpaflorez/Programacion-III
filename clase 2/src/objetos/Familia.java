package objetos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Familia implements Serializable{
    private Conejo padre;
    private Conejo madre;
    private List<Conejo> hijos;
    private String nombre;

    public Familia(String nombre) {
        this.padre = new Conejo("padre");
        this.madre = new Conejo("madre");
        this.hijos = new ArrayList();
        this.nombre = nombre;
    }

    public Conejo getPadre() {
        return padre;
    }

    public void setPadre(Conejo padre) {
        this.padre = padre;
    }

    public Conejo getMadre() {
        return madre;
    }

    public void setMadre(Conejo madre) {
        this.madre = madre;
    }

    public List<Conejo> getHijos() {
        return hijos;
    }

    public void setHijos(List<Conejo> hijos) {
        this.hijos = hijos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
