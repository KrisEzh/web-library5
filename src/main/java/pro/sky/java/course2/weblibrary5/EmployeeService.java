package pro.sky.java.course2.weblibrary5;


import java.util.Set;

public interface EmployeeService {

    Set<String> getEmployees();

    boolean add(String firstName, String lastName);

    boolean remove(String firstName, String lastName) throws EmployeeNotFoundException;

    boolean findEmployee(String firstName, String lastName) throws EmployeeNotFoundException;
}