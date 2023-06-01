package org.informatics;

import org.informatics.models.*;
import org.informatics.models.Pharmacy;
import org.informatics.service.PharmacyService;
import org.informatics.service.PharmacyServiceImpl;

import java.time.LocalDate;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Medicine medicine1 = new Medicine("Eye Drops", AgeCategory.ADULTS, LocalDate.of(2023, 9, 1));
        Medicine medicine2 = new Medicine("Eye Drops", AgeCategory.ADULTS, LocalDate.of(2021, 9, 1));
        Medicine medicine3 = new Medicine("Nurofen", AgeCategory.ADULTS, LocalDate.of(2022, 9, 1));
        Medicine medicine4 = new Medicine("Nurofen", AgeCategory.TEENAGERS, LocalDate.of(2020, 9, 1));
        Medicine medicine5 = new Medicine("Nurofen", AgeCategory.TEENAGERS, LocalDate.of(2021, 9, 1));
        Medicine medicine6 = new Medicine("Paracetamol", AgeCategory.TEENAGERS, LocalDate.of(2022, 9, 1));
        Medicine medicine7 = new Medicine("Paracetamol", AgeCategory.TEENAGERS, LocalDate.of(2023, 9, 1));
        Medicine medicine8 = new Medicine("Paracetamol", AgeCategory.CHILDREN, LocalDate.of(2023, 9, 1));
        Medicine medicine9 = new Medicine("Eye Drops", AgeCategory.CHILDREN, LocalDate.of(2022, 9, 1));
        Medicine medicine10 = new Medicine("Eye Drops", AgeCategory.CHILDREN, LocalDate.of(2023, 9, 1));

        Pharmacy pharmacy = new Pharmacy("panacea");

        PharmacyService pharmacyService = new PharmacyServiceImpl();

        // Task 2.1
        System.out.println("==================================== Task 2.1 ====================================");

        pharmacyService.addMedicinePrice(pharmacy, medicine1, 10.2);
        pharmacyService.addMedicinePrice(pharmacy, medicine2, 5.2);
        pharmacyService.addMedicinePrice(pharmacy, medicine3, 10.2);
        pharmacyService.addMedicinePrice(pharmacy, medicine4, 5.2);
        pharmacyService.addMedicinePrice(pharmacy, medicine5, 10.2);
        pharmacyService.addMedicinePrice(pharmacy, medicine6, 6.2);
        pharmacyService.addMedicinePrice(pharmacy, medicine7, 6.2);
        pharmacyService.addMedicinePrice(pharmacy, medicine8, 5.2);
        pharmacyService.addMedicinePrice(pharmacy, medicine9, 10.2);
        pharmacyService.addMedicinePrice(pharmacy, medicine10, 6.2);

        // Task 2.2
        System.out.println("==================================== Task 2.2 ====================================");

        pharmacyService.addPromotedMedicine(pharmacy, medicine1);
        pharmacyService.addPromotedMedicine(pharmacy, medicine2);
        pharmacyService.addPromotedMedicine(pharmacy, medicine3);
        pharmacyService.addPromotedMedicine(pharmacy, medicine4);
        pharmacyService.addPromotedMedicine(pharmacy, medicine5);
        pharmacyService.addPromotedMedicine(pharmacy, medicine6);
        pharmacyService.addPromotedMedicine(pharmacy, medicine7);
        pharmacyService.addPromotedMedicine(pharmacy, medicine8);

        // Task 2.3
        System.out.println("==================================== Task 2.3 ====================================");

        pharmacyService.printMedicinesSellingPrice(pharmacy);

        // Task 2.4
        System.out.println("==================================== Task 2.4 ====================================");

        pharmacyService.printPromotedMedicines(pharmacy);

        // Task 2.5
        System.out.println("==================================== Task 2.5 ====================================");

        AgeCategory ageCategory = AgeCategory.ADULTS;
        String nameContains = "ro";
        Set<Medicine> medicinesSellingPriceByAgeCategoryAndNameContains =
                pharmacyService.promotedMedicinesByAgeCategoryAndNameContains(pharmacy, ageCategory, nameContains);
        medicinesSellingPriceByAgeCategoryAndNameContains.stream().forEach(System.out::println);

//        // Task 2.6
//        System.out.println("==================================== Task 2.6 ====================================");
//
//        LocalDate dateBeforeProduction = LocalDate.of(2023, 9, 1);
//        Set<Medicine> medicinesSellingPriceByProductionDateLessThanOrderedByName =
//                pharmacyService.promotedMedicinesByProductionDateLessThanOrderedByName(pharmacy, dateBeforeProduction);
//        medicinesSellingPriceByProductionDateLessThanOrderedByName.stream().forEach(System.out::println);
//
//        // Task 2.7
//        System.out.println("==================================== Task 2.7 ====================================");
//
//        ageCategory = AgeCategory.TEENAGERS;
//        System.out.println(pharmacyService.numberOfPromotedMedicinesByAgeCategory(pharmacy, ageCategory));
//
//        // Task 2.8
//        System.out.println("==================================== Task 2.8 ====================================");
//
//        System.out.println(pharmacyService.medicinesSellingPriceTotalValue(pharmacy));
//
//        // Task 2.9
//        System.out.println("==================================== Task 2.9 ====================================");
//
//        System.out.println(pharmacyService.medicinesSellingPriceLeastValue(pharmacy));
//
//        // Task 2.10
//        System.out.println("==================================== Task 2.10 ====================================");
//
//        double sellingPriceLimit = 6.3;
//        Set<Medicine> medicinesSellingPriceGreaterThan = pharmacyService.medicinesSellingPriceBySellingPriceGreaterThan(pharmacy, sellingPriceLimit);
//        medicinesSellingPriceGreaterThan.stream().forEach(System.out::println);

    }
}