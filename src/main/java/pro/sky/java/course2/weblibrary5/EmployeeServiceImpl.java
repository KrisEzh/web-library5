package pro.sky.java.course2.weblibrary5;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        employees = new HashMap<>();
    }

    @Override
    public Collection<Employee> getEmployees() {
        for (Employee employee : employees.values()) {
            System.out.println(employee);

        }

        return employees.values();
    }


    @Override
    public Employee add(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        return add(newEmployee);
    }

    @Override
    public Employee add(Employee employee) {
        employees.put(employee.getFirstName()+employee.getLastName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        return remove(newEmployee);
    }

    @Override
    public Employee remove(Employee employee) {
        employees.remove(employee.getFirstName()+employee.getLastName(), String.valueOf(employee));
        return employee;
    }

    @Override
    public Object findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFirstName()+employee.getLastName())) {
            return employee;
        } else {
            return new EmployeeNotFoundException();
        }
    }
}

