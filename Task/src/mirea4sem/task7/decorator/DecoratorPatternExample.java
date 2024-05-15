package mirea4sem.task7.decorator;

public class DecoratorPatternExample {
    public static void main(String[] args) {
        // Создаем базовый напиток - кофе
        Beverage beverage = new Coffee();
        // Добавляем молоко
        beverage = new Milk(beverage);
        // Добавляем шоколад
        beverage = new Chocolate(beverage);

        // Выводим описание и стоимость напитка
        System.out.println("Напиток: " + beverage.getDescription());
        System.out.println("Стоимость: " + beverage.cost() + " руб.");
    }
}
