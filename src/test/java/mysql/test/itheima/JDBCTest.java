package mysql.test.itheima;

import mysql.test.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Kuexun on 2018/4/19.
 */
public class JDBCTest {
    @Test
    public void testJDBCUtil()
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs=null;
      //  conn = JDBCUtil_1.getConnection();
       // conn = JDBCUtil_2.getConnection();
        conn = JDBCUtil_3.getConnection();

        String sql = "select * from user where yb_userid=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,"1001");
            rs = pstmt.executeQuery();
            try {
                while(rs.next())
                {
                    System.out.print(rs.getString("yb_userid"));
                    System.out.print(rs.getString("yb_username"));
                    System.out.print(rs.getString("yb_sex"));
                    System.out.println(rs.getString("phonenumber"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil_3.release(conn,pstmt,rs);
        }
    }

    @Test
    public void testMyDataSource()
    {
        MyDataSource myDataSource = new MyDataSource();
        Connection connection=null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try{
            connection = myDataSource.getConnection();
            String sql = "select * from user where yb_userid=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"1002");
            rs = preparedStatement.executeQuery();
            try {
                while(rs.next())
                {
                    System.out.print(rs.getString("yb_userid"));
                    System.out.print(rs.getString("yb_username"));
                    System.out.print(rs.getString("yb_sex"));
                    System.out.println(rs.getString("phonenumber"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(preparedStatement != null)
                    preparedStatement.close();
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
