package com.courseapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "price")

public class Price implements Serializable{
	
	private long id;
	
	/* A given course will have different price component values based on the country of the user who browses the course. 
    i.e many prices  can be mapped to one course */
    
    private Course course;
    private String countryCode;
    private float basePrice;
    private float tax;
    private float addnlCharge;
    private float convFee;
    
    
    
    public Price() {
    }
 
    public Price(String countryCode,float basePrice, float tax, float addnlCharge, float convFee) {
         this.countryCode = countryCode;
         this.basePrice = basePrice;
         this.tax = tax;
         this.addnlCharge = addnlCharge;
         this.convFee = convFee;
     }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
 
    @ManyToOne(fetch = FetchType.LAZY)
   	@JoinColumn(name = "course_id", nullable = false)
   	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course= course;
	}
    
	
    @Column(name = "country_code", nullable = false)
    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
 
    @Column(name = "base_price", nullable = false)
    public float getBasePrice() {
        return basePrice;
    }
    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }
    
    @Column(name = "tax", nullable = false)
    public float getTax() {
        return tax;
    }
    public void setTax(float tax) {
        this.tax = tax;
    }
    
    @Column(name = "addnl_chg", nullable = true)
    public float getAddnlCharge() {
        return addnlCharge;
    }
    public void setAddnlCharge(float addnlCharge) {
        this.addnlCharge = addnlCharge;
    }
    
    @Column(name = "conversion_fee", nullable = true)
    public float getConvFee() {
        return convFee;
    }
    public void setConvFee(float convFee) {
        this.convFee= convFee;
    }

}
