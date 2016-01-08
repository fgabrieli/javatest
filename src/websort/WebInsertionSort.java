/**
 * Rough implementation of the InsertionSort algorithm.
 */

package websort;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WebInsertionSort extends WebSort {
  
  public List<Object> sort() {
    List<Object> tempSortable = new LinkedList<Object>();
    tempSortable.addAll(sortable);
    
    List<Object> sorted = new LinkedList<Object>();

    boolean inserted = false;
    
    while (tempSortable.size() > 0) {
      Object target = tempSortable.remove(0);
      inserted = false;
      if (sorted.size() == 0) {
        sorted.add(target);
        inserted = true;
      } else {
        int i = 0;
        Iterator<Object> it = sorted.iterator();
        while(it.hasNext()) {
          Object number = it.next();
          
          if (callback.compare(target,  number) <= 0) { // if (target <= number)
            sorted.add(i, target);
            inserted = true;
            break;
          }
          
          i++;
        }
      }
      
      if (!inserted) {
        sorted.add(target);
      }
    }

    return sorted;
  }

}
