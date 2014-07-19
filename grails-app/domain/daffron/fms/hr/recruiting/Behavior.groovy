package daffron.fms.hr.recruiting

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import java.util.Date; 

class Behavior {
	String name
	static constraints = {
		name blank:false, nullable:false
	}
	static mapping = {
		table name:'hrpbhv', schema:CH.config.hr.schema
	}

	String toString() {name}
}
