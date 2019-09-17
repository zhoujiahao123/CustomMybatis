package com.jacob.mybatis.sqlsession.defaults;

import com.jacob.mybatis.cfg.Configuration;
import com.jacob.mybatis.sqlsession.SqlSession;
import com.jacob.mybatis.sqlsession.SqlSessionFactory;

/**
 * SqlSessionFactory接口的实现类
 */
public class DefaultsSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;
    public DefaultsSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }
    /**
     * 创建一个新的操作数据库对象
     *
     * @return
     */
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
