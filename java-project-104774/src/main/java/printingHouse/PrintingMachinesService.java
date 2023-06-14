package printingHouse;

import machines.PrintingMachine;

//TODO promeni imeto
public interface PrintingMachinesService {
    boolean addMachine(PrintingMachine printingMachine);
    void removeMachine(PrintingMachine printingMachine);
}
