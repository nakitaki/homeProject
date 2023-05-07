package e07_Generics.basicExamples.restaurant;

import e07_Generics.basicExamples.box.Box;

//introduction to Generics
public class Main {
    public static void main(String[] args) {


        //Box<Goods> -> corrects because Goods implements Weighed
        Goods goods = new Goods("Computer", 1000,.7);
        Box<Goods> box2 = new Box<Goods>(goods, .2);

        System.out.println(box2);

        Food food = new Food(true);
        Drink drink = new Drink(true);
        Restaurant restaurant = new Restaurant();

        System.out.println(restaurant.servingLunch(food, drink));
    }
}
