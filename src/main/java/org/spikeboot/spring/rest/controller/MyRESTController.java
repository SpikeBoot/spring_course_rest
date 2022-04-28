package org.spikeboot.spring.rest.controller;

import org.spikeboot.spring.rest.entity.Employee;
import org.spikeboot.spring.rest.exceptions.EmployeeIncorrectData;
import org.spikeboot.spring.rest.exceptions.NoSuchEmployeeException;
import org.spikeboot.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = employeeService.getAllEmployee();
        return employeeList;
    }


    /**
     * Used << /{id} >> this is PathVariable
     * Whom we can use in method`s body
     */

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);

        if (employee == null) {
            throw new NoSuchEmployeeException("There is no Employee with id = " + id);
        }

        return employee;
    }

    /**
     * @ExceptionHandler use for handle exception in REST-request where:
     * ResponseEntity<> - wrapper class for HTTP-response whom will be include (EmployeeIncorrectData) in this case
     * NoSuchEmployeeException - RunTimeException whom will be handle in this method
     * EmployeeIncorrectData - class whom will be transform to JSON
     */

    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handleException(NoSuchEmployeeException exception) {
        EmployeeIncorrectData employeeIncorrectData = new EmployeeIncorrectData();
        employeeIncorrectData.setInfo(exception.getMessage());

        return new ResponseEntity<>(employeeIncorrectData, HttpStatus.NOT_FOUND);
    }


    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
