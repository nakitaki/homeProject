package interfacesAndAbstraction.carShop;

public class Main {
    public static void main(String[] args) {
        Sellable seat = new Seat("Leon", "gray", 110, "Spain", 11111.1);
        Rentable audi = new Audi("A4", "gray", 110, "Germany", 3, 99.9);

        printCarInfo((Car)seat);
        printCarInfo((Car)audi);
    }

    public static void printCarInfo(Car car){
        System.out.println(String.format(
                "%s is %s color and have %s horse Power",
                car.getModel(),
                car.getColor(),
                car.getHorsePower()));
        System.out.println(car);
    }
}