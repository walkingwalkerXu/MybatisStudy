package com.kuang.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//sqlSessionFactory --> sqlsession
public class MybatisUtils {
    //提升作用域
    private static SqlSessionFactory sqlSessionFactory;

    static {
        //使用mybatis第一步，获取sqlSessionFactory对象
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //既然有了 sqlSessionFactory,顾名思义，我们就可以从中获得SqlSession的实例了
    //SqlSession完全包含了面向数据库执行sql命令所需的所有方法
    public static SqlSession getSqlSession(){
        /*返回SqlSession 对象*/
        return sqlSessionFactory.openSession();
    }
}
