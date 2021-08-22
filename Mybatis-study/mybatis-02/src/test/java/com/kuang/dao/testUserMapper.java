package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class testUserMapper {

    @Test
    public void getUserList(){
        //第一步，获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //执行sql
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = userMapper.getUserList();

            for (User user : userList) {
                System.out.println(user.getId() + user.getName() + user.getPwd());
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
}
