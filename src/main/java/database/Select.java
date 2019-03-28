package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {
  public static void select(int id) {
    final Connection conn = DB.getConnection();
    PreparedStatement ps = null;
    try {
      ps = conn.prepareStatement("select * from test where id = ?");
      ps.setInt(1, id);
      ResultSet rs =  ps.executeQuery();
      while (rs.next()) {
        System.out.println(rs.getInt(1));
        System.out.println(rs.getString(2));
        System.out.println(rs.getString(3));
      }
      System.out.println(111111111);
    } catch (Exception e) {
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
  }

  public static void main(String[] args) {
    Select.select(10);
  }
}
