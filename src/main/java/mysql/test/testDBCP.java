package mysql.test;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 *需要x.properties
 <groupId>commons-dbcp</groupId>
 <artifactId>commons-dbcp</artifactId>
 <version>1.4</version>
 </dependency>
 <dependency>
 <groupId>commons-pool</groupId>
 <artifactId>commons-pool</artifactId>
 <version>1.6</version>
 </dependency>
 * Created by Kuexun on 2018/4/19.
 */
public class testDBCP {
    //手动添加参数
    public void test1()
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/enroll?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("zws19970423");
        try {
            connection = dataSource.getConnection();
            String sql = "UPDATE user set yb_username='张三' where yb_userid=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"1002");
            int num = preparedStatement.executeUpdate();
            System.out.println(num);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    //加载配置文件
    public  void test2()
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/db.properties"));
            DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
            connection = dataSource.getConnection();
            String sql = "UPDATE user set yb_username='王五' where yb_userid=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"1003");
            int num = preparedStatement.executeUpdate();
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new testDBCP().test1();
        new testDBCP().test2();
    }
}
