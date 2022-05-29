package org.sparta.model;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRecordValidatorTest {

  EmployeeRecordValidator validator = new EmployeeRecordValidator();

  @Test
  public void testToValidateFirstName()  {
    EmployeeRecord e = new EmployeeRecord(
            123, "Mr.", null, 'H', "Norman", Gender.M,
            "granville.norman@gmail.com", LocalDate.parse( "1975-01-31" ),
            LocalDate.parse( "2004-09-04" ), 66579.0d );

    List< String > result = validator.validate( e );

    assertEquals( 1, result.size() );
    assertEquals( "FirstName is missing", result.get( 0 ) );
  }

  @Test
  public void testToValidateFields()  {
    EmployeeRecord e = new EmployeeRecord(
            123, "", "Granville", 'H', "", null,
            "", LocalDate.parse( "1975-01-31" ),
            null, 66579.0d );

    List< String > result = validator.validate( e );

    assertEquals( 5, result.size() );
    assertEquals( "Title is missing", result.get( 0) );
    assertEquals( "LastName is missing", result.get( 1) );
    assertEquals( "Gender is missing", result.get( 2) );
    assertEquals( "Email is missing", result.get( 3) );
    assertEquals( "Date of Joining is missing", result.get( 4) );

  }
  
  
}