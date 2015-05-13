package ua.edu.nuos.jeetraining2011.cms.servlet;

import ua.edu.nuos.jeetraining2011.cms.entity.Course;
import ua.edu.nuos.jeetraining2011.cms.service.CourseManager;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Саша
 * Date: 19.07.12
 * Time: 11:57
 * To change this template use File | Settings | File Templates.
 */

@WebServlet(urlPatterns = {"/index"})
public class Index extends HttpServlet {
    @EJB
    CourseManager courseManager;

    @Override
    protected void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        httpServletRequest.getRequestDispatcher("/Index.jspx").forward(httpServletRequest, httpServletResponse);
    }
}
