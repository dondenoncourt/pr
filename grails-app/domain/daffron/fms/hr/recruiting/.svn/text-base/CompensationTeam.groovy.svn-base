package daffron.fms.hr.recruiting

import daffron.fms.hr.payroll.EmployeePayrollMaster
import daffron.fms.hr.payroll.GeneralConstants
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class CompensationTeam {
	String department
	EmployeePayrollMaster employee
	
	static constraints = {
	}
	
	static mapping = {
		table name:'hrpcmptm', schema:CH.config.hr.schema
		department type:'TrimString'
	}
	static transients = ['departmentDescription']

	/* per Kevin:
	 department description could come from two different places. Either PR or GL. 
	 To determine which to use you would retrieve the following constant –
	Select data from cudtahr.prpconst where name = 'PR_UseGLDepartment'
	If equal ‘Y’ then the dept should be retrieved from the GL application –
	Select DEDESC from cudtahr.glpdept where DEDEPT = ‘xx’
	If equal ‘N’ then the dept should be retrieved from PR –
	Select F4DESC from cudtahr.prpf4 where F4FLD = 'EDPT' and F4VALU = 'xx'
	 */
	String getDepartmentDescription() {
		if (GeneralConstants.findByConstantName('PR_UseGLDepartment')?.constantData == 'Y') {
			return Department.findByDepartmentCode(department)?.description?:'Not Found'
		}
		return PrCodes.findByFieldAndValue('EDPT', department)?.descOfValue?:'Not Found'
	}	
	private setDepartmentDescription(String ignore) {}
	String toString() {"${department}:${employee.name}:${employee.id}"}
}
