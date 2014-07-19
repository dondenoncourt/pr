package daffron.fms.hr.safety

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import daffron.fms.hr.Address

class Doctor {
	String name
	Address addr
	String phoneNo
	static constraints = {
		phoneNo nullable:true
	}
	static mapping = {
		table name:'hrpdoc', schema:CH.config.hr.schema
		phoneNo nullable:true, maxSize:10
		name maxSize:40
	}
	static embedded = ['addr']
}