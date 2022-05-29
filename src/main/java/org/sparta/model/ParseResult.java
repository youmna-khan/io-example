package org.sparta.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ParseResult {

  public Set< Employee > withMissingAttributes = new HashSet<>();
  public List< String > corrupt = new ArrayList<>();
  private Set< Employee > employees;
  private List< Employee > duplicates;

  public List< Employee > getDuplicates() {
    return duplicates;
  }

  public void setDuplicates( List< Employee > duplicates ) {
    this.duplicates = duplicates;
  }

  public Set< Employee > getEmployees() {
    return employees;
  }

  public void setEmployees( Set< Employee > employees ) {
    this.employees = employees;
  }

  public void addRecord( String corrupt ) {
    this.corrupt.add( corrupt );
  }


  public List< String > getCorrupt() {
    return corrupt;
  }

  public Set< Employee > getWithMissingAttributes() {
    return withMissingAttributes;
  }

  public void addMissingAttribute( Employee employee ) {
    this.withMissingAttributes.add( employee );
  }
}
