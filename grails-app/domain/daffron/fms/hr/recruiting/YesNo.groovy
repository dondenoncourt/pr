package daffron.fms.hr.recruiting

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class YesNo {
	String question
	String toString() {question}
	boolean negative = false
	String shortName
	static constraints = {
		shortName nullable:true
	}
	static mapping = {
		table name:'hrpysno', schema:CH.config.hr.schema
		negative  type:'org.hibernate.type.YesNoType'
	}
}