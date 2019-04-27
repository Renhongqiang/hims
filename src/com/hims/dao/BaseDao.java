package com.hims.dao;

import com.hims.ConfigManager;

import java.sql.*;

public class BaseDao {
    private static Connection conn;

    public static Connection getConn() {
        if (conn == null) {
            conn = getConnection();
            return conn;
        } else {
            return conn;
        }
    }

    //获取connaction
    private static Connection getConnection() {
        String driver = ConfigManager.getProperty("driver");
        String url = ConfigManager.getProperty("url");
        String user = ConfigManager.getProperty("user");
        String password = ConfigManager.getProperty("password");
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //执行查询的方法
    public static ResultSet executQury(Connection connection, String sql, Object...params) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            for(int i = 0; i < params.length; i++) {
                ps.setObject(i+1,params[i]);
            }
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    //执行查询的方法 直接根据sql语句，无 params[] 参数
    public static ResultSet executQury(Connection connection, String sql) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    //删除、修改、更新
    public static int executUpdate(Connection connection,String sql,Object...params) {
        int result = 0;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            for(int i = 0; i < params.length; i++) {
                ps.setObject(i+1,params[i]);
            }
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //删除、修改、更新 直接根据sql语句，无 params[] 参数
    public static int executUpdate(Connection connection,String sql) {
        int result = 0;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    //关闭
    public static void closeAll(Connection connection,PreparedStatement ps,ResultSet rs) {
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
