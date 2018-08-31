package mysql.test.DBUtil;

import mysql.test.C3p0utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 需要c3p0util,c3p0-config.xml,bean
 *
 <dependency>
 <groupId>commons-dbutils</groupId>
 <artifactId>commons-dbutils</artifactId>
 <version>1.6</version>
 </dependency>
 * Created by Kuexun on 2018/4/21.
 */
public class testDBUtil {
    //增删改
    public void test()
    {
        QueryRunner runner = new QueryRunner(C3p0utils.getDataSource());
        String sql = "insert into user values(?,?,?,?)";
        Object[] param = {"1005","asd","士大夫","sad"};
        try {
            int rows = runner.update(sql,param);
            System.out.println(rows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //查询所有
    public void testQueryAll1()
    {
        QueryRunner runner = new QueryRunner(C3p0utils.getDataSource());
        String sql = "select * from user";
        try {
            List<User> users = runner.query(sql, new BeanListHandler<>(User.class));
            for(User user:users)
            {
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //查询所有
    public void testQueryAll2()
    {
        QueryRunner runner = new QueryRunner(C3p0utils.getDataSource());
        String sql = "select * from user";
        try {
            List<Map<String, Object>> users = runner.query(sql, new MapListHandler());
            for(Map user:users)
            {
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //查询一条
    public void testQueryById()
    {
        QueryRunner runner = new QueryRunner(C3p0utils.getDataSource());
        String sql = "select * from user where yb_userid=?";
        try {
            Object[] params={"1005"};
            User user = runner.query(sql, new BeanHandler<>(User.class),params);
            System.out.println(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //查询个数
    public void testQueryCount()
    {
        QueryRunner runner = new QueryRunner(C3p0utils.getDataSource());
        String sql = "select count(*) from user";
        try {
            Long num = (Long)runner.query(sql, new ScalarHandler());
            System.out.println(num);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //查询指定列
    public void testQueryColumn()
    {
        QueryRunner runner = new QueryRunner(C3p0utils.getDataSource());
        String sql = "select * from user";
        try {
            Object yb_usernameList = runner.query(sql, new ColumnListHandler("yb_username"));
            System.out.println(yb_usernameList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
       // new testDBUtil().test();
       // new testDBUtil().testQueryAll1();
       // new testDBUtil().testQueryById();
       // new testDBUtil().testQueryCount();
       // new testDBUtil().testQueryAll2();
        new testDBUtil().testQueryColumn();
    }
}
