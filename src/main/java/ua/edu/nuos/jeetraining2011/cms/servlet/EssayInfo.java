package ua.edu.nuos.jeetraining2011.cms.servlet;

import org.apache.commons.lang.StringUtils;
import ua.edu.nuos.jeetraining2011.cms.entity.Essay;
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
 * Time: 17:29
 */
@WebServlet(urlPatterns = "/essayInfo")
public class EssayInfo extends HttpServlet {

    @EJB
    CourseManager courseManager;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String reqEssayId = req.getParameter("id");

        long essayId = 0;
        if (StringUtils.isNotEmpty(reqEssayId)) {
            try {
                essayId = Long.parseLong(reqEssayId);
            } catch (NumberFormatException e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Illegal argument");
            }
            Essay essay;
            if ((essay = courseManager.getEssayById(essayId)) != null) {
                req.setAttribute("essay", essay);
                req.getRequestDispatcher("/EssayInfo.jspx").forward(req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Illegal argument");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Illegal argument");
        }
    }
}

