package ua.edu.nuos.jeetraining2011.cms.dao;

import ua.edu.nuos.jeetraining2011.cms.entity.Quiz;
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
public class QuizDAO {
    @PersistenceContext
    private EntityManager em;

    public Quiz getQuizById(long id) {
        try {
            return em.find(Quiz.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Can't get quiz: " + e.getMessage());
        }
    }

    public List<Quiz> getAllQuizesOfCourse(long id) {
        TypedQuery<Task> query = em.createQuery("select c.tasks from Course c", Task.class);
        List<Task> tasks = query.getResultList();
        List<Quiz> quizes = new LinkedList<>();
        for (Task task : tasks) {
            if (task.getClass() == Quiz.class)
                quizes.add((Quiz) task);
        }

        try {
            return quizes;
        } catch (Exception e) {
            throw new RuntimeException("Can't get list of quizes: " + e.getMessage());
        }
    }

}
