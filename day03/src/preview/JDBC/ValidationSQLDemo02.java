package preview.JDBC;

import java.sql.*;

public class ValidationSQLDemo02 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql:///dau03?useSSL=false";
        String username = "root";
        String password = "123456";

        Connection conn = DriverManager.getConnection(url, username, password);//连接数据库

        String usename = "孙久超";
//        String pwd = "'or' 1 ' = ' 1";//注入
        String pwd = "123456";

        String sql = "select * from user where name = ? and password = ?";//sql语句

        PreparedStatement pstmt = conn.prepareStatement(sql);//获取执行sql对象,防注入对象
//        设置?的值
        pstmt.setString(1,usename);
        pstmt.setString(2,pwd);
        ResultSet re = pstmt.executeQuery();


        if (re.next()){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
        re.close();
        pstmt.close();
        conn.close();
    }
}

