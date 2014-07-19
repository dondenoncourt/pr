package daffron.fms.hr.payroll
//use schema:CH.config.[config.groovy custom variable] to soft-code library
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import org.systemitools.types.*


// NOTE: the composite key is not unique 

class EmployeePayrollDeductions implements Serializable {
	int employeeNo
	int deductionNo
	BigDecimal payPeriod1DeductionAmt
	BigDecimal payPeriod2DeductionAmt
	BigDecimal payPeriod3DeductionAmt
	BigDecimal payPeriod4DeductionAmt
	BigDecimal payPeriod5DeductionAmt
	static constraints = {
		employeeNo(max:999999999,nullable:false)
		deductionNo(max:99,nullable:false)
		payPeriod1DeductionAmt(max:new BigDecimal("99999.99"),nullable:false)
		payPeriod2DeductionAmt(max:new BigDecimal("99999.99"),nullable:false)
		payPeriod3DeductionAmt(max:new BigDecimal("99999.99"),nullable:false)
		payPeriod4DeductionAmt(max:new BigDecimal("99999.99"),nullable:false)
		payPeriod5DeductionAmt(max:new BigDecimal("99999.99"),nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = true
	static mapping = {
		table name:'prpmded', schema:CH.config.hr.schema
		version (false)
		id (generator:'assigned')
		id (composite:['employeeNo','deductionNo'])
		columns {
			id (composite:['employeeNo','deductionNo'])
			employeeNo (column:'MEEMP', type:'int')
			deductionNo (column:'MEDNO', type:'int')
			payPeriod1DeductionAmt (column:'MEDED1', type:'big_decimal')
			payPeriod2DeductionAmt (column:'MEDED2', type:'big_decimal')
			payPeriod3DeductionAmt (column:'MEDED3', type:'big_decimal')
			payPeriod4DeductionAmt (column:'MEDED4', type:'big_decimal')
			payPeriod5DeductionAmt (column:'MEDED5', type:'big_decimal')
		}
	}
	boolean newEntity = false
	static transients = ['newEntity']
	
	def beforeInsert () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  } 
	def beforeUpdate () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
	def beforeDelete () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
}
