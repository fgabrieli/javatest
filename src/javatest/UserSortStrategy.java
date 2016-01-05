/**
 * Strategy pattern. Change the algorithm constant below to use different sort algorithms: BUBBLE_SORT, QUICK_SORT implemented for now.
 * The Class itself is also a singleton and implements a Factory method in createSortInstance(...)
 */

package javatest;

import java.util.List;

public class UserSortStrategy {
  private static final String BUBBLE_SORT = "BubbleSort";

  private static final String QUICK_SORT = "QuickSort";

  private static String algorithm = BUBBLE_SORT; // default

  private static UserSortStrategy instance = null; // singleton
  
  private UserSortStrategy() {
    // Singleton
  }
  
  public static UserSortStrategy getInstance() {
    if (instance == null) {
      instance = new UserSortStrategy();
    }
    
    return instance;
  }
  
  public static String getAlgorithm() {
    return algorithm;
  }

  public void setAlgorithm(String algorithm) {
    UserSortStrategy.algorithm = algorithm;
  }
  
  // Factory method
  public UserSort createSortInstance(List<User> users) {
    UserSort sortInstance = null;
    
    switch (algorithm) {
    case BUBBLE_SORT:
      sortInstance = new UserSortBubble(users);
      break;

    case QUICK_SORT:
      sortInstance = new UserSortQuick(users);
      break;
    }
    
    return sortInstance;
  }
}