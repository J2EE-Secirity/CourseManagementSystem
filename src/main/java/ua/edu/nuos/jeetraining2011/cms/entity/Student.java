package ua.edu.nuos.jeetraining2011.cms.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * User: jeetrainee
 * Date: 6/2/12
 * Time: 10:35 AM
 */
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    private String name;
    private int prolongationDays;
    @Temporal(value = TemporalType.DATE)
    private Date birthday;
    private String login;


    public Student() {

    }

    public Student(String name, int prolongationDays, Date birthday, String login) {
        this.name = name;
        this.prolongationDays = prolongationDays;
        this.birthday = birthday;
        this.login = login;
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

    public int getProlongationDays() {
        return prolongationDays;
    }

    public void setProlongationDays(int prolongationDays) {
        this.prolongationDays = prolongationDays;
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
}
