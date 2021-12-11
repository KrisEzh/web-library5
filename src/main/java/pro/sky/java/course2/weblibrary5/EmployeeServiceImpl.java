package pro.sky.java.course2.weblibrary5;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    Set<String> employees;

    public EmployeeServiceImpl() {
        employees = new HashSet<>();
    }

    @Override
    public Set<String> getEmployees() {
        return employees;
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        return add(newEmployee);
    }
    @Override
    public Employee add(Employee employee) {
        if(!employees.add(String.valueOf(employee))) {
            throw new EmployeeExistsException();
        }
       return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
            return remove(newEmployee);
    }

    @Override
    public Employee remove(Employee employee) {
        if (!employees.remove(String.valueOf(employee))) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(String.valueOf(employee))) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }
}

