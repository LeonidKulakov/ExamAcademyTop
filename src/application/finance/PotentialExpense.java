package application.finance;


public class PotentialExpense {
    private String name;
    private Double potentialExpense;

    public PotentialExpense(String name, Double potentialExpense) {
        this.name = name;
        this.potentialExpense = potentialExpense;
    }

    public String getName() {
        return name;
    }

    public Double getPotentialExpense() {
        return potentialExpense;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Назначение потенциального расхода: ");
        builder.append(name);
        builder.append(". Сумма: ");
        builder.append(potentialExpense);
        builder.append("р.");
        return builder.toString();
    }
}
