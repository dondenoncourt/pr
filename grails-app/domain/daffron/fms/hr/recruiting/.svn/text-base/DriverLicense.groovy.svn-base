package daffron.fms.hr.recruiting

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
  
class DriverLicense implements Serializable { 
	String state
	String no
	String type
	Date expire
	static belongsTo = [candidate:Candidate]
	
	static constraints = {
		state nullable:false, maxSize:2, minSize:2
	}
	static mapping = {
		table name:'hrpdrvlic', schema:CH.config.hr.schema
	}
}