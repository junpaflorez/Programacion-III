package objetos;

import java.io.Serializable;

public class Conejo implements Serializable{
    private String orejas;
    private String sentimiento;
    private String patas;
    private String nombre;

    public Conejo(String nombre) {
        this.orejas = " (')_(')";
        this.sentimiento = " (='.'=)";
        this.patas = "('')__('')";
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getOrejas() {
        return orejas;
    }

    public void setOrejas(String orejas) {
        this.orejas = orejas;
    }

    public String getSentimiento() {
        return sentimiento;
    }

    public void setSentimiento(String sentimiento) {
        String[][] sentimientos = new String[2][6];
        String cara = this.sentimiento;
        sentimientos[0][0]= "felicidad";
        sentimientos[0][1]= "tristeza";
        sentimientos[0][2]= "locura";
        sentimientos[0][3]= "seriedad";
        sentimientos[0][4]= "sospecha";
        sentimientos[0][5]= "raro";
        sentimientos[1][0]= " (='U'=)";
        sentimientos[1][1]= " (=ToT=)";
        sentimientos[1][2]= " (=O.o=)";
        sentimientos[1][3]= " (=-_-=)";
        sentimientos[1][4]= " (=¬_¬=)";
        sentimientos[1][5]= " (=@_@=)";
        for(int fila=0; fila<6; fila++){
            if(sentimientos[0][fila].matches(sentimiento)){
                cara = sentimientos[1][fila];
            }
        this.sentimiento = cara;
        }
    }

    public String getPatas() {
        return patas;
    }

    public void setPatas(String patas) {
        this.patas = patas;
    }
    
    
}
