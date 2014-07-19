package daffron.fms.hr.recruiting

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class Education implements Serializable { 
	String descr
	boolean highOrGED = false
	int years
	String study
	String degree
	static belongsTo = [candidate:Candidate]
	
	static constraints = {
		study validator:{ study, edu ->
			if (edu.descr && !study) {
				return false
			}
			return true
		}
		descr validator:{ descr, edu ->
			if (edu.highOrGED && !edu.descr) {
				return 'education.at.least.highschool.GED'
			}
			return true
		}
		years validator:{ years, edu ->
			if (edu.descr && !years) {
				return false
			}
			return true
		}
	}
	static mapping = {
		table name:'hrpstu', schema:CH.config.hr.schema
		highOrGED type:'org.hibernate.type.YesNoType'
	}
}