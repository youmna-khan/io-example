package org.sparta.model;

import org.junit.jupiter.api.Test;
import org.sparta.model.io.TextFileIO;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TextFileIOTest {


  @Test
  public void testFileLoaded() throws IOException {
    ParseResult parseResult = TextFileIO.readFile( "src/test/resources/EmployeeRecords.csv" );
    Set< Employee > employees = parseResult.getEmployees();
    assertEquals( 2, employees.size() );
    Employee actual1 = new Employee();
    Employee expected1 = new Employee(
            482552, "Dr.", "Stefan", "C", "Mundell", "M",
            "stefan.mundell@yahoo.com", LocalDate.parse( "1985-08-15" ),
            LocalDate.parse( "2010-04-24" ), 177858.0d );
    assertTrue( employees.contains( expected1 ) );

    Employee actual2 = new Employee();
    Employee expected2 = new Employee(
            872637, "Mr.", "Granville", "H", "Norman", "M",
            "granville.norman@gmail.com", LocalDate.parse( "1975-01-31" ),
            LocalDate.parse( "2004-09-04" ), 66579.0d );
    assertTrue( employees.contains( expected2 ) );

    //Assertions.assertEquals( employees ).containsOnly(expected2);

  }


  @Test
  public void testIfDuplicatesArePresent() throws IOException {

    ParseResult parseResult = TextFileIO.readFile( "src/test/resources/EmployeeRecordsDuplicate.csv" );
    Set< Employee > employees = parseResult.getEmployees();
    assertEquals( 2, employees.size() );
    Employee expected1 = new Employee(
            482552, "Dr.", "Stefan", "C", "Mundell", "M",
            "stefan.mundell@yahoo.com", LocalDate.parse( "1985-08-15" ),
            LocalDate.parse( "2010-04-24" ), 177858.0d );
    assertTrue( employees.contains( expected1 ) );

    Employee expected2 = new Employee(
            872637, "Mr.", "Granville", "C", "Norman", "M",
            "granville.norman@gmail.com", LocalDate.parse( "1975-01-31" ),
            LocalDate.parse( "2004-09-04" ), 66579.0d );
    assertTrue( employees.contains( expected2 ) );

    Employee duplicate = parseResult.getDuplicates().get( 0 );
    Employee expecteDup1 = new Employee(
            872637, "Mr.", "Granville", "H", "Norman", "M",
            "granville.norman@gmail.com", LocalDate.parse( "1975-01-31" ),
            LocalDate.parse( "2004-09-04" ), 66579.0d );
    assertEquals( expecteDup1, duplicate );

  }
}


