package com.hims.dao.impl;

import com.hims.bean.User;
import com.hims.dao.BaseDao;
import com.hims.dao.UserDao;
import com.hims.util.ProduceSql;
import com.hims.util.ResultSetToBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private final String TABLE_NAME = "user";

    /**
     * 增 user
     * @param user
     * @return n : 修改的行数
     *         0 : 不返回任何内容的SQL语句
     */
    @Override
    public int insertUser(User user) {
        Connection connection = BaseDao.getConn();
        String sql = ProduceSql.getInsertSql(TABLE_NAME, user);
        int result = BaseDao.executUpdate(connection, sql);
        return result;
    }

    /**
     * 改
     * id 不能为空
     * @param user user.id 不能为空, id 为更新的where条件
     * @return n or 0
     */
    @Override
    public int updateUser(User user) {
        Connection connection = BaseDao.getConn();
        String sql = ProduceSql.getUpdateSql(TABLE_NAME, user);
        int result = BaseDao.executUpdate(connection, sql);
        return result;
    }

    /**
     * 删
     * where条件为 user 中第一个非空属性,建议使用id
     * @param user
     * @return n or 0
     */
    @Override
    public int deleteUser(User user) {
        Connection connection = BaseDao.getConn();
        String sql = ProduceSql.getDeleteSql(TABLE_NAME, user);
        int result = BaseDao.executUpdate(connection, sql);
        return result;
    }

    /**
     * 查1
     * 根据user中第一个非空属性查询用户信息
     * @param user
     * @return User
     */
    @Override
    public User getUser(User user) {
        User result = new User();
        Connection connection = BaseDao.getConn();
        String sql = ProduceSql.getSelectSql(TABLE_NAME, user);

        ResultSet resultSet = BaseDao.executQury(connection, sql);
        try {
            if (resultSet.first()) {
                //ResultSetToBean.copy() 通过反射根据给定的结果集当前行与Bean类型创建一个Bean
                result = (User) ResultSetToBean.copy(resultSet, User.class);
            }
            else {
                //未查到
                result = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(null,null,resultSet);
        }
        return result;
    }

    /**
     * 查2
     * 查询全部用户信息
     * @return List<User> 包含全部用户
     */
    @Override
    public List<User> getUserList() {
        Connection connection = BaseDao.getConn();
        String sql = "select * from user";
        List<User> usersList = new ArrayList<User>();
        ResultSet resultSet = null;
        //通过查询方法获取resultset
        resultSet = BaseDao.executQury(connection,sql);
        //将查询结果放入usersList
        try {
            User user = null;
            while(resultSet.next()) {
                user = new User();
                user = (User) ResultSetToBean.copy(resultSet, User.class);
                usersList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(null,null,resultSet);
        }
        return usersList;
    }
}
