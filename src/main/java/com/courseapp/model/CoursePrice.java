package com.courseapp.model;

public class CoursePrice implements java.io.Serializable {

		private long id;;
		private long courseId;
		private String courseTitle;
		private String courseDescription;
		private String countryCode;
	    private float basePrice;
	    private float tax;
	    private float addnlCharge;
	    private float convFee;
	    private float totalPrice;
	    
	    public CoursePrice() {
		}

	    
	    public CoursePrice(long id, long courseId, String courseTitle , String courseDescription, String countryCode, 
	    		float basePrice, float tax, float addnlCharge, float convFee) {
			this.id = id;
			this.courseId = courseId;
			this.courseTitle  = courseTitle ;
			this.courseDescription = courseDescription;
			this.countryCode= countryCode;
			this.basePrice = basePrice;
			this.tax = tax;
			this.addnlCharge = addnlCharge;
			this.convFee = convFee;
			//Not storing total fee in DB table 'price' now for quick solution. 
			//Ideally it is better to store a column for total_fee in table.
			this.totalPrice=this.basePrice+this.tax+this.addnlCharge+this.convFee; 
			}

	
		
	    public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}


		public long getCourseId() {
			return courseId;
		}


		public void setCourseId(long courseId) {
			this.courseId = courseId;
		}


		public String getCourseTitle() {
			return courseTitle;
		}


		public void setCourseTitle(String courseTitle) {
			this.courseTitle = courseTitle;
		}


		public String getCourseDescription() {
			return courseDescription;
		}


		public void setCourseDescription(String courseDescription) {
			this.courseDescription = courseDescription;
		}


		public String getCountryCode() {
			return countryCode;
		}


		public void setCountryCode(String countryCode) {
			this.countryCode = countryCode;
		}


		public float getBasePrice() {
			return basePrice;
		}


		public void setBasePrice(float basePrice) {
			this.basePrice = basePrice;
		}


		public float getTax() {
			return tax;
		}


		public void setTax(float tax) {
			this.tax = tax;
		}


		public float getAddnlCharge() {
			return addnlCharge;
		}


		public void setAddnlCharge(float addnlCharge) {
			this.addnlCharge = addnlCharge;
		}


		public float getConvFee() {
			return convFee;
		}


		public void setConvFee(float convFee) {
			this.convFee = convFee;
		}


		public float getTotalPrice() {
			return totalPrice;
		}


		public void setTotalPrice(float totalPrice) {
			this.totalPrice = totalPrice;
		}

		
		
}
