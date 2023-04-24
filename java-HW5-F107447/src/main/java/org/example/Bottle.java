package org.example;

public class Bottle {
    private BottleMaterial bottleMaterial;
    private BottleSize bottleSize;
    private boolean isFull;

    public Bottle(BottleMaterial bottleMaterial, BottleSize bottleSize, boolean isFull) {
        this.bottleMaterial = bottleMaterial;
        this.bottleSize = bottleSize;
        this.isFull = isFull;
    }

    public BottleMaterial getBottleMaterial() {
        return bottleMaterial;
    }

    public void setBottleMaterial(BottleMaterial bottleMaterial) {
        this.bottleMaterial = bottleMaterial;
    }

    public BottleSize getBottleSize() {
        return bottleSize;
    }

    public void setBottleSize(BottleSize bottleSize) {
        this.bottleSize = bottleSize;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    @Override
    public String toString() {
        return "Bottle{" +
                "bottleMaterial=" + bottleMaterial +
                ", bottleSize=" + bottleSize +
                ", isFull=" + isFull +
                '}';
    }
}
