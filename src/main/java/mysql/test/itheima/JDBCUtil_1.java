package mysql.test.itheima;

import java.sql.*;

/**
 *提供获取连接和释放资源的 方法
 * Created by Kuexun on 2018/4/19.
 */
public class JDBCUtil_1 {

    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/enroll?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";
    private static final String username = "root";
    private static final String password = "zws19970423";

    public static Connection getConnection()
    {

        Connection conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username,password);
            return conn;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void release(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
