package application;

import java.util.Scanner;

public class Application {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String userName;
        System.out.println("Создать пользователя - 1 \nВыход - Любая кнопка кроме 1");
        if (scanner.hasNextInt()) {
            int operation = scanner.nextInt();
            if (operation == 1) {
                System.out.println("Хочешь создать пользователя? \nДа-1\nНет - Любая кнопка кроме 1");
                if (scanner.hasNextInt()) {
                    operation = scanner.nextInt();
                    if (operation == 1) {
                        System.out.println("Введи имя пользователя");
                        userName = scanner.next();
                        User user = makeUser(userName);
                        operationSelection(user);


                    } else {
                        System.out.println("Пока");
                    }
                } else {
                    System.out.println("Пока");
                }
            } else {
                System.out.println("Пока");
            }
        } else {
            System.out.println("Пока");
        }
    }

    private User makeUser(String name) {
        User user = new User(name);
        return user;
    }

    private void operationSelection(User user) {
        Scanner scanner = new Scanner(System.in);
        int operation;
        String nB;
        String nW;
        String nCC;
        Double limit;
        Integer gP;
        Double percent;
        System.out.println("Выбор операции:");
        System.out.println("1 - добавить кошелек \n2 - пополнить кошелек \n3 - потратить деньги с кошелька \n4 - проверить кошелек" +
                " \n5 - проверить все кошельки \n6 - запрос баланса по всем кошелькам\n7 - удаление кошелька\n___________________________" +
                " \n8 - добавить кредитку\n9 - пополнить кредитку \n10 - потратить деньги с кредитки \n11 - проверить кредитку" +
                "\n12 - проверить все \n13 - показать кредитки \n14 - удалить кредитку \n___________________________\n15 - показать все доступные средства\n___________________________" +
                "\n16 - добавить потенциальную затрату \n17 - посмотреть потенциальную затрату\n18 - удалить потенциальную затрату" +
                "\n19 - посмотреть все потенциальные затраты\n___________________________" +
                "\n20 - добавить текущую затрату \n21 - посмотреть текущую затрату\n22 - удалить текущую затрату" +
                "\n23 - посмотреть все потенциальные затраты\n___________________________" +
                "\n24 - добавить потенциальный доход \n25 - посмотреть потенциальный доход\n26 - удалить потенциальный доход" +
                "\n27 - посмотреть все потенциальные доходы\n___________________________\nОстальные кнопки - Завершить работу!");
        if (scanner.hasNextInt()) {
            operation = scanner.nextInt();
            if (operation > 0 && operation < 28) {
                switch (operation) {
                    case (1):
                        System.out.println("Введи название банка");
                        nB = scanner.next();
                        System.out.println("Введи имя карты");
                        nW = scanner.next();
                        user.addWallet(nW, nB);
                        break;
                    case (2):
                        System.out.println("Введи имя карты");
                        nW = scanner.next();
                        System.out.println("Введи сумму");
                        if (scanner.hasNextDouble()){
                            try {
                                user.addMoneyWallet(nW,scanner.nextDouble());
                            } catch (NullPointerException e) {
                                System.out.println("Нет такого кошелька");;
                            }
                        }else {
                            System.out.println("Введено не число");
                        }
                        break;
                    case (3):
                        System.out.println("Введи имя карты");
                        nW = scanner.next();
                        System.out.println("Введи сумму");
                        if (scanner.hasNextDouble()){
                            try {
                                user.withdrawWalletMoney(nW,scanner.nextDouble());
                            } catch (NullPointerException e) {
                                System.out.println("Нет такого кошелька");
                            }
                        }else {
                            System.out.println("Введено не число");
                        }
                        break;
                    case (4):
                        System.out.println("Введи имя карты");
                        nW = scanner.next();
                        try {
                            user.checkWallet(nW);
                        }catch (NullPointerException e){
                            System.out.println("Нет такого кошелька");
                        }
                        break;
                    case (5):
                        try {
                            user.printAllWallets();
                        }catch (NullPointerException e){
                            System.out.println("Список пуст");
                        }
                        break;
                    case (6):
                        try {
                            user.getSumAllWallets();
                        }catch (NullPointerException e){
                            System.out.println("Список пуст");
                        }
                        break;
                    case (7):
                        System.out.println("Введи имя карты");
                        nW = scanner.next();
                        try {
                            user.deleteWallet(nW);
                        }catch (NullPointerException e){
                            System.out.println("Нет такого кошелька");
                        }
                        break;
                    case (8):
                        System.out.println("Введи название банка");
                        nB = scanner.next();
                        System.out.println("Введи имя кредитки");
                        nCC = scanner.next();
                        System.out.println("Введи лимит");
                        if (scanner.hasNextDouble()){
                            limit = scanner.nextDouble();
                        }else {
                            System.out.println("Введено не число");
                            break;
                        }
                        System.out.println("Введи процент");
                        if (scanner.hasNextDouble()){
                            percent = scanner.nextDouble();
                        }else {
                            System.out.println("Введено не число");
                            break;
                        }
                        System.out.println("Введи льготный период");
                        if (scanner.hasNextInt()){
                            gP = scanner.nextInt();
                        }else {
                            System.out.println("Введено не число");
                            break;
                        }
                        user.addCreditCard(nCC,nB,limit,gP,percent);
                        break;
                    case (9):
                        System.out.println("Введи имя кредитки");
                        nCC = scanner.next();
                        System.out.println("Введи сумму");
                        if (scanner.hasNextDouble()){
                            try {
                                user.addMoneyCreditCard(nCC,scanner.nextDouble());
                            } catch (NullPointerException e) {
                                System.out.println("Нет такой кредитки");;
                            }
                        }else {
                            System.out.println("Введено не число");
                        }
                        break;
                    case (10):
                        System.out.println("Введи имя кредитки");
                        nCC = scanner.next();
                        System.out.println("Введи сумму");
                        if (scanner.hasNextDouble()){
                            try {
                                user.withdrawMoneyCreditCard(nCC,scanner.nextDouble());
                            } catch (NullPointerException e) {
                                System.out.println("Нет такой кредитки");
                            }
                        }else {
                            System.out.println("Введено не число");
                        }
                        break;
                    case (11):
                        System.out.println("Введи имя кредитки");
                        nCC = scanner.next();
                        try {
                            user.checkCreditCard(nCC);
                        }catch (NullPointerException e){
                            System.out.println("Нет такой кредитки");
                        }
                        break;
                    case (12):
                        try {
                            user.getSumAllCreditCards();
                        }catch (NullPointerException e){
                            System.out.println("Список пуст");
                        }
                        break;
                    case (13):
                        try {
                            user.showCreditCards();
                        }catch (NullPointerException e){
                            System.out.println("Список пуст");
                        }
                        break;
                    case (14):
                        System.out.println("Введи имя кредитки");
                        nCC = scanner.next();
                        try {
                            user.deleteCreditCard(nCC);
                        }catch (NullPointerException e){
                            System.out.println("Нет такой кредитки");
                        }
                        break;
                    case (15):
                        try {
                            user.getAllMoney();
                        }catch (NullPointerException e){
                            System.out.println("Список пуст");
                        }
                        break;
                    case (16):
                        System.out.println();
                        break;
                    case (17):
                        System.out.println();
                        break;
                    case (18):
                        System.out.println();
                        break;
                    case (19):
                        System.out.println();
                        break;
                    case (20):
                        System.out.println();
                        break;
                    case (21):
                        System.out.println();
                        break;
                    case (22):
                        System.out.println();
                        break;
                    case (23):
                        System.out.println();
                        break;
                    case (24):
                        System.out.println();
                        break;
                    case (25):
                        System.out.println();
                        break;
                    case (26):
                        System.out.println();
                        break;
                    case (27):
                        System.out.println();
                        break;

                }
                System.out.println("1 - продолжить работу\nЗавершить работу - любая другая кнопка");
                if (scanner.hasNextInt()){
                     if (scanner.nextInt() == 1){
                        operationSelection(user);
                    } else {
                        System.out.println("Пока");
                    }
                } else {
                    System.out.println("Пока");
                }
            } else {
                System.out.println("Пока");
            }
        } else {
            System.out.println("Пока");
        }
    }
}
