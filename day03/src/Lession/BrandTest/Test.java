package Lession.BrandTest;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

public class Test {
    public static void main(String[] args) throws Exception {
        selectAll();
    }
    public static void selectAll() throws Exception {
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:\\soft\\idea\\Data\\git\\ThirdWeb\\day03\\src\\druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection connection = dataSource.getConnection();

        String sql = "select * from tb_brand";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet resultSet = pstmt.executeQuery();
        ArrayList<Brand> brandlist = new ArrayList<>();
        while (resultSet.next()) {
            /*Integer id;
String brandName;
String companyName;
Integer ordered;
String description;
禁用  1：启用
Integer status;*/
            int id = resultSet.getInt("id");
            String brand_name = resultSet.getString("brand_name");
            String company_name = resultSet.getString("company_name");
            int ordered = resultSet.getInt("ordered");
            String description = resultSet.getString("description");
            int status = resultSet.getInt("status");
            brandlist.add(new Brand(id,brand_name,company_name,ordered,description,status));
        }
        for (Brand brand : brandlist) {
            System.out.println(brand);
        }
    }
}
