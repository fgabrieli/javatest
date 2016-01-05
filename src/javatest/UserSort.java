package javatest;

import java.util.List;

interface UserSort {
  public List<User> sortByName();

  public List<User> sortByEmail();

  public List<User> sortById();
}
