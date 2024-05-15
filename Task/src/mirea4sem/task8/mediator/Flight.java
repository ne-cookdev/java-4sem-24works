package mirea4sem.task8.mediator;

// Абстрактный класс полета
abstract class Flight {
    protected FlightControlMediator mediator;
    protected String flightCode;

    public Flight(FlightControlMediator mediator, String flightCode) {
        this.mediator = mediator;
        this.flightCode = flightCode;
    }

    public abstract void sendMessage(String message);
    public abstract void receiveMessage(String message);
}
