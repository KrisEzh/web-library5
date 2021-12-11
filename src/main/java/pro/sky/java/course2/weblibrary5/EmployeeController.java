package pro.sky.java.course2.weblibrary5;

import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("firstName") String firstName , @RequestParam("lastName") String lastName){
        return "Сотрудник добавлен : " + employeeService.add(firstName,lastName);
    }
    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        return "Сотрудник удален : " + employeeService.remove(firstName,lastName);
    }
    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        return "Сотрудник найден : " + employeeService.findEmployee(firstName,lastName);
    }
    @GetMapping(path = "/get")
    public Set<String> getEmployees(){
        return employeeService.getEmployees();
    }
}
