package com.hims.util;

import java.text.DecimalFormat;

public class GetFileSize {
    /**
     * 根据 byte 转换为合适单位表示的文件大小
     * @param size
     * @return
     */
    public static String getSizeString(long size) {
        long num = 1024; //byte
        DecimalFormat decimalFormat=new DecimalFormat(".00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
        if (size < num)
            return size + "B";
        if (size < Math.pow(num, 2))
            return decimalFormat.format(size / num) + "K"; //kb
        if (size < Math.pow(num, 3))
            return decimalFormat.format(size / Math.pow(num, 2))+ "M"; //M
        if (size < Math.pow(num, 4))
            return decimalFormat.format(size / Math.pow(num, 3)) + "G"; //G
        return decimalFormat.format(size / Math.pow(num, 4))+ "T"; //T
    }
}
