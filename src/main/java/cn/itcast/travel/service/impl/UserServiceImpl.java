package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

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
//      设置用户的唯一激活码
        user.setCode(UuidUtil.getUuid());
//      设置用户的激活状态
        user.setStatus("N");
        userdao.saveUser(user);
//        设置邮箱的正文  "" 里面是 ''
        String content = "<a href='http://localhost/travel/activeUserServlet?code="+user.getCode()+"'>点击激活</a>";
//      根据用户填写的邮箱 发送邮箱
        MailUtils.sendMail(user.getEmail(),content,"请您尽快激活.");
//
        return true;
    }

    @Override
    public boolean active(String code) {
//        根据激活码查询用户对象
        User user = userdao.findByCode(code);
        if (user!=null){
//            调用dao的修改 激活状态
            userdao.updateStatus(user);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public User login(User user) {

        return userdao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
}
