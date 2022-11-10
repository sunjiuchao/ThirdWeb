package Lession.JDBC;

import java.sql.*;

public class JDBC_Demo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql:///dau03?useSSL=false";
        String username = "root";
        String password = "123456";

        String sql = "select * from user";

        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet re = pstmt.executeQuery();

        while (re.next()){
            System.out.println(re.getString("name"));
        }


        re.close();
        pstmt.close();
        connection.close();
    }
}
