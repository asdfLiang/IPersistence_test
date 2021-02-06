package com.lagou.mapper;

import com.lagou.pojo.User;
import org.dom4j.DocumentException;

import java.beans.PropertyVetoException;
import java.util.List;

/**
 * @author liangzj
 * @date 2021/1/24 19:01
 */
public interface UserMapper {

    List<User> selectAll() throws DocumentException, PropertyVetoException, ClassNotFoundException;

    User selectOne(User user) throws DocumentException, PropertyVetoException, ClassNotFoundException;

    Integer insert(User user);

    Integer delete(User user);

    Integer update(User user);
}
