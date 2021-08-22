package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.*;

public class testUserMapper {

    static Logger logger = Logger.getLogger(testUserMapper.class);

    @Test
    public void getUserList(){
        //第一步，获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //执行sql
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();

            for (User user : userList) {
                System.out.println(user.toString());
                //会自动调用这个对象的toString()方法
//                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void getUserById(){
        //第一步，获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //执行sql
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUserById(1);

            System.out.println(user.toString());
                //会自动调用这个对象的toString()方法
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testLog4j(){
        logger.info("info：进入info");
        logger.debug("debug：进入debug");
        logger.error("error：进入error");
    }

    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //执行sql
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            HashMap<String, Integer> map3 = new HashMap<String, Integer>();
            map3.put("startIndex",0);
            map3.put("pageSize",2);
            List<User> userList = userMapper.getUserByLimit(map3);

            for (User user : userList) {
                System.out.println(user.toString());
                //会自动调用这个对象的toString()方法
//                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭SqlSession
            sqlSession.close();
        }


        sqlSession.close();
    }
}
