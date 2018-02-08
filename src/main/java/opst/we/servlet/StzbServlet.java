package opst.we.servlet;

import opst.we.util.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * @author: chgj
 * @description:
 * @date: create in 2018/1/29 15:27
 * @modified:
 */
@WebServlet(name = "test", urlPatterns = "/test")
public class StzbServlet extends HttpServlet {
    /**
     * @param req
     * @param resp
     * @author: chgj
     * @description:
     * @date: 2017/11/13 11:01
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Statement statement = null;
        ResultSet rs = null;
        try {
            //1获取connection
            Connection conn = JdbcUtils.getConnection();
            //2.获取Statement
            statement = conn.createStatement();
            //3.准备Sql
            String sql = "SELECT * FROM ST_WJ";
            //4.执行查询，得到ResultSet
            rs = statement.executeQuery(sql);
            //5.处理ResultSet
            while(rs.next()){
                //rs.get+数据库中对应的类型+(数据库中对应的列别名)
                int id = rs.getInt("ID");
                String name = rs.getString("name");
                String email = rs.getString("desc");
                String birth = rs.getString("mn");

                System.out.println(id);
                System.out.println(name);
                System.out.println(email);
                System.out.println(birth);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("index1.htm");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
