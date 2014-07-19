package daffron.fms.hr.enrollment

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class Covered { 
	String name
	String relationship
	String gender
	Date birth
	Long ssn
	static belongsTo = [enroll:Enroll]
	
	static RELATIONSHIP_TYPES = ['S':'Subscriber', 'P':'Spouse','C':'Child', 'O':'other']
	static constraints = {
		relationship maxSize:1, nullable:false, blank:false, inList:RELATIONSHIP_TYPES.keySet() as List 
		gender maxSize:1, inList:['M', 'F']
		birth nullable:false 
		name nullable:false, blank:false
		ssn nullable:false, matches:/\d{9}/
	}
	static mapping = {
		table name:'hrpcovrd', schema:CH.config.hr.schema
		relationship 		column:'relation', nullable:false, blank:false
	}

	String toString() {"$name:${RELATIONSHIP_TYPES[relationship]}"}
}
