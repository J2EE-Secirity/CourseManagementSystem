package ua.edu.nuos.jeetraining2011.cms.entity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

/**
 * User: jeetrainee
 * Date: 6/2/12
 * Time: 11:07 AM
 */
@Entity
public class Essay extends Task {
    private String topic;
    private String text;

    @ElementCollection
    List<String> topicsPool;

    public Essay() {

    }

    public Essay(String description, Date dateBegin, Date dateEnd, Course course, String topic, String text, List<String> topicsPool) {
        super(description, dateBegin, dateEnd, course);
        this.topic = topic;
        this.text = text;
        this.topicsPool = topicsPool;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getTopicsPool() {
        return topicsPool;
    }

    public void setTopicsPool(List<String> topicsPool) {
        this.topicsPool = topicsPool;
    }
}
