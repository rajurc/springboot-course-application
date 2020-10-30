package com.courseapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.courseapp.model.*;

@Repository("coursepriceRepository")
public interface CoursePriceRepository extends JpaRepository<Price, Long> {
	

	@Query("select new com.courseapp.model.CoursePrice(p.id, c.id, c.courseTitle, c.courseDescription, p.countryCode, p.basePrice, p.tax, p.addnlCharge, p.convFee) "
			+ "FROM Price p, Course c where p.course.id= c.id and p.course.id= :courseId and p.countryCode= :countryCode")
		
	public CoursePrice getCoursePrice(@Param("courseId") Long courseId,@Param("countryCode") String countryCode);
	 
	
	@Query("select new com.courseapp.model.CoursePrice(p.id, c.id, c.courseTitle, c.courseDescription, p.countryCode, p.basePrice, p.tax, p.addnlCharge, p.convFee) "
			+ "FROM Price p, Course c where p.course.id= c.id and p.id= :priceId")
	public CoursePrice getCoursePrice(@Param("priceId") Long priceId);
	
	
	
	
	
}


