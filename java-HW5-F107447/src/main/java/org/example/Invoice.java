package org.example;


import java.time.LocalDate;

public class Invoice {
    private static long invoiceID = 0;
    private Supplier supplier;
    private Recipient recipient;
    private LocalDate date;
    private int numberOfSoldBottles;
    private double PricePerBottle;
    private double turnover;

    public Invoice(Supplier supplier, Recipient recipient, LocalDate date, int numberOfSoldBottles, double pricePerBottle, double turnover) {
        this.supplier = supplier;
        this.recipient = recipient;
        this.date = date;
        this.numberOfSoldBottles = numberOfSoldBottles;
        PricePerBottle = pricePerBottle;
        this.turnover = turnover;
        invoiceID++;
    }

    public static long getInvoiceID() {
        return invoiceID;
    }

    public static void setInvoiceID(long invoiceID) {
        Invoice.invoiceID = invoiceID;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getNumberOfSoldBottles() {
        return numberOfSoldBottles;
    }

    public void setNumberOfSoldBottles(int numberOfSoldBottles) {
        this.numberOfSoldBottles = numberOfSoldBottles;
    }

    public double getPricePerBottle() {
        return PricePerBottle;
    }

    public void setPricePerBottle(double pricePerBottle) {
        PricePerBottle = pricePerBottle;
    }

    public double getTurnover() {
        return turnover;
    }

    public void setTurnover(double turnover) {
        this.turnover = turnover;
    }


    @Override
    public String toString() {
        return "Invoice{" +
                "supplier=" + supplier +
                ", recipient=" + recipient +
                ", date=" + date +
                ", numberOfSoldBottles=" + numberOfSoldBottles +
                ", PricePerBottle=" + PricePerBottle +
                ", turnover=" + turnover +
                '}';
    }
}
