package pro.sky.management.service;

import org.springframework.stereotype.Service;
import pro.sky.management.exception.EmployeeAlreadyAddedException;
import pro.sky.management.exception.EmployeeNotFoundException;
import pro.sky.management.exception.EmployeeStorageIsFullException;
import pro.sky.management.model.Employee;

@Service
public class EmployeeService {
    private static final int SIZE = 3;
    private final Employee[] employees = new Employee[SIZE];

    public Employee add(String firstName, String lastName) {
        int indexForAdding = -1;
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null && indexForAdding == -1) {
                indexForAdding = i;
            }
            if (employees[i] != null && employees[i].equals(employee)) {
                throw new EmployeeAlreadyAddedException();
            }
        }
        if (indexForAdding == -1) {
            throw new EmployeeStorageIsFullException();
        }
        employees[indexForAdding] = employee;
        return employees[indexForAdding];
    }

    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (Employee emp : employees) {
            if (employee.equals(emp)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.length; i++) {
            employees[i] = null;
            return employee;
        }
        throw new EmployeeNotFoundException();
    }
}