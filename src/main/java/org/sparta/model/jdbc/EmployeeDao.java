package org.sparta.model.jdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sparta.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {


  static Logger logger = LogManager.getLogger( EmployeeDao.class );

  public Employee getEmployeeById( int id ) {
    String sqlStatement = "SELECT * FROM employee WHERE ID = ?";
    String[] arguments = new String[]{ ( String.valueOf( id ) ) };
    return executeQuery( sqlStatement, arguments ).get( 0 );
  }
//
//  public List< Employee > getFilmsWithTitle( String title ) {
//    String sqlStatement = "SELECT * FROM employee WHERE title = ?";
//    String[] arguments = new String[]{ title };
//    return executeQuery( sqlStatement, arguments );
//  }
//
//  public List< Film > getAllFilms() {
//    String sqlStatement = "SELECT * FROM employee";
//    return executeQuery( sqlStatement );
//  }
//
//  public List< Film > getFilmsWithRatingAndDescription( String rating, String description ) {
//    String sqlStatement = "SELECT * FROM employee WHERE rating = ? AND description LIKE ?";
//    String[] arguments = new String[]{ rating, "%" + description + "%" };
//    return executeQuery( sqlStatement, arguments );
//  }

  public int addEmployee( Employee employee ) {
    String sqlStatement = "INSERT INTO employee " +
            "(id, title, first_name, middle_initials, last_name, gender, email, date_of_birth, date_of_joining, salary) VALUES " +
            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
    Object[] arguments = new Object[]{
            employee.getID(), employee.getTitle(), employee.getFirstName(), employee.getMiddleInitials(), employee.getLastName(), employee.getGender(),
            employee.getEmail(), employee.getDateOfBirth(), employee.getDateOfJoining(), employee.getSalary() };
    return executeUpdate( sqlStatement, arguments );
  }


  private List< Employee > executeQuery( String sqlStatement ) {
    return executeQuery( sqlStatement, new String[]{} );
  }

  private List< Employee > executeQuery( String sqlStatement, String[] arguments ) {
    List< Employee > employees;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = getPreparedStatement( sqlStatement, arguments );
    try {
      resultSet = preparedStatement.executeQuery();
    } catch ( SQLException e ) {
      e.printStackTrace();
    } finally {
      employees = getEmployeesFromResultSet( resultSet );
      closeTheConnection();
    }
    return employees;
  }

  private void closeTheConnection() {
    try {
      ConnectionFactory.closeConnection();
    } catch ( SQLException e ) {
      e.printStackTrace();
    }
  }

  private int executeUpdate( String sqlStatement, Object[] arguments ) {
    int rowsAffected = 0;
    PreparedStatement preparedStatement = getPreparedStatement( sqlStatement, arguments );
    try {
      rowsAffected = preparedStatement.executeUpdate();
    } catch ( SQLException e ) {
      e.printStackTrace();
    }
    closeTheConnection();
    logger.info( rowsAffected + " rows were affected." );
    return rowsAffected;
  }

  private PreparedStatement getPreparedStatement( String sqlStatement, Object[] arguments ) {
    PreparedStatement preparedStatement = null;
    try {
      Connection connection = ConnectionFactory.getConnection();
      preparedStatement = connection.prepareStatement( sqlStatement );
      int i = 1;
      for ( Object argument : arguments ) {
        preparedStatement.setObject( i, argument );
        i++;
      }
    } catch ( SQLException e ) {
      e.printStackTrace();
    }
    return preparedStatement;
  }

  private List< Employee > getEmployeesFromResultSet( ResultSet resultSet ) {
    List< Employee > employees = new ArrayList<>();
    try {
      while ( resultSet.next() ) {
        Employee employee = new Employee( resultSet.getInt( "id" ), resultSet.getString( "title" ), resultSet.getString( "first_name" ), resultSet.getString( "middle_initials" ), resultSet.getString( "last_name" ), resultSet.getString( "gender" ), resultSet.getString( "email" ), resultSet.getDate( "date_of_birth" ).toLocalDate(), resultSet.getDate( "date_of_joining" ).toLocalDate(), resultSet.getInt( "salary" ) );

        employees.add( employee );
      }
    } catch ( SQLException e ) {
      e.printStackTrace();
    }
    return employees;
  }
}