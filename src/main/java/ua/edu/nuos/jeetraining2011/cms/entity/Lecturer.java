package ua.edu.nuos.jeetraining2011.cms.entity;

import javax.persistence.*;

/**
 * User: jeetrainee
 * Date: 6/2/12
 * Time: 10:39 AM
 */
@Entity
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    
    private String name;
    @Column(length = 512)
    private String description;
    @Column(length = 512)
    private String bigPhotoUrl;

    public Lecturer() {

    }

    public Lecturer(String name, String description, String bigPhotoUrl) {
        this.name = name;
        this.description = description;
        this.bigPhotoUrl = bigPhotoUrl;
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

    public String getBigPhotoUrl() {
        return bigPhotoUrl;
    }

    public void setBigPhotoUrl(String bigPhotoUrl) {
        this.bigPhotoUrl = bigPhotoUrl;
    }

}
