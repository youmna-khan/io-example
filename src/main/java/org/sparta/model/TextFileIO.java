package org.sparta.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TextFileIO {
  static Logger logger = LogManager.getLogger( TextFileIO.class );

  public static ParseResult readFile( String filename ) throws IOException {
    EmployeeRecordValidator validator = new EmployeeRecordValidator();
    Set< EmployeeRecord > employees = new HashSet<>();
    List< EmployeeRecord > duplicates = new ArrayList<>();
    try ( BufferedReader bufferedReader = new BufferedReader( new FileReader( filename ) ) ) {
      logger.info( "Reading csv file of Employee " + filename );
      String line;
      bufferedReader.readLine();

      while ( ( line = bufferedReader.readLine() ) != null ) {
        String[] lineArray = line.split( "," );
        EmployeeRecord emp = createEmployee( lineArray );
        List< String > errors = validator.validate( emp );
        if(!errors.isEmpty()){
          logger.error( "Missing Fields for Employee {} are {}"
                  ,emp.getID(), errors);
        }
        //if not duplicates
        if ( isDuplicate( employees, emp ) ) {
          duplicates.add( emp );
        } else {
          employees.add( emp );

        }
        //System.out.println( Arrays.toString( lineArray ) );
      }

    } catch ( IOException e ) {
      throw e;
    }
    ParseResult result = new ParseResult();
    result.setEmployeeRecords( employees );
    logger.info( "Number of Employee Records processed are {}", employees.size() );
    result.setDuplicates( duplicates );
    logger.error( "Number of duplicate employee records found are {}", duplicates.size());

    return result;
  }

  private static boolean isDuplicate( Set< EmployeeRecord > employees, EmployeeRecord emp ) {
    for ( EmployeeRecord employee : employees) {
      if(employee.getID() == emp.getID()){
        return true;
      }
    }
    return false;
  }

  private static EmployeeRecord createEmployee( String[] lineArray ) {
    EmployeeRecord emp = new EmployeeRecord();
    //System.out.println( "lineArray = " + lineArray[ 0 ] );
    emp.setID( Integer.parseInt( lineArray[ 0 ] ) );
    emp.setTitle( lineArray[ 1 ] );
    emp.setFirstName( lineArray[ 2 ] );
    emp.setMiddleInitials( lineArray[ 3 ].charAt( 0 ) );
    emp.setLastName( lineArray[ 4 ] );
    emp.setGender( Gender.valueOf( lineArray[ 5 ] ) );
    emp.setEmail( lineArray[ 6 ] );
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "M/d/yyyy", Locale.ENGLISH );
    LocalDate dateTime = LocalDate.parse( lineArray[ 7 ], formatter );
    emp.setDateOfBirth( dateTime );
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern( "M/d/yyyy", Locale.ENGLISH );
    LocalDate date = LocalDate.parse( lineArray[ 8 ], formatter );
    emp.setDateOfJoining( date );
    emp.setSalary( Double.parseDouble( lineArray[ 9 ] ) );
    return emp;
  }

  public static void readWriteFile( String inFile, String outFile ) {

    try ( BufferedReader br = new BufferedReader( new FileReader( inFile ) ); BufferedWriter bw = new BufferedWriter( new FileWriter( outFile ) ) ) {
      String line;
      while ( ( line = br.readLine() ) != null ) {
        //  System.out.println( Arrays.toString( line.split( "," ) ) );
        bw.write( line );
      }

    } catch ( IOException e ) {
      e.printStackTrace();
    }


  }


}








