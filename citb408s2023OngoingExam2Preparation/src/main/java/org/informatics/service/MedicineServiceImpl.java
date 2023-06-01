package org.informatics.service;

import org.informatics.models.Medicine;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class MedicineServiceImpl implements MedicineService {
    @Override
    public long daysFromProductionDate(Medicine medicine, LocalDate compareDate) {
        return ChronoUnit.DAYS.between(medicine.getProductionDate(), compareDate);
    }
}
