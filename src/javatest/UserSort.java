/**
 * Abstract class for UserSort implementations. Every sort algorithm will inherit from this one (i.e. UserSortBubble).
 * It implements UserSortInterface.
 */

package javatest;

import java.util.LinkedList;
import java.util.List;

public abstract class UserSort implements UserSortInterface {
  private List<User> users = null;

  public UserSort(List<User> users) {
    this.users = users;
  }

  private List<User> getSortable() {
    List<User> sorted = new LinkedList<User>();
    sorted.addAll(users);

    return sorted;
  }

  public List<User> sortByName() {
    return sort(getSortable(), new SortCallbackByName());
  }

  public class SortCallbackByName implements SortCallbackInterface {
    public int compare(User user1, User user2) {
      String str1 = user1.getFirstName() + user1.getLastName();
      String str2 = user2.getFirstName() + user2.getLastName();

      return str1.compareTo(str2);
    }
  }

  public List<User> sortByEmail() {
    return sort(getSortable(), new SortCallbackByEmail());
  }

  public class SortCallbackByEmail implements SortCallbackInterface {
    public int compare(User user1, User user2) {
      return user1.getEmail().compareTo(user2.getEmail());
    }
  }
}
