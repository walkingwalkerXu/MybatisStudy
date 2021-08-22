package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    @Test
    public void test(){
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

    @Test
    public void gerUserById(){
        //第一步，获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //执行sql
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUserById(4);

            System.out.println(user.getId() + user.getName() + user.getPwd());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭SqlSession
            sqlSession.close();
        }
    }

    //增删改需要提交事务
    @Test
    public void addUserTest(){
        //第一步，获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //执行sql
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User newUser = new User();
            newUser.setId(4);
            newUser.setName("新1");
            newUser.setPwd(("123457"));
            int res = userMapper.addUser(newUser);

            if(res > 0){
                System.out.println("插入成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.commit();
            //关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void updateUserTest(){
        //第一步，获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //执行sql
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User updUser = new User();
            updUser.setId(4);
            updUser.setName("新2");
            updUser.setPwd(("123458"));
            int res = userMapper.updateUser(updUser);

            if(res > 0){
                System.out.println("更新成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.commit();
            //关闭SqlSession
            sqlSession.close();
        }


    }

    @Test
    public void deleteUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int result = userMapper.deleteUser(4);
            if(result >0 ){
                System.out.println("删除成功");
            }

        } catch (Exception e){

        } finally {
            sqlSession.commit();
            sqlSession.close();
        }

    }

    @Test
    public void updateUser2Test(){
        //第一步，获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //执行sql
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Map<String,Object> map = new HashMap<String, Object>();

            map.put("id",3);
            map.put("pwd","mapgaimn");

            int res = userMapper.updateUser2(map);

            if(res > 0){
                System.out.println("更新成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.commit();
            //关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            List<User> userList = userMapper.getUserLike("%李%");

            for(User user : userList) {
                System.out.println(user.getName());
            }
        } catch (Exception e){

        }finally {
            sqlSession.close();
        }
    }

}
