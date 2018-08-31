package mysql.test;

import java.sql.*;

/**
 * 使用预编译jdbc链接
 * Created by Kuexun on 2018/4/19.
 */
public class PreparedStatementJDBC {
    private static Connection conn = null;
    private static ResultSet rs = null;
    private static final String DatabaseDriver = "com.mysql.cj.jdbc.Driver";
    private static String DatabaseConnStr = "jdbc:mysql://localhost:3306/enroll?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false";
    private static final String User = "root";
    private static final String Pass = "zws19970423";

    public String getDatabaseConnStr() {
        return DatabaseConnStr;
    }

    public static void setDatabaseConnStr(String databaseConnStr) {
        DatabaseConnStr = databaseConnStr;
    }

    public String getDatabaseDriver() {
        return DatabaseDriver;
    }

    static {
        try {
            Class.forName(DatabaseDriver);
            conn = DriverManager.getConnection(DatabaseConnStr,User,Pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getString(String name) throws SQLException {
        if(rs == null)
        {
            return ("ResuleSet is null");
        }
        return String.valueOf(rs.getString(name));
    }

    private static int execute(String sql)
    {
        int num = 0;
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            num = pstmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt != null)
                {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return num;
    }
    public static int executeInsert(String sql)
    {
        return execute(sql);
    }
    public static int executeDelete(String sql)
    {
        return execute(sql);
    }
    public static int executeUpdate(String sql)
    {
        return execute(sql);
    }
    public static ResultSet executeQuery(String sql)
    {
        rs = null;
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(pstmt != null)
                {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }
    public static void CloseDatabase()
    {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
