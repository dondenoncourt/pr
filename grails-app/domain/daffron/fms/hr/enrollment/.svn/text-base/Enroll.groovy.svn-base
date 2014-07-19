package daffron.fms.hr.enrollment

import daffron.fms.hr.payroll.EmployeePayrollMaster
import daffron.fms.hr.payroll.EmployeeInsuranceInfo

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class Enroll {
	boolean waive = false
	String election
	String mdvCoveragePrior
	String planElectionPrior
	Date dateCreated
	Date lastUpdated
	Date sign

	EmployeePayrollMaster employee

	Cafeteria cafeteria
	Contact contact
	
	boolean contactInfoSet = false
	boolean healthPlanSet = false
	boolean fsaSet = false
	boolean beneficiariesSet = false
	boolean voluntaryInsSet = false
	


	// maybe put a type code for BCBS or GHP
	//String carrierType maybe put actual object name here.... 	
	// maybe keep id of carrier record, can't use the object name, would have to manually update....
	//int carrierId 

	static hasMany = [otherCoverages:OtherCoverage,
						medicareCoverages:Medicare,
						covered:Covered,
						voluntaryInsurance:VoluntaryInsurance,
						beneficiaries:Beneficiary
					 ]
	
	static ELECTION_MAP = ['S':'single', '2':'2 person', 'F':'family']
	
	static constraints = {
		election maxSize:1, nullable:true, blank:true, inList:ELECTION_MAP.keySet() as List
		cafeteria nullable:true
		contact nullable:true
		//employeeInsuranceInfo nullable:true
		dateCreated nullable:true
		lastUpdated nullable:true
		contactInfoSet nullable:true
		healthPlanSet nullable:true
		fsaSet nullable:true
		beneficiariesSet nullable:true
		mdvCoveragePrior nullable:true
		planElectionPrior  nullable:true
		sign nullable:true
	}

	static mapping = {
		table name:'hrpenrol', schema:CH.config.hr.schema
		waive type:'org.hibernate.type.YesNoType'
		contactInfoSet type:'org.hibernate.type.YesNoType'
		healthPlanSet type:'org.hibernate.type.YesNoType'
		fsaSet type:'org.hibernate.type.YesNoType'
		beneficiariesSet type:'org.hibernate.type.YesNoType'
		voluntaryInsSet type:'org.hibernate.type.YesNoType'
		employee updateable: false
	}
	String coveredNamesForAutocomplete() {
		List list = []
		covered.each {
			list << it.name
		} 
		if (!list.find{it == employee.name}) {
			list << employee.name
		}
		String listStr = ""
		list.each{
			listStr += "'${it}',"
		}
		listStr.replaceAll(/,$/, '' )
	}
}
