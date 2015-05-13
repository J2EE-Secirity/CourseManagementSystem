package ua.edu.nuos.jeetraining2011.cms.servlet;

import org.apache.commons.lang.StringUtils;
import ua.edu.nuos.jeetraining2011.cms.entity.Course;
import ua.edu.nuos.jeetraining2011.cms.entity.RegistrationRequestItem;
import ua.edu.nuos.jeetraining2011.cms.entity.Student;
import ua.edu.nuos.jeetraining2011.cms.service.CourseManager;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: Александр
 * Date: 15.06.12
 * Time: 17:08
 */
@WebServlet(urlPatterns = "/register")
@ServletSecurity(
        @HttpConstraint(transportGuarantee = ServletSecurity.TransportGuarantee.CONFIDENTIAL,
                rolesAllowed = {"user"}))
public class UserRegistration extends HttpServlet {
    @EJB
    private CourseManager courseManager;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login =  req.getUserPrincipal().getName();
        String reqCourseId = req.getParameter("courseId");
        if (StringUtils.isEmpty(reqCourseId)) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Illegal argument");
            return;
        }
        Course course = courseManager.getCourseById(Long.valueOf(reqCourseId));
        if (course != null) {
            for (Student student : course.getStudents()) {
                if (student.getLogin().equals(login)) {
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "This login is using by other client");
                    return;
                }
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Course Id");
            return;
        }
        RegistrationRequestItem item = courseManager.getRegistrationRequestItemByLogin(login);
        if (item != null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "This login is using by other client");
            return;
        }
        courseManager.addRegistrationRequestItem(login, Long.parseLong(reqCourseId));
        resp.sendRedirect("courseInfo?id=" + Long.parseLong(reqCourseId));
    }
}
