package org.sparta.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeValidatorTest {

  EmployeeRecordValidator validator = new EmployeeRecordValidator();

  @Test
  public void testToValidateFirstName() {
    Employee e = new Employee(
            123, "Mr.", null, "H", "Norman", "M",
            "granville.norman@gmail.com", LocalDate.parse( "1975-01-31" ),
            LocalDate.parse( "2004-09-04" ), 66579.0d );

    List< String > result = validator.validate( e );

    assertEquals( 1, result.size() );
    assertEquals( "FirstName is missing", result.get( 0 ) );
  }

  @Test
  public void testToValidateFields() {
    Employee e = new Employee(
            123, "", "Granville", "H", "", null,
            "", LocalDate.parse( "1975-01-31" ),
            null, 66579.0d );

    List< String > result = validator.validate( e );

    assertEquals( 5, result.size() );
    assertEquals( "Title is missing", result.get( 0 ) );
    assertEquals( "LastName is missing", result.get( 1 ) );
    assertEquals( "Gender is missing", result.get( 2 ) );
    assertEquals( "Email is missing", result.get( 3 ) );
    assertEquals( "Date of Joining is missing", result.get( 4 ) );

  }


}