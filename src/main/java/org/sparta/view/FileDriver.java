package org.sparta.view;

import org.sparta.model.TextFileIO;

import java.io.IOException;

public class FileDriver {
  public static void main( String[] args ) throws IOException {
    TextFileIO.readFile( "src/main/resources/EmployeeRecords.csv" );
    TextFileIO.readWriteFile( "src/main/resources/EmployeeRecords.csv", "src/main/resources/EmployeeRecordsOut.csv" );
  }
}
