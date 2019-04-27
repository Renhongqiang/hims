package com.hims.action;

import com.hims.bean.User;
import com.hims.dao.UserDao;
import com.hims.dao.impl.UserDaoImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware {
    public String execute() throws Exception {
        UserDao userDao = new UserDaoImpl();
        if (user.getPassword().equals(userDao.getUser(user).getPassword())) {
            session.put("username", user.getUsername());
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
    private User user;
    private Map<String, Object> session;
}
