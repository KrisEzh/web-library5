package pro.sky.java.course2.weblibrary5;

import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.util.*;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        employees = new HashMap<>();
    }

    Employee employee = new Employee("Иван", "Иванов", 1, 10);
    Employee employee1 = new Employee("Петр", "Петров", 2, 20);
    Employee employee2 = new Employee("Сидр", "Сидоров", 1, 30);


    @Override
    public Collection<Employee> getEmployees() {
        return employees.values();
    }

    @Override
    public Employee add(String firstName, String lastName) throws BadRequestException {
        if (!(StringUtils.isAlphaSpace(firstName) && StringUtils.isAlphaSpace(lastName))) {
        throw new BadRequestException();
    }
        Employee newEmployee = new Employee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName), 1, 10);
        return add(newEmployee);

    }

    @Override
    public Employee add(Employee employee) {
            if (employees.containsKey(employee.getFirstName() + employee.getLastName())) {
                throw new EmployeeExistsException();
            } else {
                employees.put(employee.getFirstName() + employee.getLastName(), employee);
                return employee;
            }
        }


    @Override
    public Employee remove(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName, 1, 10);
        return remove(newEmployee);
    }


    @Override
    public Employee remove(Employee employee) {
        if (employees.containsKey(employee.getFirstName() + employee.getLastName())) {
            employees.remove(employee.getFirstName() + employee.getLastName(), employee);
        } else {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }


    @Override
    public Object findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName, 1, 10);
        if (employees.containsKey(employee.getFirstName()+employee.getLastName())) {
            return employee;
        } else {
            return new EmployeeNotFoundException();
        }
    }


}

