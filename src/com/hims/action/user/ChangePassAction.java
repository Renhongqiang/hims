package com.hims.action.user;

import com.hims.bean.User;
import com.hims.dao.BeanDao;
import com.hims.dao.UserDao;
import com.hims.dao.impl.BeanDaoImpl;
import com.hims.dao.impl.UserDaoImpl;
import com.hims.util.Md5Util;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;

public class ChangePassAction extends ActionSupport implements SessionAware, RequestAware {
    /**
     * 修改密码
     * @return
     * @throws Exception
     */
    public String changePassWord() throws Exception {
        User resultUser = new User();
        resultUser.setUsername((String) session.get("username"));
        //用户提交的旧密码密码的md5值
        String oldpasswordMd5 = Md5Util.getMD5Str(oldpassword);
        //数据库中旧密码
        String userpasswordMd5 = ((User) beanDao.getBean(resultUser)).getPassword();
        //用户提交的旧密码正确
        if (oldpasswordMd5.equals(userpasswordMd5)) {
            resultUser.setPassword(Md5Util.getMD5Str(newpassword));
            resultUser.setId((int)session.get("id"));
            beanDao.updateBean(resultUser);
            session.remove("username");
            addActionMessage("密码已修改，请重新登录!");
            return SUCCESS;
        } else {
            addActionMessage("旧密码错误!");
            return ERROR;
        }
    }

    private Map<String, Object> session;
    private Map<String, Object> request;
    private BeanDao beanDao = new BeanDaoImpl();
    private String oldpassword;
    private String newpassword;
    private String repassword;

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public String getOldpassword() {
        return oldpassword;
    }

    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
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
