package printingHouse;

import employees.Employee;
import employees.EmployeeType;
import exception.NoEnoughPaperInThePrintingMachineException;
import exception.NoSuchMachineInTheFactoryException;
import exception.NoSuitableMachineSelectedException;
import exception.NotPossiblePrinting;
import machines.PrintingMachine;
import machines.PrintingMachineServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pages.PageSize;
import pages.PageType;
import printMedia.MediaType;
import printMedia.PrintMedia;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PrintingHouseServiceImpTest {
    private PrintingHouse pr;
    private PrintingHouseServiceImp printingHouseServiceImp;

    PrintingHouse printingHouse;
    PrintingHouseServiceImp houseService;
    PrintingMachineServiceImp machineService;
    PrintMedia printMedia1;
    PrintingMachine printingMachine;
    Map<PrintMedia, Integer> medias;

    @BeforeEach
    void init() {
        printingHouse = new PrintingHouse("PH1", BigDecimal.valueOf(1000), BigDecimal.valueOf(10), BigDecimal.valueOf(2000), 300, BigDecimal.valueOf(3), BigDecimal.valueOf(20));
//        basicEmployeeSalary 1000
//        percentageOverprice 10
//        expectedIncome 2000
//        numberForDiscount 300
//        percentageDiscount 3
//        percentageSalaryAddition 20
//        totalPercentage  10-3
        machineService = new PrintingMachineServiceImp();
        houseService = new PrintingHouseServiceImp(printingHouse, machineService);
        printingMachine = new PrintingMachine(1000, 401, false, 50);
        printMedia1 = new PrintMedia("pr1", MediaType.NEWSPAPER, 20, PageType.NEWSPAPER_PAPER, PageSize.A2, false);
        medias = new HashMap<>();
    }

//    @Mock
//    PrintingHouseServiceImp service;
//
//    @Mock
//    PrintingHouse printingHouse;
//    PrintingMachineService printingMachineService;
//


    @Test
    void testPriceForBatch() {
        PrintMedia printMedia1 = new PrintMedia("pr1", MediaType.NEWSPAPER, 20, PageType.NEWSPAPER_PAPER, PageSize.A2, true);
        //0.8*4*20 = 64

        BigDecimal priceForOne = printMedia1.priceForPrinting();
        BigDecimal expected = new BigDecimal(320).setScale(1);
        BigDecimal actual = houseService.priceForBatch(printMedia1, 5, priceForOne); //64*5 = 320

        assertEquals(expected, actual);
    }

    @Test
    void testIncomeFromMediaAndTimes() {

        //0.8*4*20 = 64 * 5% = 67.2*3 = 201.6
        BigDecimal expected = BigDecimal.valueOf(201.6).setScale(3);
        BigDecimal actual = houseService.incomeFromMediaAndTimes(printMedia1, 3, BigDecimal.valueOf(5));

        assertEquals(expected, actual);
    }

    @Test
    void calcDiscountPercentageNoDiscount() {
        assertEquals(BigDecimal.ZERO, houseService.calcDiscountPercentage(10));
    }

    @Test
    void calcDiscountPercentageWithDiscount() {
        BigDecimal expected = printingHouse.getPercentageDiscount();
        BigDecimal actual = houseService.calcDiscountPercentage(301);

        assertEquals(expected,actual);
    }

    @Test
    void testHasDiscount() {
        assertTrue(houseService.hasDiscount(301));
    }

    @Test
    void testDoesNotHaveDiscount() {
        assertFalse(houseService.hasDiscount(10));
    }

    @Test
    void priceForOnePiece() {
        //64*5% = 67.2
        BigDecimal expected = BigDecimal.valueOf(67.2).setScale(3);
        BigDecimal actual = houseService.priceForOnePiece(printMedia1, BigDecimal.valueOf(5));

        assertEquals(expected, actual);
    }

    @Test
    void totalPercentage() {
        BigDecimal expected = BigDecimal.valueOf(7);
        BigDecimal actual = houseService.totalPercentage(BigDecimal.valueOf(3));

        assertEquals(expected, actual);
    }

    @Test
    void netIncome() {
        medias.put(printMedia1, 20);
        printingHouse.setPrintedMedias(medias);
//        total income -> 64*10% * 20 = 1408
        //expenses -> 64*20 = 1280
        BigDecimal expected = BigDecimal.valueOf(128).setScale(2);
        BigDecimal actual = houseService.netIncome();

        assertEquals(expected, actual);
    }

    @Test
    void printPublications() throws NoEnoughPaperInThePrintingMachineException, NoSuchMachineInTheFactoryException, NotPossiblePrinting, NoSuitableMachineSelectedException {
        medias.put(printMedia1, 20);
        List<PrintingMachine> machines = new ArrayList<>();
        machines.add(printingMachine);

        PrintingHouse house = new PrintingHouse(null, machines, null);
        PrintingHouseServiceImp service = new PrintingHouseServiceImp(house, machineService);

        service.printPublications(printingMachine, printMedia1, 20);

        assertEquals(medias, house.getPrintedMedias());
    }

    @Test
    void printPublicationsExceptionNoSuitableMachine() {
        List<PrintingMachine> machines = new ArrayList<>();
        machines.add(printingMachine);

        PrintingHouse house = new PrintingHouse(null, machines, null);
        PrintingHouseServiceImp service = new PrintingHouseServiceImp(house, machineService);


        PrintMedia printMedia2 =  new PrintMedia("pr1", MediaType.NEWSPAPER, 20, PageType.NEWSPAPER_PAPER, PageSize.A2, true);
        assertThrows(NoSuitableMachineSelectedException.class, ()-> service.isPrintingPossible(printingMachine, printMedia2, 20));
    }

    @Test
    void printPublicationsExceptionNoEnoughPaper(){
        List<PrintingMachine> machines = new ArrayList<>();
        machines.add(printingMachine);

        PrintingHouse house = new PrintingHouse(null, machines, null);
        PrintingHouseServiceImp service = new PrintingHouseServiceImp(house, machineService);

        assertThrows(NoEnoughPaperInThePrintingMachineException.class, ()-> service.isPrintingPossible(printingMachine, printMedia1, 110));
    }

    @Test
    void testPriningIsPossible() throws NoEnoughPaperInThePrintingMachineException, NoSuchMachineInTheFactoryException, NoSuitableMachineSelectedException {
        List<PrintingMachine> machines = new ArrayList<>();
        machines.add(printingMachine);

        PrintingHouse house = new PrintingHouse(null, machines, null);
        PrintingHouseServiceImp service = new PrintingHouseServiceImp(house, machineService);

        assertTrue(service.isPrintingPossible(printingMachine, printMedia1, 10));
    }

    @Test
    void printPublicationsExceptionNoSuchMachine() {
        assertThrows(NoSuchMachineInTheFactoryException.class, ()-> houseService.isPrintingPossible(printingMachine, printMedia1, 20));
    }


    @Test
    void isMachineAvailableYes() {
        List<PrintingMachine> machines = new ArrayList<>();
        machines.add(printingMachine);

        PrintingHouse house = new PrintingHouse(null, machines, null);
        PrintingHouseServiceImp service = new PrintingHouseServiceImp(house, machineService);


        PrintMedia printMedia2 =  new PrintMedia("pr1", MediaType.NEWSPAPER, 20, PageType.NEWSPAPER_PAPER, PageSize.A2, true);
        assertTrue(service.isMachineAvailable(printingMachine, printMedia2));
    }

    @Test
    void isMachineAvailableNo() {
        assertFalse(houseService.isMachineAvailable(printingMachine, printMedia1));
    }

    @Test
    void isMachineSuitableNo() throws NoSuitableMachineSelectedException {
        List<PrintingMachine> machines = new ArrayList<>();
        machines.add(printingMachine);

        PrintingHouse house = new PrintingHouse(null, machines, null);
        PrintingHouseServiceImp service = new PrintingHouseServiceImp(house, machineService);


        PrintMedia printMedia2 =  new PrintMedia("pr1", MediaType.NEWSPAPER, 20, PageType.NEWSPAPER_PAPER, PageSize.A2, true);
        assertFalse(service.isMachineSuitable(printingMachine, printMedia2));
    }

    @Test
    void isMachineSuitableYes() throws NoSuitableMachineSelectedException {
        List<PrintingMachine> machines = new ArrayList<>();
        machines.add(printingMachine);

        PrintingHouse house = new PrintingHouse(null, machines, null);
        PrintingHouseServiceImp service = new PrintingHouseServiceImp(house, machineService);

        assertTrue(service.isMachineSuitable(printingMachine, printMedia1));
    }

    @Test
    void testSalaryExpenses() {
        Map<Employee, BigDecimal> employees = new HashMap<>();
        Employee employee1 = new Employee("John", EmployeeType.MACHINE_OPERATOR);
        Employee employee2 = new Employee("Alice", EmployeeType.MACHINE_OPERATOR);
        Employee employee3 = new Employee("Bob", EmployeeType.MACHINE_OPERATOR);
        employees.put(employee1, BigDecimal.valueOf(1000));
        employees.put(employee2, BigDecimal.valueOf(1500));
        employees.put(employee3, BigDecimal.valueOf(2000));
        pr = new PrintingHouse(null, null, employees);
        houseService = new PrintingHouseServiceImp(pr, new PrintingMachineServiceImp());

        // Act
        BigDecimal result = houseService.salaryExpenses();

        // Assert
        BigDecimal expectedTotal = BigDecimal.valueOf(4500);
        assertEquals(expectedTotal, result);
    }


//   @Test
//    void priceForBatch() {
//        Map<PrintMedia, Integer> medias = new HashMap<>();
//        PrintMedia printMedia1 = new PrintMedia("pr1", MediaType.NEWSPAPER, 20, PageType.NEWSPAPER_PAPER, PageSize.A2, true);
//        //0.8*4*20 = 64
//        PrintMedia printMedia2 = new PrintMedia("pr2", MediaType.BOOK, 10, PageType.PLAIN_PAPER, PageSize.A4, true);
//        //0.5*2*10 = 10
//
//
//        medias.put(printMedia1, 5); //64*5 = 320
//        medias.put(printMedia2, 10); //11*10 = 110
//
//        printingHouse.setPrintedMedias(medias);
//
//        BigDecimal expected = new BigDecimal("320.0");
//        BigDecimal actual = houseService.priceForBatch(printMedia1, 5);
//
//        assertEquals(expected, actual);
//    }
//    @Test
//    void testPaperExpenses(){
//        PrintingHouse printingHouse = mock(PrintingHouse.class);
//        PrintingHouseServiceImp service = new PrintingHouseServiceImp();
//        service.setPrintingHouse(printingHouse);
//
//        Map<PrintMedia, Integer> printedMedias = new HashMap<>();
//        PrintMedia media1 = mock(PrintMedia.class);
//        PrintMedia media2 = mock(PrintMedia.class);
//        printedMedias.put(media1, 5);
//        printedMedias.put(media2, 3);
//        when(printingHouse.getPrintedMedias()).thenReturn(printedMedias);
//
//        BigDecimal media1Price = BigDecimal.valueOf(10);
//        BigDecimal media2Price = BigDecimal.valueOf(15);
//
//        when(media1.priceForPrinting()).thenReturn(BigDecimal.valueOf(2));
//        when(media2.priceForPrinting()).thenReturn(BigDecimal.valueOf(5));
//
//        when(service.priceForBatch(media1, 5, BigDecimal.valueOf(2))).thenReturn(media1Price);
//        when(service.priceForBatch(media2, 3, BigDecimal.valueOf(5))).thenReturn(media2Price);
//
//        BigDecimal result = service.paperExpenses();
//
//        BigDecimal expectedTotal = BigDecimal.valueOf(95);
//        assertEquals(expectedTotal, result);
//    }

//////////////////////////////////////////////////////////
//    @Test
//    void testTotalExpenses() {
//        PrintingHouseServiceImp spyService = spy(service);
//        printingHouse = mock(PrintingHouse.class);
////        service = mock(PrintingHouseServiceImp.class);
//        PrintMedia printMedia1 = mock(PrintMedia.class);
//        PrintMedia printMedia2 = mock(PrintMedia.class);
//
//        Map<PrintMedia, Integer> medias = new HashMap<>();
//        medias.put(printMedia1, 10);
//        medias.put(printMedia2, 20);
//
//        when(printingHouse.getPrintedMedias()).thenReturn(medias);
//
//        when(spyService.priceForBatch(printMedia1,10)).thenReturn(BigDecimal.valueOf(10)).thenReturn(BigDecimal.valueOf(20));
//
//        when(service.paperExpenses()).thenReturn(BigDecimal.valueOf(10));
//        when(service.salaryExpenses()).thenReturn(BigDecimal.valueOf(40));
//        BigDecimal result = service.totalExpenses();
//        assertEquals(BigDecimal.valueOf(50), result);
//    }

//    @Test
//    void testSalaryExpenses(){
//        Employee employee1 = mock(Employee.class);
//        Employee employee2 = mock(Employee.class);
//        Employee employee3 = mock(Employee.class);
//        printingHouse = mock(PrintingHouse.class);
//
//        Map<Employee, BigDecimal> employees = new HashMap<>();
//        employees.put(employee1, BigDecimal.valueOf(1000));
//        employees.put(employee2, BigDecimal.valueOf(2500));
//        employees.put(employee3, BigDecimal.valueOf(1500));
//
//        // Mocking the addBonus() method
//        PrintingHouseServiceImp spyPrintingHouse = spy(service);
//        when(printingHouse.getEmployees()).thenReturn(employees);
//        doNothing().when(spyPrintingHouse).addBonus();
//
//        // Act
//        BigDecimal result = service.salaryExpenses();
//
//        // Assert
//        assertEquals(new BigDecimal("4500.00"), result);
//        verify(spyPrintingHouse, times(1)).addBonus();
//    }
}