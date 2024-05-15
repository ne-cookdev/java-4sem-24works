package mirea4sem.task8.mediator;

// Конкретный полет
class AirplaneFlight extends Flight {

    public AirplaneFlight(FlightControlMediator mediator, String flightCode) {
        super(mediator, flightCode);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("Полет " + flightCode + " отправляет: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("Полет " + flightCode + " получает: " + message);
    }
}
