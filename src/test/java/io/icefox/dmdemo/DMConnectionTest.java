package io.icefox.dmdemo;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DMConnectionTest {


    public static Connection getConnection() {
        //数据库连接名
        String username = "SYSDBA";
        //数据库连接密码
        String password = "root@admin123";
        String driver = "dm.jdbc.driver.DmDriver";
        //String url = "jdbc:dm://192.168.1.8:5236";
        String url = "jdbc:dm://10.50.22.200:5236/";
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void getSelect() {
        //sql
        String sql = " SELECT name,id FROM SYSDBA.\"user\"";
        //获取连接
        Connection connection = getConnection();
        PreparedStatement pst = null;

        List<String> list = new ArrayList<>();
        try {
            pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("NAME"));
                list.add(rs.getString("ID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws SQLException {

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:dm://10.50.22.200:5236/");
        druidDataSource.setDriverClassName("dm.jdbc.driver.DmDriver");
        druidDataSource.setPassword("root@admin123");
        druidDataSource.setUsername("SYSDBA");
        DruidPooledConnection connection = druidDataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT id,username FROM SYSDBA.f_user");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("id"));
            System.out.println(resultSet.getString("username"));
        }

    }
}
