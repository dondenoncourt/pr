package daffron.fms.hr.recruiting

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class YesNoAns implements Serializable {
	YesNo yesNo
	boolean answer = false
	static belongsTo = [candidate:Candidate]
	
	String toString() {"$yesNo: ${(answer?'Yes':'No')}"}
	static constraints = {
		answer nullable:true
	}
	static mapping = {
		table name:'hrpysnoan', schema:CH.config.hr.schema
		answer  type:'org.hibernate.type.YesNoType'
	}
} 