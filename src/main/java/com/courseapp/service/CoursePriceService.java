package com.courseapp.service;

import java.util.List;

import com.courseapp.model.CoursePrice;


public interface CoursePriceService {

	
	public CoursePrice getCoursePrice(long priceId);
	public CoursePrice getCoursePriceDescription(long courseId, String countryCode); 
	
}
