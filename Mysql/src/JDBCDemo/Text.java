package JDBCDemo;

import JDBCDemo.utils.jdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.StringTokenizer;

public class Text {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // 连接
            connection = jdbcUtils.getConnection();
            // 获得SQL的执行对象
            statement = connection.createStatement();

            int num;
            // 添加
//            String sqlInsert = "insert into linshi values(8,'cky','female')";
//            num = statement.executeUpdate(sqlInsert);

//            // 删除
//            String sqlDelete = "delete from linshi where id = 8";
//            num = statement.executeUpdate(sqlDelete);

            // 修改
//            String sqlUpdate = "update linshi set id = 8,name = 'cky' where id = 10";
//            num = statement.executeUpdate(sqlUpdate);
//            if (num > 0){
//                System.out.println("DONE!");
//            }

            // 查询
//            String sqlQuery = "select name from linshi ";
//            resultSet = statement.executeQuery(sqlQuery);
//            while (resultSet.next()) {
//                System.out.println("name : "+resultSet.getObject("name"));
//            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                jdbcUtils.releaseSources(connection,statement,resultSet);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
