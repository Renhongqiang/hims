package com.hims.action;

import com.hims.bean.User;
import com.hims.dao.UserDao;
import com.hims.dao.impl.UserDaoImpl;
import com.hims.util.Md5Util;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware {
    public String login() throws Exception {
        UserDao userDao = new UserDaoImpl();
        if(userDao.getUser(user) != null)
        {
            String md5Pass = Md5Util.getMD5Str(user.getPassword());
            if (md5Pass.equals(userDao.getUser(user).getPassword())) {
                session.put("username", user.getUsername());
                session.put("id", userDao.getUser(user).getId());
                return SUCCESS;
            } else {
                addActionMessage("密码错误！");
                return ERROR;
            }
        } else {
            addActionMessage("该用户未注册！");
            return ERROR;
        }
    }

    public String singOut() throws Exception{
        session.remove("username");
        return SUCCESS;
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
