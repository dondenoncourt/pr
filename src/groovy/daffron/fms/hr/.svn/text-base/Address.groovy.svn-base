package daffron.fms.hr

class Address {
	String line1
	String line2
	String city
	String state
	String zip
	
	static constraints = {
		line1 nullable:false, blank:false
		line2 nullable:true
		city nullable:false, blank:false
		state nullable:false, maxSize:2, minSize:2, blank:false
		zip maxSize:9,nullable:false, blank:false, matches:/^\d{5,9}$/
	}
}
