package com.vbiso.mysql.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 18:50 2019-05-25
 * @Modified By:
 */
public class BasicMysqlManager {


  private static final String url = "jdbc:mysql://localhost:3307/botserver";

  private static final String user = "root";

  private static final String password = "root";


  static {
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      System.exit(-1);
    }
  }

  public static void main(String[] args){

    Connection connection = null;

    try {
      connection = DriverManager.getConnection(url, user, password);

      connection.setAutoCommit(false);

      connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

      Statement statement = connection.createStatement();

      String sql = "select * from book";

      ResultSet resultSet = statement.executeQuery(sql);

      while (resultSet.next()){
        int id = resultSet.getInt("id");
        System.out.println(id);
      }

      connection.commit();


    } catch (SQLException e) {
      if(Objects.nonNull(connection)){
        try {
          //System.out.println("开始回滚");
          connection.rollback();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
      e.printStackTrace();
    }finally {
      if(Objects.nonNull(connection)){
        try {
          connection.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }

}
