package pro.sky.java.course2.weblibrary5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.weblibrary5.EmployeeServiceConstants.*;


public class EmployeeServiceTest {
    private final EmployeeService out = new EmployeeServiceImpl();
    private Employee employee = new Employee("Иван", "Иванов", 1, 10);
    private Employee employee1 = new Employee("Петр", "Петров", 2, 20);
    private Employee employee2 = new Employee("Сидр", "Сидоров", 3, 30);
    @BeforeEach
    public void setUp(){
        Employee employee = new Employee(FIRST_NAME, LAST_NAME, DEPARTMENT_NUM, SALARY);
        Employee employee1 = new Employee(FIRST_NAME1, LAST_NAME1, DEPARTMENT_NUM1, SALARY1);
        Employee employee2 = new Employee(FIRST_NAME2, LAST_NAME2, DEPARTMENT_NUM2, SALARY2);

        out.add(employee);
        out.add(employee1);
        out.add(employee2);
    }

    @Test
    public void addEmployee() throws EmployeeExistsException {
        Employee employee = new Employee(FIRST_NAME, LAST_NAME, DEPARTMENT_NUM, SALARY);
        Employee employee1 = new Employee(FIRST_NAME1, LAST_NAME1, DEPARTMENT_NUM1, SALARY1);
        Employee employee2 = new Employee(FIRST_NAME2, LAST_NAME2, DEPARTMENT_NUM2, SALARY2);

        Collection<Employee>expected = new ArrayList<>(out.getEmployees());
        Collection<Employee>actual = new ArrayList<>();
        actual.add(employee);
        actual.add(employee1);
        actual.add(employee2);

        assertTrue(actual.size()==expected.size() && actual.containsAll(expected) && expected.containsAll(actual));

    }

    @Test
    public void getEmployees(){
        Collection<Employee> expected = out.getEmployees();
        Collection<Employee>actual = new ArrayList<>();
        actual.add(employee);
        actual.add(employee1);
        actual.add(employee2);
        assertTrue(actual.size()==expected.size() && actual.containsAll(expected) && expected.containsAll(actual));
    }
    @Test
    public void getEmployeesNotNull(){
        Collection<Employee>expected = out.getEmployees();
        assertNotNull(expected);
    }
    @Test
    public void findEmployee(){
        Employee expected = (Employee) out.findEmployee(employee.getFirstName(),employee.getLastName());
        assertEquals(expected, out.findEmployee(employee.getFirstName(), expected.getLastName()));
    }
    @Test
    public void removeEmployee(){
        Employee employee = new Employee(FIRST_NAME, LAST_NAME, DEPARTMENT_NUM, SALARY);
        Employee employee1 = new Employee(FIRST_NAME1, LAST_NAME1, DEPARTMENT_NUM1, SALARY1);
        Employee employee2 = new Employee(FIRST_NAME2, LAST_NAME2, DEPARTMENT_NUM2, SALARY2);

        Collection<Employee>expected = new ArrayList<>(out.getEmployees().size()-1);
        Collection<Employee>actual = new ArrayList<>();
        actual.remove(employee);
        actual.remove(employee1);
        actual.remove(employee2);

        assertTrue(actual.size()==expected.size() && actual.containsAll(expected) && expected.containsAll(actual));
    }
    @Test
    public void EmployeeExistsException() throws EmployeeExistsException {
        assertThrows(EmployeeExistsException.class, () -> out.add(employee));
    }

    @Test
    public void EmployeeNotFoundException() throws EmployeeNotFoundException{
        Employee employee3 = new Employee("Вася", "Васечкин", 1,10);
        assertThrows(EmployeeNotFoundException.class, () -> out.remove(employee3));
    }
}
