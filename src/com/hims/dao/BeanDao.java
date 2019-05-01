package com.hims.dao;

import java.util.List;

public interface BeanDao {
    /**
     * 添加 bean
     * @param bean
     * @return n : 修改的行数
     *         0 : 不返回任何内容的SQL语句
     */
    public <T> int insertBean(T bean);

    /**
     * 改
     * id 不能为空
     * @param bean
     * @return n or 0
     */
    public <T> int updateBean(T bean);

    /**
     * 删
     * @param bean
     * @return n or 0
     */
    public <T> int deleteBean(T bean);

    /**
     * 查1
     * 根据bean中第一个非空属性查询
     * @param bean
     * @return Object
     */
    public <T> Object getBean(T bean);

    /**
     * 查2
     * 查询 username 全部日程信息
     * @param username
     * @return List<Object> 包含全部日程
     */
    public  <T> List getBeanList(String username, Class<T> objectClass);
}
