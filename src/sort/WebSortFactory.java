package sort;

import java.util.List;

import sort.WebSortCallbackInterface;
import sort.WebSort;

public class WebSortFactory {
  // Available Sort algorithms
  public static final String BUBBLE_SORT = "BubbleSort";
  public static final String QUICK_SORT = "QuickSort";

  // Factory method
  public static WebSort create(String algorithm, List<Object> sortable, WebSortCallbackInterface callback) {
    WebSort sortInstance = null;

    switch (algorithm) {
    case BUBBLE_SORT:
      sortInstance = new WebBubbleSort();
      break;

    case QUICK_SORT:
      sortInstance = new WebQuickSort();
      break;
    }

    // XXX: throw exception if sortInstance is null

    sortInstance.sortable = sortable;
    sortInstance.callback = callback;

    return sortInstance;
  }
}