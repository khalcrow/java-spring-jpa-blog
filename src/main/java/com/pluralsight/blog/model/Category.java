package com.pluralsight.blog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany
    private List<Post> posts;

    public Category() {
        super();
        posts = new ArrayList<>();
    }

    public List<Post> getPosts() {
        return posts;
    }

}
