package JDBCDemo;
import JDBCDemo.utils.jdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 事务transaction
public class Demo04 {
    static Connection connection = null;
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;
    public static void main(String[] args) {
        try {
            connection = jdbcUtils.getConnection();

            // 关闭事务自动提交，会自动开启事务
            connection.setAutoCommit(false);
            String sql1 = "update account set money = money-100 where id = ?";
            statement = connection.prepareStatement(sql1);
            statement.setObject(1,"1");
            statement.executeUpdate();

            String sql2 = "update account set money = money+100 where id = ?";
            statement = connection.prepareStatement(sql2);
            statement.setObject(1,"2");
            statement.executeUpdate();

            // 提交事务
            connection.commit();
            System.out.println("DONE!");

        } catch (Exception e) {
            try {
                // 如果事务失败则回滚，默认回滚，即使不写，也会回滚
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
        }
    }
}
