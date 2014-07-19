package daffron.fms.hr.payroll

//use schema:CH.config.[config.groovy custom variable] to soft-code library
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import org.systemitools.types.*


// Note: do not read by key (get()) as there is no unique index on the table
class SalaryHistory implements Serializable {
	int empNo
	Date salHistPayDate
	String transactionType
	BigDecimal salHistSalHistpayRate
	String salHistPayType
	String salHistPayStatus
	String companyCode
	String division
	String department
	String subDept
	int grade
	int shiftPremium
	String jobClass
	String job
	String companyBusinessNumber
	static constraints = {
		empNo(max:999999999,nullable:false)
		salHistPayDate(nullable:false)
		transactionType(maxSize:1,nullable:false)
		salHistSalHistpayRate(max:new BigDecimal("99999.9999"),nullable:false)
		salHistPayType(maxSize:1,nullable:false)
		salHistPayStatus(maxSize:1,nullable:false)
		companyCode(maxSize:5,nullable:false)
		division(maxSize:5,nullable:false)
		department(maxSize:5,nullable:false)
		subDept(maxSize:5,nullable:false)
		grade(max:999,nullable:false)
		shiftPremium(max:99,nullable:false)
		jobClass(maxSize:5,nullable:false)
		job(maxSize:1,nullable:false)
		companyBusinessNumber(maxSize:17,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = true
	static mapping = {
		table name:'prpshist', schema:CH.config.hr.schema
		version (false)
		id (generator:'assigned')
		id (composite:['empNo','salHistPayDate','transactionType']) // do not use, no unique key on table
		columns {
			id (composite:['empNo','salHistPayDate','transactionType'])
			empNo (column:'SHEMP', type:'int')
			salHistPayDate (column:'SHPDT', type:'date')
			transactionType (column:'SHTRAN', type:'string')
			salHistSalHistpayRate (column:'SHRTE', type:'big_decimal')
			salHistPayType (column:'SHTYP', type:'string')
			salHistPayStatus (column:'SHSTAT', type:'string')
			companyCode (column:'SHCOMP', type:'string')
			division (column:'SHDIV', type:'string')
			department (column:'SHDEPT', type:'string')
			subDept (column:'SHSDPT', type:'string')
			grade (column:'SHGRD', type:'int')
			shiftPremium (column:'SHSTEP', type:'int')
			jobClass (column:'SHJCLS', type:'string')
			job (column:'SHJOB', type:'string')
			companyBusinessNumber (column:'SHBSNO', type:'string')
		}
	}
	boolean newEntity = false
	static transients = ['newEntity']

	def beforeInsert () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  } 
	def beforeUpdate () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
	def beforeDelete () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }

}