package com.lagou.mapper;

import com.lagou.config.XmlConfigBuilder;
import com.lagou.domain.Configuration;
import com.lagou.io.Resources;
import com.lagou.pojo.User;
import com.lagou.sqlSession.DefaultSqlSessionFactory;
import com.lagou.sqlSession.SqlSession;
import com.lagou.sqlSession.SqlSessionFactory;
import org.dom4j.DocumentException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.List;

/**
 * @author liangzj
 * @date 2021/1/24 19:09
 */
class UserMapperTest {

    private static SqlSession sqlSession = null;

    @BeforeAll
    static void openSqlSession() throws DocumentException, PropertyVetoException, ClassNotFoundException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        XmlConfigBuilder xmlConfigBuilder = new XmlConfigBuilder();
        Configuration configuration = xmlConfigBuilder.parseConfig(resourceAsStream);

        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(configuration);
        sqlSession = sqlSessionFactory.openSqlSession();
    }

    @Test
    void resourceTest() {
        Resources.getResourceAsStream("sqlMapConfig.xml");
    }

    @Test
    void configParseTest() throws PropertyVetoException, DocumentException, ClassNotFoundException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        XmlConfigBuilder xmlConfigBuilder = new XmlConfigBuilder();
        Configuration configuration = xmlConfigBuilder.parseConfig(resourceAsStream);
        System.out.println(configuration);
    }

    @Test
    void selectAll() throws DocumentException, PropertyVetoException, ClassNotFoundException {

//        List<Object> list = sqlSession.selectList("com.lagou.mapper.UserMapper.selectAll");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.selectAll();

        System.out.println(list);

    }

    @Test
    void selectOne() throws DocumentException, PropertyVetoException, ClassNotFoundException {

        User userParam = new User();
        userParam.setId(1L);
//        Object o = sqlSession.selectOne("com.lagou.mapper.UserMapper.selectOne", user);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectOne(userParam);
        System.out.println(user);

    }

    @Test
    void testInsert() throws DocumentException, PropertyVetoException, ClassNotFoundException {
        User user = new User();
        user.setName("ZXCC");

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        System.out.println(mapper.selectAll());
        System.out.println(mapper.insert(user));
        System.out.println(mapper.selectAll());

    }

    @Test
    void testDelete() throws DocumentException, PropertyVetoException, ClassNotFoundException {
        User user = new User();
        user.setId(5L);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        System.out.println(mapper.selectAll());
        System.out.println(mapper.delete(user));
        System.out.println(mapper.selectAll());

    }

    @Test
    void testUpdate() throws DocumentException, PropertyVetoException, ClassNotFoundException {
        User user = new User();
        user.setId(7L);
        user.setName("qwerqwe");

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        System.out.println(mapper.selectAll());
        System.out.println(mapper.update(user));
        System.out.println(mapper.selectAll());

    }


}