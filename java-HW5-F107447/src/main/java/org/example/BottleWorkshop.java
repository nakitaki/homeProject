package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BottleWorkshop {
    private List<Bottle> listOfEmptyBottles;
    private List<Bottle> listOfFullBottles;

    public BottleWorkshop() {
        this.listOfEmptyBottles = null;
        this.listOfFullBottles = null;
    }

    public BottleWorkshop(List<Bottle> listOfEmptyBottles, List<Bottle> listOfFullBottles) {
        this.listOfEmptyBottles = listOfEmptyBottles;
        this.listOfFullBottles = listOfFullBottles;
    }

    public boolean addEmptyBottle(Bottle bottle){
            return this.listOfEmptyBottles.add(bottle);
    }

    public boolean fillEmptyBottle(Bottle bottle){
        if (this.listOfEmptyBottles.contains(bottle)){
            this.listOfEmptyBottles.remove(bottle);
            return this.listOfFullBottles.add(bottle);
        }
        else {
            throw new NoSuchTypeOfBottleException();
        }
    }

    public boolean sellBottle(Bottle bottle, Invoice invoice, String filename){
        if(this.listOfFullBottles.contains(bottle)){
            this.listOfEmptyBottles.remove(bottle);
            try(FileWriter fout = new FileWriter(new File(filename), true)){
                if(invoice!=null){
                    fout.append(invoice.toString() + System.lineSeparator());
                    return true;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            throw new NoAvailableBottleException();
        }
        return false;
    }


}
