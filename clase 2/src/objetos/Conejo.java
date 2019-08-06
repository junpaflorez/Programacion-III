package objetos;

public class Conejo {
    private String orejas;
    private String sentimiento;
    private String patas;

    public Conejo() {
        this.orejas = " (')_(')";
        this.sentimiento = " (='.'=)";
        this.patas = "('')__('')";
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
        this.sentimiento = sentimiento;
    }

    public String getPatas() {
        return patas;
    }

    public void setPatas(String patas) {
        this.patas = patas;
    }
    
    
}
