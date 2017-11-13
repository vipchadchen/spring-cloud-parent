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

/**
 * @author: chgj
 * @description:
 * @date: create in 2017/11/13 10:36
 * @modified:
 */
@WebServlet(name = "order", urlPatterns = "/order")
public class TrainOrderServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(TrainOrderServlet.class);

    /**
     * @param req
     * @param resp
     * @author: chgj
     * @description: 登录
     * @date: 2017/11/13 11:01
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            logger.info("查询"+cookie.getName() + "====" + cookie.getValue());
        }

        try {
            String indextext = TticketUtil.get(Constants.SEND_URL);
            if (!"".equals(indextext) && indextext != null) {
              logger.info(indextext);
              req.setAttribute("page",indextext);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("index.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
