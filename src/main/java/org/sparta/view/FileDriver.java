package org.sparta.view;

import org.sparta.controller.EmployeeController;

import java.io.IOException;

public class FileDriver {

  public static void main( String[] args ) throws IOException {
    EmployeeController employeeController = new EmployeeController();
    employeeController.importEmployee( "src/main/resources/EmployeeRecords.csv" );
//    TextFileIO.readFile( "src/main/resources/EmployeeRecords.csv" );
//    TextFileIO.readWriteFile( "src/main/resources/EmployeeRecords.csv", "src/main/resources/EmployeeRecordsOut.csv" );
  }
}
