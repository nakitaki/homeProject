package e10_Reflection.ex2;

import java.awt.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SportsmanServiceImpl implements SportsmanService{
    public static LocalDate returnNow(){
        return LocalDate.now();
    }

    public long yearFromRegistration(Sportsman sportsman){
        return ChronoUnit.YEARS.between(sportsman.getRegistrationDate(), returnNow());
    }

    public double paymentValue(Sportsman sportsman){
        return sportsman.getAnnualSalary()+
                sportsman.getAnnualSalary()
                *sportsman.getSportsmanCategory()
                        .getIncreasePercentage()/100;
    }

    public Sportsman sportsmanWithGreaterPayment(Sportsman sportsman1, Sportsman sportsman2){
        return paymentValue(sportsman1) > paymentValue(sportsman2) ? sportsman1 : sportsman2;
    }


}
