package mirea4sem.task7.facade;

// Класс, представляющий управление освещением в умном доме
class LightSystem implements Light {
    @Override
    public void turnOn() {
        System.out.println("Освещение включено");
    }

    @Override
    public void turnOff() {
        System.out.println("Освещение выключено");
    }
}
