package pro.sky.java.course2.weblibrary5;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Map<Integer , List<Employee>> getEmployeesByDepartmentNum();

    Employee getMaxSalary(int departmentNum);

    Employee getMinSalary(int departmentNum);

    Collection<Employee> getEmployeesFor(int departmentNum);
}
