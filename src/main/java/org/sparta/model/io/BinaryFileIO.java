package org.sparta.model.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryFileIO {
  static Logger logger = LogManager.getLogger( BinaryFileIO.class );

  public static void readBinary( String infile ) {
    try ( FileInputStream fis = new FileInputStream( infile ) ) {
      //fis =new FileInputStream( infile );
      int theByte;
      while ( ( theByte = fis.read() ) != -1 ) {
        System.out.println( ( char ) theByte );
      }
    } catch ( IOException ioe ) {
      ioe.printStackTrace();

    }

  }

  public static void copyBinary( String infile, String outfile ) {
    try ( FileInputStream fis = new FileInputStream( infile );
          FileOutputStream fos = new FileOutputStream( outfile ) ) {
      int theByte;
      while ( ( theByte = fis.read() ) != -1 ) {
        System.out.println( theByte );

      }

    } catch ( IOException e ) {
      e.printStackTrace();
    }


  }
}

//Create a new project and write code to read data from an Employee CSV file.
//As it is read in, add each record read to a new object of a suitable class and then add those objects to a collection.
//Any corrupt or duplicated data should be added to a separate collection for further analysis.
//Write tests to ensure data is being managed correctly.
//Consider which date class would be best to use for the date fields – there is one in java.util and another in java.sql.
//Provide a simple user interface to display the results of reading the file – how many unique, clean records there are, how many
// duplicates, how many records with missing fields, possibly display the questionable records.
//User the provided EmployeeRecords.csv for your testing and optionally create your own test files to help with your JUnit tests.
//Notes:
//
//Consider preparing your tests beforehand, in line with a TDD approach.
//Since the overall purpose of the project is data migration, we want to make sure that only clean data is transferred.
//Consider your code structure, since later in the project we will be increasing the size of the data and looking at the efficiency of the code.
//The choice of collection will be important as there is some duplication of the employee records.
//