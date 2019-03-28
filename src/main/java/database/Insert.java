package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
  // private static final Logger log = Logger.getLogger("com.my.app");

  public static void insert(String data) {
    String s = data.trim();
    if (s.length() != 0) {
      //获取与数据库的连接
      final Connection conn = DB.getConnection();
      PreparedStatement ps = null;
      // 关闭自动提交
//      boolean autoCommit = conn.getAutoCommit();
//      conn.setAutoCommit(false);
      try {
        ps = conn.prepareStatement("INSERT INTO test (content) VALUES (?)");
        ps.setString(1, s);
        ps.execute();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } finally {
        try {
          if (ps != null) {
            ps.close();
          }
          if (conn != null) {
            conn.close();
          }
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    } else {
      System.out.println("空!!!!");
    }
  }

  public static void main(String[] args) {
    Insert.insert("222222的2");
  }
}
