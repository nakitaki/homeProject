package build;

public class Room extends Premise {
    private int numberOfBeds;

    public Room(double area, Building building, int people) {
        super(area, building);
        this.numberOfBeds = people;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    @Override
    public void capacity() {
        super.capacity();
        System.out.println(" People " + numberOfBeds);
    }

    @Override
    public String toString() {
        return "Room{" +
                "people=" + numberOfBeds +
                "} " + super.toString();
    }
}
