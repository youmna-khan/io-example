package org.sparta.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sparta.model.exception.RecordParseException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class EmployeeRecordFactory {
  static Logger logger = LogManager.getLogger( EmployeeRecordFactory.class );

  public static Employee createEmployee( String[] lineArray ) throws RecordParseException {
    Employee emp = new Employee();
    try {
      emp.setID( Integer.parseInt( lineArray[ 0 ] ) );
      emp.setTitle( lineArray[ 1 ] );
      emp.setFirstName( lineArray[ 2 ] );
      emp.setMiddleInitials( lineArray[ 3 ] );
      emp.setLastName( lineArray[ 4 ] );
      emp.setGender( lineArray[ 5 ] );
      emp.setEmail( lineArray[ 6 ] );
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "M/d/yyyy", Locale.ENGLISH );
      LocalDate dateTime = LocalDate.parse( lineArray[ 7 ], formatter );
      emp.setDateOfBirth( dateTime );
      LocalDate date = LocalDate.parse( lineArray[ 8 ], formatter );
      emp.setDateOfJoining( date );
      emp.setSalary( Double.parseDouble( lineArray[ 9 ] ) );
    } catch ( Exception e ) {
      logger.error( "Corrupt Record found " + e.getMessage() );
      throw new RecordParseException( "Corrupt record found ", e );
    }
    return emp;
  }
}
