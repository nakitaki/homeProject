package interfacesAndAbstraction.sayHello;

public class Spanish extends BasePerson {
    public Spanish(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hola";
    }
}
