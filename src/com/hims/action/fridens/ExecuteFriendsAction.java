package com.hims.action.fridens;

import com.hims.bean.Friends;
import com.hims.dao.BeanDao;
import com.hims.dao.impl.BeanDaoImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class ExecuteFriendsAction extends ActionSupport implements SessionAware, RequestAware {

    /**
     * 为当前用户添加联系人
     * @return
     * @throws Exception
     */
    public String addFriends() throws Exception {
        if (friends.getName() != null) {
            friends.setUsername((String) session.get("username"));
            beanDao.insertBean(friends);
            addActionMessage("添加成功!");
        } else {
            addActionMessage("联系人姓名为空!");
        }
        return SUCCESS;
    }

    /**
     * 修改联系人
     * @return
     * @throws Exception
     */
    public String changeFriends() throws Exception {
        if (friends.getId() != 0) {
            beanDao.updateBean(friends);
            addActionMessage("修改成功!");
        } else {
            addActionMessage("修改失败!");
        }
        return SUCCESS;
    }

    private Map<String, Object> session;
    private Map<String, Object> request;
    private Friends friends;
    private BeanDao beanDao = new BeanDaoImpl();

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
