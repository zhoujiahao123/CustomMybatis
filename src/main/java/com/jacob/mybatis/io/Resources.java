package com.jacob.mybatis.io;

import java.io.InputStream;

/**
 * 类加载器
 */
public class Resources {
    public static InputStream getResourceAsStream(String filePath){
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
