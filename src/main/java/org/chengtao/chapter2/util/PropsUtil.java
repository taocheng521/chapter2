package org.chengtao.chapter2.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropsUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);
    /**
     * 加载属性文件
     */
    public static Properties loadProps (String fileName){
        Properties properties = null;
        InputStream is = null;
        try {
            is=Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if(is == null){
                throw new FileNotFoundException(fileName + "file is not found");
            }
            properties = new Properties();
            properties.load(is);
        } catch (IOException e) {
            LOGGER.error("load properties file faile", e.getMessage());
        }finally {
            if(is != null){
                try{
                    is.close();
                }catch (IOException e){
                    LOGGER.error("close input stream failure", e.getMessage());
                }
            }
        }
        return properties;
    }

    /**
     * 获取字符属性(默认值为空字符串)
     */
    public static String getString(Properties properties, String key) {
        return getString(properties, key, "");
    }

    /**
     * 获取字符型属性（可指定默认值）
     */
    public static String getString (Properties properties, String key, String defaultValue){
        String value = defaultValue;
        if(properties.containsKey(key)){
            value=properties.getProperty(key);
        }
        return value;
    }

}
