package javatest;

public interface SortCallbackInterface {
  /**
   * Compare two users to know which one comes first for sorting purposes.
   * 
   * @param User
   * @param User
   * @return < 0 if user1 is lesser than user2, > 0 if user1 is bigger than user2, 0 if they are the same
   */
  int compare(User user1, User user2);
}
