package e07_Generics.basicExamples.restaurant;

import e07_Generics.basicExamples.box.Weighted;

public class Goods implements Weighted, Comparable<Goods>{
    private String name;
    private double price;
    private double weight;

    public Goods(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Goods o) {
        return Double.compare(this.price, o.price);
    }
}
