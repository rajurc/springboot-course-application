package com.courseapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.courseapp.exception.ResourceNotFoundException;
import com.courseapp.model.CoursePrice;
import com.courseapp.service.CoursePriceService;

@RestController
@RequestMapping("/api/v1")

public class CoursePriceRESTController {

    @Autowired
    private CoursePriceService coursePriceService;
    
    
    /* 
     * Get method to return response to course description page. This method to be called first
     * 
     */
    @GetMapping("/courses/description/{courseId}/{countryCode}")
    public ResponseEntity<CoursePrice> getCoursePriceDescription(@PathVariable(value = "courseId") Long courseId,@PathVariable(value = "countryCode") String countryCode)
        throws ResourceNotFoundException {
        CoursePrice coursePrice = coursePriceService.getCoursePriceDescription(courseId,countryCode);
        // need to use JSON library to mask fields not needed to return in the JSON reponse say price component like tax etc not to be shown in Course description page..
        // Has not implemented that here due to time limitation.
        return ResponseEntity.ok().body(coursePrice);
    }
    
    /* 
     * Pass the value of 'id' which is obtained in the JSON response of above Get method to this Get method.
     *  This response of this Get method will be passed to the course checkout page to see the price split up for that particular course.
     * 
     */
    @GetMapping("/courses/checkout/{priceId}")
    public ResponseEntity<CoursePrice> getCoursePrice(@PathVariable(value = "priceId") Long priceId)
        throws ResourceNotFoundException {
        CoursePrice coursePrice = coursePriceService.getCoursePrice(priceId);
        return ResponseEntity.ok().body(coursePrice);
    }
    
}
