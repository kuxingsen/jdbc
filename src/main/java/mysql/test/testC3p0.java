package mysql.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *需要c3p0-config.xml
 <dependency>
 <groupId>c3p0</groupId>
 <artifactId>c3p0</artifactId>
 <version>0.9.1.2</version>
 </dependency>
 * Created by Kuexun on 2018/4/19.
 */
public class testC3p0 {
    public void test1()
    {
        ComboPooledDataSource myDataSource = new ComboPooledDataSource("testC3p0");
        Connection connection=null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try{
            connection = myDataSource.getConnection();
            String sql = "select * from user";
            preparedStatement = connection.prepareStatement(sql);
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
    public static void main(String[] args) {
        new testC3p0().test1();
    }
}
