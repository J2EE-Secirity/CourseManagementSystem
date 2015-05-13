package ua.edu.nuos.jeetraining2011.cms.servlet.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * User: Саша
 * Date: 20.07.12
 * Time: 5:41
 * To change this template use File | Settings | File Templates.
 *
 * Servlet implementation class LoginServlet
 */

@WebServlet(urlPatterns = "/admin/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String UserName = request.getParameter("username");
        String ResultPage;

        HttpSession session = request.getSession();

        UserInfo User = (UserInfo) session.getAttribute("userInfo");

        if (User == null)
            User = new UserInfo();

        if (UserName.equals("gizur"))
        {
            User.Login(UserName);
            ResultPage = "/login_ok.jsp";
            session.setAttribute("userInfo", User);
        }
        else
        {
            ResultPage = "/login.jsp";
            User.SetError("Incorrect user name - " + UserName);
            session.setAttribute("userInfo", User);
        }


        ServletContext SC = getServletContext();
        RequestDispatcher Disp = SC.getRequestDispatcher(ResultPage);
        Disp.forward(request, response);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            String IsLogout = request.getParameter("logout");

            HttpSession session = request.getSession();

            String ResultPage;
            UserInfo User = (UserInfo) session.getAttribute("userInfo");

            if (User == null)
                User = new UserInfo();

            if (IsLogout != null)
                if (IsLogout.equals("true"))
                    User.Logout();

            ResultPage = "/login.jsp";

            session.setAttribute("userInfo", User);

            ServletContext SC = getServletContext();
            RequestDispatcher Disp = SC.getRequestDispatcher(ResultPage);
            Disp.forward(request, response);
        }
        catch (Throwable theException)
        {
            theException.printStackTrace();
        }
    }

}