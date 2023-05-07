package e06_SOLID.hotels;

import e06_SOLID.hotels.exceptions.RoomAlreadyInTheListException;
import e06_SOLID.hotels.exceptions.RoomIsNotAvailableException;
import e06_SOLID.hotels.exceptions.RoomNotInTheListException;
import e06_SOLID.hotels.hotel.Hotel;
import e06_SOLID.hotels.hotel.HotelRoom;
import e06_SOLID.hotels.utils.HotelSerializer;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        HotelRoom hotelRoom1 = new HotelRoom(101, 2, 133);
        HotelRoom hotelRoom2 = new HotelRoom(102, 3, 123);
        HotelRoom hotelRoom3 = new HotelRoom(103, 3, 123);
        HotelRoom hotelRoom4 = new HotelRoom(104, 2, 133);

        Hotel hotel = new Hotel("H1");

        try {
            hotel.addRoom(hotelRoom1);
        } catch (RoomAlreadyInTheListException e) {
            throw new RuntimeException(e);
        }

        try {
            hotel.addRoom(hotelRoom2);
        } catch (RoomAlreadyInTheListException e) {
            throw new RuntimeException(e);
        }

        try {
            hotel.addRoom(hotelRoom3);
        } catch (RoomAlreadyInTheListException e) {
            throw new RuntimeException(e);
        }

        hotel.printRooms();

        try (FileWriter fileWriter = new FileWriter("rented room " + hotelRoom2.getRoomNumber() + ".txt");) {
            fileWriter.write(hotel.toString() + " " + hotelRoom3);
            hotel.addRentedRoom(hotelRoom2);
        } catch (RoomIsNotAvailableException | RoomNotInTheListException | IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println();
        System.out.println();
        System.out.println(hotelRoom2);


        String filePath = "hotel_room.ser";
        try {
            HotelSerializer.serializeHotelRoom(filePath, hotelRoom2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.print("Deserialize  ");
        try {
            System.out.println(HotelSerializer.deserializeHotelRoom(filePath));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        hotelRoom2.setPrice(140);

        System.out.println(hotelRoom2);


    }

}
