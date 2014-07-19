package daffron.fms.hr.enrollment

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

public class Medicare {
	String name
	String policyNo
	Date effective
	String type
	static belongsTo = [enroll:Enroll]
	
	static TYPE_MAP = ['A':'Whatever A is', 'B':'B description here', 'D':'Not sure what D is']
	static constraints = {
		name nullable:false, blank:false
		policyNo nullable:false, blank:false
		effective nullable:false, blank:false
		type maxSize:1, nullable:false, blank:false, inList:TYPE_MAP.keySet() as List
	}
	static mapping = {
		table name:'hrpmedicr', schema:CH.config.hr.schema
	}
	String toString() {"$name:${TYPE_MAP[type]}"}
	
}
