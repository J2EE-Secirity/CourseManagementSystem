package ua.edu.nuos.jeetraining2011.cms.entity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

/**
 * User: jeetrainee
 * Date: 6/2/12
 * Time: 11:11 AM
 */
@Entity
public class Homework extends Task {
    private String target;
    @ElementCollection
    private List<String> usefulFileUrls;
    @ElementCollection
    private List<String> commitedFileUrls;
    private String vcsUrl;
    @ElementCollection
    private List<String> targetsPool;

    public Homework() {

    }

    public Homework(String description, Date dateBegin, Date dateEnd, Course course, String target, List<String> usefulFileUrls, List<String> commitedFileUrls, String vcsUrl, List<String> targetsPool) {
        super(description, dateBegin, dateEnd, course);
        this.target = target;
        this.usefulFileUrls = usefulFileUrls;
        this.commitedFileUrls = commitedFileUrls;
        this.vcsUrl = vcsUrl;
        this.targetsPool = targetsPool;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public List<String> getUsefulFileUrls() {
        return usefulFileUrls;
    }

    public void setUsefulFileUrls(List<String> usefulFileUrls) {
        this.usefulFileUrls = usefulFileUrls;
    }

    public List<String> getCommitedFileUrls() {
        return commitedFileUrls;
    }

    public void setCommitedFileUrls(List<String> commitedFileUrls) {
        this.commitedFileUrls = commitedFileUrls;
    }

    public String getVcsUrl() {
        return vcsUrl;
    }

    public void setVcsUrl(String vcsUrl) {
        this.vcsUrl = vcsUrl;
    }

    public List<String> getTargetsPool() {
        return targetsPool;
    }

    public void setTargetsPool(List<String> targetsPool) {
        this.targetsPool = targetsPool;
    }
}
