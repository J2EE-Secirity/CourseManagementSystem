package ua.edu.nuos.jeetraining2011.cms.dao;

import ua.edu.nuos.jeetraining2011.cms.entity.Lection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * User: Александр
 * Date: 13.06.12
 * Time: 16:41
 */
@Stateless
@Local
public class LectionDAO {
    @PersistenceContext
    private EntityManager em;

    public Lection getLectionById(long id) {
        try {
            return em.find(Lection.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Can't get lection: " + e.getMessage());
        }
    }

    public List<Lection> getAllLectionsOfCourse(long id) {
        TypedQuery<Lection> query = em.createQuery("select c.lections from Course c", Lection.class);

        try {
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Can't get list of lections: " + e.getMessage());
        }
    }

}
