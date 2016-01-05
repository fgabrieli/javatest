/**
 * Rough implementation of the BubbleSort algorithm.
 */

package javatest;

// Remove comment to use the Iterator implementation below in the sort() method
// import java.util.Iterator;

import java.util.List;

public class UserSortBubble extends UserSort {

  public UserSortBubble(List<User> users) {
    super(users);
  }

  public List<User> sort(List<User> entries, SortCallbackInterface callback) {

    // NOTE: i wanted to use a for loop here but below is the implementation
    // with an Iterator (remove the comments and ctrl+shift+f to indent)

    boolean swapped = false;
    for (int index = 0; index < entries.size() - 1; index++) {
      User user1 = entries.get(index);
      User user2 = entries.get(index + 1);

      boolean isBigger = (callback.compare(user1, user2) > 0);
      if (isBigger) {
        User temp = user2; // save reference
        entries.set(index + 1, user1);
        entries.set(index, temp);

        swapped = true;
      }
    }

    if (swapped == true) {
      entries = sort(entries, callback);
    }

    return entries;

    //
    // Iterator implementation
    //
    // Iterator<User> it = entries.iterator();
    // int index = 0;
    // boolean swapped = false;
    // while (it.hasNext()) {
    // User user1 = it.next();
    //
    // index++;
    //
    // if (it.hasNext()) {
    // User user2 = entries.get(index);
    //
    // if (callback.compare(user1, user2) > 0) {
    // User temp = user2;
    // entries.set(index, user1);
    // entries.set(index - 1, temp);
    //
    // swapped = true;
    // }
    // }
    // }
    //
    // if (swapped == true) {
    // entries = sort(entries, callback);
    // }
    //
    // return entries;
  }
}
