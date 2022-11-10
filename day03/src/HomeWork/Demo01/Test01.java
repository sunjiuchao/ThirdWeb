package HomeWork.Demo01;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class Test01 {
    public static void main(String[] args) throws Exception {
//        1. 查询出所有的数据，并将每一条数据封装到Student实体类对象中存储到List集合中
//        method01();
//        2. 查询出id是 `2` 的数据并封装到一个 Student 对象中
//        qureymethod02();
//        3. 往表中添加如下数据
//           周芷若 20 北京昌平 女 13678529961 1315-05-21
//        addmethod3();

//        4. 修改 `张三丰` 的家庭住址为 `北京海淀区`
//        updateMethod();
//        5. 删除id为 `2` 的数据
//        deleteMethod();


    }

    private static void deleteMethod() throws Exception {
        Properties prop = new Properties();
        ArrayList<Student> list = new ArrayList<>();
        prop.load(new FileInputStream("D:\\soft\\idea\\Data\\git\\ThirdWeb\\day03\\src\\druid.properties"));
//        获取连接池对象

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();

        String sql = "delete from student where id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,2);
        int i = pstmt.executeUpdate();

        System.out.println(i);

        pstmt.close();
        conn.close();
    }

    private static void updateMethod() throws Exception {
        Properties prop = new Properties();
        ArrayList<Student> list = new ArrayList<>();
        prop.load(new FileInputStream("D:\\soft\\idea\\Data\\git\\ThirdWeb\\day03\\src\\druid.properties"));
//        获取连接池对象

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();

        String sql = "update student set address = ? where name = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "北京海淀区");
        pstmt.setString(2,"张三丰");
        int i = pstmt.executeUpdate();

        System.out.println(i);
        pstmt.close();
        conn.close();
    }

    private static void addmethod3() throws Exception {
        Properties prop = new Properties();
        ArrayList<Student> list = new ArrayList<>();
        prop.load(new FileInputStream("D:\\soft\\idea\\Data\\git\\ThirdWeb\\day03\\src\\druid.properties"));
//        获取连接池对象

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();

        String sql = "insert into student (name,age,address,gender,phone,birthday) value ('周芷若',20,'北京昌平','女','13678529961','1315-05-21')";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        int i = pstmt.executeUpdate();

        System.out.println(i);
        pstmt.close();
        conn.close();
    }

    private static void qureymethod02() throws Exception {
        Properties prop = new Properties();
        ArrayList<Student> list = new ArrayList<>();
        prop.load(new FileInputStream("D:\\soft\\idea\\Data\\git\\ThirdWeb\\day03\\src\\druid.properties"));
//        获取连接池对象

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();

        String sql = "select * from Student where id = 2";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet re = pstmt.executeQuery();

        while (re.next()) {
            String name = re.getString("name");
            int age = re.getInt("age");
            String address = re.getString("address");
            String gender = re.getString("gender");
            String phone = re.getString("phone");
            Date birthday = re.getDate("birthday");
            list.add(new Student(name, age, address, gender, phone, birthday));
        }

        System.out.println(list);
        pstmt.close();
        conn.close();
    }

    private static void method01() throws Exception {
        Properties prop = new Properties();
        ArrayList<Student> list = new ArrayList<>();
        prop.load(new FileInputStream("D:\\soft\\idea\\Data\\git\\ThirdWeb\\day03\\src\\druid.properties"));
//        获取连接池对象

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();

        String sql = "select * from Student";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet re = pstmt.executeQuery();
        while (re.next()) {
            String name = re.getString("name");
            int age = re.getInt("age");
            String address = re.getString("address");
            String gender = re.getString("gender");
            String phone = re.getString("phone");
            Date birthday = re.getDate("birthday");

            list.add(new Student(name, age, address, gender, phone, birthday));
        }

        for (Student student : list) {
            System.out.println(student);
        }
        pstmt.close();
        conn.close();
    }
}
