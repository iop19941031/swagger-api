package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

  public static void update(int id, String amend) {
    String data = amend.trim();
    if (data.length() > 0) {
      //获取与数据库的连接
      final Connection conn = DB.getConnection();
      PreparedStatement ps = null;
      try {
        ps = conn.prepareStatement("UPDATE test SET content = ? WHERE id = ?");
        ps.setString(1, data);
        ps.setInt(2, id);
        ps.execute();
      } catch (SQLException e) {
        e.printStackTrace();
      } finally {
        try {
          if (conn != null) {
            conn.close();
          }
        } catch (SQLException e) {
          e.printStackTrace();
        }
        try {
          if (ps != null) {
            ps.close();
          }
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public static void main(String[] args) {
    Update.update(11, "222222的2");
  }
}
