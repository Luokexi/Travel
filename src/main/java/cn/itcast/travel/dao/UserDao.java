package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

/**
 * @Author: Luokexi
 * @Date: 2018/10/19 21:25
 * 明确需求,整理思路,步步实现,规范编写,测试功能,总结经验.
 */
public interface UserDao {

    /**
     *  根据用户名查询用户信息
     * @param username
     * @return
     */
    public User findUserByUsername(String username);

    /**
     * 保存用户细信息
     * @param user
     */
    public void saveUser(User user);
}
