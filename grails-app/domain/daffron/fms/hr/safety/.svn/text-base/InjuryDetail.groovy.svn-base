package daffron.fms.hr.safety

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import daffron.fms.hr.payroll.EmployeePayrollMaster
import daffron.fms.hr.recruiting.JobClassDescription

class InjuryDetail implements Serializable, Comparable {
	String bodyPart
	String bodySide
	String nature
	static belongsTo = [incident:Incident]
	static constraints = {
		nature nullable:true
		bodySide nullable:true
	}
	static mapping = {
		table name:'hrpinjdtl', schema:CH.config.hr.schema
	}
	
	int compareTo(obj) {
		id?id.compareTo(obj.id?:0):0
	}
}