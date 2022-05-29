package org.sparta.model;

import java.time.LocalDate;
import java.util.Objects;

public class EmployeeRecord {

  int ID;
  String title;
  String firstName;
  char middleInitials;
  String lastName;
  Gender gender;
  String email;
  LocalDate dateOfBirth;
  LocalDate dateOfJoining;
  double salary;

  public EmployeeRecord() {
  }

  public EmployeeRecord( int ID, String title, String firstName,
                         char middleInitials, String lastName,
                         Gender gender, String email, LocalDate dateOfBirth,
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

  public String getTitle() {
    return title;
  }

  public String getFirstName() {
    return firstName;
  }

  public char getMiddleInitials() {
    return middleInitials;
  }

  public String getLastName() {
    return lastName;
  }

  public Gender getGender() {
    return gender;
  }

  public String getEmail() {
    return email;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public LocalDate getDateOfJoining() {
    return dateOfJoining;
  }

  public double getSalary() {
    return salary;
  }


  public void setID( int ID ) {
    this.ID = ID;
  }

  public void setTitle( String title ) {
    this.title = title;
  }

  public void setFirstName( String firstName ) {
    this.firstName = firstName;
  }

  public void setMiddleInitials( char middleInitials ) {
    this.middleInitials = middleInitials;
  }

  public void setLastName( String lastName ) {
    this.lastName = lastName;
  }

  public void setGender( Gender gender ) {
    this.gender = gender;
  }

  public void setEmail( String email ) {
    this.email = email;
  }

  public void setDateOfBirth( LocalDate dateOfBirth ) {
    this.dateOfBirth = dateOfBirth;
  }

  public void setDateOfJoining( LocalDate dateOfJoining ) {
    this.dateOfJoining = dateOfJoining;
  }

  public void setSalary( double salary ) {
    this.salary = salary;
  }


  @Override
  public String toString() {
    return "EmployeeRecord{" +
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
    if ( !( o instanceof EmployeeRecord ) ) return false;
    EmployeeRecord that = ( EmployeeRecord ) o;
    return getID() == that.getID() && getMiddleInitials() == that.getMiddleInitials() && Double.compare( that.getSalary(), getSalary() ) == 0 && Objects.equals( getTitle(), that.getTitle() ) && Objects.equals( getFirstName(), that.getFirstName() ) && Objects.equals( getLastName(), that.getLastName() ) && getGender() == that.getGender() && Objects.equals( getEmail(), that.getEmail() ) && Objects.equals( getDateOfBirth(), that.getDateOfBirth() ) && Objects.equals( getDateOfJoining(), that.getDateOfJoining() );
  }

  @Override
  public int hashCode() {
    return Objects.hash( getID(), getTitle(), getFirstName(), getMiddleInitials(), getLastName(), getGender(), getEmail(), getDateOfBirth(), getDateOfJoining(), getSalary() );
  }
}




