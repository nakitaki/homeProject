package printingHouse;

import employees.Employee;
import machines.PrintingMachine;
import printMedia.PrintMedia;

import java.math.BigDecimal;
import java.util.*;

public class PrintingHouse {
    private String name;
    private BigDecimal basicEmployeeSalary;
    private Map<PrintMedia, Integer> printedMedias;
    private List<PrintingMachine> printingMachines;
    private Map<Employee, BigDecimal> employees;
    private BigDecimal percentageOverprice;
    private BigDecimal expectedIncome;
    private int numberForDiscount;
    private BigDecimal percentageDiscount;
    private BigDecimal percentageSalaryAddition;

    public PrintingHouse(String name, BigDecimal basicEmployeeSalary, BigDecimal percentageOverprice, BigDecimal expectedIncome,
                         int numberForDiscount, BigDecimal percentageDiscount, BigDecimal percentageSalaryAddition) {
        this.name = name;
        this.basicEmployeeSalary = basicEmployeeSalary;
        this.percentageOverprice = percentageOverprice;
        this.expectedIncome = expectedIncome;
        this.numberForDiscount = numberForDiscount;
        this.percentageDiscount = percentageDiscount;
        this.percentageSalaryAddition = percentageSalaryAddition;

        this.printedMedias = new HashMap<>();
        this.printingMachines = new ArrayList<>();
        this.employees = new TreeMap<>();
    }

    public PrintingHouse(Map<PrintMedia, Integer> printedMedias, List<PrintingMachine> printingMachines, Map<Employee, BigDecimal> employees) {
        this.printedMedias = Objects.requireNonNullElseGet(printedMedias, HashMap::new);
        this.printingMachines = Objects.requireNonNullElseGet(printingMachines, ArrayList::new);
        this.employees = Objects.requireNonNullElseGet(employees, TreeMap::new);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getBasicEmployeeSalary() {
        return basicEmployeeSalary;
    }

    public Map<PrintMedia, Integer> getPrintedMedias() {
        return printedMedias;
    }

    public List<PrintingMachine> getPrintingMachines() {
        return printingMachines;
    }

    public Map<Employee, BigDecimal> getEmployees() {
        return employees;
    }

    public int getTimesForDiscount() {
        return numberForDiscount;
    }

    public BigDecimal getExpectedIncome() {
        return expectedIncome;
    }

    public BigDecimal getPercentageDiscount() {
        return percentageDiscount;
    }

    public BigDecimal getPercentageOverprice() {
        return percentageOverprice;
    }

    public BigDecimal getPercentageSalaryAddition() {
        return percentageSalaryAddition;
    }


    public void setBasicEmployeeSalary(BigDecimal basicEmployeeSalary) {
        this.basicEmployeeSalary = basicEmployeeSalary;
    }

    public void setPrintingMachines(List<PrintingMachine> printingMachines) {
        this.printingMachines = printingMachines;
    }

    public void setPercentageOverprice(BigDecimal percentageOverprice) {
        this.percentageOverprice = percentageOverprice;
    }

    public void setExpectedIncome(BigDecimal expectedIncome) {
        this.expectedIncome = expectedIncome;
    }

    public void setNumberForDiscount(int numberForDiscount) {
        this.numberForDiscount = numberForDiscount;
    }

    public void setPercentageDiscount(BigDecimal percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
    }

    public void setPercentageSalaryAddition(BigDecimal percentageSalaryAddition) {
        this.percentageSalaryAddition = percentageSalaryAddition;
    }

    public void setEmployees(Map<Employee, BigDecimal> employees) {
        this.employees = employees;
    }

    public void setPrintedMedias(Map<PrintMedia, Integer> printedMedias) {
        this.printedMedias = printedMedias;
    }

    @Override
    public String toString() {
        return "PrintingHouse{" +
                "name='" + name + '\'' +
                ", basicEmployeeSalary=" + basicEmployeeSalary +
                ", printedMedias=" + printedMedias +
                ", printingMachines=" + printingMachines +
                ", employees=" + employees +
                '}';
    }
}
