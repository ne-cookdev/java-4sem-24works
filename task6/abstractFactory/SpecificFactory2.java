package mirea4sem.task6.abstractFactory;

public class SpecificFactory2 implements AbstractFactory {

    @Override
    public ProductA createProductA() {
        return new SpecificProductA2();
    }

    @Override
    public ProductB createProductB() {
        return new SpecificProductB2();
    }
}
