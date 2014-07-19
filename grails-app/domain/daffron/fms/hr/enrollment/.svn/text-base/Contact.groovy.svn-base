package daffron.fms.hr.enrollment

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

import daffron.fms.hr.Address

public class Contact {
	String emergency1Name = ''
	String emergency1Phone1 = ''
	String emergency1Phone2 = ''
	String emergency2Name = ''
	String emergency2Phone1 = ''
	String emergency2Phone2 = ''
	String lastName = ''
	String firstName = ''
	String mi = ''
	String workSite = ''
	String status = ''
	String unionStatus = ''
	String maritalStatus = ''
	Address addr  
	String phone = ''
	String ssn = ''
	String gender = 'M'
	
	boolean noChanges = false

	static belongsTo = [enroll:Enroll]
	
	static constraints = {
		emergency1Name 		nullable:true, blank:true
		emergency1Phone1 	nullable:true, blank:true
		emergency1Phone2 	nullable:true, blank:true
		emergency2Name 		nullable:true, blank:true
		emergency2Phone1 	nullable:true, blank:true
		emergency2Phone2 	nullable:true, blank:true

	}

	static mapping = {
		table name:'hrpcntx', schema:CH.config.hr.schema
		noChanges               type:'org.hibernate.type.YesNoType'
	}
	
	static embedded = ['addr']

}
