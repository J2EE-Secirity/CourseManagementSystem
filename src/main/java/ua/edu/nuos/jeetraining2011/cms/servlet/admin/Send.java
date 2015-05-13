package ua.edu.nuos.jeetraining2011.cms.servlet.admin;

import ua.edu.nuos.jeetraining2011.cms.service.CourseManager;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Саша
 * Date: 19.07.12
 * Time: 19:24
 * To change this template use File | Settings | File Templates.
 */

@WebServlet(urlPatterns = {"/send"})
public class Send extends HttpServlet {
    @EJB
    CourseManager courseManager;

    @Override
    protected void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        httpServletRequest.getRequestDispatcher("/Send.jspx").forward(httpServletRequest, httpServletResponse);
    }
}