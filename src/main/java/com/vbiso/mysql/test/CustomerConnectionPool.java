package com.vbiso.mysql.test;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @Author: wenliujie
 * @Description:
 * @Date: Created in 19:27 2019-05-25
 * @Modified By:
 */
public class CustomerConnectionPool {


  private  LinkedList<Connection> connectionPool = new LinkedList<>();


  private enum Holder{
    INSTANCE;

    public CustomerConnectionPool instance(){
      return new CustomerConnectionPool();
    }
  }

  public static CustomerConnectionPool getInstance(){
    return Holder.INSTANCE.instance();
  }

  public CustomerConnectionPool() {
    for(int i = 0; i< 10; i++){
      connectionPool.add(CustomerMysqlConnectionManager.getConnection());
    }
  }
}
