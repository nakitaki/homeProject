package e06_SOLID.food;

import java.util.List;

public class Restaurant {
    private double maxMinutes;
    private List<Dish> dishList;

    public double totalIncomeByDelivery(){
        double sum = 0;
        for(Dish dish : this.dishList){
            if(dish.delivery(this.maxMinutes, 10)){
                sum+=dish.getPrice();
            }
        }
        return sum;
    }
}
