package com.hims.action.fridens;

import com.hims.bean.Friends;
import com.hims.dao.BeanDao;
import com.hims.dao.impl.BeanDaoImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FriendsAction extends ActionSupport implements SessionAware, RequestAware {

    /**
     * 获取当前用户的联系人 List
     * @return List<Friends> 没有联系人则为null
     * @throws Exception
     */
    public String lookFriends() throws Exception {
        String username = (String) session.get("username");
        List<Friends> friendsList = (List<Friends>) beanDao.getBeanList(username, Friends.class);
        if (friendsList.size() == 0) {
            addActionMessage("您还没有联系人!");
        }
        request.put("friendsList", friendsList);
        return SUCCESS;
    }

    /**
     * 查找当前用户的联系人 List
     * friends.name 查找，为空则返回所有
     * @return List<Friends> 没有联系人则为null
     * @throws Exception
     */
    public String findFriends() throws Exception {
        String username = (String) session.get("username");
        List<Friends> friendsList = (List<Friends>) beanDao.getBeanList(username, Friends.class);
        List<Friends> result = new ArrayList<Friends>();
        String name = friends.getName();
        if (name == "") {
            //查询条件为空，返回全部
            request.put("friendsList", friendsList);
        } else {
            //查询包含name的
            for (Friends f : friendsList) {
                if (f.toString().indexOf(name) > -1) {
                    result.add(f);
                }
            }
            addActionMessage("查找到" + result.size() + "个信息包含" + name + "的联系人");
            request.put("friendsList", result);
            return SUCCESS;
        }
        return SUCCESS;
    }

    /**
     * 删除联系人
     * @return
     * @throws Exception
     */
    public String deleteFriends() throws Exception {
        if (friends.getId() != 0) {
            beanDao.deleteBean(friends);
            addActionMessage("删除成功!");
            return SUCCESS;
        } else {
            addActionMessage("删除失败!");
            return ERROR;
        }
    }

    /**
     * 跳转修改联系人页面
     * @return
     * @throws Exception
     */
    public String changeFriendsPage() throws Exception {
        Friends result = new Friends();
        if (friends.getId() != 0) {
            result= (Friends) beanDao.getBean(friends);
            if(result != null) {
                request.put("friends", result);
            }
        }
        return SUCCESS;
    }

    private Map<String, Object> session;
    private Map<String, Object> request;
    private BeanDao beanDao = new BeanDaoImpl();
    private Friends friends;

    public Friends getFriends() {
        return friends;
    }

    public void setFriends(Friends friends) {
        this.friends = friends;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    public Map<String, Object> getRequest() {
        return request;
    }

    @Override
    public void setRequest(Map<String, Object> map) {
        this.request = map;
    }
}
