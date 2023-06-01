package e12_TestPreparation.prep1.sports;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class Player implements Serializable {
    private UUID uuid;
    private String name;
    private LocalDate registrationDate;
    private SportCategory sportCategory;
    private double annualSalary;

    public Player(String name, LocalDate registrationDate, SportCategory sportCategory, double annualSalary) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.registrationDate = registrationDate;
        this.sportCategory = sportCategory;
        this.annualSalary = annualSalary;
    }

    public Player() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public SportCategory getSportCategory() {
        return sportCategory;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    @Override
    public String toString() {
        return "Player{" +
                "uuid=" + uuid +
                ", name='" + name + '\'' +
                ", registrationDate=" + registrationDate +
                ", sportCategory=" + sportCategory +
                ", annualSalary=" + annualSalary +
                '}';
    }
}
