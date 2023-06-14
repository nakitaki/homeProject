import employees.Employee;
import employees.EmployeeType;
import exception.*;
import machines.PrintingMachine;
import machines.PrintingMachineService;
import machines.PrintingMachineServiceImp;
import pages.*;
import printMedia.*;
import printingHouse.PrintingHouse;
import printingHouse.PrintingHouseServiceImp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {

        PrintingHouse printingHouse = new PrintingHouse("Ciela", BigDecimal.valueOf(1300), BigDecimal.valueOf(100),
                BigDecimal.valueOf(10000), 20, BigDecimal.valueOf(0), BigDecimal.valueOf(10));

        PrintingMachineServiceImp machineService = new PrintingMachineServiceImp();
        PrintingHouseServiceImp service = new PrintingHouseServiceImp(printingHouse, machineService);

        printingHouse.setBasicEmployeeSalary(BigDecimal.valueOf(100));
        printingHouse.setPercentageSalaryAddition(BigDecimal.valueOf(100));

        //employees
        Employee employee1 = new Employee("Ivan", EmployeeType.MANAGER);
        Employee employee2 = new Employee("Daniela", EmployeeType.MANAGER);
        Employee employee5 = new Employee("Daniela", EmployeeType.MANAGER);
        Employee employee3 = new Employee("Peter", EmployeeType.MACHINE_OPERATOR);
        Employee employee4 = new Employee("Poter", EmployeeType.MACHINE_OPERATOR);


        service.addEmployee(employee3);
        service.addEmployee(employee2);
        service.addEmployee(employee1);
        service.addEmployee(employee4);
        service.addEmployee(employee5);
        System.out.println(printingHouse.getEmployees());
        System.out.println();

        service.removeEmployee(employee2);
        System.out.println(printingHouse.getEmployees());
        System.out.println();

        //machine
        PrintingMachine printingMachine1 = new PrintingMachine(800000, 709900, true, 20);
        PrintingMachine printingMachine2 = new PrintingMachine(500, 500, false,26);
        PrintingMachine printingMachine3 = new PrintingMachine(100, 50, true,26);

        service.addMachine(printingMachine1);
        service.addMachine(printingMachine2);
        service.addMachine(printingMachine3);
        System.out.println(printingHouse.getPrintingMachines());

        service.removeMachine(printingMachine2);
        System.out.println(printingHouse.getPrintingMachines());

        try {
            machineService.addPages(printingMachine1,10);
        } catch (ExceededPageCountException e) {
            throw new RuntimeException(e);
        }
        System.out.println();


        //media + print
        Paper paper1 = new Paper(PageSize.A3, PageType.PLAIN_PAPER);
        Paper paper2 = new Paper(PageSize.A1, PageType.GLOSSY_PAPER);
        Paper paper3 = new Paper(PageSize.A4, PageType.NEWSPAPER_PAPER);
        PrintMedia book1 = new PrintMedia("Magician of Oz", MediaType.BOOK, 20, paper1, false);
        PrintMedia poster1 = new PrintMedia("Imagine Dragons", MediaType.POSTER, 1, paper2, true);
        PrintMedia newspaper1 = new PrintMedia("24 chasa", MediaType.NEWSPAPER, 20, paper2, true);

        try {
//            System.out.println(printingHouse.printPublications(printingMachine1, book1, 10));
            service.printPublications(printingMachine1, book1, 100);
            service.printPublications(printingMachine1, newspaper1, 700);
            service.printPublications(printingMachine1, book1, 4);
            service.printPublications(printingMachine1, poster1, 30);

        } catch (NoSuchMachineInTheFactoryException | NoSuitableMachineSelectedException |
                 NoEnoughPaperInThePrintingMachineException | NotPossiblePrinting e) {
            throw new RuntimeException(e);
        }

//        service.historyOfPrinting();
//        System.out.println();

        //salary
//        System.out.println(service.paperExpenses());
        System.out.println("!!!!");
        System.out.println(service.getPrintingHouse().getEmployees());
//        System.out.println(service.salaryExpenses());
        System.out.println(service.salaryExpenses());

        System.out.println("!!!!");

//        System.out.println(Arrays.toString(service.getPrintingHouse().getEmployees().entrySet().stream()
//                .filter(service::isManager).toArray()));
//
//        Map<Employee, BigDecimal> employeesMap = service.getPrintingHouse().getEmployees().entrySet().stream()
//                .filter(service::isManager)
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(service.getPrintingHouse().getEmployees());
//        System.out.println(employeesMap);


//        System.out.println(Arrays.toString(service.getPrintingHouse().getEmployees().entrySet().stream().filter(service::isOperator).toArray()));


//        System.out.println(service.totalExpenses());
//
//        System.out.println(service.totalIncome());
//        System.out.println(service.netIncome());
//        System.out.println();
//        System.out.println("file");
//
        String filename = "PrintingMachineData.txt";
        service.writeDataInFile(filename);

        List<String> dataFromFile = new ArrayList<>(service.readDataFromFile(filename));
        for(String st: dataFromFile){
            System.out.println(st);
        }

        System.out.println(service.paperExpenses());

        System.out.println(service.totalIncome());



    }
}