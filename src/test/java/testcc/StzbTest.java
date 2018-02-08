package testcc;

import opst.we.util.HttpsClientSSL;
import opst.we.util.JdbcUtils;
import opst.we.util.JsonUtil;
import opst.we.util.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;


/**
 * @author: chgj
 * @description:
 * @date: create in 2018/1/29 15:29
 * @modified:
 */
public class StzbTest {
    static Pattern pattern = Pattern.compile("[^0-9]");
    public static void main(String[] args) {
//        insert();
        String s = HttpsClientSSL.postUrl("http://stzb.163.com/herolist/100001.html","");
        System.out.println(s);
                getElement(s,1L);

    }

    public static  void insert(){
        Connection conn = JdbcUtils.getConnection("jdbc:mysql://127.0.0.1:3306/stzb?useUnicode=true&characterEncoding=utf8","stzb","stzb",JdbcUtils.MYSQL);
        try {
            conn.setAutoCommit(false);
            PreparedStatement updateSales1 = null;
            updateSales1 = conn.prepareStatement("insert into st_wj VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,'','')");
            for (int i = 100076; i < 100107; i++) {
                System.out.println("数据拉取:"+i);
                String s = HttpsClientSSL.postUrl("http://stzb.163.com/herolist/"+i+".html","");
                if(!StringUtils.isEmpty(s)){
                    if("timeout".equals(s)){
                        break;
                    }
                    StzbGenerals stzbGenerals = getElement(s,Long.valueOf(i));
                    updateSales1.setLong(1, stzbGenerals.getId());
                    updateSales1.setString(2, stzbGenerals.getName());
                    updateSales1.setString(3, stzbGenerals.getXj());

                    updateSales1.setString(4, stzbGenerals.getCost());
                    updateSales1.setString(5, stzbGenerals.getBz());
                    updateSales1.setString(6, stzbGenerals.getJl());

                    updateSales1.setString(7, stzbGenerals.getMn());
                    updateSales1.setString(8, stzbGenerals.getGj());
                    updateSales1.setString(9, stzbGenerals.getGc());
                    updateSales1.setString(10, stzbGenerals.getFy());

                    updateSales1.setString(11, stzbGenerals.getSd());
                    updateSales1.setString(12, stzbGenerals.getZf());
                    updateSales1.setString(13, stzbGenerals.getCj());
                    updateSales1.executeUpdate();
                }
            }
            conn.commit();
            updateSales1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public static StzbGenerals getElement(String s,Long id) {
        StzbGenerals st = new StzbGenerals();
        st.setId(id);
        Document doc = Jsoup.parse(s, "UTF-8");
        //武将名称
        String name = doc.select("h1").get(1).text();
        st.setName(name);
        String xjs = doc.select("span.star").first().select("i").attr("class");
        String [] xj = xjs.split("-");
        if(xj.length<2){
            xjs = "5";
        }else {
            xjs = xj[1];
        }
        System.out.println(xjs);
        //武将描述
        String desc = doc.select("p.desc").first().text();
        st.setDesc(desc);
        //信息
        Elements elements = doc.select("p.attr-list");
        for (int i = 0; i <elements.size() ; i++) {
            Elements el = elements.get(i).select("span");
            for (int j = 0; j < el.size(); j++) {
                String as = el.get(j).text();
                System.out.println("i="+i+"j="+j+"----"+as);
                String shuzi = pattern.matcher(as).replaceAll("");
                if(i==0){
                    if(j==0){
                        st.setCost(shuzi);
                        continue;
                    }
                    if(j==1){
                        //兵种
                        st.setBz(as);
                        continue;
                    }
                    if(j==2){
                        st.setJl(shuzi);
                        continue;
                    }
                }else if(i == 1){
                    if(j==0){
                        st.setMn(shuzi);
                        continue;
                    }
                    if(j==1){
                        st.setGj(shuzi);
                        continue;
                    }
                    if(j==2){
                        st.setGc(shuzi);
                        continue;
                    }
                }else if(i == 2){
                    if(j==0){
                        st.setFy(shuzi);
                        continue;
                    }
                    if(j==1){
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
            if(i==0){
                st.setZf(el.text());
            }else{
                st.setCj(el.text());
            }
        }
        System.out.println(JsonUtil.toJson(st));
        return  st;
    }

}

/*

    CREATE TABLE `stzb`.`Untitled`  (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
        `xj` varchar(2222) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
        `cost` decimal(10, 0) NULL DEFAULT NULL,
        `bz` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
        `jl` decimal(10, 0) NULL DEFAULT NULL,
        `mn` decimal(10, 0) NULL DEFAULT NULL,
        `gj` decimal(10, 0) NULL DEFAULT NULL,
        `gc` decimal(10, 0) NULL DEFAULT NULL,
        `fy` decimal(10, 0) NULL DEFAULT NULL,
        `sd` decimal(10, 0) NULL DEFAULT NULL,
        `zf` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
        `cj` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
        `createdate` datetime(0) NULL DEFAULT NULL,
        `ref1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
        `ref2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
        PRIMARY KEY (`id`) USING BTREE
        ) ENGINE = InnoDB AUTO_INCREMENT = 100200 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;*/
