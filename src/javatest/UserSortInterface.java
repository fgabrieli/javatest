package javatest;

import java.util.List;

public interface UserSortInterface {
  public List<User> sort(List<User> sorted, SortCallbackInterface callback);
}
