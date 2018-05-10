package com.github.yakovlevs.hbrnt.persistent.repository;

import com.github.yakovlevs.hbrnt.persistent.domain.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {
  @Autowired
  private EntityManagerFactory mysqlEntityManagerFactory;

  private EntityManager getEntityManager() {
    return mysqlEntityManagerFactory.createEntityManager();
  }

  @SuppressWarnings("unchecked")
  public List<Employee> getRangeOfEmployees(int first, int max) {
    Query query = getEntityManager().createQuery("from Employee");
    query.setFirstResult(first);
    query.setMaxResults(max);
    return query.getResultList();
  }

  public Employee getById(Long id) {
    return getEntityManager().find(Employee.class, id);
  }

  public long getTotalPages(int pageSize) {
    Query queryTotal = getEntityManager().createQuery
            ("SELECT count(e.id) FROM Employee AS e");
    long countResult = (long) queryTotal.getSingleResult();

    if (countResult % pageSize > 0) {
      return countResult / pageSize + 1;
    } else {
      return countResult / pageSize;
    }
  }

  @SuppressWarnings("unchecked")
  public List<Employee> getPageOfEmployee(int pageNumber, int pageSize) {
    Query query = getEntityManager().createQuery("from Employee");
    query.setFirstResult(pageNumber * pageSize);
    query.setMaxResults(pageSize);
    return query.getResultList();
  }
}
