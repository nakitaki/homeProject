package e08_Collection.Set.EnumSet;

import java.util.EnumSet;

public class Main {
    public static void main(String[] args) {
        EnumSet<Fruit> enumSet1, enumSet2, enumSet3, enumSet4;
        enumSet1 = EnumSet.of(Fruit.APPLE, Fruit.PEAR);
        enumSet2 = EnumSet.complementOf(enumSet1); //everything which is not is EnumSet1
        enumSet3 = EnumSet.allOf(Fruit.class); //everything in the enum
        enumSet4 = EnumSet.range(Fruit.APPLE, Fruit.CHERRY); //from apple to cherry
        System.out.println("Set 1: " + enumSet1);
        System.out.println("Set 2: " + enumSet2);
        System.out.println("Set 3: " + enumSet3);
        System.out.println("Set 4: " + enumSet4);
    }
}
