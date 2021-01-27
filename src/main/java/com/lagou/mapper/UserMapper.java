package com.lagou.mapper;

import com.lagou.pojo.User;

import java.util.List;

/**
 * @author liangzj
 * @date 2021/1/24 19:01
 */
public interface UserMapper {

    List<User> selectAll(User user);

    User selectOne(User user);

}
