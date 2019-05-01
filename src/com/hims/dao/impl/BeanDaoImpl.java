package com.hims.dao.impl;

import com.hims.dao.BaseDao;
import com.hims.dao.BeanDao;
import com.hims.util.ProduceSql;
import com.hims.util.ResultSetToBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BeanDaoImpl implements BeanDao {

    /**
     * 根据实体类 t 类型获取对应表名即实体类名小写
     * @param t
     * @param <T>
     * @return
     */
    private static <T> String getTableName(T t) {
        String[] names = t.getClass().getName().toString().split("\\.");
        return names[names.length - 1].toLowerCase();
    }

    /**
     * 根据 Class 类型获取对应表名即实体类名小写
     * @param clazz
     * @return
     */
    private static String getTableName(Class clazz) {
        String[] names = clazz.getName().toString().split("\\.");
        return names[names.length - 1].toLowerCase();
    }

    /**
     * 添加 bean
     *
     * @param bean
     * @return n : 修改的行数
     * 0 : 不返回任何内容的SQL语句
     */
    @Override
    public <T> int insertBean(T bean) {
        Connection connection = BaseDao.getConn();
        String sql = ProduceSql.getInsertSql(getTableName(bean), bean);
        int result = BaseDao.executUpdate(connection, sql);
        return result;
    }

    /**
     * 改
     * id 不能为空
     *
     * @param bean
     * @return n or 0
     */
    @Override
    public <T> int updateBean(T bean) {
        Connection connection = BaseDao.getConn();
        String sql = ProduceSql.getUpdateSql(getTableName(bean), bean);
        int result = BaseDao.executUpdate(connection, sql);
        return result;
    }

    /**
     * 删
     *
     * @param bean
     * @return n or 0
     */
    @Override
    public <T> int deleteBean(T bean) {
        Connection connection = BaseDao.getConn();
        String sql = ProduceSql.getDeleteSql(getTableName(bean), bean);
        int result = BaseDao.executUpdate(connection, sql);
        return result;
    }

    /**
     * 查1
     * 根据bean中第一个非空属性查询
     *
     * @param bean
     * @return Object
     */
    @Override
    public <T> Object getBean(T bean) {
        //通过反射创建 bean.class 对象
        Object result = null;
        try {
            result = bean.getClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Connection connection = BaseDao.getConn();
        String sql = ProduceSql.getSelectSql(getTableName(bean), bean);

        ResultSet resultSet = BaseDao.executQury(connection, sql);
        try {
            if (resultSet.first()) {
                //ResultSetToBean.copy() 通过反射根据给定的结果集当前行与Bean类型创建一个(T)Bean
                result = (T) ResultSetToBean.copy(resultSet, bean.getClass());
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
     * @return List<Object> 包含全部日程
     */
    @Override
    public <T> List getBeanList(String username, Class<T> objectClass) {
        Connection connection = BaseDao.getConn();
        String sql = "select * from " + getTableName(objectClass) + " where username = '" + username + "'";
        List dates = new ArrayList<>();

        ResultSet resultSet = null;
        resultSet = BaseDao.executQury(connection,sql);
        try {
            //T date = null;
            Object date = null;
            if(resultSet != null) {
                while(resultSet.next()) {
                    //通过反射创建 objectClass 对象
                    try {
                        date = objectClass.newInstance();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    date = ResultSetToBean.copy(resultSet, objectClass);
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
