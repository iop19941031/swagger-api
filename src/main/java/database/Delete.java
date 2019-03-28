package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {

  /**
   * 删除数据库某段数据
   *
   * @param id 某段数据的id.
   */
  public static void delete(int id) {
    final Connection conn = DB.getConnection();
    PreparedStatement ps = null;
    try {
      ps = conn.prepareStatement("DELETE FROM test WHERE id = ?");
      ps.setInt(1, id);
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

  public static void main(String[] args) {
    Delete.delete(21);
  }
}
