package org.spikeboot.spring.rest.service;

import org.spikeboot.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);

    public List<Employee> getAllEmployee();
}
