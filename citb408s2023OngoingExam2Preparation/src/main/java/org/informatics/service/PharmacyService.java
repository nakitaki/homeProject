package org.informatics.service;

import org.informatics.models.AgeCategory;
import org.informatics.models.Medicine;
import org.informatics.models.Pharmacy;

import java.time.LocalDate;
import java.util.Set;

public interface PharmacyService {
    /**
     * @param pharmacy
     * @param medicine
     * @param sellingPrice
     * @return true if medicine and its selling price are added to the medicinesSellingPrice map, false otherwise
     */
    boolean addMedicinePrice(Pharmacy pharmacy, Medicine medicine, double sellingPrice);

    /**
     * @param pharmacy
     * @param medicine
     * @return true if medicine is added to the promotedMedicines set, false otherwise
     */
    boolean addPromotedMedicine(Pharmacy pharmacy, Medicine medicine);

    /**
     * @param pharmacy the method prints the medicines and their prices stored in medicinesSellingPrice map
     */
    void printMedicinesSellingPrice(Pharmacy pharmacy);

    /**
     * @param pharmacy the method prints the medicines stored in promotedMedicines set
     */
    void printPromotedMedicines(Pharmacy pharmacy);

    /**
     * @param pharmacy
     * @param ageCategory
     * @param nameContains
     * @return the set of medicines that are appropriate for a given ageCategory and which name contains a given string
     */
    Set<Medicine> promotedMedicinesByAgeCategoryAndNameContains(Pharmacy pharmacy, AgeCategory ageCategory, String nameContains);

    /**
     * @param pharmacy
     * @param productionDate
     * @return the set of medicines that are produced before a given date, ordered by name
     */
    Set<Medicine> promotedMedicinesByProductionDateLessThanOrderedByName(Pharmacy pharmacy, LocalDate productionDate);

    /**
     * @param pharmacy
     * @param ageCategory
     * @return the number of medicines that are appropriate for given age category
     */
    long numberOfPromotedMedicinesByAgeCategory(Pharmacy pharmacy, AgeCategory ageCategory);

    /**
     * @param pharmacy
     * @return the total value of the selling prices stored in medicinesSellingPrice map
     */
    double medicinesSellingPriceTotalValue(Pharmacy pharmacy);

    /**
     * @param pharmacy
     * @return the least value of the selling prices stored in medicinesSellingPrice map
     */
    double medicinesSellingPriceLeastValue(Pharmacy pharmacy);

    /**
     * @param pharmacy
     * @return the set of medicines that are with selling price greater than a given one, ordered by name descending
     */
    Set<Medicine> medicinesSellingPriceBySellingPriceGreaterThan(Pharmacy pharmacy, Double sellingPriceLimit);
}
