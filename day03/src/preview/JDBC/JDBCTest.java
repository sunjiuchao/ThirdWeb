package preview.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCTest {
    public static void main(String[] args) throws Exception {
//        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql:///day02?useSSL=false";

        String username = "root";
        String password = "123456";

        Connection conn = DriverManager.getConnection(url, username, password);//连接数据库

        Statement stmt = conn.createStatement();//获取执行sql对象

        String sql = "select jname from job";//sql语句
        boolean result = stmt.execute(sql);//执行语句

        System.out.println(result);


    }
}
