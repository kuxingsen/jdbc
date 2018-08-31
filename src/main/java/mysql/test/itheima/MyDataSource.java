package mysql.test.itheima;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * 自定义连接池//感觉像装饰类
 * Created by Kuexun on 2018/4/19.
 */
public class MyDataSource implements DataSource{
    //创建一个List集合存放多个连接对象
    private List<Connection> list = new ArrayList<Connection>();
    public MyDataSource()
    {
        for (int i = 0; i < 3;i ++)
        {
            Connection conn = JDBCUtil_3.getConnection();
            list.add(conn);
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        if(list.isEmpty())
        {
            for (int i = 0; i < 3;i ++)
            {
                Connection conn = JDBCUtil_3.getConnection();
                list.add(conn);
            }
        }
        Connection connection = list.remove(0);
        MyConnection myConnection = new MyConnection(connection,list);
        return myConnection;
    }
    public void addBack(Connection conn)
    {
        list.add(conn);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }


    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
