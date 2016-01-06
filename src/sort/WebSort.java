/**
 * Abstract class for objectsort implementations. Every sort algorithm will inherit from this one (i.e. objectsortBubble).
 * It implements objectsortInterface.
 */

package sort;

import java.util.List;

public abstract class WebSort implements WebSortInterface {
  protected List<Object> sortable = null;

  protected WebSortCallbackInterface callback = null;
}
