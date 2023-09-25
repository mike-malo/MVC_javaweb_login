package servlet;

import dao.AdminDao;
import model.Admin;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String method = request.getParameter("method");
        String name = request.getParameter("account");
        String password = request.getParameter("password");
        String loginStatus = "loginFailed";
        AdminDao adminDao = new AdminDao();
        Admin admin = adminDao.login(name, password);
        adminDao.closeCon();
        if (admin == null) {
            response.getWriter().write("loginError");
            return;
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", admin);
        loginStatus = "loginSuccess";
        response.getWriter().write(loginStatus);
    }
}
