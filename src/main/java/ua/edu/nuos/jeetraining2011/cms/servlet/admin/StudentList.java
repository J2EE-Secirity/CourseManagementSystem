package ua.edu.nuos.jeetraining2011.cms.servlet.admin;

import org.apache.commons.lang.StringUtils;
import ua.edu.nuos.jeetraining2011.cms.dao.CourseDAO;
import ua.edu.nuos.jeetraining2011.cms.dao.StudentDAO;
import ua.edu.nuos.jeetraining2011.cms.entity.Course;
import ua.edu.nuos.jeetraining2011.cms.entity.RegistrationRequestItem;
import ua.edu.nuos.jeetraining2011.cms.entity.Student;
import ua.edu.nuos.jeetraining2011.cms.service.CourseManager;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: dimon
 * Date: 23.06.12
 * Time: 21:05
 * To change this template use File | Settings | File Templates.
 */

@WebServlet(urlPatterns = {"/students"})
public class StudentList extends HttpServlet {
    @EJB
    CourseManager courseManager;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqCourseId = req.getParameter("courseId");

        int courseId = 0;
        if (StringUtils.isNotEmpty(reqCourseId)) {
            try {
                courseId = Integer.parseInt(reqCourseId);
            } catch (NumberFormatException e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Illegal argument");
            }
            if (courseManager.getCourseById(courseId) != null) {
                Course course = courseManager.getCourseById(courseId);
                List<Student> students = course.getStudents();

                req.setAttribute("students", students);

                req.getRequestDispatcher("/StudentList.jspx").forward(req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Illegal argument");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Illegal argument");
        }
    }

}
