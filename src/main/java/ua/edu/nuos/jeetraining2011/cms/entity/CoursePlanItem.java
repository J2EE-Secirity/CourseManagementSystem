package ua.edu.nuos.jeetraining2011.cms.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * User: Александр
 * Date: 11.06.12
 * Time: 20:03
 */
@Entity
public class CoursePlanItem {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private int phase;
    @OneToOne
    private Lection lection;
    @OneToOne
    private Essay essay;
    @OneToOne
    private Quiz quiz;
    @OneToOne
    private Homework homework;
    @Temporal(value = TemporalType.DATE)
    private Date date;
    @ManyToOne
    private Course course;

    public CoursePlanItem() {

    }

    public CoursePlanItem(Lection lection, int phase, Essay essay, Quiz quiz, Homework homework, Date date, Course course) {
        this.lection = lection;
        this.phase = phase;
        this.essay = essay;
        this.quiz = quiz;
        this.homework = homework;
        this.date = date;
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public Lection getLection() {
        return lection;
    }

    public void setLection(Lection lection) {
        this.lection = lection;
    }

    public Essay getEssay() {
        return essay;
    }

    public void setEssay(Essay essay) {
        this.essay = essay;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Homework getHomework() {
        return homework;
    }

    public void setHomework(Homework homework) {
        this.homework = homework;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }
}
