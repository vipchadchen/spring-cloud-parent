package opst.we.service.impl;

import opst.we.model.StWj;
import opst.we.model.mapper.StWjMapper;
import opst.we.service.StzbService;
import opst.we.util.HttpsClientSSL;
import opst.we.util.Page;
import opst.we.util.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Service
@Transactional(rollbackFor = Exception.class)
public class StzbServiceImpl implements StzbService {
    @Autowired
    private StWjMapper mapper;
    private static final Logger logger = LoggerFactory.getLogger(StzbServiceImpl.class);
    static Pattern pattern = Pattern.compile("[^0-9]");

    @Override
    public List<StWj> listWj() {
        return mapper.selectByExample(null);
    }

    @Override
    public Page listWjByPage(Page page) {
        return page.setRows(mapper.listWjByPage(page));
    }

    @Override
    public void updateHero() {
        Integer id = mapper.selectWxMaxId();
        if (id == null) {
            id = 100000;
        }
        logger.info("当前最大id url" + id);
        for (int i = id + 1; i < 100289; i++) {
            logger.info("数据拉取:" + i);
            String s = HttpsClientSSL.postUrl("http://stzb.163.com/herolist/" + i + ".html", "");
            if (StringUtils.isEmpty(s)) {
                continue;
            }
            if ("timeout".equals(s)) {
                break;
            }
            //插入数据库i
            try {
                StWj stWj = getElementHtml(s, i);
                mapper.insert(stWj);
            } catch (Exception e) {
                logger.error(e.toString());
                break;
            }
        }
    }

    @Override
    public StWj getFirstHero(String type) {
        if("1".equals(type)){
            type = "gj";
        }else if("2".equals(type)){
            type = "mn";
        }else if("3".equals(type)){
            type = "gc";
        }else if("4".equals(type)){
            type = "sd";
        }else if("5".equals(type)){
            type = "jl";
        }else if("6".equals(type)){
            type = "fy";
        }else{
            type = "gj";
        }
        StWj wj =  mapper.getFirstHero(type);
        return wj;
    }

    private StWj getElementHtml(String s, Integer id) {
        StWj st = new StWj();
        st.setId(id);
        st.setCreatedate(new Date());
        Document doc = Jsoup.parse(s, "UTF-8");
        //武将名称
        Elements namedoc = doc.select("h1");
        String name = "";
        if(namedoc.size()>1){
            name = doc.select("h1").get(1).text();
        }else {
            name = doc.select("h1").get(0).text();
        }
        st.setName(name);
        //武将星级
        String xjs = doc.select("span.star").first().select("i").attr("class");
        String[] xj = xjs.split("-");
        if (xj.length < 2) {
            xjs = "5";
        } else {
            xjs = xj[1];
        }
        st.setXj(xjs);
        //武将信息
        Elements elements = doc.select("p.attr-list");
        for (int i = 0; i < elements.size(); i++) {
            Elements el = elements.get(i).select("span");
            for (int j = 0; j < el.size(); j++) {
                String as = el.get(j).text();
                String jqsz = pattern.matcher(as).replaceAll("");
                BigDecimal shuzi = new BigDecimal(0);
                if (!StringUtils.isEmpty(jqsz)) {
                    shuzi = new BigDecimal(jqsz);
                }
                if (i == 0) {
                    if (j == 0) {
                        if (shuzi.compareTo(new BigDecimal("10")) == 1) {
                            st.setCost(shuzi.divide(new BigDecimal("10")));
                        } else {
                            st.setCost(shuzi);
                        }
                        continue;
                    }
                    if (j == 1) {
                        //兵种
                        st.setBz(as);
                        continue;
                    }
                    if (j == 2) {
                        st.setJl(shuzi);
                        continue;
                    }
                } else if (i == 1) {
                    if (j == 0) {
                        st.setMn(shuzi);
                        continue;
                    }
                    if (j == 1) {
                        st.setGj(shuzi);
                        continue;
                    }
                    if (j == 2) {
                        st.setGc(shuzi);
                        continue;
                    }
                } else if (i == 2) {
                    if (j == 0) {
                        st.setFy(shuzi);
                        continue;
                    }
                    if (j == 1) {
                        st.setSd(shuzi);
                        continue;
                    }
                }
            }
        }
        Elements attr = doc.select("dl.group");
        for (int i = 0; i < attr.size(); i++) {
            Elements el = attr.get(i).getElementsByTag("dd");
            System.out.println(el.text());
            if (i == 0) {
                st.setZf(el.text());
            } else {
                st.setCj(el.text());
            }
        }
        return st;
    }
}
