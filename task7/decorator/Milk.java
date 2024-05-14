package mirea4sem.task7.decorator;

// Конкретный декоратор - с добавкой молока
class Milk extends CondimentDecorator {
    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Молоко";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.5;
    }
}
