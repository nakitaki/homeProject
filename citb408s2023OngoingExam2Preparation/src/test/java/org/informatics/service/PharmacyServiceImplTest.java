package org.informatics.service;

import org.informatics.models.AgeCategory;
import org.informatics.models.Medicine;
import org.informatics.models.Pharmacy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PharmacyServiceImplTest {

    @InjectMocks
    private PharmacyServiceImpl pharmacyService;
    @Mock
    private Pharmacy pharmacy;


    @Test
    void testNumberOfPromotedMedicinesByAgeCategory() {
        //given
        Medicine medicine1 = mock(Medicine.class);
        Medicine medicine2 = mock(Medicine.class);
        Medicine medicine3 = mock(Medicine.class);
        Medicine medicine4 = mock(Medicine.class);

        when(medicine1.getAgeCategory()).thenReturn(AgeCategory.ADULTS);
        when(medicine2.getAgeCategory()).thenReturn(AgeCategory.ADULTS);
        when(medicine3.getAgeCategory()).thenReturn(AgeCategory.TEENAGERS);
        when(medicine4.getAgeCategory()).thenReturn(AgeCategory.CHILDREN);

        Set<Medicine> medicines = new HashSet<>();
        medicines.add(medicine1);
        medicines.add(medicine2);
        medicines.add(medicine3);
        medicines.add(medicine4);

        when(pharmacy.getPromotedMedicines()).thenReturn(medicines);

        long expected = 2;

        //when
        long actual = pharmacyService.numberOfPromotedMedicinesByAgeCategory(pharmacy, AgeCategory.ADULTS);

        //then

        assertEquals(expected, actual);
    }

    @Test
    void testMedicinesSellingPriceTotalValue() {
        Medicine medicine1 = mock(Medicine.class);
        Medicine medicine2 = mock(Medicine.class);

        Map<Medicine, Double> medicines = new HashMap<>();
        medicines.put(medicine1, 10.2);
        medicines.put(medicine2, 5.4);

        when(pharmacy.getMedicinesSellingPrice()).thenReturn(medicines);

        double expected = 15.6;
        double actual = pharmacyService.medicinesSellingPriceTotalValue(pharmacy);

        assertEquals(expected, actual);
    }
}