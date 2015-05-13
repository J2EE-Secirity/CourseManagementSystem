package ua.edu.nuos.jeetraining2011.cms.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * User: Александр
 * Date: 08.06.12
 * Time: 16:26
 */
public class EntitiesGenerator {
    private EntityManagerFactory emf;
    private EntityManager em;

    public EntitiesGenerator() {
        emf = Persistence.createEntityManagerFactory("CourseManagementSystem");
        em = emf.createEntityManager();
    }

    /*public void createCourses() {
        createStudents();
        em.getTransaction().begin();
        for (int i = 0; i < 7; i++) {
            Course course = new Course("Course" + i, new Date(), new Date(System.currentTimeMillis() + 20000L), null, null, createLections(i), null, createLecturers(i), createTask(i), null,null, null, null, "images/testimg.gif");
            em.persist(course);
        }
        em.getTransaction().commit();
    }

    private List<Lection> createLections(int i) {
        List<Lection> lections = new LinkedList<Lection>();
        for (int i2 = 0; i2 < 7; i2++) {
            Lection lection = new Lection("Лекция " + i + "-" + i2, "Лекция по теме " + i2, null, null, null, null);
            lections.add(lection);
        }
        return lections;
    }

    private void createStudents() {
        em.getTransaction().begin();
        for (int i = 0; i < 20; i++) {
            Student student = new Student("Студент " + i, 0, new Date(), "Login" + i);
            em.persist(student);
        }
        em.getTransaction().commit();
    }

    private List<Task> createTask(int i) {
        List<Task> tasks = new LinkedList<>();
        Random random = new Random();
        for (int i2 = 0; i2 < 5; i2++) {
            int type = random.nextInt(3);
            if (type == 0) {
                tasks.add(new Essay("Essay" + i + "-" + i2, new Date(), new Date(System.currentTimeMillis() + 20000L), null, null, null));
            }
            if (type == 1) {
                tasks.add(new Homework("Homework" + i + "-" + i2, new Date(), new Date(System.currentTimeMillis() + 20000L), null, null, null, null, null));
            }
            if (type == 2) {
                tasks.add(new Quiz("Quiz" + i + "-" + i2, new Date(), new Date(System.currentTimeMillis() + 20000L), null, null, null, null));
            }
            continue;
        }
        return tasks;
    }

    private List<Lecturer> createLecturers(int i) {
        List<Lecturer> lecturers = new LinkedList<>();
        for (int i2 = 0; i2 < 5; i2++) {
            Lecturer lecturer = new Lecturer("Lecturer " + i + "-" + i2, null, null);
            lecturers.add(lecturer);
        }
        return lecturers;
    }*/

   /* public void show()
    {
        Course course = em.find(Course.class,1L);
        TypedQuery<CoursePlanItem> query = em.createQuery("SELECT c FROM CoursePlanItem c WHERE c.course=:course",CoursePlanItem.class);
        query.setParameter("course",course);
        for(CoursePlanItem coursePlanItem : query.getResultList())
            System.out.println(coursePlanItem.getPhase());
    }*/

    public static void main(String[] args) {
        new EntitiesGenerator();
    }
}
