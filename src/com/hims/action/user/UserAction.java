package com.hims.action.user;

import com.hims.bean.User;
import com.hims.dao.BeanDao;
import com.hims.dao.UserDao;
import com.hims.dao.impl.BeanDaoImpl;
import com.hims.dao.impl.UserDaoImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class UserAction extends ActionSupport implements SessionAware, RequestAware{

    /**
     * 获取个人信息
     * @return
     * @throws Exception
     */
    public String lookInfo() throws Exception {
            User resultUser = new User();
            resultUser.setId((int)session.get("id"));
            resultUser = (User) beanDao.getBean(resultUser);
            request.put("user", resultUser);
            return SUCCESS;
    }

    /**
     * 修改用户信息
     * @return
     * @throws Exception
     */
    public String changeInfo() throws Exception {
        if (user.getId() > -1) {
            beanDao.updateBean(user);
            addActionMessage("修改成功!");
            return SUCCESS;
        } else {
            addActionMessage("ID错误!");
            return ERROR;
        }
    }


    private Map<String, Object> session;
    private Map<String, Object> request;
    private BeanDao beanDao = new BeanDaoImpl();
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
