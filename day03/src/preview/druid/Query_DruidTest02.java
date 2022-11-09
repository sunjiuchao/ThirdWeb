package preview.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;
import preview.JDBC.User;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Query_DruidTest02 {
        @Test
        public void testSelect() throws Exception {
            System.out.println(System.getProperty("user.dir"));

            Properties prop = new Properties();
            prop.load(new FileInputStream("D:\\soft\\idea\\Data\\git\\ThirdWeb\\day03\\src\\druid.properties"));
//        获取连接池对象
            DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
            Connection conn = dataSource.getConnection();

            String sql = "select * from user";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet re = pstmt.executeQuery();

            ArrayList<User> list = new ArrayList<>();

            while (re.next()){
                int id = re.getInt("id");
                String name = re.getString("name");
                double money = re.getDouble("money");
                list.add(new User(id,name,money));
            }
            for (User user : list) {
                System.out.println(user);
            }

            re.close();
            pstmt.close();
            conn.close();
        }
}
