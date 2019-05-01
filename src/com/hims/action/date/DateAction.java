package com.hims.action.date;

import com.hims.bean.Date;
import com.hims.dao.BeanDao;
import com.hims.dao.impl.BeanDaoImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

public class DateAction extends ActionSupport implements SessionAware, RequestAware {

    /**
     * 获取当前用户的日程
     * @return List<Date> 没有日程则为null
     * @throws Exception
     */
    public String lookDate() throws Exception {
        String username = (String) session.get("username");
        List<Date> dates = (List<Date>) beanDao.getBeanList(username, Date.class);
        if (dates.size() == 0) {
            addActionMessage("您还没有日程!");
        }
        request.put("dates", dates);
        return SUCCESS;
    }

    /**
     * 删除日程
     * @return
     * @throws Exception
     */
    public String deleteDate() throws Exception {
        if (date.getId() != 0) {
            beanDao.deleteBean(date);
            addActionMessage("删除成功!");
            return SUCCESS;
        } else {
            addActionMessage("删除失败!");
            return ERROR;
        }
    }

    /**
     * 为当前用户添加日程
     * @return
     * @throws Exception
     */
    public String addDate() throws Exception {
        if (date.getThing() != null) {
            date.setUsername((String) session.get("username"));
            beanDao.insertBean(date);
            addActionMessage("添加成功!");
        } else {
            addActionMessage("日程内容为空!");
        }
        return SUCCESS;
    }

    /**
     * 修改日程
     * @return
     * @throws Exception
     */
    public String changeDate() throws Exception {
        if (date.getId() != 0) {
            beanDao.updateBean(date);
            addActionMessage("修改成功!");
        } else {
            addActionMessage("修改失败!");
        }
        return SUCCESS;
    }

    /**
     * 跳转修改日程页面
     * @return
     * @throws Exception
     */
    public String changeDatePage() throws Exception {
        Date result = new Date();
        if (date.getId() != 0) {
            result= (Date) beanDao.getBean(date);
            if(result != null) {
                request.put("date", result);
            }
        }
        return SUCCESS;
    }



    private Map<String, Object> session;
    private Map<String, Object> request;
    private BeanDao beanDao = new BeanDaoImpl();
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
