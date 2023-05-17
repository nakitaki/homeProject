package e08_Collection.ex1.vehicle;

import java.util.Objects;

public class Vehicle {
    private String regNumber;
    private VehicleType vehicleType;

    public Vehicle(String regNumber, VehicleType vehicleType) {
        this.regNumber = regNumber;
        this.vehicleType = vehicleType;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(regNumber, vehicle.regNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regNumber);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "regNumber='" + regNumber + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }


}
