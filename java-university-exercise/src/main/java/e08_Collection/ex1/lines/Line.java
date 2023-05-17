package e08_Collection.ex1.lines;

import e08_Collection.ex1.stop.Stop;

import java.util.*;

public class Line {
    private int number;

    ///1 - Stop (7891)
    ///2 - Stop (7899)
    ///3 - Stop (7929)
    ///Mladost - Liulin
    ///Liulin - Mladost
    private Set<Stop> stopsStartEnd;
    private Map<Integer, Stop> stops;

    public Line(int number) {
        this.number = number;
        this.stopsStartEnd = new LinkedHashSet<>();
        this.stops = new TreeMap<>(); //Integer - natural ordering -> 1,2,3,4  => we don't have to do anything
    }

    public boolean addStop(Stop stop){
        return this.stopsStartEnd.add(stop);
    }

    public void printStops(){
        this.stopsStartEnd.stream()
                .forEach(stop -> System.out.println(stop));
    }

    public void addStopToMap(int number, Stop stop){
        if(this.stops.containsKey(number)){
            //exception
        }
        if(this.stops.containsValue(stop)){
            //exception
        }
        else this.stops.put(number, stop); //if key is already in the Map, it will return the old collection with that key
    }

    public void printStopsMapEntry(){
        this.stops.entrySet() //couple -> key, value
                .stream()
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue())); ;
    }
}

//proekt
