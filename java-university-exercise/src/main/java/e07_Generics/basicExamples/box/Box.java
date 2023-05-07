package e07_Generics.basicExamples.box;

//generic class -> has T which extends Weighted => for sure T has method getWeight()
public class Box<T extends Weighted> {
    private T item;
    private double boxWeight;

    public Box(T item, double boxWeight) {
        this.item = item;
        this.boxWeight = boxWeight;
    }

    public T getItem() {
        return item;
    }

    public double getBoxWeight() {
        return boxWeight;
    }
    public double totalWeight(){
        return this.item.getWeight() + this.boxWeight;
    }

    @Override
    public String toString() {
        return "Box{" +
                "item=" + item +
                ", boxWeight=" + boxWeight +
                '}';
    }
}
