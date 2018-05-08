package com.hithub.yakovlevs.hbrnt.persistent.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.text.DateFormat;
import java.util.Date;

@Entity
@Table(name = "employees")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee {
  @Id()
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "emp_no")
  private long id;

  @Column(name = "birth_date")
  private Date birthDate;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "gender")
  private String gender;

  @Column(name = "hire_date")
  private Date hireDate;

  public Employee() {
  }

  public Employee(Date birthDate, String firstName, String lastName, String gender, Date hireDate) {
    this.birthDate = birthDate;
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.hireDate = hireDate;
  }

  private String printStandardDate(Date date) {
    return DateFormat.getDateTimeInstance(
            DateFormat.FULL, DateFormat.SHORT).format(date);
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getBirthDate() {
    return printStandardDate(birthDate);
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getHireDate() {
    return printStandardDate(hireDate);
  }

  public void setHireDate(Date hireDate) {
    this.hireDate = hireDate;
  }
}
