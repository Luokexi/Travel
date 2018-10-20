package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

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
        String sql = "insert into tab_user (username,password,name,birthday,sex,telephone,email) " +
                     "values(?,?,?,?,?,?,?)";
        template.update(sql,
                user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getBirthday(),
                user.getSex(),
                user.getTelephone(),
                user.getEmail());

    }
}
