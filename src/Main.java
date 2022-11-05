import application.Application;

public class Main {
    /**
     *
     * 1) Изменены затраты/доходы, теперь ArrayList содержится внутри класса
     * 2) Изменена "навигация" по приложению
     * 3) Изменено завершение программы
     * 4) Затраты логируются автоматически
     *
     * */



    public static void main(String[] args) {
        Application application = new Application();
        application.start();
    }
}
