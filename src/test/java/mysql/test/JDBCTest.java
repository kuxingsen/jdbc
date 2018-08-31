package mysql.test;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Kuexun on 2018/4/18.
 */
public class JDBCTest {
    @Test
    public void testJDBCUtil()
    {
        //int num = JDBCUtil.executeInsert("insert into user values('1002','aaa','bbb','ccc')");
       // System.out.println(num);
        //int num = JDBCUtil.executeDelete("delete from user where yb_userid='1002'");
       // System.out.println(num);
       // int num = JDBCUtil.executeUpdate("update user set yb_username='里斯',yb_sex='男',phonenumber='12345678912' where yb_userid='1001'");
       // System.out.println(num);

        ResultSet rs = JDBCUtil.executeQuery("select * from user");
        try {
            while(rs.next())
            {
                System.out.print(rs.getString("yb_userid"));
                System.out.print(rs.getString("yb_username"));
                System.out.print(rs.getString("yb_sex"));
                System.out.print(rs.getString("phonenumber"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPreparedStatementJDBC()
    {
        //int num = PreparedStatementJDBC.executeInsert("insert into user values('1003','aaa','bbb','ccc')");
        // System.out.println(num);

        ResultSet rs = JDBCUtil.executeQuery("select * from user");
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
    }
}
