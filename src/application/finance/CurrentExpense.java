package application.finance;


public class CurrentExpense {
    private String name;
    private Double currentExpense;

    public CurrentExpense(String name, Double currentExpense) {
        this.name = name;
        this.currentExpense = currentExpense;
    }

    public String getName() {
        return name;
    }

    public Double getCurrentExpense() {
        return currentExpense;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Назначение текущего платежа: ");
        builder.append(name);
        builder.append(". Сумма ");
        builder.append(currentExpense);
        builder.append("р.");
        return builder.toString();
    }

}
