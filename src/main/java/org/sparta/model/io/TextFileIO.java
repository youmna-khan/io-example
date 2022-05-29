package org.sparta.model.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sparta.model.Employee;
import org.sparta.model.EmployeeRecordFactory;
import org.sparta.model.EmployeeRecordValidator;
import org.sparta.model.ParseResult;
import org.sparta.model.exception.RecordParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TextFileIO {
  static Logger logger = LogManager.getLogger( TextFileIO.class );

  public static ParseResult readFile( String filename ) throws IOException {
    ParseResult result = new ParseResult();
    EmployeeRecordValidator validator = new EmployeeRecordValidator();
    Set< Employee > employees = new HashSet<>();
    List< Employee > duplicates = new ArrayList<>();

    try ( BufferedReader bufferedReader = new BufferedReader( new FileReader( filename ) ) ) {
      logger.info( "Reading csv file of Employee " + filename );
      String line;
      bufferedReader.readLine();

      while ( ( line = bufferedReader.readLine() ) != null ) {
        String[] lineArray = line.split( "," );
        try {
          Employee emp = EmployeeRecordFactory.createEmployee( lineArray );

          List< String > errors = validator.validate( emp );
          if ( !errors.isEmpty() ) {
            logger.error( "Missing Fields for Employee {} are {}", emp.getID(), errors );
            result.addMissingAttribute( emp );
          } else if ( isDuplicate( employees, emp ) ) {
            duplicates.add( emp );
          } else {
            employees.add( emp );
          }
        } catch ( RecordParseException e ) {
          result.addRecord( line );
        }
      }

    } catch ( IOException e ) {
      logger.error( "Error ", e );
      throw e;
    }
    result.setEmployees( employees );
    logger.info( "Number of Employee Records processed are {}", employees.size() );
    result.setDuplicates( duplicates );
    logger.error( "Number of duplicate employee records found are {}", duplicates.size() );

    return result;
  }

  private static boolean isDuplicate( Set< Employee > employees, Employee emp ) {
    for ( Employee employee : employees ) {
      if ( employee.getID() == emp.getID() ) {
        return true;
      }
    }
    return false;
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








