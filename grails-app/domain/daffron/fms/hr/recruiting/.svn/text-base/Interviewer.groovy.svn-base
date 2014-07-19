package daffron.fms.hr.recruiting

import daffron.fms.hr.payroll.EmployeePayrollMaster

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class Interviewer {

	EmployeePayrollMaster emp	
	static belongsTo = [requisition:Requisition]
	
    static constraints = {
    }

	static mapping = {
		table name:'hrprqitv', schema:CH.config.hr.schema
	}
}
