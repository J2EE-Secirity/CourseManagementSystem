package ua.edu.nuos.jeetraining2011.cms.service;

import ua.edu.nuos.jeetraining2011.cms.dao.*;
import ua.edu.nuos.jeetraining2011.cms.entity.*;
import ua.edu.nuos.jeetraining2011.cms.classes.GradeBookEntity;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.LinkedList;
import java.util.List;

/**
 * User: dimon
 * Date: 06.06.12
 * Time: 15:28
 */
@Stateless
@Local
public class CourseManager {
    @EJB
    private CourseDAO courseDAO;
    @EJB
    private EssayDAO essayDAO;
    @EJB
    private HomeworkDAO homeworkDAO;
    @EJB
    private LectionDAO lectionDAO;
    @EJB
    private QuizDAO quizDAO;
    @EJB
    private RegistrationRequestItemDAO registrationRequestItemDAO;
    @EJB
    private StudentDAO studentDAO;
    @EJB
    private CoursePlanItemDAO coursePlanItemDAO;
    @EJB
    private GradeBookDAO gradeBookDAO;

    public List<Course> getAllCourses() {
        return courseDAO.getAllCourses();
    }

    public Course getCourseById(long id) {
        return courseDAO.getCourseById(id);
    }

    public List<Essay> getAllEssaysOfCourse(long id) {
        return essayDAO.getAllEssaysOfCourse(id);
    }

    public Essay getEssayById(long id) {
        return essayDAO.getEssayById(id);
    }

    public List<Homework> getAllHomeworksOfCourse(long id) {
        return homeworkDAO.getAllHomeworksOfCourse(id);
    }

    public Homework getHomeworkById(long id) {
        return homeworkDAO.getHomeworkById(id);
    }

    public List<Lection> getAllLectionsOfCourse(long id) {
        return lectionDAO.getAllLectionsOfCourse(id);
    }

    public Lection getLectionById(long id) {
        return lectionDAO.getLectionById(id);
    }

    public List<Quiz> getAllQuizesOfCourse(long id) {
        return quizDAO.getAllQuizesOfCourse(id);
    }

    public List<CoursePlanItem> getAllCoursePlanItems(long id) {
        return coursePlanItemDAO.getCoursePlanItemsOfCourse(id);
    }

    public List<RegistrationRequestItem> getAllRegistrationRequestItems(long id) {
        return registrationRequestItemDAO.getAllRegistrationRequestItemsOfCourse(id);
    }

    public Quiz getQuizById(long id) {
        return quizDAO.getQuizById(id);
    }

    public void approveRegistrationRequest(long id, int courseId) {
        RegistrationRequestItem registrationRequestItem = registrationRequestItemDAO.getRegistrationRequestItemById(id);

        Student student = new Student(registrationRequestItem.getName(), 0, registrationRequestItem.getBirthday(), registrationRequestItem.getLogin());
        courseDAO.addStudent(student, courseId);

        registrationRequestItemDAO.removeRegistrationRequestItem(registrationRequestItem);
    }

    public RegistrationRequestItem getRegistrationRequestItemByLogin(String login) {
        return registrationRequestItemDAO.getRegistrationRequestItemByLogin(login);
    }

    public void addRegistrationRequestItem(String login, long courseId) {
        registrationRequestItemDAO.addRegistrationRequestItem(login, courseId);
    }

    public void rejectRegistrationRequest(int id) {
        RegistrationRequestItem registrationRequestItem = registrationRequestItemDAO.getRegistrationRequestItemById(id);

        registrationRequestItemDAO.removeRegistrationRequestItem(registrationRequestItem);
    }

    public GradeBook getGradeBookById(long id) {
        return gradeBookDAO.getGradeBookById(id);
    }

    public List<GradeBook> getAllGradeBooksOfCourse(long id) {
        return gradeBookDAO.getAllGradeBooksOfCourse(id);
    }

    public List<GradeBook> getAllGradeBooksOfCourse(Course course) {
        return gradeBookDAO.getAllGradeBooksOfCourse(course);
    }

    public List<GradeBook> getGradeBooksOfCoursePlanItem(CoursePlanItem coursePlanItem) {
        return gradeBookDAO.getGradeBooksOfCoursePlanItem(coursePlanItem);
    }

    public List<Integer> getPhases(long courseId) {
        Course course = courseDAO.getCourseById(courseId);
        return coursePlanItemDAO.getPhasesOfCourse(course);
    }

    public List<Student> getStudentsOfCourse(long courseId) {
        return studentDAO.getStudentsOfCourse(courseId);
    }

    public List<String> getMarks(List<Integer> phases, Student student, Course course) {
        List<String> marks = new LinkedList<>();
        for (Integer phase : phases) {
            marks.add(gradeBookDAO.getMark(student, course, phase));
        }
        return marks;
    }

    public List<GradeBookEntity> getMarksForStudentsOfCourse(List<Student> students, List<Integer> phases, Course course) {
        List<GradeBookEntity> gradeBookEntities = new LinkedList<>();
        int position = 1;
        for (Student student : students) {
            gradeBookEntities.add(new GradeBookEntity(getMarks(phases, student, course), student, position++));
        }
        return gradeBookEntities;
    }
}
