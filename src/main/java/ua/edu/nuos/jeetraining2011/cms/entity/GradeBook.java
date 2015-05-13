package ua.edu.nuos.jeetraining2011.cms.entity;

import javax.persistence.*;

/**
 * User: jeetrainee
 * Date: 6/2/12
 * Time: 10:51 AM
 */
@Entity
public class GradeBook {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @OneToOne(cascade = CascadeType.MERGE)
    private Student student;
    private String mark;
    @OneToOne
    private CoursePlanItem coursePlanItem;
    @ManyToOne
    private Course course;

    public GradeBook() {

    }

    public GradeBook(Student student, String mark, CoursePlanItem coursePlanItem, Course course) {
        this.student = student;
        this.course = course;
        this.mark = mark;
        this.coursePlanItem = coursePlanItem;
    }

    public long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public CoursePlanItem getCoursePlanItem() {
        return coursePlanItem;
    }

    public void setCoursePlanItem(CoursePlanItem coursePlanItem) {
        this.coursePlanItem = coursePlanItem;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
