package pro.sky.java.course2.weblibrary5;


import java.util.Set;

public interface EmployeeService {

    Set<String> getEmployees();

    Employee add(String firstName, String lastName);

    Employee add(Employee employee);

    Employee remove(String firstName, String lastName);

    Employee remove(Employee employee);

    Employee findEmployee(String firstName, String lastName);
}