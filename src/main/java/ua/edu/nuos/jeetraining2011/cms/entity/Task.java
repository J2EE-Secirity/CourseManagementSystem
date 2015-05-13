package ua.edu.nuos.jeetraining2011.cms.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * User: jeetrainee
 * Date: 6/2/12
 * Time: 10:41 AM
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    private String description;
    @javax.persistence.Temporal(value = TemporalType.DATE)
    private Date dateBegin;
    @javax.persistence.Temporal(value = TemporalType.DATE)
    private Date dateEnd;
    @ManyToOne
    private Course course;

    public Task() {

    }

    public Task(String description, Date dateBegin, Date dateEnd, Course course) {
        this.description = description;
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
