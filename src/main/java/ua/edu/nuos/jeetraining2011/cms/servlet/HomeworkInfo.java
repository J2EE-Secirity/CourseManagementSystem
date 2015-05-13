package ua.edu.nuos.jeetraining2011.cms.servlet;

import org.apache.commons.lang.StringUtils;
import ua.edu.nuos.jeetraining2011.cms.entity.Homework;
import ua.edu.nuos.jeetraining2011.cms.service.CourseManager;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: Александр
 * Date: 13.06.12
 * Time: 17:47
 */
@WebServlet(urlPatterns = "/homeworkInfo")
public class HomeworkInfo extends HttpServlet {

    @EJB
    CourseManager courseManager;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String reqHomeworkId = req.getParameter("id");

        long homeworkId = 0;
        if (StringUtils.isNotEmpty(reqHomeworkId)) {
            try {
                homeworkId = Long.parseLong(reqHomeworkId);
            } catch (NumberFormatException e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Illegal argument");
            }
            Homework homework;
            if ((homework = courseManager.getHomeworkById(homeworkId)) != null) {
                req.setAttribute("homework", homework);
                req.getRequestDispatcher("/HomeworkInfo.jspx").forward(req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Illegal argument");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Illegal argument");
        }
    }
}
