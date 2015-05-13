package ua.edu.nuos.jeetraining2011.cms.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * User: dimon
 * Date: 15.06.12
 * Time: 13:21
 */
@Entity
public class RegistrationRequestItem {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    private String name;
    @Temporal(value = TemporalType.DATE)
    private Date birthday;
    private String login;
    @ManyToOne
    private Course course;

    public RegistrationRequestItem() {

    }

    public RegistrationRequestItem(String name, Date birthday, String login, Course course) {
        this.name = name;
        this.birthday = birthday;
        this.login = login;
        this.course = course;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
