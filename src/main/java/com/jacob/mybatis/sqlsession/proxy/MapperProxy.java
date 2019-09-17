package com.jacob.mybatis.sqlsession.proxy;

import com.jacob.mybatis.cfg.Mapper;
import com.jacob.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {
    //map的key是全限定类名+方法名
    public MapperProxy(Map<String, Mapper> mappers, Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    private Map<String, Mapper> mappers;
    private Connection conn;

    /**
     * 对方法进行增强,其实就是调用selectList方法
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //1.获取方法名称
        String methodName = method.getName();
        //2.获取方法所在类的全路径
        String className = method.getDeclaringClass().getName();
        //3.组合key
        String key = className +"."+ methodName;
        //4.获取map对象
        Mapper mapper = mappers.get(key);
        if (mapper == null) {
            throw new IllegalArgumentException("传入的参数有误");
        }
        return new Executor().selectList(mapper,conn);
    }
}
