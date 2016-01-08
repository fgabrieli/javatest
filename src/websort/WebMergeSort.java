/**
 * Rough implementation of the MergeSort algorithm.
 */

package websort;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WebMergeSort extends WebSort {

  public List<Object> sort() {
    return mergeSort(sortable);
  }

  private List<Object> mergeSort(List<Object> sortable) {

    // Divide in two lists
    
    int middle = Math.round(sortable.size() / 2);

    List<Object> A = new LinkedList<Object>();
    List<Object> B = new LinkedList<Object>();

    int i;
    for (i = 0; i < middle; i++) {
      A.add(sortable.get(i));
    }

    for (; i < sortable.size(); i++) {
      B.add(sortable.get(i));
    }


    // If lists A or B have more than one element, recurse
    
    if (A.size() > 1) {
      A = mergeSort(A);
    }
    
    if (B.size() > 1) {
      B = mergeSort(B);
    }


    // Order and join in list C
    
    List<Object> C = new LinkedList<Object>();
    Iterator<Object> itA = A.iterator();
    Object target = null;
    while (itA.hasNext()) {
      target = itA.next();
      itA.remove();

      if (B.size() > 0) {
        Iterator<Object> itB = B.iterator();
        while (itB.hasNext()) {
          Object b = itB.next();

          if (callback.compare(target, b) < 0) {
            C.add(target);
            target = null;
            break;
          } else {
            C.add(b);
            itB.remove();
          }
        }
      } else {
        C.add(target);
      }
    }

    if (B.size() > 0) {
      C.addAll(B);
    } else if (target != null) {
      C.add(target);
    }

    return C;
  }
}
