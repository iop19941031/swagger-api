package database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 * 数据库连接池.
 *
 * @author H
 */
public class DB {
    private HikariDataSource ds;
    private static final Logger log = Logger.getLogger("com.my.db");

    /**
     * 初始化连接池.
     *
     * @param minimum 池中最小空闲链接数量
     * @param maximum 池中最大链接数量
     */
    public void init(int minimum, int maximum) {
        // 连接池配置
        final HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.MariaDbDataSource");
        config.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test"
                + "?user=root&password=H171023&useUnicode=true&characterEncoding=utf8");
        config.addDataSourceProperty("cachePrepStmts", true);
        config.addDataSourceProperty("prepStmtCacheSize", 500);
        config.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
        config.setConnectionTestQuery("SELECT 1");
        config.setAutoCommit(true);
        config.setMinimumIdle(minimum);
        config.setMaximumPoolSize(maximum);

        ds = new HikariDataSource(config);
    }

    /**
     * 返回数据库连接.
     * @return 返回数据库连接或者返回个空值
     */
    public Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            log.severe(e.toString());
            return null;
        }
    }

//    public static void main(String[] args) {
//        Connection conn = null;
//        Statement stmt = null;
//        try {
//            DB db = new DB();
//            db.init(5, 10);
//            // 打开链接
//            System.out.println("连接数据库...");
//            conn = db.getConnection();
//
//            // 执行查询
//            System.out.println(" 实例化Statement对象...");
//            stmt = conn.createStatement();
//            String sql;
//            sql = "SELECT content FROM test";
//            ResultSet rs = stmt.executeQuery(sql);
//
//            // 展开结果集数据库
//            while (rs.next()) {
//                // 通过字段检索
//                String name = rs.getString("content");
//
//                // 输出数据
//                System.out.println(", 站点名称: " + name);
//            }
//            // 完成后关闭
//            rs.close();
//            stmt.close();
//            conn.close();
//        } catch (SQLException se) {
//            // 处理 JDBC 错误
//            se.printStackTrace();
//        } catch (Exception e) {
//            // 处理 Class.forName 错误
//            e.printStackTrace();
//        } finally {
//            // 关闭资源
//            try {
//                if (stmt != null)
//                    stmt.close();
//            } catch (SQLException se2) {
//            } // 什么都不做
//            try {
//                if (conn != null)
//                    conn.close();
//            } catch (SQLException se) {
//                se.printStackTrace();
//            }
//        }
//        System.out.println("Go2odbye!");
//    }
}