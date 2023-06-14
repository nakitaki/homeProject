package printingHouse;

public interface PrintingHouseService extends PrintingMachinesService, FinanceService, EmployeeService {
    void historyOfPrinting();
}
