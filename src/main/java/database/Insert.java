package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class Insert {
    // private static final Logger log = Logger.getLogger("com.my.app");

    public void insert(String data) {
        String s = data.trim();
        if (s.length() != 0) {
            final DB ds = new DB();
            // 初始化数据库连接池.
            ds.init(10, 50);

            final Connection conn = ds.getConnection();
            Statement stmt = null;
            // 关闭自动提交
//      boolean autoCommit = conn.getAutoCommit();
//      conn.setAutoCommit(false);
            try {
                stmt = conn.createStatement();
                stmt.executeUpdate("INSERT INTO test (content) VALUES ('" + s + "')");

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
//				log.severe(e.toString());
//				System.out.println(e.toString());
                }
            }
        } else {
            System.out.println("空!!!!");
        }
    }

    public static void main(String[] args) {
        new Insert().insert("    的    的     ");
    }
}
