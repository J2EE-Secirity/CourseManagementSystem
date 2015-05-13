package ua.edu.nuos.jeetraining2011.cms.servlet.admin;

import org.apache.commons.lang.StringUtils;
import ua.edu.nuos.jeetraining2011.cms.entity.Course;
import ua.edu.nuos.jeetraining2011.cms.entity.RegistrationRequestItem;
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
 * User: dimon
 * Date: 15.06.12
 * Time: 14:47
 */
@WebServlet(urlPatterns = "/admin/regreq")
public class RegistrationRequestList extends HttpServlet {
    @EJB
    private CourseManager courseManager;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        String reqCourseId = req.getParameter("courseId");
        String[] applicantsIds = req.getParameterValues("applicants");

        int courseId = 0;
        if (StringUtils.isNotEmpty(reqCourseId)) {
            try {
                courseId = Integer.parseInt(reqCourseId);
            } catch (NumberFormatException e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Illegal argument");
            }
            if (courseManager.getCourseById(courseId) != null) {
                if (applicantsIds != null) {
                    String reqAction = req.getParameter("action");
                    switch (reqAction){
                        case "Approve":
                            approveApplicants(applicantsIds, courseId);
                            break;
                        case "Reject":
                            rejectApplicants(applicantsIds);
                            break;
                    }

                }
                Course course = courseManager.getCourseById(courseId);
                List<RegistrationRequestItem> registrationRequestItems = courseManager.getAllRegistrationRequestItems(course.getId());

                req.setAttribute("applicants", registrationRequestItems);

                req.getRequestDispatcher("/RegistrationRequestList.jspx").forward(req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Illegal argument");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Illegal argument");
        }
    }

    private void approveApplicants(String[] ids, int courseId) {
        for (String id : ids) {
            courseManager.approveRegistrationRequest(Integer.parseInt(id), courseId);
        }
    }

    private void rejectApplicants(String[] ids) {
        for (String id : ids) {
            courseManager.rejectRegistrationRequest(Integer.parseInt(id));
        }
    }

}
