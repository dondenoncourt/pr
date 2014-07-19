package daffron.fms.hr.recruiting

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import daffron.fms.hr.payroll.EmployeePayrollMaster;

@SuppressWarnings("deprecation")
class Approve implements Serializable {

  int employeeId
  String jobClassId
  boolean mustOk

	static transients = ['jobClassDescription', 'employee']
	
	static mapping = {
		table name:'hrpaprv', schema:CH.config.hr.schema
		mustOk  type:'org.hibernate.type.YesNoType'
		jobClass maxSize:5, nullable:true
		employeeId nullable:true
	}
  static constraints = {
    employeeId nullable:true, validator: { employeeId, approve ->
      if (employeeId && !EmployeePayrollMaster.get(employeeId)) {
        return "approve.employee_id.invalid"
      }
    }
  }
	String toString() {"id: $id, employee: $employeeId:${employee?.name}, job class: $jobClassId: ${jobClassDescription?.title}"}

	EmployeePayrollMaster getEmployee() {
		EmployeePayrollMaster.get(employeeId)
	}
	void setEmployee(EmployeePayrollMaster epm) {
		employeeId = epm.id
	}
  JobClassDescription getJobClassDescription() {
	def key = jobClassId.replaceFirst(/^0+(?!$)/, '') 
    JobClassDescription.get(key)
  }
	void setJobClassDescription(JobClassDescription jcd) {
    jobClassId = jcd.id 
  }

}
