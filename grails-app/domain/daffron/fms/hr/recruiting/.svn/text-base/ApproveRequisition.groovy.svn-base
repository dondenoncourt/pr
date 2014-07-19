package daffron.fms.hr.recruiting

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import daffron.fms.hr.payroll.EmployeePayrollMaster;

@SuppressWarnings("deprecation")
class ApproveRequisition implements Serializable {
  EmployeePayrollMaster employee
  boolean mustOk
  Date approved
  
	static belongsTo = [requisition:Requisition]
	static mapping = {
		table name:'hrpokreq', schema:CH.config.hr.schema
		mustOk  type:'org.hibernate.type.YesNoType'
	}
  static constraints = {
		approved nullable:true
  }
	String toString() {employee.name}
	static boolean isApprover(EmployeePayrollMaster emp, Requisition req) {
		ApproveRequisition.findByRequisitionAndEmployee(req, emp)?.mustOk
	}
}
