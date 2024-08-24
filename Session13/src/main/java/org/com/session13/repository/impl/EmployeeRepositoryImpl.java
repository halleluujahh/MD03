package org.com.session13.repository.impl;

import org.com.session13.model.Employee;
import org.com.session13.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Employee> findAll() {
        return em.createQuery("from Employee", Employee.class).getResultList();
    }

    @Override
    @Transactional
    public boolean save(Employee employee) {
        try{
            em.persist(employee);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
