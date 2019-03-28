package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接池.
 *
 * @author H
 */
public class DB {

  /**
   * 返回数据库连接.
   *
   * @return 返回数据库连接或者返回个空值
   */
  public static Connection getConnection() {
    Connection conn = null;
    try {
      Class.forName("org.mariadb.jdbc.Driver");
      //获取与数据库的连接
      conn = DriverManager.getConnection(
          "jdbc:mariadb://127.0.0.1:3306/test?"
              + "user=root"
              + "&password=H171023"
              + "&useUnicode=true&characterEncoding=utf8");
    } catch (ClassNotFoundException cfe) {
      System.out.println(cfe.toString());
    } catch (SQLException sqle) {
      System.out.println(sqle.toString());

    }

    return conn;
  }

}