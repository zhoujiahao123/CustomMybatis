package com.jacob.test;

import com.jacob.dao.IuserDao;
import com.jacob.domain.User;
import com.jacob.mybatis.io.Resources;
import com.jacob.mybatis.sqlsession.SqlSession;
import com.jacob.mybatis.sqlsession.SqlSessionFactory;
import com.jacob.mybatis.sqlsession.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    @Test
    public void test() throws Exception{
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession sqlSession = factory.openSession();
        IuserDao iuserDao = sqlSession.getMapper(IuserDao.class);
        List<User> users = iuserDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
        sqlSession.close();
        inputStream.close();
    }
}
