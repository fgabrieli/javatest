package com.fgabrieli.app;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fgabrieli.lib.websort.WebSort;
import com.fgabrieli.lib.websort.WebSortCallbackInterface;
import com.fgabrieli.lib.websort.WebSortException;
import com.fgabrieli.lib.websort.WebSortFactory;


public class Users {
  static Users instance = null;

  private static final String sortAlgorithm = WebSortFactory.INSERTION_SORT;
  
  private static List<User> users = new LinkedList<User>();

  private int lastId = 1;

  private WebSort sortInstance = null;

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
  
  private class SortByNameCallback implements WebSortCallbackInterface {
    public int compare(Object obj1, Object obj2) {
      User user1 = (User) obj1;
      User user2 = (User) obj2;

      String str1 = user1.getFirstName() + user1.getLastName();
      String str2 = user2.getFirstName() + user2.getLastName();
      
      return str1.compareTo(str2);
    }
  }

  public List<User> getSortedByName() throws WebSortException {
    WebSort sortInstance = getSortInstance(new SortByNameCallback());
    List<Object> sorted = sortInstance.sort();
    
    return convertSortedToUserType(sorted);
  }

  private class SortByEmailCallback implements WebSortCallbackInterface {
    public int compare(Object obj1, Object obj2) {
      User user1 = (User) obj1;
      User user2 = (User) obj2;

      return user1.getEmail().compareTo(user2.getEmail());
    }
  }
  
  public List<User> getSortedByEmail() throws WebSortException {
    WebSort sortInstance = getSortInstance(new SortByEmailCallback());
    List<Object> sorted = sortInstance.sort();
    
    return convertSortedToUserType(sorted);
  }

  private List<User> convertSortedToUserType(List<Object> sorted) {
    List<User> result = new LinkedList<User>();
    
    // Convert to User type, XXX: not sure what's the best approach here to avoid converting two times    
    Iterator<Object> it = sorted.iterator();
    while (it.hasNext()) {
      User user = (User) it.next();
      result.add(user);
    }

    return result;
  }

  public List<User> getSortedById() {
    return users; // no need to sort here
  }

  private WebSort getSortInstance(WebSortCallbackInterface callback) throws WebSortException {
    if (sortInstance == null) {
      
      List<Object> sortable = new LinkedList<Object>();
      sortable.addAll(users);

      sortInstance = WebSortFactory.create(sortAlgorithm, sortable, callback);
    }

    return sortInstance;
  }
}