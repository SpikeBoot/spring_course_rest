package org.spikeboot.spring.rest.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.spikeboot.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    SessionFactory sessionFactory;

    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(id);
    }

    @Override
    public List<Employee> getAllEmployee() {
        Session session = sessionFactory.getCurrentSession();
        String query = "from Employee";
        List<Employee> employeeList = session.createQuery(query).getResultList();
        return employeeList;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
