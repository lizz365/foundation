package com.lizz.fundation.pattern.abstractFactory;

/**
 * @author lizz365
 */
public class BMWFactory implements CarFactory{
    @Override
    public Car newCar() {
        return new BMW();
    }
}
