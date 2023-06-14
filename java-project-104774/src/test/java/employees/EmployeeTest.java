package employees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void isManager() {
        Employee employee = new Employee("Ivan", EmployeeType.MANAGER);
        assertTrue(employee.isManager());
    }

    @Test
    void isNotManager() {
        Employee employee = new Employee("Ivan", EmployeeType.MACHINE_OPERATOR);
        assertFalse(employee.isManager());
    }
}