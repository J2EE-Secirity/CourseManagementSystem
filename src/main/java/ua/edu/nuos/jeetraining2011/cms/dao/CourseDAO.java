package ua.edu.nuos.jeetraining2011.cms.dao;

import ua.edu.nuos.jeetraining2011.cms.entity.Course;
import ua.edu.nuos.jeetraining2011.cms.entity.Student;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * User: dimon
 * Date: 05.06.12
 * Time: 19:53
 */
@Stateless
@Local
public class CourseDAO {
    @PersistenceContext
    private EntityManager em;

    public Course getCourseById(long id) {
        try {
            return em.find(Course.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Can't get course: " + e.getMessage());
        }
    }

    public List<Course> getAllCourses() {
        TypedQuery<Course> query = em.createQuery("select c from Course c", Course.class);

        try {
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Can't get list of courses: " + e.getMessage());
        }
    }

    public void addStudent(Student student, int courseId) {
        Course course = getCourseById(courseId);
        course.getStudents().add(student);
    }
}
