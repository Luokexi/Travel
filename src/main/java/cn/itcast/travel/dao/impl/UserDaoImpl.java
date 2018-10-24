package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 * @Author: Luokexi
 * @Date: 2018/10/19 21:28
 * 明确需求,整理思路,步步实现,规范编写,测试功能,总结经验.
 */
public class UserDaoImpl implements UserDao {


    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    @Override
    public User findUserByUsername(String username) {
        User user = null;
        try {
//        定义SQL
            String  sql = "select * from tab_user where username = ?";
//      返回一个User
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }


    /**
     * 保存用户信息
     * @param user
     */
    @Override
    public void saveUser(User user) {
//        定义SQL时 对应数据表中的字段顺序
        String sql = "insert into tab_user (username,password,name,birthday,sex,telephone,email,status,code) " +
                     "values(?,?,?,?,?,?,?,?,?)";

        template.update(sql,
                user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getBirthday(),
                user.getSex(),
                user.getTelephone(),
                user.getEmail(),
                user.getStatus(),
                user.getCode());
    }

    /**
     * 根据激活码查找用户
     * @param code
     * @return
     */
    @Override
    public User findByCode(String code) {

        User user = null;
        try {
//        SQL
            String sql = "select * from tab_user where code = ?";
            user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),code);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 修改用户的激活状态
     * @param user
     */
    @Override
    public void updateStatus(User user) {
//        SQL 表  字段  属性
        String sql = "update tab_user set status = 'Y' where uid = ?";
        template.update(sql,user.getUid());

    }

    /**
     * 根据用户的用户名和密码查找用户
     * @param username
     * @param password
     * @return
     */
    @Override
    public User findUserByUsernameAndPassword(String username, String password) {

        User user = null;
        try {
            //1.定义sql
            String sql = "select * from tab_user where username = ? and password = ?";
            //2.执行sql
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
