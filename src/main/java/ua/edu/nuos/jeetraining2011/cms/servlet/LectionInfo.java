package ua.edu.nuos.jeetraining2011.cms.servlet;

import org.apache.commons.lang.StringUtils;
import org.xml.sax.SAXException;
import ua.edu.nuos.jeetraining2011.cms.entity.Lection;
import ua.edu.nuos.jeetraining2011.cms.service.CourseManager;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;


/**
 * User: Александр
 * Date: 13.06.12
 * Time: 16:25
 */
@WebServlet(urlPatterns = "/lectionInfo")
public class LectionInfo extends HttpServlet {
    @EJB
    CourseManager courseManager;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqLectionId = req.getParameter("id");

        long lectionId = 0;
        if (StringUtils.isNotEmpty(reqLectionId)) {
            try {
                lectionId = Long.parseLong(reqLectionId);
            } catch (NumberFormatException e) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Illegal argument");
            }
            Lection lection;
            if ((lection = courseManager.getLectionById(lectionId)) != null) {
                req.setAttribute("lection", lection);
                req.setAttribute("embeddedCode", getEmbeddedCode(lection));
                req.getRequestDispatcher("/LectionInfo.jspx").forward(req, resp);
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Illegal argument");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Illegal argument");
        }
    }

    private String getEmbeddedCode(Lection lection) {
        StringBuilder xmlString = new StringBuilder();

        switch (lection.getType()) {
            case HYPERTEXT:
                xmlString.append(lection.getText());
                break;
            case VIDEO:
                xmlString.append("<iframe class = 'youtube-player' type = 'text/html' width='320' height='240' src = '").append(lection.getUrl()).append("?html5=1' frameborder = '0'></iframe>");
                break;
            case PRESENTATION:
                xmlString.append("<iframe src='").append(lection.getUrl()).append("' frameborder='0' width='480' height='389' allowfullscreen='true' mozallowfullscreen='true' webkitallowfullscreen='true'></iframe>");
                break;
            case PDF:
                xmlString.append("<iframe src='").append(lection.getUrl()).append("' frameborder='0' width='800' height='600'></iframe>");
                break;
            default:
                xmlString.append("<div>No info added</div>");
        }

/*
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            dbFactory.setValidating(true);
            DocumentBuilder builder = dbFactory.newDocumentBuilder();
            builder.parse(new ByteArrayInputStream(xmlString.toString().getBytes()));
        } catch (SAXException | IOException | ParserConfigurationException e) {
            throw new RuntimeException("Parsing error occured", e);
        }
*/

        return xmlString.toString();
    }

}
