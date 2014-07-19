package daffron.fms.hr

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import daffron.fms.hr.payroll.EmployeePayrollMaster
import daffron.fms.hr.recruiting.Candidate
import daffron.fms.hr.recruiting.Requisition;

class PersonnelAction {
	String name // which may not yet have a PayrollMaster auto-fill from candidate or payrollmaster
	Candidate candidate
	EmployeePayrollMaster emp
	Requisition requisition
	
	// ADD
	Date addEffective
	PAF add	
				
	// CHANGE
	Date changeEffective
	boolean changeTransfer = false
	boolean changePromotion = false
	String changeOther
	PAF from
	PAF to
				
	// DROP
	Date dropEffective
	boolean dropVoluntary = false
	String dropReason
	Date dropInterview
	EmployeePayrollMaster dropInterviewBy 
	
	String comments
	EmployeePayrollMaster supervisor
	EmployeePayrollMaster deptManager
	EmployeePayrollMaster hr
	Date supervisorApprove
	Date deptManagerApprove
	Date hrApprove
	Date distribution
	
	static embedded = ['add', 'from', 'to']
	
    static constraints = {
		candidate nullable:true
		emp nullable:true
		requisition nullable:true
		addEffective nullable:true
		changeEffective nullable:true
		dropEffective nullable:true
		dropInterview nullable:true
		dropReason nullable:true
		dropInterviewBy nullable:true
		supervisorApprove nullable:true
		deptManagerApprove nullable:true
		hrApprove nullable:true
		distribution nullable:true
		to nullable:true
		from nullable:true
		add nullable:true
		supervisor nullable:true
		deptManager nullable:true
		hr nullable:true
		name nullable:true
		comments nullable:true
		changeOther nullable:true
    }
	static mapping = {
		table name:'hrppaf', schema:CH.config.hr.schema
	}
}
	
