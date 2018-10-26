package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.dao.impl.FavoriteDaoImpl;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.service.FavoriteService;

/**
 * @Author: Luokexi
 * @Date: 2018/10/25 19:22
 * 明确需求,整理思路,步步实现,规范编写,测试功能,总结经验.
 */
public class FavoriteServiceImpl implements FavoriteService{

    private FavoriteDao favoriteDao = new FavoriteDaoImpl();
    /**
     *
     * @param rid
     * @param uid
     * @return
     */
    @Override
    public boolean isFavorite(String rid, int uid) {

        Favorite favorite = favoriteDao.findByRidAndUid(Integer.parseInt(rid), uid);
//        如果对象有 值 为 true 返回 true 反之 false
        return favorite!=null;
    }
}
