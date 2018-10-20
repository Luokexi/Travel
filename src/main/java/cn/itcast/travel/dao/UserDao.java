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

    /**
     *  根据激活码查询用户
     * @param code
     * @return
     */
    User findByCode(String code);

    /**
     * 更新用户的激活状态
     * @param user
     */
    void updateStatus(User user);

    /**
     * 根据用户的用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    User findUserByUsernameAndPassword(String username, String password);
}
