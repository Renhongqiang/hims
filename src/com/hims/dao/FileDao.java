package com.hims.dao;

import com.hims.bean.File;

import java.util.List;

public interface FileDao {
    /**
     * 添加 file
     * @param file
     * @return n : 修改的行数
     *         0 : 不返回任何内容的SQL语句
     */
    public int insertFile(File file);

    /**
     * 改
     * id 不能为空
     * @param file
     * @return n or 0
     */
    public int updateFile(File file);

    /**
     * 删
     * @param file
     * @return n or 0
     */
    public int deleteFile(File file);

    /**
     * 查1
     * 根据file中第一个非空属性查询
     * @param file
     * @return file
     */
    public File getFile(File file);

    /**
     * 查2
     * 查询 username 全部文件
     * @param username
     * @return List<File> 包含全部文件
     */
    public List<File> getFileList(String username);
}
