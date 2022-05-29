package org.sparta.model;

import org.junit.jupiter.api.Test;
import org.sparta.model.exception.RecordParseException;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeFactoryTest {

  EmployeeRecordFactory factory = new EmployeeRecordFactory();

  @Test
  void createEmployeeRecord() throws RecordParseException {
    String[] empStr = { "1000", "Mr", "Tom", "A", "Jerry",
            "M", "tom@gmail.com", "3/1/1980", "4/14/2020", "1000" };
    Employee employee = EmployeeRecordFactory.createEmployee( empStr );

    assertEquals( 1000, employee.getID() );
    assertEquals( "Mr", employee.getTitle() );
    assertEquals( "Tom", employee.getFirstName() );
    assertEquals( 'A', employee.getMiddleInitials() );
    assertEquals( "Jerry", employee.getLastName() );
    assertEquals( Gender.M, employee.getGender() );
    assertEquals( "tom@gmail.com", employee.getEmail() );
    assertEquals( LocalDate.of( 1980, 3, 1 ), employee.getDateOfBirth() );
    assertEquals( LocalDate.of( 2020, 4, 14 ), employee.getDateOfJoining() );
    assertEquals( 1000, employee.getSalary() );
  }

//  @Test
//  void throwExceptionWhenInvalid() {
//    String [] empStr = {"aaa", "Mr", "Tom", "A", "Jerry",
//            "M", "tom@gmail.com", "3/1/1980", "4/14/2020", "1000"};
//    assertThrows( EmployeeRecordFactory.createEmployee( empStr ), RecordParseException.class );
//  }
}