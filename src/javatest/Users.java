package javatest;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Users {
  static Users instance = null;

  private static List<User> users = new LinkedList<User>();

  private int lastId = 1;

  private Users() {
    // Singleton
  }

  public static Users getInstance() {
    if (instance == null) {
      instance = new Users();
    }

    return instance;
  }

  public void loadFromCSV(String fileName) throws UsersException {
    try {
      CSV csv = new CSV(fileName);

      List<Map<String, String>> entries = csv.getEntries();
      
      Iterator<Map<String, String>> it = entries.iterator();
      while (it.hasNext()) {
        Map<String, String> entry = it.next();

        User user = new User();
        user.setId(lastId++);
        user.setFirstName(entry.get("firstName"));
        user.setLastName(entry.get("lastName"));
        user.setEmail(entry.get("email"));

        users.add(user);
      }
    } catch (CSVFormatException e) {
      throw new UsersException("Users could not be loaded from CSV file");
    }
  }

  public List<User> searchByEmail(String email) {
    List<User> result = new LinkedList<User>();

    Iterator<User> it = users.iterator();
    while (it.hasNext()) {
      User user = it.next();
      if (user.getEmail().equals(email)) {
        result.add(user);
      }
    }
    return result;
  }

  public List<User> searchByName(String firstName, String lastName) {
    List<User> result = new LinkedList<User>();

    Iterator<User> it = users.iterator();
    while (it.hasNext()) {
      User user = it.next();
      if (user.getFirstName().equals(firstName) && user.getLastName().equals(lastName)) {
        result.add(user);
      }
    }
    return result;
  }

  public List<User> getAll() {
    return users;
  }

  public List<User> searchById(int id) {
    List<User> result = new LinkedList<User>();

    Iterator<User> it = users.iterator();
    while (it.hasNext()) {
      User user = it.next();
      if (user.getId() == id) {
        result.add(user);
      }
    }
    return result;
  }

  public List<User> getSortedByName() {
    return (new UserSortStrategy(users).sortByName());
  }

  public List<User> getSortedByEmail() {
    return (new UserSortStrategy(users).sortByEmail());
  }

  public List<User> getSortedById() {
    return (new UserSortStrategy(users).sortById());
  }
}
