package com.test.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * 文件上传的工具类
 * @author Administrator
 *
 */
public class UploadUtils {
    /**
     * 传入文件名称，返回唯一的名称
     * @param filename
     * @return
     */
    public static String getUUIDName(String filename){
        //先查找 从后往前找
        int index = filename.lastIndexOf(".");
        //截取后缀名
        String lastname = filename.substring(index,filename.length());
        //System.out.println(filename);
        //唯一字符串
        String uuid = UUID.randomUUID().toString().replace("-", "");//默认带有-
         
        return uuid+lastname;
    }
    public static void main(String[] args) {
        String filename = "gril.jsp";
        System.out.println(getUUIDName(filename));
    }
}