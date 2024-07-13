package org.sk.designpatterns.decorator;

public class DecoratorTest {

    public static void main(String[] args) {
        Briyani mutton = new MuttonBriyani();
        System.out.println("Mutton briyani price: " + mutton.getPrice());
        EggDecorator egg = new EggDecorator(mutton);
        System.out.println(" Add eggs : " + egg.getPrice());
        EggDecorator egg1 = new EggDecorator(egg);
        System.out.println(" Add more eggs : " + egg1.getPrice());
    }
}
