package org.v5k.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "SHOWS")
public class Show {

    @Id
    @GeneratedValue
    @Column(name = "SHOW_ID")
    private Long id;

    @Column(nullable = false)
    private String show;

    @Column
    private Long season;

    @Column
    private Boolean active;

    @Column
    private Date added;

    protected Show() {

    }

    public Long getId() {
        return id;
    }

    public String getShow() {
        return show;
    }

    public Long getSeason() {
        return season;
    }

    public Boolean getActive() {
        return active;
    }

    public Date getAdded() {
        return added;
    }
}
