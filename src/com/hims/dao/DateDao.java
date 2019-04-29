package com.hims.dao;

import com.hims.bean.Date;

import java.util.List;

public interface DateDao {
    /**
     * 添加 data
     * @param date
     * @return n : 修改的行数
     *         0 : 不返回任何内容的SQL语句
     */
    public int insertData(Date date);

    /**
     * 改
     * id 不能为空
     * @param date
     * @return n or 0
     */
    public int updateData(Date date);

    /**
     * 删
     * @param date
     * @return n or 0
     */
    public int deleteData(Date date);

    /**
     * 查1
     * 根据date中第一个非空属性查询
     * @param date
     * @return data
     */
    public Date getData(Date date);

    /**
     * 查2
     * 查询 username 全部日程信息
     * @param username
     * @return List<Date> 包含全部日程
     */
    public List<Date> getDataList(String username);
}
