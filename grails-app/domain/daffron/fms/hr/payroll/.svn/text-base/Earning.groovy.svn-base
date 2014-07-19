package daffron.fms.hr.payroll
//use schema:CH.config.[config.groovy custom variable] to soft-code library
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import org.systemitools.types.*

class Earning implements Serializable {
	int empNo
	String typeCode
	BigDecimal currentHoursForPayPeriod
	BigDecimal currentEarningsForPayPeriod
	BigDecimal monthToDateHours
	BigDecimal monthToDateEarnings
	BigDecimal quarterToDateHours
	BigDecimal quarterToDateEarnings
	BigDecimal yearToDateHours
	BigDecimal yearToDateEarnings
	BigDecimal endingLeaveHours
	BigDecimal dollars
	BigDecimal remainingLeaveHours
	BigDecimal maximumCompanyLiabilityHours
	BigDecimal accuralRate
	Date leaveEligibilityDate
	String leaveAccrualMethod
	static constraints = {
		empNo(max:999999999,nullable:true)
		typeCode(maxSize:3,nullable:true)
		currentHoursForPayPeriod(max:new BigDecimal("99999.99"),nullable:true)
		currentEarningsForPayPeriod(max:new BigDecimal("999999999.99"),nullable:true)
		monthToDateHours(max:new BigDecimal("99999.99"),nullable:true)
		monthToDateEarnings(max:new BigDecimal("999999999.99"),nullable:true)
		quarterToDateHours(max:new BigDecimal("99999.99"),nullable:true)
		quarterToDateEarnings(max:new BigDecimal("999999999.99"),nullable:true)
		yearToDateHours(max:new BigDecimal("99999.99"),nullable:true)
		yearToDateEarnings(max:new BigDecimal("999999999.99"),nullable:true)
		endingLeaveHours(max:new BigDecimal("99999.99"),nullable:true)
		dollars(max:new BigDecimal("999999999.99"),nullable:true)
		remainingLeaveHours(max:new BigDecimal("99999.99"),nullable:true)
		maximumCompanyLiabilityHours(max:new BigDecimal("99999.99"),nullable:true)
		accuralRate(max:new BigDecimal("999.99"),nullable:true)
		leaveEligibilityDate(nullable:true)
		leaveAccrualMethod(maxSize:1,nullable:true)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = true
	static mapping = {
		table name:'prpearn', schema:CH.config.hr.schema
		version (false)
		id (generator:'assigned')
		id (composite:['empNo','typeCode'])
		columns {
			id (composite:['empNo','typeCode'])
			empNo (column:'EREMP', type:'int')
			typeCode (column:'ERCODE', type:'string')
			currentHoursForPayPeriod (column:'ERCHRS', type:'big_decimal')
			currentEarningsForPayPeriod (column:'ERCEARN', type:'big_decimal')
			monthToDateHours (column:'ERMHRS', type:'big_decimal')
			monthToDateEarnings (column:'ERMEARN', type:'big_decimal')
			quarterToDateHours (column:'ERQHRS', type:'big_decimal')
			quarterToDateEarnings (column:'ERQEARN', type:'big_decimal')
			yearToDateHours (column:'ERYHRS', type:'big_decimal')
			yearToDateEarnings (column:'ERYEARN', type:'big_decimal')
			endingLeaveHours (column:'ERENHR', type:'big_decimal')
			dollars(column:'EREN$$', type:'big_decimal')
			remainingLeaveHours (column:'ERRMNG', type:'big_decimal')
			maximumCompanyLiabilityHours (column:'ERMLIB', type:'big_decimal')
			accuralRate (column:'ERARTE', type:'big_decimal')
			leaveEligibilityDate (column:'ERELIG', type:'date')
			leaveAccrualMethod (column:'ERMTH', type:'string')
		}
	}
	boolean newEntity = false
	static transients = ['newEntity']
	
	def beforeInsert () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  } 
	def beforeUpdate () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
	def beforeDelete () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
}
