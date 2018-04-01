package com.lizz.fundation.pattern.AbstractFactory;

/**
 * @author lizz365
 */
public class BenzFactory implements CarFactory{
    @Override
    public Car newCar() {
        return new Benz();
    }
}
