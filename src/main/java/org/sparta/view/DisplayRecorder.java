package org.sparta.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sparta.model.io.TextFileIO;

import java.util.ArrayList;
import java.util.Arrays;

public class DisplayRecorder {

  static Logger logger = LogManager.getLogger( DisplayRecorder.class );

  public static ArrayList< String > getRecordFiles() {
    return new ArrayList<>( Arrays.asList( "src/main/resources/EmployeeRecords.csv" ) );

  }

  public static void printExcludingDuplicate( TextFileIO textFileIO, String[] employee ) {
    logger.info( "Duplicates are not present" + Arrays.toString( employee ) );

  }


}
