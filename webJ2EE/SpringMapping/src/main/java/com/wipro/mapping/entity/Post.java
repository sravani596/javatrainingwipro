package com.wipro.mapping.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    
    private String title;

    @Column(name = "description")
    
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pc_fid", referencedColumnName = "id")
    
    List < Comment > comments = new ArrayList < > ();

    
    public Post() {

    }

    public Post(String title, String description) {
        super();
        this.title = title;
        this.description = description;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List < Comment > getComments() {
        return comments;
    }

    public void setComments(List < Comment > comments) {
        this.comments = comments;
    }

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", description=" + description + ", comments=" + comments + "]";
	}
    
    
}
