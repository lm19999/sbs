package com.systop.sbs.common.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @Program: sbs
 * @Description: 读取文件工具类
 * @Author: liumiao
 * @Date: 2020/8/8 19:51
 **/
public class ReadFile {
    /**
     * 读取lrc文件
     * @param file 文件
     * @return 文件内容
     */
    public String getFromAssets(String file) {
        try {
            InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file),"gbk");
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line="";
            String result="";
            while((line = bufReader.readLine()) != null){
                if(line.trim().equals(""))
                    continue;
                result += line + "\r\n";
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
