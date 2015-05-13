package ua.edu.nuos.jeetraining2011.cms.servlet;

import org.apache.commons.lang.StringUtils;
import ua.edu.nuos.jeetraining2011.cms.entity.Quiz;
import ua.edu.nuos.jeetraining2011.cms.service.CourseManager;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * User: Александр
 * Date: 13.06.12
 * Time: 17:50
 */
@WebServlet(urlPatterns = "/quizInfo")
public class QuizInfo extends HttpServlet {

    @EJB
    CourseManager courseManager;
    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String reqQuizId = req.getParameter("id");

        long quizId = 0;
        if (StringUtils.isNotEmpty(reqQuizId)) {
            try {
                quizId = Long.parseLong(reqQuizId);
            } catch (NumberFormatException e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Illegal argument");
            }
            Quiz quiz;
            if ((quiz = courseManager.getQuizById(quizId)) != null) {
                req.setAttribute("quiz", quiz);
                req.getRequestDispatcher("/QuizInfo.jspx").forward(req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Illegal argument");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Illegal argument");
        }
    }
}
