package JDBCDemo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import JDBCDemo.utils.jdbcUtils;

/*
* PrepareStatement：可以防止sql注入问题
* */
public class Demo03 {
    static Connection connection = null;
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;
    public static void main(String[] args) {
        try {
            connection = jdbcUtils.getConnection();

            // 区别
            // 用?占位符代替参数
//            String sqlInsert = "insert into linshi values(?,?,?)";
            // 预编译SQL，先写sql，不执行
//            statement = connection.prepareStatement(sqlInsert);
            // 手动给参数赋值
//            statement.setObject(1,"6"); // 参数下标和值，下标从1开始
//            statement.setObject(2,"name");
//            statement.setObject(3,"female");

            //sql.Date 数据库使用的Date
            //utils.Date java使用的Date
//            statement.setDate(4,new java.sql.Date(new java.util.Date().getTime())); // 日期类


            // 删除
//            String sqlDelete = "delete from linshi where id = ?";
//            statement = connection.prepareStatement(sqlDelete);
//            statement.setObject(1,"3");

            // 更新
//            String sqlUpdate = "update linshi set id = ?,name = ? where id = ?";
//            statement = connection.prepareStatement(sqlUpdate);
//            statement.setObject(1,"11");
//            statement.setObject(2,"llllll");
//            statement.setObject(3,"6");

            // 查询
            String sqlQuery = "select * from linshi where id = ? and sex = ?";
            statement = connection.prepareStatement(sqlQuery);
            statement.setObject(1,"2");
            statement.setObject(2,"female");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getObject("name"));
            }


//            int num;
//            // 执行
//            num = statement.executeUpdate();
//            if (num > 0){
//                System.out.println("Done!");
//            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                jdbcUtils.releaseSources(connection,statement,null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
