package com.hithub.yakovlevs.hbrnt.controllers;


import com.hithub.yakovlevs.hbrnt.models.User;
import com.hithub.yakovlevs.hbrnt.models.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

  @Autowired
  private UserDao _userDao;

  @RequestMapping(value = "/delete")
  @ResponseBody
  public String delete(long id) {
    try {
      User user = new User(id);
      _userDao.delete(user);
    } catch (Exception ex) {
      return ex.getMessage();
    }
    return "User succesfully deleted!";
  }

  @RequestMapping(value = "/get-by-email")
  @ResponseBody
  public String getByEmail(String email) {
    String userId;
    try {
      User user = _userDao.getByEmail(email);
      userId = String.valueOf(user.getId());
    } catch (Exception ex) {
      return "User not found";
    }
    return "The user id is: " + userId;
  }

  @RequestMapping(value = "/save")
  @ResponseBody
  public String create(String email, String name) {
    try {
      User user = new User(email, name);
      _userDao.save(user);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return "User succesfully saved!";
  }

  @RequestMapping(value = "/all")
  @ResponseBody
  public List<User> getAll() {
    List<User> users = null;
    try {
      users = _userDao.getAll();
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return users;
  }
}