/**
 * Rough implementation of the BubbleSort algorithm.
 */

package com.fgabrieli.lib.websort;

import java.util.List;

public class WebBubbleSort extends WebSort {

  public List<Object> sort() {

    // NOTE: i am using a for loop, but i could do it with an iterator as well

    boolean swapped = false;
    for (int index = 0; index < sortable.size() - 1; index++) {
      Object Object1 = sortable.get(index);
      Object Object2 = sortable.get(index + 1);

      boolean isBigger = (callback.compare(Object1, Object2) > 0);
      if (isBigger) {
        Object temp = Object2; // save reference
        sortable.set(index + 1, Object1);
        sortable.set(index, temp);

        swapped = true;
      }
    }

    if (swapped == true) {
      sort();
    }

    return sortable;
  }

}
