package Lession.JDBC;

import org.junit.Test;

import java.sql.*;

public class JDBC_Demo02 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql:///dau03?useSSL=false";
        String username = "root";
        String password = "123456";

        Connection connection = DriverManager.getConnection(url, username, password);

        long l = System.currentTimeMillis();
        String s = String.valueOf(l);
        String time = s.substring(0, s.length() - 3);
        int datetime = Integer.parseInt(time);



//        String sql = " insert into user (name,password,money,createtime) values ('静奶奶','123456','200','"+datetime+"')";
        String sql = " update user set password = '098765',updatetime = '"+datetime+"'  where name = '孙久超'";

        Statement stmt = connection.createStatement();
        int i = stmt.executeUpdate(sql);

        System.out.println(i);


        stmt.close();
        connection.close();
    }
}
