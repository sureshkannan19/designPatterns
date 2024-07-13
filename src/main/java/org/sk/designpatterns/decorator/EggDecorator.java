package org.sk.designpatterns.decorator;

public class EggDecorator extends BiryaniDecorator {
    protected Briyani briyani;

    public EggDecorator(Briyani briyani) {
        super(briyani);
        this.price = 10;
        this.briyani = briyani;
    }

}
