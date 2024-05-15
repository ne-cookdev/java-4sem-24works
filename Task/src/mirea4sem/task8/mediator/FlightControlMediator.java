package mirea4sem.task8.mediator;

// Интерфейс посредника
interface FlightControlMediator {
    void registerFlight(Flight flight);
    void sendMessage(String message, Flight flight);
}
