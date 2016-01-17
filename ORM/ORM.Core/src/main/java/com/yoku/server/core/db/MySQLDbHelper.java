package com.yoku.server.core.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLDbHelper {
	
	private static final Logger logger = Logger.getLogger(MySQLDbHelper.class.getName());
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public MySQLDbHelper() {
		
	}
	
	public void openConnection(Connection conn) throws RuntimeException {
		
	}
	
	private void close() {
	    try {
	      if (resultSet != null) {
	        resultSet.close();
	      }

	      if (statement != null) {
	        statement.close();
	      }

	      if (connect != null) {
	        connect.close();
	      }
	    } catch (Exception e) {

	    }
	  }
	
	public ResultSet readData(String query, String[] args) {
		
		if(logger.isLoggable(Level.INFO)){
			logger.log(Level.INFO, "Inside MySQLDbHelper.readData with query and args");
		}
		try{
			// This will load the MySQL driver, each DB has its own driver
		      Class.forName("com.mysql.jdbc.Driver");
		      // Setup the connection with the DB
		      connect = DriverManager
		          .getConnection("jdbc:mysql://localhost/yoku?"
			              + "user=yoku&password=yoku");

		      // Statements allow to issue SQL queries to the database
		      statement = connect.createStatement();
		      preparedStatement = connect.prepareStatement(query);
		      for(int i=0; i<args.length; i++){
		    	  preparedStatement.setString(i+1, args[i]);
		      }
		      resultSet = preparedStatement.executeQuery();
		      // Result set get the result of the SQL query
		      /*resultSet = statement
		          .executeQuery("select * from yoku.tbl_assignments");*/
		      //writeResultSet(resultSet);
		      
		} catch (ClassNotFoundException e) {
			if(logger.isLoggable(Level.SEVERE)){
				logger.log(Level.SEVERE, "Cannot find the JDBC Driver for MYSQL in MySQLDbHelper", e);
			}
		} catch (SQLException e) {
			if(logger.isLoggable(Level.SEVERE)){
				logger.log(Level.SEVERE, "Unable to perform the SQL Operation in MySQLDbHelper.readData", e);
			}
		}finally{
			//close();
		}
		if(logger.isLoggable(Level.INFO)){
			logger.log(Level.INFO, "Exiting MySQLDbHelper.readData with query and args");
		}
		return resultSet;
	}
	
}
