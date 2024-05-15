package mirea4sem.task6.abstractFactory;

public class SpecificFactory1 implements AbstractFactory {

    @Override
    public ProductA createProductA() {
        return new SpecificProductA1();
    }

    @Override
    public ProductB createProductB() {
        return new SpecificProductB1();
    }
}

