package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
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
     * @param rname
     * @return
     */
    @Override
    public int findTotalCount(int cid, String rname) {
//        定义sql
        String sql = " select count(*) from tab_route where 1=1 ";
//        定义 StringBuilder拼接字符串
        StringBuilder newSql = new StringBuilder(sql);
//        将传递的条件添加到List中
        List paramters = new ArrayList();
//        判断传过来的参数是否有值 有值就拼接字符串
        if (cid != 0){
            newSql.append(" and cid = ?");
            paramters.add(cid);
        }
        if (rname!=null && rname.length() > 0){
            newSql.append(" and rname like ? ");
            paramters.add("%"+rname+"%");
        }
        sql = newSql.toString();
//        将拼接好的newSql传入
        return template.queryForObject( sql,Integer.class,paramters.toArray());
    }

    /**
     * 分页查询 用户输入的路线
     * @param cid
     * @param start start 开始的索引
     * @param pageSize
     * @param rname
     * @return  传递的是List集合 即页面的数据
     */
    @Override
    public List<Route> findByPage(int cid, int start, int pageSize, String rname) {
//        定义sql
        String sql = " select * from tab_route where 1 = 1 ";
//        定义 StringBuilder拼接字符串
        StringBuilder newSql = new StringBuilder(sql);
//        将传递的条件添加到List中
        List paramters = new ArrayList();
//        判断传过来的参数是否有值 有值就拼接字符串
        if (cid!=0){
            newSql.append(" and cid = ?");
            paramters.add(cid);
        }
        if (rname!=null && rname.length() > 0){
            newSql.append(" and rname like ?");
            paramters.add("%"+rname+"%");
        }
//        分页条件
        newSql.append(" limit ?, ? ");
        paramters.add(start);
        paramters.add(pageSize);
        sql = newSql.toString();
//
        return template.query(sql,new BeanPropertyRowMapper<Route>(Route.class),paramters.toArray());
    }


    /**
     *
     * @param rid
     * @return
     */
    @Override
    public Route findOne(int rid) {
//      定义sql
        String sql = "select * from tab_route where rid = ? ";
        return template.queryForObject(sql,new BeanPropertyRowMapper<Route>(Route.class),rid);
    }
}
