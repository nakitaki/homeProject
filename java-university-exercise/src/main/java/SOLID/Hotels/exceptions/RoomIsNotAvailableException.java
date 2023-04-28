package SOLID.Hotels.exceptions;

import SOLID.Hotels.hotel.HotelRoom;

public class RoomIsNotAvailableException extends Exception {
    private HotelRoom hotelRoom;

    public RoomIsNotAvailableException(HotelRoom hotelRoom) {
        this.hotelRoom = hotelRoom;
    }

    @Override
    public String toString() {
        return "RoomIsNotAvailableException{" +
                "hotelRoom=" + hotelRoom +
                "} ";
    }
}
