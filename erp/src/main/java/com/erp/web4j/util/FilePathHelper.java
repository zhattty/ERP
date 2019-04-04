package com.erp.web4j.util;

/**
 * Created by ZhangYao
 * Date 2019/4/4 Time 16:06
 */
public class FilePathHelper {
    private  FilePathHelper(){}
    public static String getRelativePath(String filename){
        if (filename!=null){
            int i = filename.hashCode();
            String string = Integer.toHexString(i);
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : string.toCharArray()) {
                stringBuilder.append(c).append("/");
            }
            StringBuilder append = stringBuilder.append(filename);
            return append.toString();
        }
        return null;
    }
}
