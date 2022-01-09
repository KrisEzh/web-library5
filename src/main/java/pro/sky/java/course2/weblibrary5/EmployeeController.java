package pro.sky.java.course2.weblibrary5;

import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) throws FileNotFoundException {
        return "Сотрудник добавлен : " + employeeService.add(firstName, lastName);
    }

    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return "Сотрудник удален : " + employeeService.remove(firstName, lastName);
    }

    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return "Сотрудник найден : " + employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping(path = "/all")
    public Collection<Employee> getEmployees() {
        return employeeService.getEmployees();
    }


}
