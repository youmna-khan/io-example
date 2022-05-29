package org.sparta.model;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {

  int ID;
  String title;
  String firstName;
  String middleInitials;
  String lastName;
  String gender;
  String email;
  LocalDate dateOfBirth;
  LocalDate dateOfJoining;
  double salary;

  public Employee() {
  }

  public Employee( int ID, String title, String firstName,
                   String middleInitials, String lastName,
                   String gender, String email, LocalDate dateOfBirth,
                   LocalDate dateOfJoining, double salary ) {
    this.ID = ID;
    this.title = title;
    this.firstName = firstName;
    this.middleInitials = middleInitials;
    this.lastName = lastName;
    this.gender = gender;
    this.email = email;
    this.dateOfBirth = dateOfBirth;
    this.dateOfJoining = dateOfJoining;
    this.salary = salary;
  }

  public int getID() {
    return ID;
  }

  public void setID( int ID ) {
    this.ID = ID;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle( String title ) {
    this.title = title;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName( String firstName ) {
    this.firstName = firstName;
  }

  public String getMiddleInitials() {
    return middleInitials;
  }

  public void setMiddleInitials( String middleInitials ) {
    this.middleInitials = middleInitials;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName( String lastName ) {
    this.lastName = lastName;
  }

  public String getGender() {
    return gender;
  }

  public void setGender( String gender ) {
    this.gender = gender;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail( String email ) {
    this.email = email;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth( LocalDate dateOfBirth ) {
    this.dateOfBirth = dateOfBirth;
  }

  public LocalDate getDateOfJoining() {
    return dateOfJoining;
  }

  public void setDateOfJoining( LocalDate dateOfJoining ) {
    this.dateOfJoining = dateOfJoining;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary( double salary ) {
    this.salary = salary;
  }


  @Override
  public String toString() {
    return "Employee{" +
            "Id=" + ID +
            ", title='" + title + '\'' +
            ", firstName='" + firstName + '\'' +
            ", middleInitials=" + middleInitials +
            ", lastName='" + lastName + '\'' +
            ", gender=" + gender +
            ", email='" + email + '\'' +
            ", dateOfBirth=" + dateOfBirth +
            ", dateOfJoining=" + dateOfJoining +
            ", salary=" + salary +
            '}';
  }

  @Override
  public boolean equals( Object o ) {
    if ( this == o ) return true;
    if ( !( o instanceof Employee ) ) return false;
    Employee that = ( Employee ) o;
    return getID() == that.getID() && getMiddleInitials() == that.getMiddleInitials() && Double.compare( that.getSalary(), getSalary() ) == 0 && Objects.equals( getTitle(), that.getTitle() ) && Objects.equals( getFirstName(), that.getFirstName() ) && Objects.equals( getLastName(), that.getLastName() ) && getGender() == that.getGender() && Objects.equals( getEmail(), that.getEmail() ) && Objects.equals( getDateOfBirth(), that.getDateOfBirth() ) && Objects.equals( getDateOfJoining(), that.getDateOfJoining() );
  }

  @Override
  public int hashCode() {
    return Objects.hash( getID(), getTitle(), getFirstName(), getMiddleInitials(), getLastName(), getGender(), getEmail(), getDateOfBirth(), getDateOfJoining(), getSalary() );
  }
}




