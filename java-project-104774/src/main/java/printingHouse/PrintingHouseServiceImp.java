package printingHouse;

import employees.Employee;
import exception.NoEnoughPaperInThePrintingMachineException;
import exception.NoSuchMachineInTheFactoryException;
import exception.NoSuitableMachineSelectedException;
import exception.NotPossiblePrinting;
import machines.PrintingMachine;
import machines.PrintingMachineService;
import printMedia.PrintMedia;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrintingHouseServiceImp implements PrintingHouseService {
    private PrintingHouse printingHouse;
    private PrintingMachineService printingMachineService;

    public PrintingHouseServiceImp(PrintingHouse printingHouse, PrintingMachineService printingMachineService) {
        this.printingHouse = printingHouse;
        this.printingMachineService = printingMachineService;
    }

    public PrintingHouse getPrintingHouse() {
        return printingHouse;
    }

    public boolean addMachine(PrintingMachine printingMachine) {
        return printingHouse.getPrintingMachines().add(printingMachine);
    }

    public void removeMachine(PrintingMachine printingMachine){
        if (printingHouse.getPrintingMachines().contains(printingMachine)) {
            printingHouse.getPrintingMachines().remove(printingMachine);
        }
    }

    public void addEmployee(Employee employee) {
        printingHouse.getEmployees().put(employee, printingHouse.getBasicEmployeeSalary());
    }

    public void removeEmployee(Employee employee) {
        if (printingHouse.getEmployees().containsKey(employee)) {
            printingHouse.getEmployees().remove(employee);
        }
    }

    public BigDecimal totalExpenses() {
        return paperExpenses().add(salaryExpenses());
    }

    public void BonusForAllEmployees() {
        if(isIncomeMoreThenExpected()) {
            printingHouse.getEmployees().entrySet().stream()
                    .filter(entry -> entry.getKey().isManager())
                    .forEach(entry -> addBonusToSalary(entry));
        }
    }

    public BigDecimal salaryExpenses() {
        return printingHouse.getEmployees()
                .values()
                .stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    //TODO target
    public boolean isIncomeMoreThenExpected(){
        return totalIncome().compareTo(printingHouse.getExpectedIncome()) > 0;
    }

    public void addBonusToSalary(Map.Entry<Employee, BigDecimal> employee) {
        employee.setValue(employee.getValue().add(printingHouse.getPercentageSalaryAddition()));
    }

    public BigDecimal paperExpenses() {
        return printingHouse.getPrintedMedias().entrySet()
                .stream()
                .map(media -> priceForBatch(media.getKey(), media.getValue(), media.getKey().priceForPrinting()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }



    public BigDecimal priceForBatch(PrintMedia printMedia, int times, BigDecimal priceForOne ) {
        return priceForOne.multiply(BigDecimal.valueOf(times));
    }

    public BigDecimal totalIncome() {
        return printingHouse.getPrintedMedias().entrySet().stream()
                .map(media -> incomeFromMediaAndTimes(media.getKey(), media.getValue(), calcDiscountPercentage(media.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }


    public BigDecimal incomeFromMediaAndTimes(PrintMedia printMedia, int times, BigDecimal percentage) {
        //(price for one)*(times)
        return priceForOnePiece(printMedia, percentage)
                .multiply(BigDecimal.valueOf(times));
    }

    public BigDecimal calcDiscountPercentage(Integer times){
        if(hasDiscount(times)) {
            return printingHouse.getPercentageDiscount();
        }
        else return BigDecimal.ZERO;
    }

    public boolean hasDiscount(Integer times) {
        return times >= printingHouse.getTimesForDiscount();
    }

    public BigDecimal priceForOnePiece(PrintMedia printMedia, BigDecimal percentage){
        return printMedia.priceForPrinting().add((totalPercentage(percentage).
                divide(BigDecimal.valueOf(100))).multiply(printMedia.priceForPrinting()));
    }

    public BigDecimal totalPercentage(BigDecimal percentage){
        return (printingHouse.getPercentageOverprice().subtract(percentage));
    }

    public BigDecimal netIncome(){
        return totalIncome().subtract(totalExpenses());
    }

    public void historyOfPrinting() {
        printingHouse.getPrintedMedias().entrySet()
                .stream()
                .forEach(media -> System.out.println(media.getKey() + " -> " + media.getValue() + " times"));
    }

    public String printPublications(PrintingMachine printingMachine, PrintMedia printMedia, int times)
            throws NoSuchMachineInTheFactoryException, NoSuitableMachineSelectedException, NoEnoughPaperInThePrintingMachineException, NotPossiblePrinting {
        if (isPrintingPossible(printingMachine, printMedia, times)) {
            addPrintMedia(printMedia, times);
            return printingMachineService.print(printMedia, times);
        } else {
            throw new NotPossiblePrinting(printingMachine, printMedia);
        }
    }

    public boolean isPrintingPossible(PrintingMachine printingMachine, PrintMedia printMedia, int times) throws NoSuchMachineInTheFactoryException, NoSuitableMachineSelectedException, NoEnoughPaperInThePrintingMachineException {
        //check if the machine exists in this printing house
        if (!isMachineAvailable(printingMachine, printMedia)) {
            throw new NoSuchMachineInTheFactoryException(printingMachine);
        }
        //check if the machine can print colored
        else if (!isMachineSuitable(printingMachine, printMedia)) {
            throw new NoSuitableMachineSelectedException(printingMachine);
        }
        else if (!printingMachineService.hasEnoughPages(printingMachine, printMedia, times)) {
            int totalPages = printMedia.getPagesNumber() * times;
            throw new NoEnoughPaperInThePrintingMachineException(totalPages, printingMachine.getAvailablePages());
        } else {
            return true;
        }
    }

    public boolean isMachineAvailable(PrintingMachine printingMachine, PrintMedia printMedia) {
        if (printingHouse.getPrintingMachines().contains(printingMachine)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isMachineSuitable(PrintingMachine printingMachine, PrintMedia printMedia) throws NoSuitableMachineSelectedException {
        if (!printingMachine.isColored() && printMedia.isColored()) {
            return false;
        }
        return true;
    }


    public void addPrintMedia(PrintMedia printMedia, int times) {
        if (printingHouse.getPrintedMedias().containsKey(printMedia)) {
            printingHouse.getPrintedMedias().put(printMedia, printingHouse.getPrintedMedias().get(printMedia) + times);
        } else {
            printingHouse.getPrintedMedias().put(printMedia, times);
        }
    }




    public void writePrintMediaInFile(String outputFilename) {
        try (FileWriter fout = new FileWriter(new File(outputFilename), false)) {
            printingHouse.getPrintedMedias().entrySet().stream()
                    .filter(entry -> entry.getKey() != null)
                    .forEach(entry -> {
                        try {
                            fout.append(entry.getKey().toString() + " " + entry.getValue() + " times" + System.lineSeparator());
                        } catch (IOException e) {
                            System.out.println("IOException: " + e);
                        }
                    });
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
    }


    public void writeDataInFile(String outputFilename){
        writePrintMediaInFile(outputFilename);
        writeFinancyInFile(outputFilename);
    }

    public void writeFinancyInFile(String outputFilename){
        try (FileWriter fout = new FileWriter(new File(outputFilename), true);){
            fout.append("Total expenses: " + totalExpenses() + System.lineSeparator());
            fout.append("Total income: " + totalIncome() + System.lineSeparator());
            fout.append("Profit: " + netIncome() + System.lineSeparator());
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e);
        } catch (IOException e) {
            System.out.println("IOException " + e);
        }
    }

    // Task 2
    public List<String> readDataFromFile(String inputFilename) {
        List<String> text = new ArrayList<>();
        try (FileReader fis = new FileReader(new File(inputFilename))) {
            BufferedReader bufferedReader = new BufferedReader(fis);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                text.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}


//    public BigDecimal getSalary(Map.Entry<Employee, BigDecimal> employee){
//        return employee.getValue();
//    }

//    public Employee getEmployee(Map.Entry<Employee, BigDecimal> employee){
//        return employee.getKey();
//    }

//    public PrintMedia getMedia(Map.Entry<PrintMedia, Integer> media){
//        return media.getKey();
//    }

//    public int getTimes(Map.Entry<PrintMedia, Integer> media){
//        return media.getValue();
//    }
