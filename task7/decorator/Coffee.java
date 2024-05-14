package mirea4sem.task7.decorator;

// Базовая реализация напитка - кофе
class Coffee implements Beverage {
    @Override
    public String getDescription() {
        return "Кофе";
    }

    @Override
    public double cost() {
        return 2.0;
    }
}
