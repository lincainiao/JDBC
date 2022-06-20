package JDBCDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import JDBCDemo.utils.jdbcUtils_DBCP;

public class TestDBCP {
    static Connection connection = null;
    static PreparedStatement statement = null;
    static ResultSet resultSet = null;
    public static void main(String[] args) {
        try {
            connection = jdbcUtils_DBCP.getConnection();
            String sql = "insert into account values (?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setObject(1,"4");
            statement.setObject(2,"D");
            statement.setObject(3,"1500");
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                jdbcUtils_DBCP.release(connection,statement,null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
