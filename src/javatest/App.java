package javatest;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {
  private static final String FILENAME = "c:\\home\\javatest\\src\\javatest\\address-book.csv";

  public static void main(String[] args) {
    Users users = Users.getInstance();
    users.loadFromCSV(FILENAME);

    Scanner sc = new Scanner(System.in);

    while (true) {
      showOptions();
      processInput(sc);
    }
  }

  private static void showOptions() {
    System.out.println("\n\nPlease select an option:");
    System.out.println("(1) Search By Name");
    System.out.println("(2) Search By Email");
    System.out.println("(3) Search By ID");
    System.out.println("(4) List all");
  }

  private static void processInput(Scanner sc) {
    List<User> foundUsers = null;
    Users users = Users.getInstance();

    if (sc.hasNextInt()) {
      int option = sc.nextInt();
      switch (option) {
      case 1:
        System.out.println("Enter the First name:");
        String firstName = sc.next();

        System.out.println("Enter the Last name:");
        String lastName = sc.next();
        
        foundUsers = users.searchByName(firstName, lastName);

        break;

      case 2:
        System.out.println("Enter the Email:");

        String email = sc.next();
        
        foundUsers = users.searchByEmail(email);

        break;

      case 3:
        System.out.println("Enter the ID:");
        
        int id = sc.nextInt();

        foundUsers = users.searchById(id);
        
        break;

      case 4:
        foundUsers = users.getAll();
        break;
      }

      if (foundUsers.size() > 0) {
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