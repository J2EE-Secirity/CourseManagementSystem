package ua.edu.nuos.jeetraining2011.cms.servlet;

import org.apache.commons.lang.StringUtils;
import ua.edu.nuos.jeetraining2011.cms.entity.*;
import ua.edu.nuos.jeetraining2011.cms.service.CourseManager;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * User: jeetrainee
 * Date: 6/9/12
 * Time: 10:18 AM
 */
@WebServlet(urlPatterns = "/courseInfo")
public class CourseInfo extends HttpServlet {
    @EJB
    CourseManager courseManager;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqCourseId = req.getParameter("id");

        int courseId = 0;
        if (StringUtils.isNotEmpty(reqCourseId)) {
            try {
                courseId = Integer.parseInt(reqCourseId);
            } catch (NumberFormatException e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Illegal argument");
            }
            if (courseManager.getCourseById(courseId) != null) {
                Course course = courseManager.getCourseById(courseId);
                List<CoursePlanItem> coursePlanItems = courseManager.getAllCoursePlanItems(course.getId());

                req.setAttribute("course", course);
                req.setAttribute("coursePlanItems", coursePlanItems);

                req.getRequestDispatcher("/CourseInfo.jspx").forward(req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Illegal argument");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Illegal argument");
        }
    }

}
