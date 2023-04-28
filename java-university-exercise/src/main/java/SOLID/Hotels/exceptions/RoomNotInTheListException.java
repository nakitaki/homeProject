package SOLID.Hotels.exceptions;

import SOLID.Hotels.hotel.HotelRoom;

public class RoomNotInTheListException extends Exception {
    private HotelRoom hotelRoom;

    public RoomNotInTheListException(HotelRoom hotelRoom) {
        this.hotelRoom = hotelRoom;
    }

    @Override
    public String toString() {
        return "RoomNotInTheListException{" +
                "hotelRoom=" + hotelRoom +
                "} ";
    }
}
