package ex2;

import ex3.Seller;

import java.math.BigDecimal;

public class FlowerShop {
    private int flowers;
    private BigDecimal pricePerFlower;
    private Seller seller;
    private BigDecimal increaseSalaryAmount;

    public FlowerShop() {
        this.flowers = 0;
        this.pricePerFlower = BigDecimal.valueOf(0);
    }

    public FlowerShop(int flowers) {
        this.flowers = flowers;
        this.pricePerFlower = BigDecimal.valueOf(0);
    }

    public FlowerShop(BigDecimal pricePerFlower) {
        this.pricePerFlower = pricePerFlower;
        this.flowers = 0;
    }

    public FlowerShop(int flowers, BigDecimal pricePerFlower) {
        this.flowers = flowers;
        this.pricePerFlower = pricePerFlower;
    }

    public boolean increasePricePerFlower(BigDecimal price){
        if(price.compareTo(BigDecimal.ZERO) < 0){
            System.out.println("invalid");
            return false;
        }
        else{
            this.pricePerFlower = this.pricePerFlower.add(price);
            return true;
        }
    }
    public boolean decreasePricePerFlower(BigDecimal price){
        if(price.compareTo(BigDecimal.ZERO) < 0){
            System.out.println("invalid");
            return false;
        }
        else if(price.compareTo(this.pricePerFlower) <0){
            this.pricePerFlower = BigDecimal.ZERO;
        }
        else{
            this.pricePerFlower = this.pricePerFlower.subtract(price);
        }
        return true;
    }

    public boolean increaseFlowers(int flowers){
        if(flowers<=0){
            System.out.println("invalid");
            return false;
        }
        else{
            this.flowers+=flowers;
            return true;
        }
    }

    public boolean decreaseFlower(int flowers){
        if(flowers <= 0){
            System.out.println("invalid");
            return false;
        }
        else if(flowers>=this.flowers){
            this.flowers=0;
        }
        else{
            this.flowers-=flowers;
        }
        return true;
    }

    public BigDecimal profit(){
        return this.pricePerFlower.multiply(BigDecimal.valueOf(this.flowers));
    }

    public boolean hasBiggerTurnoverThan(FlowerShop flowerShop){
        return this.profit().compareTo(flowerShop.profit()) > 0;
    }

    public FlowerShop shopWithBiggerTurnover(FlowerShop flowerShop){
        if(this.profit().compareTo(flowerShop.profit()) > 0){
            return new FlowerShop(this.flowers, this.pricePerFlower);
        }
        return new FlowerShop(flowerShop.flowers, flowerShop.pricePerFlower);
    }

    public boolean increaseSellerSalary(){
        if(increaseSalaryAmount.compareTo(BigDecimal.ZERO)<=0){
            System.out.println("invalid");
            return false;
        }
        else{
            seller.setSalary(seller.getSalary().add(increaseSalaryAmount));
            return true;
        }

    }

    @Override
    public String toString() {
        return "FlowerShop{" +
                "flowers=" + flowers +
                ", pricePerFlower=" + pricePerFlower +
                '}';
    }
}
