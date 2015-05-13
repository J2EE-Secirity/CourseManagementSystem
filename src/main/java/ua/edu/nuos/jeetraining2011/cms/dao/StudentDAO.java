package ua.edu.nuos.jeetraining2011.cms.dao;

import ua.edu.nuos.jeetraining2011.cms.entity.Course;
import ua.edu.nuos.jeetraining2011.cms.entity.Student;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * User: dimon
 * Date: 15.06.12
 * Time: 22:52
 */
@Stateless
@Local
public class StudentDAO {
    @PersistenceContext
    private EntityManager em;
    @EJB
    private CourseDAO courseDAO;

    public void addStudent(Student student) {
        try {
            em.persist(student);
        } catch (Exception e) {
            throw new RuntimeException("Can't add student: " + e.getMessage());
        }
    }

    public List<Student> getStudentsOfCourse(long courseId) {
        Course course = courseDAO.getCourseById(courseId);
        TypedQuery<Student> query = em.createQuery("SELECT s FROM Course course JOIN course.students s WHERE course=:course", Student.class);
        query.setParameter("course", course);
        return query.getResultList();
    }
}
