package mysql.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Kuexun on 2018/4/21.
 */
public class C3p0utils {
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource("testC3p0");
    public static DataSource getDataSource()
    {
        return dataSource;
    }
    public static Connection getConnection()
    {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
