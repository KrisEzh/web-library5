package pro.sky.java.course2.weblibrary5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
    // private final EmployeeServiceImpl employeeServiceMock = mock(EmployeeServiceImpl.class);

    @Mock
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void initOut() {
        out = new DepartmentServiceImpl(employeeService);
    }

    @InjectMocks
    private DepartmentServiceImpl out;

    @BeforeEach
    public void setUp() {
        Employee employee = new Employee("Иван", "Иванов", 1, 10);
        Employee employee1 = new Employee("Петр", "Петров", 2, 20);
        Employee employee2 = new Employee("Сидр", "Сидоров", 3, 30);

        Collection<Employee> actual = new ArrayList<>();
        when(employeeService.getEmployees()).thenReturn(actual);
        actual.add(employee);
        actual.add(employee1);
        actual.add(employee2);

    }

    public int MIN_SALARY = 10;
    public int MAX_SALARY = 30;


    @Test
    public void getMaxSalaryTest() {
        assertEquals(MAX_SALARY, out.getMaxSalary(3).getSalary());

    }

    @Test
    public void getMinSalary() {
        assertEquals(MIN_SALARY, out.getMinSalary(1).getSalary());
    }

    @Test
    public void getEmployeesForTest() {
        Employee employee = new Employee("Иван", "Иванов", 1, 10);
        Collection<Employee> actual = new ArrayList<>();
        when(out.getEmployeesFor(1)).thenReturn(actual);
        actual.add(employee);
        assertEquals(employeeService.getEmployees(), out.getEmployeesFor(1));
    }

    @Test
    public void employeeNotFoundExceptionTest() {
        if (employeeService.getEmployees() == null) {
            when(employeeService.getEmployees()).thenThrow(EmployeeNotFoundException.class);

        }
    }
}
