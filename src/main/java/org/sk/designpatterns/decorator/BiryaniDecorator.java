package org.sk.designpatterns.decorator;

public abstract class BiryaniDecorator extends Briyani {
    protected Briyani briyani;
    public BiryaniDecorator(Briyani briyani) {
        this.briyani = briyani;
    }

    public double getPrice() {
        return this.price + this.briyani.getPrice();
    }
}