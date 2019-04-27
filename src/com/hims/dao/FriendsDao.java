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
     * 根据联系人名查询联系人信息
     * @param name
     * @return friend
     */
    public Friends getFriends(String name);

    /**
     * 查2
     * 查询全部联系人信息
     * @return List<Friends> 包含全部联系人
     */
    public List<Friends> getFriendsList();
}
