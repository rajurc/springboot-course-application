package com.courseapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseapp.model.CoursePrice;
import com.courseapp.repository.CoursePriceRepository;

@Transactional
@Service("coursePriceService")
public class CoursePriceServImpl  implements CoursePriceService{
	
	@Autowired
	public CoursePriceRepository coursepriceRepository;
	
	@Override
	public CoursePrice getCoursePrice(long priceId){
		return coursepriceRepository.getCoursePrice(priceId);
	}
	
	@Override
	public CoursePrice getCoursePriceDescription(long courseId, String countryCode){
		CoursePrice coursePrice = coursepriceRepository.getCoursePrice(courseId, countryCode);
		CoursePrice returnCoursePrice = new CoursePrice();
		returnCoursePrice.setId(coursePrice.getId());
		returnCoursePrice.setCourseId(coursePrice.getCourseId());
		returnCoursePrice.setCourseTitle(coursePrice.getCourseTitle());
		returnCoursePrice.setCourseDescription(coursePrice.getCourseDescription());
		returnCoursePrice.setCountryCode(coursePrice.getCountryCode());
		//A user from US need not be shown with total price as per the requirement spec.
		if(countryCode.equalsIgnoreCase("US"))
			returnCoursePrice.setBasePrice(coursePrice.getBasePrice());
		else
		returnCoursePrice.setTotalPrice(coursePrice.getTotalPrice());
		return returnCoursePrice;
		
	}
	
	

}
