package employees;

import java.math.BigDecimal;
import java.util.Comparator;

public class Employee implements Employable, Comparable<Employee> {
    private static long employeeNumber = 0;
    private String name;
    private final long id;
    private EmployeeType employeeType;

    public Employee(String name, EmployeeType employeeType) {
        this.name = name;
        this.employeeType = employeeType;
        this.id = ++employeeNumber;
    }


    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public boolean isManager(){
        return employeeType.equals(EmployeeType.MANAGER);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", employeeType=" + employeeType +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return Long.compare(this.getId(), o.getId());
    }
}
