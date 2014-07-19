package daffron.fms.hr

import daffron.fms.hr.payroll.EmployeePayrollMaster;
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class PAF {
	int department // should match department Name in req
	int position	// should match req position
	int subDepartment // may have to change to String with name
	int replacingEmpNo // req emp
	BigDecimal wageSalary
	String wageSalaryPeriod
	String grade
	boolean useVacation
	boolean sickLeave
	String vacationCode
	String eeoc
	String insideOutside
	String savings401k
	String rsPension
	String bcbs
	boolean fullTime = false
	int partTimeHours = 0
	boolean temp = false
	static constraints = {
		insideOutside inList:['I', 'O']
		/*partTimeHours validator:{hours, paf ->
			if (!paf.fullTime && !hours) {
				return ['paf.partTimeHours.invalid']
			}
		}*/
		department nullable:true
		position nullable:true
		subDepartment nullable:true
		replacingEmpNo nullable:true
		wageSalary nullable:true
		wageSalaryPeriod nullable:true
		grade nullable:true
		useVacation nullable:true
		sickLeave nullable:true
		vacationCode nullable:true
		eeoc nullable:true
		insideOutside nullable:true
		savings401k nullable:true
		rsPension nullable:true
		bcbs nullable:true
		partTimeHours nullable:true
		
	}
	static mapping = {
		useVacation               type:'org.hibernate.type.YesNoType'
		sickLeave               type:'org.hibernate.type.YesNoType'
		fullTime               type:'org.hibernate.type.YesNoType'
		temp               type:'org.hibernate.type.YesNoType'
	}
}
