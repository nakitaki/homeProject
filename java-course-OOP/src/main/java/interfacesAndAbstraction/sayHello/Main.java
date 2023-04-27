package interfacesAndAbstraction.sayHello;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        persons.add(new Bulgarian("Ivan"));
        persons.add(new American("Peter"));
        persons.add(new Spanish("Joan"));

        
        for(Person person: persons){
            print(person);
        }
    }

    private static void print(Person person){
        System.out.println(person.sayHello());
    }
}