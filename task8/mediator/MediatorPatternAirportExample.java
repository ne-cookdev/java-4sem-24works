package mirea4sem.task8.mediator;

public class MediatorPatternAirportExample {
    public static void main(String[] args) {
        FlightControlMediator mediator = new FlightControlTower();

        Flight flight1 = new AirplaneFlight(mediator, "ABC123");
        Flight flight2 = new AirplaneFlight(mediator, "XYZ789");
        Flight flight3 = new AirplaneFlight(mediator, "DEF456");

        mediator.registerFlight(flight1);
        mediator.registerFlight(flight2);
        mediator.registerFlight(flight3);

        flight1.sendMessage("Мы начинаем посадку.");
        flight2.sendMessage("Подтверждаю, у нас прекрасная погода.");
        flight3.sendMessage("Понял, продолжайте следить за турбулентностью.");
    }
}
