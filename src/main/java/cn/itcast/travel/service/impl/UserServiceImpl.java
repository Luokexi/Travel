package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;

/**
 * @Author: Luokexi
 * @Date: 2018/10/19 21:25
 * 明确需求,整理思路,步步实现,规范编写,测试功能,总结经验.
 */
public class UserServiceImpl implements UserService {

    private UserDao userdao = new UserDaoImpl();

    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public boolean registUser(User user) {
//        根据用户名查询
        User findUser = userdao.findUserByUsername(user.getUsername());
        if (findUser != null) {
//            用户名存在
            return false;
        }
//
        userdao.saveUser(user);
        return true;
    }
}
