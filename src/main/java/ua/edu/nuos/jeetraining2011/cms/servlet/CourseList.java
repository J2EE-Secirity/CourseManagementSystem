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
 * User: jeetrainee
 * Date: 6/6/12
 * Time: 7:07 PM
 */
@WebServlet(urlPatterns = {"/courses"})
public class CourseList extends HttpServlet {
    @EJB
    CourseManager courseManager;

    @Override
    protected void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        List<Course> courses = courseManager.getAllCourses();
        List<List<Course>> rowList = new LinkedList<>();
        int quantity = 0;
        List<Course> coursesRow = null;
        for (Course course : courses) {
            if (coursesRow == null)
                coursesRow = new LinkedList<>();
            if (quantity == 3) {
                rowList.add(coursesRow);
                coursesRow = new LinkedList<>();
                quantity = 0;
            }
            coursesRow.add(course);
            quantity++;
        }
        if (coursesRow.size() != 0)
            rowList.add(coursesRow);

        httpServletRequest.setAttribute("rows", rowList);
        httpServletRequest.getRequestDispatcher("/CourseList.jspx").forward(httpServletRequest, httpServletResponse);
    }
}
