package org.sparta.model;

import java.util.List;
import java.util.Map;
import java.util.Set;


public class ParseResult {

  private Set< EmployeeRecord > employeeRecords;
  private Map< Double, List< String > > errors;

  public List< EmployeeRecord > getDuplicates() {
    return duplicates;
  }

  public void setDuplicates( List< EmployeeRecord > duplicates ) {
    this.duplicates = duplicates;
  }

  private List< EmployeeRecord > duplicates;

  public Set< EmployeeRecord > getEmployeeRecords() {
    return employeeRecords;
  }

  public void setEmployeeRecords( Set< EmployeeRecord > employeeRecords ) {
    this.employeeRecords = employeeRecords;
  }

  public Map< Double, List< String > > getErrors() {
    return errors;
  }

  public void setErrors( Map< Double, List< String > > errors ) {
    this.errors = errors;
  }
}
