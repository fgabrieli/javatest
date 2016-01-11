package com.fgabrieli.tool.websort;

public interface WebSortCallbackInterface {
  /**
   * Compare two objects.
   * 
   * @return < 0 if obj1 < obj2; > 0 if obj1 > obj2; = 0 if obj1 == obj2
   */
  int compare(Object obj1, Object obj2);
}
