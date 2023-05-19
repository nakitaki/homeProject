package e10_Reflection.ex2;

import java.io.Serializable;
import java.time.LocalDate;

public class Sportsman implements Serializable {
    private SportsmanService sportsmanService;
    private String name;
    private LocalDate registrationDate;
    private SportsmanCategory  sportsmanCategory;
    private double annualSalary;
    private static double additionalPayment = 1000;

    public Sportsman(String name, LocalDate registrationDate, SportsmanCategory sportsmanCategory, double annualSalary) {
        this.name = name;
        this.registrationDate = registrationDate;
        this.sportsmanCategory = sportsmanCategory;
        this.annualSalary = annualSalary;
    }

    public String getName() {
        return name;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public SportsmanCategory getSportsmanCategory() {
        return sportsmanCategory;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public static double getAdditionalPayment() {
        return additionalPayment;
    }

    @Override
    public String toString() {
        return "Sportsman{" +
                "sportsmanService=" + sportsmanService +
                ", name='" + name + '\'' +
                ", registrationDate=" + registrationDate +
                ", sportsmanCategory=" + sportsmanCategory +
                ", annualSalary=" + annualSalary +
                '}';
    }
}
