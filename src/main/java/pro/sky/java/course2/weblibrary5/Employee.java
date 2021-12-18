package pro.sky.java.course2.weblibrary5;

import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;
    private int departmentNum;
    private int salary;


    public Employee(String firstName, String lastName, int departmentNum, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentNum = Integer.parseInt(String.valueOf(departmentNum));
        this.salary = Integer.parseInt(String.valueOf(salary));

    }

    public int getDepartmentNum() {
        return departmentNum;
    }

    public int getSalary() {
        return salary;
    }

    public  String getFirstName() {
        return firstName;
    }

    public  String getLastName() {
        return lastName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}


