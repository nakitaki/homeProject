import exceptions.NegativeOverchargePercentageException;

import java.io.IOException;
import java.time.LocalDate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Task 1
        Sellable sellable;

        // Task 2
        double overchargePercentage = 10;
        Item item = new Item(111L, "Cosmetics", 10);
        System.out.println(item);
        try {
            System.out.println(item.sellingPrice(overchargePercentage));
        } catch (NegativeOverchargePercentageException e) {
            throw new RuntimeException(e);
        }

        // Task 3
        Medicine medicine = new Medicine(222L, "Eye Drops", 20, LocalDate.of(2023, 9, 1), AgeCategory.ADULTS);
        System.out.println(medicine);
        System.out.println(medicine.daysToExpiration());
        try {
            System.out.println(medicine.sellingPrice(overchargePercentage));
        } catch (NegativeOverchargePercentageException e) {
            throw new RuntimeException(e);
        }

        // Task 4
        Pharmacy pharmacy = new Pharmacy(overchargePercentage);
        pharmacy.addSellable(item);
        pharmacy.addSellable(medicine);
        System.out.println(pharmacy);
        try {
            System.out.println(pharmacy.totalIncome());
        } catch (NegativeOverchargePercentageException e) {
            throw new RuntimeException(e);
        }

        // Task 5
        String filePath = "item.ser";
        try {
            ItemUtil.serializeItem(filePath, item);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(ItemUtil.deserializeItem(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}