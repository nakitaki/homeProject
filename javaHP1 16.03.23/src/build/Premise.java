package build;

public class Premise {
    private double area;
    private Building building;

    public Premise(double area, Building building) {
        this.area = area;
        this.building = building;
    }

    public double getArea() {
        return area;
    }

    public void capacity() {
        System.out.println("Area " + area);
    }

    @Override
    public String toString() {
        return "Space{" +
                "area=" + area +
                ", building=" + building +
                '}';
    }
}
