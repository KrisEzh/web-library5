package pro.sky.java.course2.weblibrary5;

import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeesByDepartmentNum(){
        return employeeService.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentNum));

    }

    @Override
    public Employee getMaxSalary(int departmentNum) {
       return employeeService.getEmployees().stream().
                filter(employee -> employee.getDepartmentNum()==(departmentNum))
                .max(Comparator.comparingInt(employee -> employee.getSalary()))
                .orElseThrow(()->new EmployeeNotFoundException());

    }
    @Override
    public  Employee getMinSalary(int departmentNum) {
       return employeeService.getEmployees().stream().
                filter(employee -> employee.getDepartmentNum()==(departmentNum))
                .min(Comparator.comparingInt(employee -> employee.getSalary()))
                .orElseThrow(()->new EmployeeNotFoundException());
    }
    @Override
    public Collection<Employee> getEmployeesFor(int departmentNum){
        return employeeService.getEmployees().stream().
                filter(employee->employee.getDepartmentNum()==(departmentNum))
                .collect(Collectors.toList());
    }
}
