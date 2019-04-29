package com.hims.dao.impl;

import com.hims.bean.Date;
import com.hims.dao.BaseDao;
import com.hims.dao.DateDao;
import com.hims.util.ProduceSql;
import com.hims.util.ResultSetToBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DateDaoImpl implements DateDao {
    private final String TABLE_NAME = "date";
    /**
     * 添加 data
     *
     * @param date
     * @return n : 修改的行数
     * 0 : 不返回任何内容的SQL语句
     */
    @Override
    public int insertData(Date date) {
        Connection connection = BaseDao.getConn();
        String sql = ProduceSql.getInsertSql(TABLE_NAME, date);
        int result = BaseDao.executUpdate(connection, sql);
        return result;
    }

    /**
     * 改
     * id 不能为空
     *
     * @param date
     * @return n or 0
     */
    @Override
    public int updateData(Date date) {
        Connection connection = BaseDao.getConn();
        String sql = ProduceSql.getUpdateSql(TABLE_NAME, date);
        int result = BaseDao.executUpdate(connection, sql);
        return result;
    }

    /**
     * 删
     *
     * @param date
     * @return n or 0
     */
    @Override
    public int deleteData(Date date) {
        Connection connection = BaseDao.getConn();
        String sql = ProduceSql.getDeleteSql(TABLE_NAME, date);
        int result = BaseDao.executUpdate(connection, sql);
        return result;
    }

    /**
     * 查1
     * 根据date中第一个非空属性查询
     *
     * @param date
     * @return data
     */
    @Override
    public Date getData(Date date) {
        Date result = new Date();
        Connection connection = BaseDao.getConn();
        String sql = ProduceSql.getSelectSql(TABLE_NAME, date);

        ResultSet resultSet = BaseDao.executQury(connection, sql);
        try {
            if (resultSet.first()) {
                //ResultSetToBean.copy() 通过反射根据给定的结果集当前行与Bean类型创建一个Bean
                result = (Date) ResultSetToBean.copy(resultSet, Date.class);
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
     * 查询 username 全部日程信息
     *
     * @param username
     * @return List<Date> 包含全部日程
     */
    @Override
    public List<Date> getDataList(String username) {
        Connection connection = BaseDao.getConn();
        String sql = "select * from " + TABLE_NAME + " where username = '" + username + "'";
        List<Date> dates = new ArrayList<Date>();
        ResultSet resultSet = null;
        resultSet = BaseDao.executQury(connection,sql);
        try {
            Date date = null;
            if(resultSet != null) {
                while(resultSet.next()) {
                    date = new Date();
                    date = (Date) ResultSetToBean.copy(resultSet, Date.class);
                    dates.add(date);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(null,null,resultSet);
        }
        return dates;
    }
}
