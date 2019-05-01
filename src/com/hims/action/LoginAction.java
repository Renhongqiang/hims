package com.hims.action;

import com.hims.bean.User;
import com.hims.dao.BeanDao;
import com.hims.dao.impl.BeanDaoImpl;
import com.hims.util.Md5Util;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware {
    public String login() throws Exception {
        //查出数据库中此用户
        User thisUser = (User) beanDao.getBean(user);
        if(thisUser != null)
        {
            String md5Pass = Md5Util.getMD5Str(user.getPassword());
            if (md5Pass.equals(thisUser.getPassword())) {
                session.put("username", thisUser.getUsername());
                session.put("id", thisUser.getId());
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
    private BeanDao beanDao = new BeanDaoImpl();
}
