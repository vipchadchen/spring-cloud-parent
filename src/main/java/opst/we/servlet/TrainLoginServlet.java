package opst.we.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import opst.we.Constants;
import opst.we.util.TticketUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: chgj
 * @description:
 * @date: create in 2017/11/13 10:36
 * @modified:
 */
@WebServlet(name = "login", urlPatterns = "/login")
public class TrainLoginServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(TrainLoginServlet.class);

    /**
     * @param req
     * @param resp
     * @author: chgj
     * @description: 登录
     * @date: 2017/11/13 11:01
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 验证码
         * 42,43
         * 110,38
         * 180,32
         * 254,29
         * 44,107
         * 112,112
         * 184,120
         * 252,120
         */
        String uname = req.getParameter("uname");
        String ppass = req.getParameter("ppass");
        String rcode = req.getParameter("rcode");
        logger.info(uname + ppass + rcode);
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            logger.info(cookie.getName() + "====" + cookie.getValue());
        }
        try {
            //校验
            String checktext = TticketUtil.post(Constants.CHECK_CODE_URL, "answer=" + rcode + "&login_site=E&" + "rand=sjrand");
            if (!"".equals(checktext) && checktext != null) {
                JSONObject jsonObject = JSON.parseObject(checktext);
                logger.info("校验结果："+jsonObject.getString(Constants.RESULT_CODE));
                if (Constants.CHECK_CODE.equals(jsonObject.getString(Constants.RESULT_CODE))) {
                    //登录
                    String logintext = TticketUtil.post(Constants.LOGIN_URL, "username=" + uname + "&password=" + ppass + "&appid=otn");
                    if (!"".equals(logintext) && logintext != null) {
                        JSONObject loginstr = JSON.parseObject(logintext);
                        logger.info("登录结果："+loginstr.getString(Constants.RESULT_CODE));
                        if (Constants.LOGIN_CODE.equals(loginstr.getString(Constants.RESULT_CODE))) {
                                resp.sendRedirect("order");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("--------------------失败");
        resp.sendRedirect("tticket");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
