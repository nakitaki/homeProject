package e07_Generics.basicExamples.restaurant;

public class Restaurant {
    //generic method - restriction of types -> now we are sure we will serve food and drink
    public <F extends Food, D extends Drink> String servingLunch(F f, D d){
        return "You ordered " + f + " and " + d;
    }

}
