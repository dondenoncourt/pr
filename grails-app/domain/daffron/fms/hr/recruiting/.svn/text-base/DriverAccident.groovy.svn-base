package daffron.fms.hr.recruiting

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class DriverAccident implements Serializable { 
	Date date
	String nature
	int fatalities = 0
	int injuries = 0
	String hasMat 
	static belongsTo = [candidate:Candidate]
	
	static constraints = {
		hasMat nullable:true
		date nullable:true
	}
	static mapping = {
		table name:'hrpdrvaci', schema:CH.config.hr.schema
	}
}