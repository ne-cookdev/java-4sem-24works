package mirea4sem.task7.facade;

public class Main {
    public static void main(String[] args) {
        SmartHomeFacade smartHome = new SmartHomeFacade();

        // Включение освещения и включение системы безопасности через фасад
        smartHome.turnLightsOn();
        smartHome.armSecurity();

        // Выключение освещения и выключение системы безопасности через фасад
        smartHome.turnLightsOff();
        smartHome.disarmSecurity();
    }
}
