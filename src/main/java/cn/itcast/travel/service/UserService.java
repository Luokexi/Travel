package cn.itcast.travel.service;

import cn.itcast.travel.domain.User; /**
 * @Author: Luokexi
 * @Date: 2018/10/19 21:25
 * 明确需求,整理思路,步步实现,规范编写,测试功能,总结经验.
 */
public interface UserService {

    /**
     * 注册用户
     * @param user
     * @return
     */
    boolean registUser(User user);

    boolean active(String code);

    User login(User user);
}
