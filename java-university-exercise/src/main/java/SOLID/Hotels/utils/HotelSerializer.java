package SOLID.Hotels.utils;

import SOLID.Hotels.hotel.HotelRoom;

import java.io.*;

public class HotelSerializer {
    public static void serializeHotelRoom(String filePath, HotelRoom hotelRoom) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath);
             ObjectOutputStream outputStream = new ObjectOutputStream(fos);) {
            outputStream.writeObject(hotelRoom);
        }
    }

    public static HotelRoom deserializeHotelRoom(String filePath) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(filePath);
             ObjectInputStream inputStream = new ObjectInputStream(fis);) {
            return (HotelRoom) inputStream.readObject();
        }
    }
}
