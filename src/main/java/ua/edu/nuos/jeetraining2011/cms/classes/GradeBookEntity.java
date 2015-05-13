package ua.edu.nuos.jeetraining2011.cms.classes;

import ua.edu.nuos.jeetraining2011.cms.entity.Student;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: abelencev_a
 * Date: 27.06.12
 * Time: 15:15
 * To change this template use File | Settings | File Templates.
 */
public class GradeBookEntity {
    private List<String> marks;
    private Student student;
    private int position;

    public GradeBookEntity(List<String> marks, Student student, int position) {
        this.marks = marks;
        this.student = student;
        this.position = position;
    }

    public List<String> getMarks() {
        return marks;
    }

    public void setMarks(List<String> marks) {
        this.marks = marks;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
