package com.lizz.fundation.pattern.abstractFactory;

/**
 * @author lizz365
 */
public class BenzFactory implements CarFactory{
    @Override
    public Car newCar() {
        return new Benz();
    }
}
