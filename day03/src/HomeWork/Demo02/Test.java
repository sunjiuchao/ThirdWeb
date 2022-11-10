package HomeWork.Demo02;

import CustClass.TimeSecond;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {
    public static void main(String[] args) throws Exception {
//订单详情数据
        OrderDetail orderDetail = new OrderDetail();
//订单中商品的名称
        orderDetail.setName("华为Meta50");
//订单中该商品的数量
        orderDetail.setNumber(2);
//该商品的单价
        orderDetail.setAmount(6000);

        OrderDetail orderDetail2 = new OrderDetail();
//订单中商品的名称
        orderDetail2.setName("MetaBook X Pro");
//订单中该商品的数量
        orderDetail2.setNumber(2);
//该商品的单价
        orderDetail2.setAmount(9299);

        List<OrderDetail> list = new ArrayList<>();
        list.add(orderDetail);
        list.add(orderDetail2);

//订单数据
        Orders orders = new Orders();
        orders.setId(1);
//使用UUID生成一个订单号
        String number = UUID.randomUUID().toString();
        orders.setNumber(number);
//下单后默认就是 "待付款"
        orders.setStatus(1);
//支付方式默认是 "微信支付"
        orders.setPayMethod(1);
//下单时间即为系统当前时间
        orders.setOrderTime(new Date());
//总金额，需要将订单中所有的商品的价格总和
        double amount = 0;
        for (OrderDetail detail : list) {
            amount += detail.getNumber() * detail.getAmount();
        }
        orders.setAmount(amount);
//收货地址
        orders.setAddress("北京西三旗");
//收货人手机号
        orders.setPhone("17621234235");

        ArrayList<Orders> orlist = new ArrayList<>();
        orlist.add(orders);

//        开启事物
        Properties prop = new Properties();
        prop.load(new FileInputStream("D:\\soft\\idea\\Data\\git\\ThirdWeb\\day03\\src\\druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = dataSource.getConnection();


        try {
            conn.setAutoCommit(false);
            for (OrderDetail detail : list) {
                String name = detail.getName();
                int orderId = detail.getOrderId();
                int number1 = detail.getNumber();
                double amount1 = detail.getAmount();

                String sql = "insert into order_detail (name,order_id,number,amount) value (?,?,?,?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, name);
                pstmt.setInt(2, orderId);
                pstmt.setInt(3, number1);
                pstmt.setDouble(4, amount1);
                int i = pstmt.executeUpdate();
                System.out.println(i);
            }

            for (Orders orders1 : orlist) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String format = sdf.format(orders1.getOrderTime());
                String number1 = orders1.getNumber();
                int status = orders1.getStatus();
                int payMethod = orders1.getPayMethod();
                double amount1 = orders1.getAmount();
                String phone = orders1.getPhone();
                String address = orders1.getAddress();

                String sql = "insert into orders (number,status,order_time,pay_method,amount,phone,address) value (?,?,?,?,?,?,?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setString(1, number1);
                pstmt.setInt(2, status);
                pstmt.setString(3, format);
                pstmt.setInt(4, payMethod);
                pstmt.setDouble(5, amount1);
                pstmt.setString(6, phone);
                pstmt.setString(7, address);
                int i = pstmt.executeUpdate();
                System.out.println(i);
            }
            conn.commit();
        } catch (SQLException e) {
            System.out.println("defail");
            conn.rollback();
        }
    }
}
