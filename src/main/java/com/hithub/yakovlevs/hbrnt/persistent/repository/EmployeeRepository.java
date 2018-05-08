package com.hithub.yakovlevs.hbrnt.persistent.repository;

import com.hithub.yakovlevs.hbrnt.persistent.domain.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {
  final
  private SessionFactory _sessionFactory;

  @Autowired
  public EmployeeRepository(SessionFactory _sessionFactory) {
    this._sessionFactory = _sessionFactory;
  }

  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  @SuppressWarnings("unchecked")
  public List<Employee> getAll() {
    return getSession().createQuery("from Employee").setFirstResult(900).setMaxResults(100).list();
  }

  public Employee getById(Long id) {
    return (Employee) getSession().load(Employee.class, id);
  }
}