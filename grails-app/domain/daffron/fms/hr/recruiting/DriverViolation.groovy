package daffron.fms.hr.recruiting

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
 
class DriverViolation implements Serializable { 
	Date date
	String location
	String charge
	String penalty
	static belongsTo = [candidate:Candidate]
	
	static constraints = {
	}
	static mapping = {
		table name:'hrpdrvvio', schema:CH.config.hr.schema
	}
}