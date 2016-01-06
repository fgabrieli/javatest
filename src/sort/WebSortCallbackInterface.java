package sort;

public interface WebSortCallbackInterface {
  /**
   * Compare two objects to know which one comes first for sorting purposes.
   * 
   * @return < 0 if obj1 < obj2; > 0 if obj1 > obj2; = 0 if obj1 == obj2
   */
  int compare(Object obj1, Object obj2);
}
