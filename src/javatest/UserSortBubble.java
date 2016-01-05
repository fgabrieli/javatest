/**
 * Bubble sort implementation.
 */

package javatest;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class UserSortBubble implements UserSort {
  private List<User> users;

  private interface SortCallbackInterface {
    boolean isBigger(User user1, User user2);
  }

  public UserSortBubble(List<User> users) {
    this.users = users;
  }

  private List<User> sortUsers(SortCallbackInterface callback) {
    List<User> sorted = new LinkedList<User>();
    sorted.addAll(users);
    
    sort(sorted, callback);
    
    return sorted;
  }
  
  private void sort(List<User> sorted, SortCallbackInterface callback) {
    Iterator<User> it = sorted.iterator();
    int index = 0;
    boolean swapped = false;
    while (it.hasNext()) {
      User user1 = it.next();

      index++;

      if (it.hasNext()) {
        User user2 = sorted.get(index);

        if (callback.isBigger(user1, user2)) {
          User temp = user2;
          sorted.set(index, user1);
          sorted.set(index - 1, temp);

          swapped = true;
        }
      }
    }

    if (swapped == true) {
      sort(sorted, callback);
    } else {
      // stop recursion
    }
  }
  
  public class SortCallbackByName implements SortCallbackInterface {
    public boolean isBigger(User user1, User user2) {
      String str1 = user1.getFirstName() + user1.getLastName();
      String str2 = user2.getFirstName() + user2.getLastName();
      return (str1.compareTo(str2) > 0);
    }
  }

  public List<User> sortByName() {
    return sortUsers(new SortCallbackByName());
  }

  public class SortCallbackByEmail implements SortCallbackInterface {
    public boolean isBigger(User user1, User user2) {
      return (user1.getEmail().compareTo(user2.getEmail()) > 0);
    }
  }

  public List<User> sortByEmail() {
    return sortUsers(new SortCallbackByEmail());
  }

  public List<User> sortById() {
    return users; // users are ordered by id, this is the default
  }
}
