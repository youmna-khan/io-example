package org.sparta.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TextFileIOTest {


  @Test
  public void testFileLoaded() throws IOException {
    ParseResult parseResult = TextFileIO.readFile( "src/test/resources/EmployeeRecords.csv" );
    Set< EmployeeRecord > employeeRecords = parseResult.getEmployeeRecords();
    assertEquals( 2, employeeRecords.size() );
    EmployeeRecord actual1 = new EmployeeRecord();
    EmployeeRecord expected1 = new EmployeeRecord(
            482552, "Dr.", "Stefan", 'C', "Mundell", Gender.M,
            "stefan.mundell@yahoo.com", LocalDate.parse( "1985-08-15" ),
            LocalDate.parse( "2010-04-24" ), 177858.0d );
    assertTrue( employeeRecords.contains( expected1 ));

    EmployeeRecord actual2 = new EmployeeRecord();
    EmployeeRecord expected2 = new EmployeeRecord(
            872637, "Mr.", "Granville", 'H', "Norman", Gender.M,
            "granville.norman@gmail.com", LocalDate.parse( "1975-01-31" ),
            LocalDate.parse( "2004-09-04" ), 66579.0d );
    assertTrue( employeeRecords.contains( expected2 ));

    //Assertions.assertEquals( employeeRecords ).containsOnly(expected2);

  }


  @Test
  public void testIfDuplicatesArePresent() throws IOException {

    ParseResult parseResult = TextFileIO.readFile( "src/test/resources/EmployeeRecordsDuplicate.csv" );
    Set< EmployeeRecord > employeeRecords = parseResult.getEmployeeRecords();
    assertEquals( 2, employeeRecords.size() );
    EmployeeRecord expected1 = new EmployeeRecord(
            482552, "Dr.", "Stefan", 'C', "Mundell", Gender.M,
            "stefan.mundell@yahoo.com", LocalDate.parse( "1985-08-15" ),
            LocalDate.parse( "2010-04-24" ), 177858.0d );
    assertTrue( employeeRecords.contains( expected1 ));

    EmployeeRecord expected2 = new EmployeeRecord(
            872637, "Mr.", "Granville", 'H', "Norman", Gender.M,
            "granville.norman@gmail.com", LocalDate.parse( "1975-01-31" ),
            LocalDate.parse( "2004-09-04" ), 66579.0d );
    assertTrue( employeeRecords.contains( expected2 ));

    EmployeeRecord duplicate = parseResult.getDuplicates().get( 0 );
    EmployeeRecord expecteDup1 = new EmployeeRecord(
            872637, "Mr.", "Granville", 'H', "Norman", Gender.M,
            "granville.norman@gmail.com", LocalDate.parse( "1975-01-31" ),
            LocalDate.parse( "2004-09-04" ), 66579.0d );
    assertEquals( expecteDup1, duplicate );

    }
  }


