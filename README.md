# springboot-course-application
Spring boot REST API for a sample online Course Application


1. DB MySQL is used schema : course_catalog
Please refer src\main\resources\dbScripts.sql for the DDL and DML scripts which explains the Tables created and the data prepopulated. Every course has its own price components for each country. So Course to Price is a one to many relationship. The application is developed based on that relationship mapping.


2. Application. properties with necessary configurarion

3. Application follows a typical Spring Boot REST structure as can be seen in code packages under src directory. Spring REST, JPA, MySQL and JPAQL is used.

4. Ideally the application should support few more DB tables like Users, Country with relationship. Due to time limiation, I am passing the countrycode directly in the GET request. http://localhost:8080/api/v1/courses/description/{courseId}/{countryCode} is the URL for getting the course description page. The country code can be US, IND, etc. Please refer the DML for other country codes mapped to a course to get that country's base price, tax etc. (these values are prepoulated in the DB tables).

5. CURL commands to get response for courseid =1 country code =US is   curl --location --request GET 'http://localhost:8080/api/v1/courses/description/1/IND' \
--data-raw ''  . This returns a JSOn response

{
    "id": 2,
    "courseId": 1,
    "courseTitle": "Science",
    "courseDescription": "Science Description",
    "countryCode": "IND",
    "basePrice": 0.0,
    "tax": 0.0,
    "addnlCharge": 0.0,
    "convFee": 0.0,
    "totalPrice": 250.1
}

Since it is IND, it shows total price. if it is US, it will show base price in the response. Due to time limitation, the JSON is not formatted to omit the other non-required fields

6. Once we get the above JSON response, ideally in a UI a user clicks catalog for that Course, it submits a request to course catalog page with the below format./courses/checkout/{priceId} where priceID is the ID returned from response mentioned in 5 above.
That means http://localhost:8080/api/v1/courses/checkout/3 should return all the course details plus all the price split up matching the ID =3

{
    "id": 3,
    "courseId": 2,
    "courseTitle": "Mathematics",
    "courseDescription": "Mathematics Description",
    "countryCode": "US",
    "basePrice": 150.0,
    "tax": 0.3,
    "addnlCharge": 0.02,
    "convFee": 1.0,
    "totalPrice": 151.32
}

The curl for the above is curl --location --request GET 'http://localhost:8080/api/v1/courses/checkout/3' \
--data-raw ''

7. Price strategy is added a column in course table. This is not fully implmented i.e  global configuration that should be used in cases courses have not
added their overrides in the table. Also for free course the above JSON response should show only course details and no price fields. I have not returned price strategy in the response. That can be easily added in the code though.

8. building and running the code. Like any spring boot application, first do a Run As--> Maven install. And execute the API requests in tool like POSTMAN based on the data loaded in the tables as per the SQL scripts mentioned in 1 above.
Note: There will be a small warning thrown in the console when the application is  built and run. Though that does not affect the spring boot application from being started. 


Thank you
