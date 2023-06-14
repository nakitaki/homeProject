package ex2;

public class Main {
    public static void main(String[] args) {
        //return int
        int ordinal = DayOfWeek.MONDAY.ordinal(); //0
        System.out.println(ordinal);

        DayOfWeek[] values = DayOfWeek.values();

        for(DayOfWeek value : values){
            System.out.println(value.getName());
        }

        
    }
}
