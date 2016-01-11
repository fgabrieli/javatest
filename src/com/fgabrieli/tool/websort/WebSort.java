package com.fgabrieli.tool.websort;

import java.util.List;

public abstract class WebSort {
  protected List<Object> sortable = null;

  protected WebSortCallbackInterface callback = null;
  
  /**
   * Should be overridden by child classes. 
   * 
   * @return the original sortable by default.
   */
  public List<Object> sort() {
    return sortable;
  }
}