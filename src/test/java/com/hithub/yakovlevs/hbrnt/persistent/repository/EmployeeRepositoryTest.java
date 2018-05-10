package com.hithub.yakovlevs.hbrnt.persistent.repository;

import com.github.yakovlevs.hbrnt.configs.DatabaseConfig;
import com.github.yakovlevs.hbrnt.persistent.repository.EmployeeRepository;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(DatabaseConfig.class)
@AutoConfigureTestDatabase(replace = NONE)
public class EmployeeRepositoryTest {

  @Autowired
  private SessionFactory _sessionFactory;

  @Autowired
  private EmployeeRepository _empEmployeeRepository;

  @Test
  public void getById() throws Exception {
  }

}