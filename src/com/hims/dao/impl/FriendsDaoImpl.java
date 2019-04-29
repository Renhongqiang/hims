package com.hims.dao.impl;

import com.hims.bean.Friends;
import com.hims.dao.BaseDao;
import com.hims.dao.FriendsDao;
import com.hims.util.ProduceSql;
import com.hims.util.ResultSetToBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FriendsDaoImpl implements FriendsDao {
    private final String TABLE_NAME = "friends";
    /**
     * 添加 Friend
     *
     * @param friend
     * @return n : 修改的行数
     * 0 : 不返回任何内容的SQL语句
     */
    @Override
    public int insertFriend(Friends friend) {
        Connection connection = BaseDao.getConn();
        String sql = ProduceSql.getInsertSql(TABLE_NAME, friend);
        int result = BaseDao.executUpdate(connection, sql);
        return result;
    }

    /**
     * 改
     * id 不能为空
     * @param friend
     * @return n or 0
     */
    @Override
    public int updateFriend(Friends friend) {
        Connection connection = BaseDao.getConn();
        String sql = ProduceSql.getUpdateSql(TABLE_NAME, friend);
        int result = BaseDao.executUpdate(connection, sql);
        return result;
    }

    /**
     * 删
     *
     * @param friend
     * @return n or 0
     */
    @Override
    public int deleteUser(Friends friend) {
        Connection connection = BaseDao.getConn();
        String sql = ProduceSql.getDeleteSql(TABLE_NAME, friend);
        int result = BaseDao.executUpdate(connection, sql);
        return result;
    }

    /**
     * 查1
     * 根据friends中第一个非空属性查询
     *
     * @param friends
     * @return friend
     */
    @Override
    public Friends getFriends(Friends friends) {
        Friends result = new Friends();
        Connection connection = BaseDao.getConn();
        String sql = ProduceSql.getSelectSql(TABLE_NAME, friends);

        ResultSet resultSet = BaseDao.executQury(connection, sql);
        try {
            if (resultSet.first()) {
                //ResultSetToBean.copy() 通过反射根据给定的结果集当前行与Bean类型创建一个Bean
                result = (Friends) ResultSetToBean.copy(resultSet, Friends.class);
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
     * 查询 username 全部联系人信息
     * @param username
     * @return List<Friends> 包含全部联系人
     */
    @Override
    public List<Friends> getFriendsList(String username) {
        Connection connection = BaseDao.getConn();
        String sql = "select * from " + TABLE_NAME + " where username = '" + username + "'";
        List<Friends> friendsList = new ArrayList<Friends>();
        ResultSet resultSet = null;
        //通过查询方法获取resultset
        resultSet = BaseDao.executQury(connection,sql);
        //将查询结果放入usersList
        try {
            Friends friends = null;
            if(resultSet != null) {
                while(resultSet.next()) {
                    friends = new Friends();
                    friends = (Friends) ResultSetToBean.copy(resultSet, Friends.class);
                    friendsList.add(friends);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(null,null,resultSet);
        }
        return friendsList;
    }
}
