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
        String[][] sentimientos = new String[6][2];
        String cara = this.sentimiento;
        sentimientos[0][0]= "felicidad";
        sentimientos[0][1]= "tristeza";
        sentimientos[0][2]= "locura";
        sentimientos[0][3]= "seriedad";
        sentimientos[0][4]= "sospecha";
        sentimientos[0][5]= "raro";
        sentimientos[1][0]= "(='U'=)";
        sentimientos[1][1]= "(=ToT=)";
        sentimientos[1][2]= "(=O.o=)";
        sentimientos[1][3]= "(=-_-=)";
        sentimientos[1][4]= "(=¬_¬=)";
        sentimientos[1][5]= "(=@_@=)";
        for(int i=0; i<6;i++){
            if(sentimientos[0][i].matches(sentimiento)){
                cara = sentimientos[1][i];
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
