package opst.we.service;


import opst.we.model.StHero;
import opst.we.util.Page;

import java.util.List;

public interface StzbService {

    /**
     * @author: chgj
     * @description:更新数据
     * @date: 2018/2/11 13:23
     */
    void updateAllHero();
    /**
     * @author: chgj
     * @description: 推荐武将
     * @date: 2018/2/11 12:49
     */
    List<StHero> recommendedHero();

    /**
     * @author: chgj
     * @param id
     * @description:
     * @date: 2018/2/11 13:24
     */
    StHero getStHeroById(Integer id);
    /**
     * @author: chgj
     * @param page
     * @param hero
     * @description:武将列表分页查询
     * @date: 2018/2/11 13:24
     */
    Page listStHeroByPage(Page page, StHero hero);
}
