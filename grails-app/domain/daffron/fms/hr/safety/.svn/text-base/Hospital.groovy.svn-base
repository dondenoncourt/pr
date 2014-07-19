package daffron.fms.hr.safety

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import daffron.fms.hr.Address

class Hospital {
	String name
	Address addr
	String phoneNo
	static constraints = {
		phoneNo nullable:true, maxSize:10
		name maxSize:40
	}
	static mapping = {
		table name:'hrphosp', schema:CH.config.hr.schema
	}
	static embedded = ['addr']
}