package com.courseapp.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")

public class Course implements Serializable{
	
	private long id;
    private String courseTitle;
    private String courseDescription;
    private String priceStrtgy;
    /* A given course will have different price component values based on the country of the user who browses the course. 
    i.e one course id can be mapped to many prices */
    
    private Set<Price> prices; //= new HashSet<Price>(0);
    
    public Course() {
    }
 
    public Course(String courseTitle,String courseDescription, String priceStrtgy) {
         this.courseTitle = courseTitle;
         this.courseDescription = courseDescription;
         this.priceStrtgy = priceStrtgy;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
 
    @Column(name = "course_title", nullable = false)
    public String getCourseTitle() {
        return courseTitle;
    }
    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }
    
    @Column(name = "course_desc", nullable = false)
    public String getCourseDescription() {
        return courseDescription;
    }
    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }
    
 
    @Column(name = "price_strtgy", nullable = false)
    public String getPriceStrtgy() {
        return priceStrtgy;
    }
    public void setPriceStrtgy(String priceStrtgy) {
        this.priceStrtgy = priceStrtgy;
    }
 
    @OneToMany(targetEntity = Price.class, fetch = FetchType.LAZY, mappedBy = "id")
    
	public Set<Price> getPrices() {
		return this.prices;
	}

	public void setPrices(Set<Price> prices) {
		this.prices = prices ;
	}

}
