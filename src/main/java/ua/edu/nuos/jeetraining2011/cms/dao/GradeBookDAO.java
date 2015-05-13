package ua.edu.nuos.jeetraining2011.cms.dao;

import ua.edu.nuos.jeetraining2011.cms.entity.Course;
import ua.edu.nuos.jeetraining2011.cms.entity.CoursePlanItem;
import ua.edu.nuos.jeetraining2011.cms.entity.GradeBook;
import ua.edu.nuos.jeetraining2011.cms.entity.Student;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Александр
 * Date: 24.06.12
 * Time: 19:58
 * To change this template use File | Settings | File Templates.
 */
@Stateless
@Local
public class GradeBookDAO {

    @PersistenceContext
    EntityManager entityManager;
    @EJB
    CourseDAO courseDAO;


    public GradeBook getGradeBookById(long id) {
        return entityManager.find(GradeBook.class, id);
    }

    public List<GradeBook> getAllGradeBooksOfCourse(long id) {
        Course course = courseDAO.getCourseById(id);
        TypedQuery<GradeBook> query = entityManager.createQuery("SELECT gradeBook FROM GradeBook gradeBook WHERE gradeBook.course=:course", GradeBook.class);
        query.setParameter("course", course);
        return query.getResultList();
    }

    public List<GradeBook> getAllGradeBooksOfCourse(Course course) {
        TypedQuery<GradeBook> query = entityManager.createQuery("SELECT gradeBook FROM GradeBook gradeBook WHERE gradeBook.course=:course", GradeBook.class);
        query.setParameter("course", course);
        return query.getResultList();
    }

    public List<GradeBook> getGradeBooksOfCoursePlanItem(CoursePlanItem coursePlanItem) {
        TypedQuery<GradeBook> query = entityManager.createQuery("SELECT gradeBook FROM GradeBook gradeBook WHERE gradeBook.coursePlanItem=:coursePlanItem", GradeBook.class);
        query.setParameter("coursePlanItem", coursePlanItem);
        return query.getResultList();
    }

    public String getMark(Student student, Course course, int phase) {
        TypedQuery<String> query = entityManager.createQuery("SELECT g.mark FROM GradeBook g WHERE g.student=:student AND g.course=:course AND g.coursePlanItem.phase=:phase", String.class);
        query.setParameter("student", student).setParameter("course", course).setParameter("phase", phase);
        String mark;
        try {
            mark = query.getSingleResult();
        } catch (NoResultException e) {
            mark = "-";
        }
        return mark;
    }
}
