/**
 * An algorithm that came up while looking into merge sort, kind of useless :)
 */

package com.fgabrieli.lib.websort;

import java.util.LinkedList;
import java.util.List;

public class WebSwapSort extends WebSort {

  public List<Object> sort() {
    return swapSort(sortable);
  }

  private List<Object> swapSort(List<Object> elements) {
    List<Object> sorted = new LinkedList<Object>();

    int i = 0;
    boolean swapped = false;
    
    Object target = elements.get(i++);
    while (i < elements.size()) {
      Object nextElement = elements.get(i++);

      if (callback.compare(target, nextElement) <= 0) {
        sorted.add(target);
        target = nextElement;
      } else {
        sorted.add(nextElement);
        swapped = true;
      }
    }
    
    List<Object> result = null;
    if (swapped) {
      sorted.add(target);
      result = swapSort(sorted);
    } else {
      result = sorted;
    }
    
    return result;
  }
}
