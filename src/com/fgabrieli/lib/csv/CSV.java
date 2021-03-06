package com.fgabrieli.lib.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSV {
  private List<Map<String, String>> entries = new LinkedList<Map<String, String>>();

  public CSV(String fileName) throws CSVFormatException {
    List<String> lines = new LinkedList<String>();
    try {
      readFile(fileName, lines);
    } catch (IOException e) {
      e.printStackTrace();
    }

    Iterator<String> it = lines.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
  }

  public List<Map<String, String>> getEntries() {
    return entries;
  }

  public void readFile(String fileName, List<String> lines) throws IOException, CSVFormatException {
    Path path = Paths.get(fileName);

    BufferedReader reader = Files.newBufferedReader(path);
    String line = null;
    while ((line = reader.readLine()) != null) {
      line = line.trim();
      
      Map<String, String> csvData = new HashMap<String, String>();
      
      parse(line, csvData);
 
      entries.add(csvData);
    }
  }

  private void parse(String text, Map<String, String> csvData) throws CSVFormatException {
    Pattern p = Pattern.compile("([a-zA-Z@.]+);([a-zA-Z@.]+);([a-zA-Z@.]+)");
    Matcher m = p.matcher(text);
    if (!m.matches()) {
      throw new CSVFormatException("CSV format is wrong");
    } else {
      csvData.put("firstName", m.group(1));
      csvData.put("lastName", m.group(2));
      csvData.put("email", m.group(3));
    }
  }
}