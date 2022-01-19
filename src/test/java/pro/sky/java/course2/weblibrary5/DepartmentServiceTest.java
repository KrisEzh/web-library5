package pro.sky.java.course2.weblibrary5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static pro.sky.java.course2.weblibrary5.EmployeeServiceConstants.*;


@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
     private final EmployeeServiceImpl employeeServiceMock = mock(EmployeeServiceImpl.class);


    @BeforeEach
    public void initOut() {
        out = new DepartmentServiceImpl(employeeServiceMock);
    }

    @InjectMocks
    private DepartmentServiceImpl out;

    private Employee employee = new Employee("Иван", "Иванов", 1, 10);
    private Employee employee1 = new Employee("Петр", "Петров", 2, 20);
    private Employee employee2 = new Employee("Сидр", "Сидоров", 3, 30);

    public int MIN_SALARY = 10;
    public int MAX_SALARY = 30;
    public int CORRECT_DEPARTMENT = 1;

    @BeforeEach
    public void setUp(){
        Employee employee = new Employee(FIRST_NAME, LAST_NAME, DEPARTMENT_NUM, SALARY);
        Employee employee1 = new Employee(FIRST_NAME1, LAST_NAME1, DEPARTMENT_NUM1, SALARY1);
        Employee employee2 = new Employee(FIRST_NAME2, LAST_NAME2, DEPARTMENT_NUM2, SALARY2);


        employeeServiceMock.add(employee);
        employeeServiceMock.add(employee1);
         employeeServiceMock.add(employee2);

    }

    @Test
    public void getMaxSalaryTest() {
        when(out.getMaxSalary(CORRECT_DEPARTMENT)).thenReturn();
        assertEquals(MAX_SALARY, out.getMaxSalary(CORRECT_DEPARTMENT).getSalary());

    }
    @Test
    public void getMinSalary() {
        assertEquals(MIN_SALARY, out.getMinSalary(CORRECT_DEPARTMENT).getSalary());
    }
    @Test
    public void getEmployeesForTest(){
        Employee employee = new Employee("Иван", "Иванов", 1, 10);
        Collection<Employee> expected = out.getEmployeesFor(1);
        Collection<Employee> actual = new ArrayList<>();
        when(out.getEmployeesFor(1)).thenReturn(actual);
        employeeServiceMock.add(employee);
        assertEquals(actual,expected);
    }

    @Test
    public void employeeNotFoundExceptionTest(){
        when(employeeServiceMock.getEmployees()).thenThrow(EmployeeNotFoundException.class);
    }
}
