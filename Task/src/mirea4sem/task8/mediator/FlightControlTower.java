package mirea4sem.task8.mediator;

import java.util.ArrayList;
import java.util.List;

class FlightControlTower implements FlightControlMediator {
    private List<Flight> flights;

    public FlightControlTower() {
        this.flights = new ArrayList<>();
    }

    @Override
    public void registerFlight(Flight flight) {
        this.flights.add(flight);
    }

    @Override
    public void sendMessage(String message, Flight flight) {
        for (Flight f : flights) {
            // Посредник рассылает сообщения всем другим полетам, кроме отправителя
            if (f != flight) {
                f.receiveMessage(message);
            }
        }
    }
}
