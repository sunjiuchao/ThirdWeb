package preview.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlCommitDemo02 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql:///dau03?useSSL=false";
        String username = "root";
        String password = "123456";

        Connection connection = DriverManager.getConnection(url, username, password);
        Statement stmt = connection.createStatement();

//        开启事务
        try {
            connection.setAutoCommit(false);
            String sql1 = "update user set money = 600 where name = '李达' ";
            int re1 = stmt.executeUpdate(sql1);
            System.out.println(re1);
            int s = 3/0;
            String sql2 = "update user set money = 700 where name = '李达' ";
            int re2 = stmt.executeUpdate(sql2);
            System.out.println(re2);

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.getStackTrace();
        }
    }
}
