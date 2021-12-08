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
    public boolean add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        return employees.add(String.valueOf(employee));
    }

    @Override
    public boolean remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        return employees.remove(String.valueOf(employee));
    }

    @Override
    public boolean findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {

        } return true;
    }
}
