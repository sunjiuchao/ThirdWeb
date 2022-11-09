package preview.JDBC;

import java.sql.*;

public class ValidationSQLDemo01 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql:///dau03?useSSL=false";
        String username = "root";
        String password = "123456";

        Connection conn = DriverManager.getConnection(url, username, password);//连接数据库

        Statement stmt = conn.createStatement();//获取执行sql对象

        String usename = "孙久超";
        String pwd = "'or' 1 ' = ' 1";//注入

        String sql = "select * from user where name = '"+usename+"' and password ='"+pwd+"' ";//sql语句
        ResultSet resultSet = stmt.executeQuery(sql);

        System.out.println(resultSet);
        resultSet.close();
        stmt.close();
        conn.close();
    }
}
