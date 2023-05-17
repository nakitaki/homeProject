package e08_Collection.ex1;

import e08_Collection.ex1.lines.Line;
import e08_Collection.ex1.stop.Stop;
import e08_Collection.ex1.transport.PublicTransportCompany;
import e08_Collection.ex1.vehicle.Vehicle;
import e08_Collection.ex1.vehicle.VehicleType;

public class Main {
    public static void main(String[] args) {


        Vehicle vehicle1 = new Vehicle("CA1234G", VehicleType.BUS);
        Vehicle vehicle2 = new Vehicle("CA1234P", VehicleType.TRAIN);
        Vehicle vehicle3 = new Vehicle("CA1234L", VehicleType.BUS);
        Vehicle vehicle4 = new Vehicle("CA1234T", VehicleType.TRAM);

        PublicTransportCompany publicTransportCompany = new PublicTransportCompany("Sofia Traffic");
        publicTransportCompany.addVehicle(vehicle1);
        publicTransportCompany.addVehicle(vehicle2);
        publicTransportCompany.addVehicle(vehicle3);
        publicTransportCompany.addVehicle(vehicle4);
        System.out.println(publicTransportCompany.addVehicle(vehicle4));

        publicTransportCompany.printVehicles();

        Stop stop1 = new Stop(1231, "NBU", "Montevideo 21");
        Stop stop2 = new Stop(1232, "NBU", "Montevideo 22");
        Stop stop3 = new Stop(1233, "NBU", "Montevideo 23");
        Stop stop4 = new Stop(1234, "NBU", "Montevideo 24");
        Stop stop5 = new Stop(1235, "NBU", "Montevideo 24");

        System.out.println();

        Line line = new Line(111);
        line.addStop(stop3);
        line.addStop(stop1);
        line.addStop(stop4);
        line.addStop(stop2);

        line.printStops();
    }
}
