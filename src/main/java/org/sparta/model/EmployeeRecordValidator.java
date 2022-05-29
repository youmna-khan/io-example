package org.sparta.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRecordValidator {
  public List< String > validate( Employee e ) {
    List< String > errors = new ArrayList<>();

    if ( e.getTitle().isBlank() ) {
      errors.add( "Title is missing" );
    }
    if ( e.getFirstName().isBlank() ) {
      errors.add( "FirstName is missing" );
    }
    if ( e.getLastName().isBlank() ) {
      errors.add( "LastName is missing" );
    }
    if ( e.getGender() == null ) {
      errors.add( "Gender is missing" );
    }
    if ( e.getEmail().isBlank() ) {
      errors.add( "Email is missing" );
    }
    if ( e.getDateOfJoining() == null ) {
      errors.add( "Date of Joining is missing" );
    }

    return errors;
  }
}
