package sort;

public interface WebSortCallbackInterface {
  /**
   * Compare two objects to know how to sort them.
   * 
   * @return < 0 if obj1 < obj2; > 0 if obj1 > obj2; = 0 if obj1 == obj2
   */
  int compare(Object obj1, Object obj2);
}
