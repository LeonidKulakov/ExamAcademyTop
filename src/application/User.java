package application;

import application.card.CreditCard;
import application.card.Wallet;
import application.finance.CurrentExpense;
import application.finance.PotentialExpense;
import application.finance.PotentialIncom;

import java.util.HashMap;
import java.util.Map;

public class User {

    private String userName;
    private HashMap<String, CreditCard> creditCards;
    private HashMap<String, Wallet> wallets;
    private HashMap<String, CurrentExpense> currentExpenses;
    private HashMap<String, PotentialExpense> potentialExpenses;
    private HashMap<String, PotentialIncom> potentialIncoms;

    public User(String userName) {
        this.userName = userName;
        this.creditCards = new HashMap<>();
        this.wallets = new HashMap<>();
        this.currentExpenses = new HashMap<>();
        this.potentialExpenses = new HashMap<>();
        this.potentialIncoms = new HashMap<>();
    }

    /**
     * Блок кошелька
     */
    public void addWallet(String nameWallet, String bank) {
        Wallet wal = new Wallet(bank, 0.0);
        wallets.put(nameWallet, wal);
    }

    public void printAllWallets() {
        for (Wallet wal : wallets.values()) {
            System.out.println(wal.toString());
        }
    }

    public void checkWallet(String nameWallet) throws NullPointerException {
        System.out.println("Кошелёк: " + nameWallet + wallets.get(nameWallet).toString());
    }

    public Double getSumAllWallets() {
        Double sum = 0.0;
        for (Map.Entry s : wallets.entrySet()) {
            Wallet w = (Wallet) s.getValue();
            sum += w.getSum();
        }
        System.out.println("Суммарный баланс " + sum);
        return sum;
    }

    public void addMoneyWallet(String nameWallet, Double sum) throws NullPointerException {
        Wallet wal = wallets.get(nameWallet);
        wal.addMoney(sum);
    }

    public void withdrawWalletMoney(String nameWallet, Double money) throws NullPointerException {
        Wallet wal = wallets.get(nameWallet);
        wal.withdrawMoney(money);
    }

    public void deleteWallet(String nameWallet) throws NullPointerException {
        wallets.remove(nameWallet);
    }

    public void showWallets() throws NullPointerException {
        for (Map.Entry s : wallets.entrySet()) {
            Wallet w = (Wallet) s.getValue();
            System.out.println(w.toString());
        }
    }

    /**
     * Блок кредитки
     */
    public void addCreditCard(String nameCreditCard, String bank, Double limit, Integer gracePeriod, Double percent) {
        CreditCard cc = new CreditCard(bank, limit, gracePeriod, percent);
        creditCards.put(nameCreditCard, cc);
    }

    public void checkCreditCard(String name) throws NullPointerException {
        System.out.println("Кредитка " + name + creditCards.get(name).toString());
    }

    public Double getSumAllCreditCards() {
        Double sum = 0.0;
        for (Map.Entry s : creditCards.entrySet()) {
            CreditCard cc = (CreditCard) s.getValue();
            sum += cc.getSum();
        }
        System.out.println("Суммарный остаток " + sum);
        return sum;
    }


    public void addMoneyCreditCard(String nameCreditCard, Double sum) throws NullPointerException {
        CreditCard cc = creditCards.get(nameCreditCard);
        cc.addMoney(sum);
    }

    public void withdrawMoneyCreditCard(String nameCreditCard, Double money) {
        CreditCard cc = creditCards.get(nameCreditCard);
        cc.addMoney(money);
    }

    public void deleteCreditCard(String nameCreditCard) throws NullPointerException {
        creditCards.remove(nameCreditCard);
    }

    public void showCreditCards() throws NullPointerException {
        for (Map.Entry s : creditCards.entrySet()) {
            CreditCard cc = (CreditCard) s.getValue();
            System.out.println(cc.toString());
        }
    }

    /**
     * Блок общих методов
     */
    public Double getAllMoney() throws NullPointerException {
        Double sum = getSumAllWallets();
        sum += getSumAllCreditCards();
        System.out.println("Доступные средства " + sum + "р.");
        return sum;
    }

    /**
     * Блок потенциальных затрат
     */
    public void addPotentialExpense(String namePotentialExpense, String nameBank, Double sum) {
        potentialExpenses.put(namePotentialExpense, new PotentialExpense(nameBank, sum));
    }
    public void getPotentialExpense(String namePotentialExpense)throws NullPointerException{
        PotentialExpense potentialExpense = (PotentialExpense) potentialExpenses.get(namePotentialExpense);
        System.out.println(potentialExpense.toString());
    }
    public void deletePotentialExpense(String namePotentialExpense)throws NullPointerException{
        potentialExpenses.remove(namePotentialExpense);
    }
    public void getAllPotentialExpense(){
        for (Map.Entry s : potentialExpenses.entrySet()) {
            PotentialExpense potentialExpense = (PotentialExpense) s.getValue();
            System.out.println(potentialExpense.toString());
        }
    }
    /**
     * Блок текущих затрат
     */

    public void addCurrentExpense(String nameCurrentExpense, String nameBank, Double sum) {
        currentExpenses.put(nameCurrentExpense, new CurrentExpense(nameBank, sum));
    }
    public void getCurrentExpense(String nameCurrentExpense)throws NullPointerException{
        CurrentExpense currentExpense = (CurrentExpense) currentExpenses.get(nameCurrentExpense);
        System.out.println(currentExpense.toString());
    }
    public void deleteCurrentExpense(String nameCurrentExpense)throws NullPointerException{
        creditCards.remove(nameCurrentExpense);
    }
    public void getAllCurrentExpense(){
        for (Map.Entry s: creditCards.entrySet()){
            CurrentExpense currentExpense = (CurrentExpense) s.getValue();
            System.out.println(currentExpense.toString());
        }
    }
    /**
     * Блок планируемых доходов
     */
    public void addPotentialIncom(String namePotentialIncom, String nameBank, Double sum) {
        potentialIncoms.put(namePotentialIncom, new PotentialIncom(nameBank, sum));
    }
    public void getPotentialIncom(String namePotentialIncom)throws NullPointerException{
        PotentialIncom potentialIncom = (PotentialIncom) potentialIncoms.get(namePotentialIncom);
        System.out.println(potentialIncom.toString());
    }
    public void deletePotentialIncom(String namePotentialIncom)throws NullPointerException {
        potentialIncoms.remove(namePotentialIncom);
    }
    public void getAllPotentialIncom(){
        for (Map.Entry s: potentialIncoms.entrySet()){
            PotentialIncom potentialIncom = (PotentialIncom) s.getValue();
            System.out.println(potentialIncom.toString());
        }
    }
}