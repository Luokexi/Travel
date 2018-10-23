package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Author: Luokexi
 * @Date: 2018/10/23 14:10
 * 明确需求,整理思路,步步实现,规范编写,测试功能,总结经验.
 */
public class RouteDaoImpl implements RouteDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 根据类别 cid 查询总记录数
     * @param cid
     * @return
     */
    @Override
    public int findTotalCount(int cid) {
//        定义sql
        String sql = "select count(*) from tab_route where cid = ?";
        return template.queryForObject(sql,Integer.class,cid);
    }

    /**
     * 分页查询
     * @param cid
     * @param start start 开始的索引
     * @param pageSize
     * @return  传递的是List集合 即页面的数据
     */
    @Override
    public List<Route> findByPage(int cid, int start, int pageSize) {
//        定义sql
        String sql = "select * from tab_route where cid = ? limit ? , ?";
        return template.query(sql,new BeanPropertyRowMapper<Route>(Route.class),cid,start,pageSize);
    }
}
