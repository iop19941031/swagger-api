package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.MessageData;

public class Select {
  public static MessageData select(int id) {
    final Connection conn = DB.getConnection();
    PreparedStatement ps = null;
    MessageData md = new MessageData();
    try {
      ps = conn.prepareStatement("select * from test where id = ?");
      ps.setInt(1, id);
      ResultSet rs =  ps.executeQuery();
      while (rs.next()) {
        md.setId(rs.getInt(1));
        md.setContent(rs.getString(2));
        md.setTime(rs.getString(3));
      }
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
    return md;
  }

  public static void main(String[] args) {
    System.out.println(Select.select(10));
  }
}
