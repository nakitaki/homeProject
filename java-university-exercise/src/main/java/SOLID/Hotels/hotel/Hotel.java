package SOLID.Hotels.hotel;

import SOLID.Hotels.exceptions.RoomAlreadyInTheListException;
import SOLID.Hotels.exceptions.RoomIsNotAvailableException;
import SOLID.Hotels.exceptions.RoomNotInTheListException;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private List<HotelRoom> rooms;
    private List<HotelRoom> rentedRooms;

    public Hotel(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
        this.rentedRooms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean addRoom(HotelRoom hotelRoom) throws RoomAlreadyInTheListException {
        if(this.rooms.contains(hotelRoom)){
            throw new RoomAlreadyInTheListException(hotelRoom);
        }
        return this.rooms.add(hotelRoom);
    }

    public boolean addRentedRoom(HotelRoom hotelRoom) throws RoomNotInTheListException, RoomIsNotAvailableException {
        if(this.rooms.contains(hotelRoom)){
            if(this.rentedRooms.contains(hotelRoom)){
                throw new RoomIsNotAvailableException(hotelRoom);
            }
             return this.rentedRooms.add(hotelRoom);
        }
        else{
            throw new RoomNotInTheListException(hotelRoom);
        }
    }

    public void printRooms(){
        for(HotelRoom hotelRoom: this.rooms){
            System.out.println(hotelRoom);
        }

    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}

