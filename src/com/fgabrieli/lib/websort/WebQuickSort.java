/**
 * Rough implementation of the QuickSort algorithm.
 */

package com.fgabrieli.lib.websort;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WebQuickSort extends WebSort {

  public List<Object> sort() {
    return quickSort(sortable);
  }
  
  private List<Object> quickSort(List<Object> sortable) {
    int size = sortable.size();
    int middle = Math.round(size / 2);

    Object pivot = sortable.get(middle);

    // Create Lists with lesser and bigger sortable
    List<Object> lesser = new LinkedList<Object>();
    List<Object> bigger = new LinkedList<Object>();

    Iterator<Object> it = sortable.iterator();
    while (it.hasNext()) {
      Object entry = it.next();

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
      lesser = quickSort(lesser);
    }

    if (bigger.size() > 1) {
      bigger = quickSort(bigger);
    }

    List<Object> result = new LinkedList<Object>();
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
