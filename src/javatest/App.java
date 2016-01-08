package javatest;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import websort.WebSortException;

public class App {
  private static final String FILENAME = "c:\\home\\javatest\\src\\javatest\\address-book.csv";

  public static void main(String[] args) {
    Users users = Users.getInstance();

    try {
      users.loadFromCSV(FILENAME);

      Scanner sc = new Scanner(System.in);

      while (true) {
        showOptions();
        processInput(sc);
      }
    } catch (CSVFormatException e) {
      e.printStackTrace();
    }
  }

  private static void showOptions() {
    System.out.println("\n\nPlease select an option:");
    System.out.println("(1) Search By Name");
    System.out.println("(2) Search By Email");
    System.out.println("(3) Search By ID");
    System.out.println("(4) List all");
    System.out.println("(5) Sort by name");
    System.out.println("(6) Sort by email");
    System.out.println("(7) Sort by ID");
  }

  private static void processInput(Scanner sc) {
    boolean found = true;
    List<User> foundUsers = null;
    
    Users usersInstance = Users.getInstance();

    if (sc.hasNextInt()) {
      int option = sc.nextInt();
      switch (option) {
      case 1:
        System.out.println("Enter the First name:");
        String firstName = sc.next();

        System.out.println("Enter the Last name:");
        String lastName = sc.next();

        foundUsers = usersInstance.searchByName(firstName, lastName);

        break;

      case 2:
        System.out.println("Enter the Email:");

        String email = sc.next();

        foundUsers = usersInstance.searchByEmail(email);

        break;

      case 3:
        System.out.println("Enter the ID:");

        int id = sc.nextInt();

        foundUsers = usersInstance.searchById(id);

        break;

      case 4:
        foundUsers = usersInstance.getAll();
        break;

      case 5:
        try {
          foundUsers = usersInstance.getSortedByName();
        } catch (WebSortException e) {
          found = false;

          System.out.println("Error: " + e.getMessage());
        }

        break;

      case 6:
        try {
          foundUsers = usersInstance.getSortedByEmail();
        } catch (WebSortException e) {
          found = false;

          System.out.println("Error: " + e.getMessage());
        }

        break;

      case 7:
        foundUsers = usersInstance.getSortedById();
        
        break;
      }

      if (found && foundUsers.size() > 0) {
        System.out.println("Found " + foundUsers.size() + " entries.");

        Iterator<User> it = foundUsers.iterator();
        while (it.hasNext()) {
          User user = it.next();
          user.print();
        }
      }

    }
  }
}