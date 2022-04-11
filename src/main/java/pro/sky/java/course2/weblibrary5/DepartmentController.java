package pro.sky.java.course2.weblibrary5;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentServiceImpl departmentService;
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = (DepartmentServiceImpl) departmentService;
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> getEmployeesByDepartmentNum() {
        return departmentService.getEmployeesByDepartmentNum();
    }
    @GetMapping(path = "/max-salary")
    public String getMaxSalary(@RequestParam("departmentId") Integer departmentNum) {
        return "Сотрудник с максимальной зарплатой по отделу найден : " + departmentService.getMaxSalary(departmentNum);
    }
    @GetMapping(path = "/min-salary")
    public String getMinSalary(@RequestParam("departmentId") Integer departmentNum) {
        return "Сотрудник с минимальной зарплатой по отделу найден : " + departmentService.getMinSalary(departmentNum);
    }
     @GetMapping(value = "/all", params = {"departmentId"})
     public Collection<Employee> getEmployeesFor(@RequestParam("departmentId") Integer departmentNum) {
        return departmentService.getEmployeesFor(departmentNum);
    }
}
