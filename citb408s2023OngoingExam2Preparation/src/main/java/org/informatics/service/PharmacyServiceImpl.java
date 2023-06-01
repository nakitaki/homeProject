package org.informatics.service;

import org.informatics.models.AgeCategory;
import org.informatics.models.Medicine;
import org.informatics.models.Pharmacy;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PharmacyServiceImpl implements PharmacyService {
    /**
     * @param pharmacy
     * @param medicine
     * @param sellingPrice
     * @return true if medicine and its selling price are added to the medicinesSellingPrice map, false otherwise
     */
    @Override
    public boolean addMedicinePrice(Pharmacy pharmacy, Medicine medicine, double sellingPrice) {
        pharmacy
                .getMedicinesSellingPrice()
                .putIfAbsent(medicine,sellingPrice);
        return true;
    }

    /**
     * @param pharmacy
     * @param medicine
     * @return true if medicine is added to the promotedMedicines set, false otherwise
     */
    @Override
    public boolean addPromotedMedicine(Pharmacy pharmacy, Medicine medicine) {
        return pharmacy
                .getPromotedMedicines()
                .add(medicine);

    }

    /**
     * @param pharmacy the method prints the medicines and their prices stored in medicinesSellingPrice map
     */
    @Override
    public void printMedicinesSellingPrice(Pharmacy pharmacy) {
        pharmacy.getMedicinesSellingPrice()
                .entrySet()
                .stream()
                .forEach(entry -> System.out.println(entry.getKey() + "->" + entry.getValue()));
    }

    /**
     * @param pharmacy the method prints the medicines stored in promotedMedicines set
     */
    @Override
    public void printPromotedMedicines(Pharmacy pharmacy) {
        pharmacy.getPromotedMedicines()
                .stream()
                .forEach(System.out::println);
    }

    /**
     * @param pharmacy
     * @param ageCategory
     * @param nameContains
     * @return the set of medicines that are appropriate for a given ageCategory and which name contains a given string
     */
    @Override
    public Set<Medicine> promotedMedicinesByAgeCategoryAndNameContains(Pharmacy pharmacy, AgeCategory ageCategory, String nameContains) {
        return pharmacy
                .getPromotedMedicines()
                .stream()
                .filter(medicine -> medicine.getAgeCategory().equals(ageCategory) &&
                        medicine.getName().contains(nameContains))
                .collect(Collectors.toSet());
    }

    /**
     * @param pharmacy
     * @param productionDate
     * @return the set of medicines that are produced before a given date, ordered by name
     */
    @Override
    public Set<Medicine> promotedMedicinesByProductionDateLessThanOrderedByName(Pharmacy pharmacy, LocalDate productionDate) {
        return pharmacy
                .getPromotedMedicines()
                .stream()
                .filter(medicine -> medicine.getProductionDate().isBefore(productionDate))
                .sorted(Comparator.comparing(Medicine::getName)) //TODO!! 3. AKO E SIVO -> ALT+SPACE -> COLLECT TO
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    /**
     * @param pharmacy
     * @param ageCategory
     * @return the number of medicines that are appropriate for given age category
     */
    @Override
    public long numberOfPromotedMedicinesByAgeCategory(Pharmacy pharmacy, AgeCategory ageCategory) {
        return pharmacy.getPromotedMedicines()
                .stream()
                .filter(medicine -> medicine.getAgeCategory().equals(ageCategory))
                .count();
    }

    /**
     * @param pharmacy
     * @return the total value of the selling prices stored in medicinesSellingPrice map
     */
    @Override
    public double medicinesSellingPriceTotalValue(Pharmacy pharmacy) {
        return pharmacy
                .getMedicinesSellingPrice()
                .entrySet()
                .stream()
                .map(entry -> entry.getValue())
                .reduce(0., Double::sum); //TODO sum of collection
    }

    /**
     * @param pharmacy
     * @return the least value of the selling prices stored in medicinesSellingPrice map
     */
    @Override
    public double medicinesSellingPriceLeastValue(Pharmacy pharmacy) {
        return pharmacy
                .getMedicinesSellingPrice()
                .entrySet()
                .stream()
                .map(entry -> entry.getValue())
                .min(Double::compare) //TODO min/max
                .get();
    }

    /**
     * @param pharmacy
     * @param sellingPriceLimit
     * @return the set of medicines that are with selling price greater than a given one, ordered by name descending
     */
    @Override
    public Set<Medicine> medicinesSellingPriceBySellingPriceGreaterThan(Pharmacy pharmacy, Double sellingPriceLimit) {
        return pharmacy
                .getMedicinesSellingPrice()
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue()>sellingPriceLimit)
                .map(entry -> entry.getKey())
                .collect(Collectors.toCollection(LinkedHashSet::new)); //TODO dont forget collect(Collectors.toCollection(LinkedHashSet::new))
    }
}
