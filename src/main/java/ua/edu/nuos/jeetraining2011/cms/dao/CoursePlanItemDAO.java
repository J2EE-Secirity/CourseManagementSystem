package ua.edu.nuos.jeetraining2011.cms.dao;

import ua.edu.nuos.jeetraining2011.cms.entity.Course;
import ua.edu.nuos.jeetraining2011.cms.entity.CoursePlanItem;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * User: dimon
 * Date: 19.06.12
 * Time: 20:35
 */
@Stateless
@Local
public class CoursePlanItemDAO {
    @PersistenceContext
    private EntityManager em;
    @EJB
    CourseDAO courseDAO;

    public List<CoursePlanItem> getCoursePlanItemsOfCourse(long id) {
        Course course = courseDAO.getCourseById(id);
        TypedQuery<CoursePlanItem> query = em.createQuery("SELECT coursePlanItem FROM CoursePlanItem coursePlanItem WHERE coursePlanItem.course=:course", CoursePlanItem.class);
        query.setParameter("course", course);
        return query.getResultList();
    }

    public List<CoursePlanItem> getCoursePlanItemsOfCourse(Course course) {
        TypedQuery<CoursePlanItem> query = em.createQuery("SELECT coursePlanItem FROM CoursePlanItem coursePlanItem WHERE coursePlanItem.course=:course", CoursePlanItem.class);
        query.setParameter("course", course);
        return query.getResultList();
    }

    public CoursePlanItem getCoursePlanItemById(long id) {
        return em.find(CoursePlanItem.class, id);
    }

    public List<Integer> getPhasesOfCourse(Course course) {
        TypedQuery<Integer> query = em.createQuery("SELECT DISTINCT c.phase FROM CoursePlanItem c WHERE c.course=:course ORDER BY c.phase", Integer.class);
        query.setParameter("course", course);
        return query.getResultList();
    }
}
