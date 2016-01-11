package com.fgabrieli.tool.websort;

import java.util.List;

import com.fgabrieli.tool.websort.WebSort;
import com.fgabrieli.tool.websort.WebSortCallbackInterface;


public class WebSortFactory {
  // Available Sort algorithms
  public static final String BUBBLE_SORT = "BubbleSort";
  public static final String QUICK_SORT = "QuickSort";
  public static final String SWAP_SORT = "SwapSort";
  public static final String MERGE_SORT = "MergeSort";
  public static final String INSERTION_SORT = "InsertionSort";

  // Factory method
  public static WebSort create(String algorithm, List<Object> sortable, WebSortCallbackInterface callback)
      throws WebSortException {
    WebSort sortInstance = null;

    switch (algorithm) {
    case BUBBLE_SORT:
      sortInstance = new WebBubbleSort();
      break;

    case QUICK_SORT:
      sortInstance = new WebQuickSort();
      break;

    case SWAP_SORT:
      sortInstance = new WebSwapSort();
      break;

    case MERGE_SORT:
      sortInstance = new WebMergeSort();
      break;

    case INSERTION_SORT:
      sortInstance = new WebInsertionSort();
      break;
    }
    
    if (sortInstance == null) {
      throw new WebSortException("Sort instance is null, selected algorithm might be wrong or not implemented. "
          + "Available algorithms: bubble sort, quick sort.");
    }

    sortInstance.sortable = sortable;
    sortInstance.callback = callback;

    return sortInstance;
  }
}