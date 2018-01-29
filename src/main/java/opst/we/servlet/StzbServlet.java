package opst.we.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: chgj
 * @description:
 * @date: create in 2018/1/29 15:27
 * @modified:
 */
@WebServlet(name = "stzb", urlPatterns = "/stzb")
public class StzbServlet extends HttpServlet {
    /**
     * @param req
     * @param resp
     * @author: chgj
     * @description: 登录
     * @date: 2017/11/13 11:01
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("1123");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
