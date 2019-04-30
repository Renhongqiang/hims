package com.hims.dao.impl;

import com.hims.bean.File;
import com.hims.dao.BaseDao;
import com.hims.dao.FileDao;
import com.hims.util.ProduceSql;
import com.hims.util.ResultSetToBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FileDaoImpl implements FileDao {
    private final String TABLE_NAME = "file";

    /**
     * 添加 file
     *
     * @param file
     * @return n : 修改的行数
     * 0 : 不返回任何内容的SQL语句
     */
    @Override
    public int insertFile(File file) {
        Connection connection = BaseDao.getConn();
        String sql = ProduceSql.getInsertSql(TABLE_NAME, file);
        int result = BaseDao.executUpdate(connection, sql);
        return result;
    }

    /**
     * 改
     * id 不能为空
     *
     * @param file
     * @return n or 0
     */
    @Override
    public int updateFile(File file) {
        Connection connection = BaseDao.getConn();
        String sql = ProduceSql.getUpdateSql(TABLE_NAME, file);
        int result = BaseDao.executUpdate(connection, sql);
        return result;
    }

    /**
     * 删
     *
     * @param file
     * @return n or 0
     */
    @Override
    public int deleteFile(File file) {
        Connection connection = BaseDao.getConn();
        String sql = ProduceSql.getDeleteSql(TABLE_NAME, file);
        int result = BaseDao.executUpdate(connection, sql);
        return result;
    }

    /**
     * 查1
     * 根据file中第一个非空属性查询
     *
     * @param file
     * @return file
     */
    @Override
    public File getFile(File file) {
        File result = new File();
        Connection connection = BaseDao.getConn();
        String sql = ProduceSql.getSelectSql(TABLE_NAME, file);

        ResultSet resultSet = BaseDao.executQury(connection, sql);
        try {
            if (resultSet.first()) {
                //ResultSetToBean.copy() 通过反射根据给定的结果集当前行与Bean类型创建一个Bean
                result = (File) ResultSetToBean.copy(resultSet, File.class);
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
     * 查询 username 全部文件
     *
     * @param username
     * @return List<File> 包含全部文件
     */
    @Override
    public List<File> getFileList(String username) {
        Connection connection = BaseDao.getConn();
        String sql = "select * from " + TABLE_NAME + " where username = '" + username + "'";
        List<File> files = new ArrayList<File>();
        ResultSet resultSet = null;
        resultSet = BaseDao.executQury(connection,sql);
        try {
            File file = null;
            if(resultSet != null) {
                while(resultSet.next()) {
                    file = new File();
                    file = (File) ResultSetToBean.copy(resultSet, File.class);
                    files.add(file);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeAll(null,null,resultSet);
        }
        return files;
    }
}
