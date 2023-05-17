package e10_Reflection.ex1;

public class Student extends Person implements Register{
    private String fNumber;

    public Student() {
    }

    public Student(String name, int age, String fNumber) {
        super(name, age);
        this.fNumber = fNumber;
    }

    public String getfNumber() {
        return fNumber;
    }

    public void setfNumber(String fNumber) {
        this.fNumber = fNumber;
    }

    private String privateMessage(){
        return "Private message!";
    }

    private String privateMessageWithParam(String message){
        return message;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fNumber='" + fNumber + '\'' +
                "} " + super.toString();
    }

    @Deprecated
    @Override
    public void register() {
        System.out.println("Registered");
    }
}
