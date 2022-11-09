package preview.Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * 数据库连接池演示
 */
public class DruidTest01 {
    public static void main(String[] args) throws Exception {
//        打印当前路径
        System.out.println(System.getProperty("user.dir"));


//        导包
//        定义配置文件
//        加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("day03\\src\\druid.properties"));
//        获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
    }
}
