package application.finance;


import java.util.ArrayList;

public class PotentialIncom {
    private ArrayList<String> potentialIncom;

    public PotentialIncom() {
        this.potentialIncom = new ArrayList<>();
    }

    public void addPotentialIncom(String s, Double m){
        StringBuilder builder = new StringBuilder();
        builder.append("Назначение платежа: ");
        builder.append(s);
        builder.append(" Сумма: ");
        builder.append(m);
        potentialIncom.add(builder.toString());
    }
    public void printPotentialIncom(){
        for (String s: potentialIncom){
            System.out.println(s);
        }
    }

}
