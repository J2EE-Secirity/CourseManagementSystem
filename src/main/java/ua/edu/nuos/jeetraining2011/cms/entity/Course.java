package ua.edu.nuos.jeetraining2011.cms.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * User: jeetrainee
 * Date: 6/2/12
 * Time: 10:23 AM
 */
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    private String name;
    @javax.persistence.Temporal(value = TemporalType.DATE)
    private Date dateBegin;
    @javax.persistence.Temporal(value = TemporalType.DATE)
    private Date dateEnd;
    @Column(length = 512)
    private String briefDescription;
    @Column(length = 2048)
    private String fullDescription;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Student> students;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Lecturer> lecturers;
    @Column(length = 1024)
    private String prerequisites;
    private String imageURL;

    public Course() {

    }

    public Course(String name, Date dateBegin, Date dateEnd, String briefDescription, String fullDescription, List<Student> students, List<Lecturer> lecturers, String prerequisites, String imageURL) {
        this.name = name;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.briefDescription = briefDescription;
        this.fullDescription = fullDescription;
        this.students = students;
        this.lecturers = lecturers;
        this.prerequisites = prerequisites;
        this.imageURL = imageURL;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getBriefDescription() {
        return briefDescription;
    }

    public void setBriefDescription(String briefDescription) {
        this.briefDescription = briefDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(List<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
