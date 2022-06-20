package JDBCDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 第一份JDBC程序
 */
public class Demo01 {
    public static void main(String[] args) throws Throwable{
        // 1.加载驱动
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class c = Class.forName("com.mysql.jdbc.Driver"); // 固定写法
        // 2.连接信息，需要用户信息和url
        String url = "jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&useSSL=true";
        String username = "root";
        String psw = "root";

        // 3.连接成功，数据库对象 connection 代表数据库
        Connection connection = DriverManager.getConnection(url, username, psw);

        // 4.执行SQL的对象
        Statement statement = connection.createStatement();// 执行SQL的对象

        // 5.通过执行SQL对象 去 执行SQL，可能存在结果，查看返回
        String sql = "select NAME from users";

        // 插入
        String sqlInsert = "insert into users(字段) values(值)";
        int num = statement.executeUpdate(sqlInsert);
        if (num > 0) {
            System.out.println("插入成功");
        }

        ResultSet resultSet = statement.executeQuery(sql); // 返回结果集，结果集中，分装了查询的所有结果
        while (resultSet.next()){
            System.out.println("name : " + resultSet.getObject("NAME"));
        }

        // 6.释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
