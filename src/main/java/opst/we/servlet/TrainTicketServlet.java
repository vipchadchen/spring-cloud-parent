package opst.we.servlet;

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
import java.util.List;

/**
 * @author: chgj
 * @description:
 * @date: create in 2017/11/13 10:36
 * @modified:
 */
@WebServlet(name = "tticket", urlPatterns = "/tticket")
public class TrainTicketServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(TrainTicketServlet.class);

    /**
     * @param req
     * @param resp
     * @author: chgj
     * @description: 登录
     * @date: 2017/11/13 11:01
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            /**
             * 初始化
             */
            TticketUtil.get(Constants.INIT_URL);
            /**
             * 获取验证码,下载到本地
             */
            TticketUtil.getFile(Constants.IMG_URL + Math.random());
        } catch (Exception e) {
            e.printStackTrace();
        }
        Cookie icookie = null;
        List<org.apache.http.cookie.Cookie> cookies = TticketUtil.printCookies();
        for (org.apache.http.cookie.Cookie cookie : cookies) {
            icookie = new Cookie(cookie.getName(), cookie.getValue());
            resp.addCookie(icookie);
        }
        req.getRequestDispatcher("login.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
