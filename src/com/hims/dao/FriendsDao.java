package com.hims.dao;

import com.hims.bean.Friends;

import java.util.List;

public interface FriendsDao {
    /**
     * 添加 Friend
     * @param friend
     * @return n : 修改的行数
     *         0 : 不返回任何内容的SQL语句
     */
    public int insertFriend(Friends friend);

    /**
     * 改
     * id 不能为空
     * @param friend
     * @return n or 0
     */
    public int updateFriend(Friends friend);

    /**
     * 删
     * @param friend
     * @return n or 0
     */
    public int deleteUser(Friends friend);

    /**
     * 查1
     * 根据friends中第一个非空属性查询
     * @param friends
     * @return friend
     */
    public Friends getFriends(Friends friends);

    /**
     * 查2
     * 查询 username 全部联系人信息
     * @param username
     * @return List<Friends> 包含全部联系人
     */
    public List<Friends> getFriendsList(String username);
}
