/**
 * Rough implementation of the QuickSort algorithm.
 */

package javatest;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class UserSortQuick extends UserSort {

  public UserSortQuick(List<User> users) {
    super(users);
  }

  public List<User> sort(List<User> entries, SortCallbackInterface callback) {
    int size = entries.size();
    int middle = Math.round(size / 2);

    User pivot = entries.get(middle);

    // Create Lists with lesser and bigger entries
    List<User> lesser = new LinkedList<User>();
    List<User> bigger = new LinkedList<User>();

    Iterator<User> it = entries.iterator();
    while (it.hasNext()) {
      User entry = it.next();

      if (entry != pivot) {
        boolean isBigger = callback.compare(entry, pivot) > 0;
        if (isBigger) {
          bigger.add(entry);
        } else {
          lesser.add(entry);
        }
      }
    }

    if (lesser.size() > 1) {
      lesser = sort(lesser, callback);
    }

    if (bigger.size() > 1) {
      bigger = sort(bigger, callback);
    }

    List<User> result = new LinkedList<User>();
    if (lesser.size() > 0) {
      result.addAll(lesser);
    }

    result.add(pivot);
    
    if (bigger.size() > 0) {
      result.addAll(bigger);
    }
    
    return result;
  }
}
