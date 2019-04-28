package com.hims.action;

import com.hims.bean.User;
import com.hims.dao.UserDao;
import com.hims.dao.impl.UserDaoImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class RegisterAction extends ActionSupport implements RequestAware {
    public String execute() throws Exception {
        UserDao userDao = new UserDaoImpl();
        if(userDao.getUser(user) == null) {
            userDao.insertUser(user);
            addActionMessage("恭喜你,注册成功!");
            request.put("username", user.getUsername());
            return SUCCESS;
        } else {
            //该用户名已注册
            addActionMessage("该用户名已被注册!");
            return ERROR;
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public Map<String, Object> getRequest() {
        return request;
    }

    @Override
    public void setRequest(Map<String, Object> map) {
        this.request = map;
    }

    private User user;
    private String repassword;
    private Map<String, Object> request;
}
