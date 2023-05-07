package e06_SOLID.hotels.exceptions;

import e06_SOLID.hotels.hotel.HotelRoom;

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
