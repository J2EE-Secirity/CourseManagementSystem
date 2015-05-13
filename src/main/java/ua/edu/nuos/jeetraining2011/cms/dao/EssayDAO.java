package ua.edu.nuos.jeetraining2011.cms.dao;

import ua.edu.nuos.jeetraining2011.cms.entity.Essay;
import ua.edu.nuos.jeetraining2011.cms.entity.Task;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.LinkedList;
import java.util.List;

/**
 * User: Александр
 * Date: 13.06.12
 * Time: 17:30
 */
@Stateless
@Local
public class EssayDAO {
    @PersistenceContext
    private EntityManager em;

    public Essay getEssayById(long id) {
        try {
            return em.find(Essay.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Can't get essay: " + e.getMessage());
        }
    }

    public List<Essay> getAllEssaysOfCourse(long id) {
        TypedQuery<Task> query = em.createQuery("select c.tasks from Course c", Task.class);
        List<Task> tasks = query.getResultList();
        List<Essay> essays = new LinkedList<>();
        for (Task task : tasks) {
            if (task.getClass() == Essay.class)
                essays.add((Essay) task);
        }

        try {
            return essays;
        } catch (Exception e) {
            throw new RuntimeException("Can't get list of essays: " + e.getMessage());
        }
    }
}
