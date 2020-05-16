package com.pluralsight.blog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String lead;

    @Column(length=1000000)
    @Lob
    private String body;
    private String author;
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    private Category category;


    public Post() {
        super();
    }

    public Post(Long id, String title, String lead, String body, String author, Date date) {
        this();
        this.id = id;
        this.title = title;
        this.lead = lead;
        this.body = body;
        this.author = author;
        this.date = date;
    }

    public String getDateStr() {
        DateFormat outputFormatter = new SimpleDateFormat("MM/dd/yyyy");
        return outputFormatter.format(this.date);
    }

}
