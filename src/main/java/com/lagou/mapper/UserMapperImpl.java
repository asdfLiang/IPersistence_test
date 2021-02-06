package com.lagou.mapper;

import com.lagou.config.XmlConfigBuilder;
import com.lagou.domain.Configuration;
import com.lagou.io.Resources;
import com.lagou.pojo.User;
import com.lagou.sqlSession.DefaultSqlSessionFactory;
import com.lagou.sqlSession.SqlSession;
import com.lagou.sqlSession.SqlSessionFactory;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.List;

/**
 * @author liangzj
 * @date 2021/1/30 16:22
 */
public class UserMapperImpl implements UserMapper {
    @Override
    public List<User> selectAll() throws DocumentException, PropertyVetoException, ClassNotFoundException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        Configuration configuration = new XmlConfigBuilder().parseConfig(resourceAsStream);
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(configuration);
        SqlSession sqlSession = sqlSessionFactory.openSqlSession();

        return sqlSession.selectList("com.lagou.mapper.UserMapper.selectAll");
    }

    @Override
    public User selectOne(User user) throws DocumentException, PropertyVetoException, ClassNotFoundException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        Configuration configuration = new XmlConfigBuilder().parseConfig(resourceAsStream);
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(configuration);
        SqlSession sqlSession = sqlSessionFactory.openSqlSession();

        return sqlSession.selectOne("com.lagou.mapper.UserMapper.selectOne", user);
    }

    @Override
    public Integer insert(User user) {
        return null;
    }

    @Override
    public Integer delete(User user) {
        return null;
    }

    @Override
    public Integer update(User user) {
        return null;
    }
}
