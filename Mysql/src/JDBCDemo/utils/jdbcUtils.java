package JDBCDemo.utils;

// 工具类
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class jdbcUtils {
    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;

    static {
        try {
            InputStream in = jdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(in);

            driver = properties.getProperty("driver");
            username = properties.getProperty("username");
            password = properties.getProperty("password");
            url = properties.getProperty("url");

            // 加载驱动，驱动只要加载一次
            Class.forName(driver);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // 获取连接
    public static Connection getConnection() throws Exception{
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    // 释放资源
    public static void releaseSources(Connection connection, Statement statement, ResultSet resultSet) throws Exception{
        if (resultSet != null) {
            resultSet.close();
        }
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}
