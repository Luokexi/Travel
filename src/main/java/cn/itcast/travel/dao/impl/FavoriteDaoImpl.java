package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author: Luokexi
 * @Date: 2018/10/25 19:18
 * 明确需求,整理思路,步步实现,规范编写,测试功能,总结经验.
 */
public class FavoriteDaoImpl implements FavoriteDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Favorite findByRidAndUid(int rid, int uid) {
//
        Favorite favorite =null;
        try{
            String sql =" select * from tab_favorite where rid = ? anduid = ?";
            favorite =template.queryForObject(sql,new BeanPropertyRowMapper<Favorite>(Favorite.class), rid, uid);
        }catch(DataAccessException e) {
            e.printStackTrace();
        }
        return favorite;
    }
}
