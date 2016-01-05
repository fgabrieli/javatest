package javatest;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Users {
  static Users instance = null;

  private static List<User> users = new LinkedList<User>();

  private int lastId = 1;

  private UserSort sortInstance = null;

  private Users() {
    // Singleton
  }

  public static Users getInstance() {
    if (instance == null) {
      instance = new Users();
    }

    return instance;
  }

  public void loadFromCSV(String fileName) throws CSVFormatException {
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
    return getSortInstance().sortByName();
  }

  public List<User> getSortedByEmail() {
    return getSortInstance().sortByEmail();
  }

  public List<User> getSortedById() {
    return users; // no need to sort here
  }

  private UserSort getSortInstance() {
    if (sortInstance == null) {
      sortInstance = UserSortStrategy.getInstance().createSortInstance(users);
    }

    return sortInstance;
  }
}
