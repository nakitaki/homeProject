package build;

public class Building {
    private double area;

    public Building(double area) {
        this.area = area;
    }

    public double getArea() {
        return area;
    }

    public void capacity(){
        System.out.println("Area " + area);
    }

    @Override
    public String toString() {
        return "Building{" +
                "area=" + area +
                '}';
    }
}
