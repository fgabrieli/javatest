package javatest;

public class User {
  private int id = 0;

  private String firstName = "";

  private String lastName = "";

  private String email = "";

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void print() {
    System.out.println("User data => Id: " + id + ", Name: " + firstName + " " + lastName + ", Email: " + email);
  }

}