package pro.sky.management.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.management.model.Employee;
import pro.sky.management.service.EmployeeService;

@RestController
    @RequestMapping("/employee")
    public class EmployeeController {
        private final EmployeeService employeeService;
        public EmployeeController(EmployeeService employeeService) {
            this.employeeService = employeeService;
    }
    @GetMapping("/add")
    public Employee add(@RequestParam String firstname, @RequestParam String lastName) {
       return employeeService.add(firstname, lastName);
    }
    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstname, @RequestParam String lastName) {
        return employeeService.add(firstname, lastName);
    }
    @GetMapping("/find")
    public Employee find(@RequestParam String firstname, @RequestParam String lastName) {
        return employeeService.add(firstname, lastName);
    }
}
