package org.spikeboot.spring.rest.dao;

import org.spikeboot.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int id);

    public void deleteEmployee(int id);

    public List<Employee> getAllEmployee();


}
