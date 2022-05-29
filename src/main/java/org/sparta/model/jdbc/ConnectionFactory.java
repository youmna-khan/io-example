package org.sparta.model.jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
  public static Connection connection = null;

  private ConnectionFactory() {

  }

  public static Connection getConnection() throws SQLException {
    try {

      Properties props = new Properties();
      String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
      Class.forName( JDBC_DRIVER );
      props.load( new FileReader( "src/main/resources/mysql.properties" ) );
      connection = DriverManager.getConnection( props.getProperty( "dburl" ), props.getProperty( "dbusername" ), props.getProperty( "dbpassword" ) );
      return connection;
    } catch ( Exception e ) {
      e.printStackTrace();
      return connection;
    }
  }

  public static void closeConnection() throws SQLException {
    if ( connection != null ) {
      connection.close();
      connection = null;
    }

  }
}


