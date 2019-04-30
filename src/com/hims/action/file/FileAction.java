package com.hims.action.file;


import com.hims.bean.File;
import com.hims.dao.FileDao;
import com.hims.dao.impl.FileDaoImpl;
import com.hims.util.GetFileSize;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class FileAction extends ActionSupport implements SessionAware, RequestAware {

    /**
     * 上传文件
     * @return
     * @throws Exception
     */
    public String uploadFile() throws Exception {
        if (file.getTitle().equals("")) {
            addActionMessage("文件名不能为空!");
            return INPUT;
        }
        if (getUpload() == null) {
            addActionMessage("您未选择文件!");
            return INPUT;
        }
        //存储路径 + 文件名
        //getSavePath()在struts2.xml中配置：<param name="savePath">/uploadFiles</param>
        String path = getSavePath() + "\\" + getUploadFileNameUuid();
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        FileInputStream fileInputStream = new FileInputStream(getUpload());
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = fileInputStream.read(buffer)) > 0) {
            fileOutputStream.write(buffer, 0, len);
        }

        file.setUsername((String) session.get("username"));
        file.setName(getUploadFileName());
        file.setContenttype(getUploadContentType());
        //将 ‘\’ 替换为 '/'
        file.setFilepath(path.replace('\\', '/'));
        file.setSize(GetFileSize.getSizeString(upload.length()));  //Bytes
        fileDao.insertFile(file);
        addActionMessage("上传成功!");
        return SUCCESS;
    }

    /**
     * 根据登录用户名查询文件List
     * @return
     * @throws Exception
     */
    public String lookFiles() throws Exception {
        String username = (String) session.get("username");
        List<File> files = fileDao.getFileList(username);
        if (files.size() == 0) {
            addActionMessage("您还没有文件!");
        }
        request.put("files", files);
        return SUCCESS;
    }

    /**
     * 删除文件 根据file.id
     * @return
     * @throws Exception
     */
    public String deleteFile() throws Exception {
        String path = fileDao.getFile(file).getFilepath();
        String uname = fileDao.getFile(file).getUsername();
        java.io.File deleteFile = new java.io.File(path);
        //id不为空且请求删除的是本用户的文件
        if (file.getId() != 0 && uname.equals(session.get("username"))) {
            if(deleteFile.delete()) {
                fileDao.deleteFile(file);
                addActionMessage("删除成功!");
                return SUCCESS;
            }else {
                addActionMessage("删除失败!");
                return ERROR;
            }
        } else {
            addActionMessage("非法操作!");
            return ERROR;
        }
    }

    /**
     * 获取目标流对象
     * 在 struts2.xml 中配置 <param name="inputName">inputStream</param>
     * @return InputStream
     */
    public InputStream getInputStream() {
        java.io.File isFile = new java.io.File(file.getFilepath());
        InputStream is = null;
        try {
            is = new FileInputStream(isFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return is;
    }

    /**
     * 下载文件
     * @return
     */
    public String downloadFile(){
        file = fileDao.getFile(file);
        String uname = fileDao.getFile(file).getUsername();
        if (!uname.equals(session.get("username"))) {
            addActionMessage("非法操作!");
            return ERROR;
        }
        return SUCCESS;
    }

    private java.io.File upload;
    //上传文件类型
    private String uploadContentType;
    //上传文件名
    private String uploadFileName;
    //struts2.xml中配置的成员变量
    private String savePath;

    public java.io.File getUpload() {
        return upload;
    }

    public void setUpload(java.io.File upload) {
        this.upload = upload;
    }

    public String getUploadContentType() {
        return uploadContentType;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    //生成文件名 uploadFileName 的 UUID 重置文件名
    public String getUploadFileNameUuid() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        // 获得文件后缀名称
        String suffixName = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1).toLowerCase();
        // 生成最新的uuid文件名称
        String newFileName = uuid + "."+ suffixName;
        return newFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    //获取上传文件的保存位置
    public String getSavePath() {
        return ServletActionContext.getServletContext().getRealPath(savePath);
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    private Map<String, Object> session;
    private Map<String, Object> request;
    private FileDao fileDao = new FileDaoImpl();
    private File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
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
