package org.informatics.service;

import org.informatics.models.Medicine;

import java.time.LocalDate;

public interface MedicineService {
    long daysFromProductionDate(Medicine medicine, LocalDate localDate);
}
