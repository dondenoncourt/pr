package daffron.fms.hr.recruiting

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import java.util.Date; 
 
class Test { 
	String name
	String url
	int questions
	int globalAveCorrect
	String toString() {name}
	Date created
	Date updated
	static constraints = {
		name unique:true
	}
	static mapping = {
		table name:'hrptest', schema:CH.config.hr.schema
	}
	def beforeInsert = {
		created = new Date()
	}
	def beforeUpdate = {
		updated = new Date()
	}
}