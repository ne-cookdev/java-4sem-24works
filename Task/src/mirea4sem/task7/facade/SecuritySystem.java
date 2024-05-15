package mirea4sem.task7.facade;

// Класс, представляющий управление системой безопасности в умном доме
class SecuritySystem implements Security {
    @Override
    public void arm() {
        System.out.println("Система безопасности включена");
    }

    @Override
    public void disarm() {
        System.out.println("Система безопасности выключена");
    }
}
