package javatest;

import java.util.List;

public class UserSortStrategy implements UserSort {
  private static final String BUBBLE_SORT = "BubbleSort";

  private String algorithm = BUBBLE_SORT;
  
  private UserSort sortInstance = null;
  
  public UserSortStrategy(List<User> users) {
    if (algorithm == BUBBLE_SORT) {
      sortInstance = new UserSortBubble(users);
    }
  }

  public List<User> sortByName() {
    return sortInstance.sortByName();
  }

  public List<User> sortByEmail() {
    return sortInstance.sortByEmail();
  }

  public List<User> sortById() {
    return sortInstance.sortById();
  }
}
