package com.jacob.mybatis.sqlsession;

import com.jacob.mybatis.cfg.Configuration;
import com.jacob.mybatis.sqlsession.defaults.DefaultsSqlSessionFactory;
import com.jacob.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 用于创建一个SqlSessionFactoryBuilder方法
 */
public class SqlSessionFactoryBuilder {
    /**
     * 根据参数的字节输入流来构建一个SqlSessionFactory工厂
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultsSqlSessionFactory(cfg);
    }
}
