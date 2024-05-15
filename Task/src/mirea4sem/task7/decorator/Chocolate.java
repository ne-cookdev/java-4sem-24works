package mirea4sem.task7.decorator;

// Конкретный декоратор - с добавкой шоколада
class Chocolate extends CondimentDecorator {
    public Chocolate(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Шоколад";
    }

    @Override
    public double cost() {
        return beverage.cost() + 1.0;
    }
}
