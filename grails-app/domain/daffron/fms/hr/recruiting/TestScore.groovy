package daffron.fms.hr.recruiting

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import java.util.Date;

class TestScore implements Comparable {
	Test test 
	Date created = new Date()
	Date updated = new Date()
	int correct
	static belongsTo = [candidate:Candidate]
	static mapping = {
		table name:'hrpscor', schema:CH.config.hr.schema
	}
	def beforeInsert = {
		created = new Date()
	}
	def beforeUpdate = {
		updated = new Date()
	}
	int score() {correct / test.questions * 100}
	int compareTo(obj) {
		test.name.compareTo(obj.test.name)
	}

}