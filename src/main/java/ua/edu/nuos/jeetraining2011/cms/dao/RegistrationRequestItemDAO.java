package ua.edu.nuos.jeetraining2011.cms.dao;

import ua.edu.nuos.jeetraining2011.cms.entity.Course;
import ua.edu.nuos.jeetraining2011.cms.entity.RegistrationRequestItem;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

/**
 * User: Александр
 * Date: 16.06.12
 * Time: 0:41
 */
@Stateless
@Local
public class RegistrationRequestItemDAO {
    @PersistenceContext
    private EntityManager em;

    public RegistrationRequestItem getRegistrationRequestItemById(long id) {
        return em.find(RegistrationRequestItem.class, id);
    }

    public RegistrationRequestItem getRegistrationRequestItemByLogin(String login) {
        TypedQuery<RegistrationRequestItem> query = em.createQuery("select item from RegistrationRequestItem item where item.login=:login", RegistrationRequestItem.class);
        query.setParameter("login", login);
        RegistrationRequestItem registrationRequestItem;
        try {
            registrationRequestItem = query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        return registrationRequestItem;
    }

    public void addRegistrationRequestItem(String login, long courseId) {
        Course course = em.find(Course.class, courseId);

        RegistrationRequestItem registrationRequestItem = new RegistrationRequestItem(login, new Date(), login, course);
        em.persist(registrationRequestItem);

    }

    public void removeRegistrationRequestItem(RegistrationRequestItem registrationRequestItem) {
        RegistrationRequestItem item = em.find(RegistrationRequestItem.class, registrationRequestItem.getId());
        em.remove(item);
    }

    public List<RegistrationRequestItem> getAllRegistrationRequestItemsOfCourse(long id) {
        TypedQuery<RegistrationRequestItem> query = em.createQuery("select r from RegistrationRequestItem r where r.course.id = :id", RegistrationRequestItem.class);
        query.setParameter("id", id);
        try {
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Can't get list of registration request items: " + e.getMessage());
        }
    }
}
