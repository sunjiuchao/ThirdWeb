package preview.JDBC;

import CustClass.TimeSecond;

import java.sql.*;
import java.util.ArrayList;

public class MysqlResultSetDome01 {
    public static void main(String[] args) throws SQLException {
        ArrayList<User> list = new ArrayList<>();

        String url = "jdbc:mysql:///dau03?useSSL = false";
        String username = "root";
        String password = "123456";
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement stmt = connection.createStatement();
        TimeSecond ts = new TimeSecond();
        String Q1= "select * from user";

        ResultSet re = stmt.executeQuery(Q1);
        while (re.next()){
//            int id = re.getInt(1);
//            String name = re.getString(2);
//            double money = re.getDouble(4);
            int id = re.getInt("id");
            String name = re.getString("name");
            double money = re.getDouble("money");
            list.add(new User(id,name,money));
        }
        for (User user : list) {
            System.out.println(user);
        }
        re.close();
        stmt.close();
        connection.close();
    }
}
