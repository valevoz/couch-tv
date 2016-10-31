package org.v5k.domain;

import javax.persistence.*;
import java.util.Date;

@Entity()
@Table(
        name = "SHOWS",
        uniqueConstraints = @UniqueConstraint(name = "SHOW_UNIQUE", columnNames = {"SHOW"})
)
public class Show {

    @Id
    @GeneratedValue
    @Column(name = "SHOW_ID")
    private Long id;

    @Column(nullable = false)
    private String show;

    @Column
    private Boolean active;

    @Column
    private Date added;

    protected Show() {

    }

    public Show(String name) {
        this.show = name;
        this.active = true;
        this.added = new Date();
    }

    public Long getId() {
        return id;
    }

    public String getShow() {
        return show;
    }

    public Boolean getActive() {
        return active;
    }

    public Date getAdded() {
        return added;
    }
}
