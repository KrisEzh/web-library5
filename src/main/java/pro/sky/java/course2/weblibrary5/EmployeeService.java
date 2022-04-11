package pro.sky.java.course2.weblibrary5;


import java.io.FileNotFoundException;
import java.util.Collection;

public interface EmployeeService {


    Collection<Employee> getEmployees();

    Employee add(String firstName, String lastName) throws FileNotFoundException;

    Employee add(Employee employee);

    Employee remove(String firstName, String lastName);

    Employee remove(Employee employee);

    Object findEmployee(String firstName, String lastName);


}