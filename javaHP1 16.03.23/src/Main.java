import build.Building;
import build.Room;

public class Main {
    public static void main(String[] args) {

        Building building = new Building(300.34);

        Room room = new Room(23.45, building, 4);
        room.capacity();
        System.out.println(room);
    }
}