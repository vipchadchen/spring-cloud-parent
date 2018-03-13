package opst.we.service.impl;

import opst.we.model.StContrast;
import opst.we.model.StHero;
import opst.we.model.mapper.StContrastMapper;
import opst.we.model.mapper.StHeroMapper;
import opst.we.service.StzbService;
import opst.we.service.dto.Root;
import opst.we.util.HttpsClientSSL;
import opst.we.util.JsonUtil;
import opst.we.util.Page;
import opst.we.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Service
@Transactional(rollbackFor = Exception.class)
public class StzbServiceImpl implements StzbService {
    @Autowired
    private StHeroMapper heroMapper;
    @Autowired
    private StContrastMapper stContrastMapper;

    private static final Logger logger = LoggerFactory.getLogger(StzbServiceImpl.class);
    static Pattern pattern = Pattern.compile("[^0-9]");

    @Override
    public void updateAllHero() {
        Integer id = heroMapper.selectHeroMaxId();
        if (id == null) {
            id = 100000;
        }
        logger.info("当前最大id url" + id);
        for (int i = id; i < 100600; i++) {
            logger.info("数据拉取:" + i);
            String s = HttpsClientSSL.get("https://app.gamer.163.com/game-db/g10/hero/" + i, "");
            if (!StringUtils.isEmpty(s)) {
                try {
                    Root root = JsonUtil.toObject(s, Root.class);
                    StHero hero = root.getHero();
                    hero.setSdate(new Date());
                    heroMapper.insert(hero);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public List<StHero> recommendedHero() {
        return heroMapper.recommendedHero();
    }

    @Override
    public StHero getStHeroById(Integer id) {
        StHero wj = heroMapper.selectByPrimaryKey(id);
        if (wj == null) {
            wj = heroMapper.getDefalutHero("attack");
        }
        return wj;
    }

    @Override
    public Page listStHeroByPage(Page page, StHero hero, String sort) {
        if ("1".equals(sort)) {
            sort = "attack";
        } else if ("2".equals(sort)) {
            sort = "ruse";
        } else if ("3".equals(sort)) {
            sort = "speed";
        } else if ("4".equals(sort)) {
            sort = "def";
        } else if ("5".equals(sort)) {
            sort = "siege";
        } else {
            sort = "id";
        }
        List<StHero> list = heroMapper.listStHeroByPage(page, hero, sort);
        return page.setRows(list);
    }

    @Override
    public void addContrastHero(Integer id) {
        StHero stHero = heroMapper.selectByPrimaryKey(id);
        if (stHero == null) {
            throw new RuntimeException("武将不存在，添加失败");
        }
        StContrast stContrast = stContrastMapper.getContrastByHeroid(id);
        if (stContrast != null) {
            throw new RuntimeException("重复添加");
        }
        stContrast = new StContrast();
        stContrast.setSdate(new Date());
        stContrast.setHeroid(id);
        stContrast.setStatus(1);
        stContrast.setUserid(1);
        stContrastMapper.insert(stContrast);
    }

    @Override
    public List<StHero> listContrastHero(Integer userid) {
        return heroMapper.listContrastHeroByUser(userid);
    }

    @Override
    public void delContrastHero(Integer heroid) {
        stContrastMapper.deleteByHeroid(heroid);
    }

//    private StWj getElementHtml(String s, Integer id) {
//        StWj st = new StWj();
//        st.setId(id);
//        st.setCreatedate(new Date());
//        Document doc = Jsoup.parse(s, "UTF-8");
//        //武将名称
//        Elements namedoc = doc.select("h1");
//        String name = "";
//        if (namedoc.size() > 1) {
//            name = doc.select("h1").get(1).text();
//        } else {
//            name = doc.select("h1").get(0).text();
//        }
//        st.setName(name);
//        //武将星级
//        String xjs = doc.select("span.star").first().select("i").attr("class");
//        String[] xj = xjs.split("-");
//        if (xj.length < 2) {
//            xjs = "5";
//        } else {
//            xjs = xj[1];
//        }
//        st.setXj(xjs);
//        //武将信息
//        Elements elements = doc.select("p.attr-list");
//        for (int i = 0; i < elements.size(); i++) {
//            Elements el = elements.get(i).select("span");
//            for (int j = 0; j < el.size(); j++) {
//                String as = el.get(j).text();
//                String jqsz = pattern.matcher(as).replaceAll("");
//                BigDecimal shuzi = new BigDecimal(0);
//                if (!StringUtils.isEmpty(jqsz)) {
//                    shuzi = new BigDecimal(jqsz);
//                }
//                if (i == 0) {
//                    if (j == 0) {
//                        if (shuzi.compareTo(new BigDecimal("10")) == 1) {
//                            st.setCost(shuzi.divide(new BigDecimal("10")));
//                        } else {
//                            st.setCost(shuzi);
//                        }
//                        continue;
//                    }
//                    if (j == 1) {
//                        //兵种
//                        st.setBz(as);
//                        continue;
//                    }
//                    if (j == 2) {
//                        st.setJl(shuzi);
//                        continue;
//                    }
//                } else if (i == 1) {
//                    if (j == 0) {
//                        st.setMn(shuzi);
//                        continue;
//                    }
//                    if (j == 1) {
//                        st.setGj(shuzi);
//                        continue;
//                    }
//                    if (j == 2) {
//                        st.setGc(shuzi);
//                        continue;
//                    }
//                } else if (i == 2) {
//                    if (j == 0) {
//                        st.setFy(shuzi);
//                        continue;
//                    }
//                    if (j == 1) {
//                        st.setSd(shuzi);
//                        continue;
//                    }
//                }
//            }
//        }
//        Elements attr = doc.select("dl.group");
//        for (int i = 0; i < attr.size(); i++) {
//            Elements el = attr.get(i).getElementsByTag("dd");
//            System.out.println(el.text());
//            if (i == 0) {
//                st.setZf(el.text());
//            } else {
//                st.setCj(el.text());
//            }
//        }
//        return st;
//    }
}
