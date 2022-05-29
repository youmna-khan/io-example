package org.sparta.controller;

import org.sparta.model.jdbc.EmployeeDao;

import java.io.IOException;

public class EmployeeController {
  EmployeeDao employeeDao = new EmployeeDao();

  public void importEmployee( String filePath ) throws IOException {
  /*  ParseResult parseResult = TextFileIO.readFile( filePath );
    for ( Employee employee : parseResult.getEmployees() ) {
      employeeDao.addEmployee( employee );
    }*/
    System.out.println( "employeeDao = " + employeeDao.getEmployeeById( 891727 ) );
  }
}
