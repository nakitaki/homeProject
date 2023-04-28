package SOLID.Hotels.exceptions;

import SOLID.Hotels.hotel.HotelRoom;

public class RoomAlreadyInTheListException extends Exception {
    private HotelRoom hotelRoom;

    public RoomAlreadyInTheListException(HotelRoom hotelRoom) {
        this.hotelRoom = hotelRoom;
    }

    @Override
    public String toString() {
        return "RoomAlreadyInTheListException{" +
                "hotelRoom=" + hotelRoom +
                "} ";
    }
}
