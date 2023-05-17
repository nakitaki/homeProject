package e08_Collection.ex1.transport;

import e08_Collection.ex1.stop.Stop;
import e08_Collection.ex1.vehicle.Vehicle;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class PublicTransportCompany {
    private String name;
    private Set<Vehicle> vehicles;
    private Set<Stop> stops;


    //HashSet, TreeSet, LinkedSet, EnumSet

    public PublicTransportCompany(String name) {
        this.name = name;
        this.vehicles = new HashSet<>();
        this.stops = new TreeSet<>(); //stops sorted by number
    }

    public String getName() {
        return name;
    }

    public boolean addVehicle(Vehicle vehicle){
        return this.vehicles.add(vehicle);
    }

    public void printVehicles(){
        this.vehicles
                .stream()
                .forEach(vehicle -> System.out.println(vehicle));
    }

    public void removeVehicle(Vehicle vehicle){
        this.vehicles.remove(vehicle);
    }
}
