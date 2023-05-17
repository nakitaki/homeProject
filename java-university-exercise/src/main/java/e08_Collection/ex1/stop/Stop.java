package e08_Collection.ex1.stop;

import java.util.Objects;

public class Stop implements Comparable<Stop>{
    private int number;
    private String name;
    private String address;

    public Stop(int number, String name, String address) {
        this.number = number;
        this.name = name;
        this.address = address;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stop stop = (Stop) o;
        return number == stop.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Stop{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int compareTo(Stop o) {
        return Integer.compare(this.number, o.number);
    }
}
