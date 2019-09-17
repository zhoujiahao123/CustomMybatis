package com.jacob.mybatis.sqlsession;

/**
 * 自定义mybatis中和数据库交互的核心类
 *他里面可以创建dao接口的代理对象
 */
public interface SqlSession {
    /**
     *
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);
    //释放资源
    void close();
}
