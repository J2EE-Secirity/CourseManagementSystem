package ua.edu.nuos.jeetraining2011.cms.entity;

import javax.persistence.*;
import java.util.Enumeration;
import java.util.List;

/**
 * User: jeetrainee
 * Date: 6/2/12
 * Time: 10:31 AM
 */
@Entity
public class Lection {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    private String name;
    @Column(length = 512)
    private String description;
    private String url;
    public static enum LectionType { HYPERTEXT, VIDEO, PRESENTATION, PDF }
    @Basic(fetch = FetchType.LAZY)
    @Column(length = 16384)
    private String text;
    private LectionType type;
    @ManyToOne
    private Course course;

    public Lection() {

    }

    public Lection(String name, String description, String url, String text, LectionType type, Course course) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.text = text;
        this.type = type;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LectionType getType() {
        return type;
    }

    public void setType(LectionType type) {
        this.type = type;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}

