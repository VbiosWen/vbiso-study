package com.vbiso.mysql.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 19:18 2019-05-25
 * @Modified By:
 */
public class CustomerMysqlConnectionManager {

  private static final String url = "jdbc:mysql://localhost:3307/botserver";

  private static final String user = "root";

  private static final String password = "root";

  static {
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      System.out.println("load driver error");
      System.exit(-1);
    }
  }

  public static Connection getConnection() {
    try {
      return DriverManager.getConnection(url,user,password);
    } catch (SQLException e) {
      e.printStackTrace();
      System.exit(-1);
    }
    return null;
  }

  public static void close(Connection connection){
    try {
      if (Objects.nonNull(connection)){
        connection.close();
      }
    } catch (SQLException e) {
      System.out.println("connection release failed.");
      e.printStackTrace();
    }
  }

  public static void close(Statement statement){
    try {
      if(Objects.nonNull(statement)){
        statement.close();
      }
    } catch (SQLException e) {
      System.out.println("statement release failed.");
      e.printStackTrace();
    }
  }

}
