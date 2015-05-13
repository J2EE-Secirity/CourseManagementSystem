package ua.edu.nuos.jeetraining2011.cms.servlet;

import org.apache.commons.lang.StringUtils;
import ua.edu.nuos.jeetraining2011.cms.classes.GradeBookEntity;
import ua.edu.nuos.jeetraining2011.cms.entity.Course;
import ua.edu.nuos.jeetraining2011.cms.entity.Student;
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
 * Created with IntelliJ IDEA.
 * User: Александр
 * Date: 24.06.12
 * Time: 19:48
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(urlPatterns = "/courseGradebook")
public class CourseGradebookServlet extends HttpServlet {

    @EJB
    CourseManager courseManager;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseId = req.getParameter("courseId");

        long courseID = 0L;
        if (StringUtils.isNotEmpty(courseId)) {
            try {
                courseID = Long.parseLong(courseId);
            } catch (NumberFormatException e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Illegal argument");
            }
            if (courseManager.getCourseById(courseID) != null) {
                Course course = courseManager.getCourseById(courseID);
                List<Integer> phases = courseManager.getPhases(courseID);
                List<Student> students = courseManager.getStudentsOfCourse(courseID);
                List<GradeBookEntity> gradeBookEntities = courseManager.getMarksForStudentsOfCourse(students, phases, course);
                req.setAttribute("course", course);
                req.setAttribute("phases", phases);
                req.setAttribute("gradeBookEntities", gradeBookEntities);
                req.getRequestDispatcher("/CourseGradeBookInfo.jspx").forward(req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Illegal argument");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Illegal argument");
        }
    }
}
