package interfacesAndAbstraction.sayHello;

public class American extends BasePerson {
    public American(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}

