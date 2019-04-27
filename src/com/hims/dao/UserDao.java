package com.hims.dao;

import com.hims.bean.User;

import java.util.List;

public interface UserDao {
    /**
     * 添加 user
     * @param user
     * @return n : 修改的行数
     *         0 : 不返回任何内容的SQL语句
     */
    public int insertUser(User user);

    /**
     * 修改用户信息
     * @param user
     * @return n or 0
     */
    public int updateUser(User user);

    /**
     * 删除用户
     * @param user
     * @return n or 0
     */
    public int deleteUser(User user);

    /**
     * 根据user中第一个非空属性查询
     * @param user
     * @return User
     */
    public User getUser(User user);

    /**
     * 查询全部用户信息
     * @return List<User> 包含全部用户
     */
    public List<User> getUserList();
}
