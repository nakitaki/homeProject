package org.example;

public enum BottleSize {
    HALFLITER(0.5), LITER(1), LITERANDHALF(1.5);
    private double litres;


    BottleSize(double litres) {
        this.litres = litres;
    }

}
