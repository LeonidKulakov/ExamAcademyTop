package application.finance;


public class PotentialIncom {
    private String name;
    private Double potentialIncom;

    public PotentialIncom(String name, Double potentialIncom) {
        this.name = name;
        this.potentialIncom = potentialIncom;
    }

    public String getName() {
        return name;
    }

    public Double getPotentialIncom() {
        return potentialIncom;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Назначение платежа: ");
        builder.append(name);
        builder.append(". Сумма ");
        builder.append(potentialIncom);
        builder.append("р.");
        return builder.toString();
    }
}
