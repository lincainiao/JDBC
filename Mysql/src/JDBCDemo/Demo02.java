package JDBCDemo;
import JDBCDemo.utils.jdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/*
* SQL注入问题
* */
public class Demo02 {
    static Connection connection = null;
    static Statement statement = null;
    static ResultSet resultSet = null;
    public static void main(String[] args) {
        Demo02 demo02 = new Demo02();
        // 正常登录
        login("zsy","3");

    }

    // 登录
    public static void login(String username,String password){
        try {
            connection = jdbcUtils.getConnection();
            statement = connection.createStatement();

            // select * from linshi where name = 'zsy' and id = 3
            String sql = "select * from linshi where name = '"+username+"' and id = '"+password+"'";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getObject("name")+" : "+resultSet.getObject("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
