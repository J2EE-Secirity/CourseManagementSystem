package ua.edu.nuos.jeetraining2011.cms.dao;

import ua.edu.nuos.jeetraining2011.cms.entity.Homework;
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
 * Time: 17:42
 */
@Stateless
@Local
public class HomeworkDAO {
    @PersistenceContext
    private EntityManager em;

    public Homework getHomeworkById(long id) {
        try {
            return em.find(Homework.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Can't get homework: " + e.getMessage());
        }
    }

    public List<Homework> getAllHomeworksOfCourse(long id) {
        TypedQuery<Task> query = em.createQuery("select c.tasks from Course c", Task.class);
        List<Task> tasks = query.getResultList();
        List<Homework> homeworks = new LinkedList<>();
        for (Task task : tasks) {
            if (task.getClass() == Homework.class)
                homeworks.add((Homework) task);
        }

        int a  = 55_5;

        try {
            return homeworks;
        } catch (Exception e) {
            throw new RuntimeException("Can't get list of homeworks: " + e.getMessage());
        }
    }
}
