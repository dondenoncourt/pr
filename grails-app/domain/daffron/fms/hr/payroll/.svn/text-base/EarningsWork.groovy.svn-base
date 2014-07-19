package daffron.fms.hr.payroll

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import org.systemitools.types.*
// NOTE, please use read-only and this is not a uniquely keyed file so do not use .get()
class EarningsWork implements Serializable {
	int empNo
	Date payPeriodBeginDate
	Date payPeriodEndingDate
	Date payPeriodCheckDate
	String earningsTypeCode
	BigDecimal currentHoursForPayPeriod
	BigDecimal currentEarningsForPayPeriod
	BigDecimal monthToDateHours
	BigDecimal monthToDateEarnings
	BigDecimal quarterToDateHours
	BigDecimal quarterToDateEarnings
	BigDecimal yearToDateHours
	BigDecimal yearToDateEarnings
	BigDecimal endingLeaveHours
	BigDecimal h2EnDol
	BigDecimal remainingLeaveHours
	BigDecimal maximumCompanyLiabilityHours
	BigDecimal accuralRate
	Date leaveEligibilityDate
	String leaveAccrualMethod
	int checkNumber
	String recordPreviouslyVoided
	static constraints = {
		empNo(max:999999999,nullable:false)
		payPeriodBeginDate(nullable:false)
		payPeriodEndingDate(nullable:false)
		payPeriodCheckDate(nullable:false)
		earningsTypeCode(maxSize:3,nullable:false)
		currentHoursForPayPeriod(max:new BigDecimal("99999.99"),nullable:false)
		currentEarningsForPayPeriod(max:new BigDecimal("999999999.99"),nullable:false)
		monthToDateHours(max:new BigDecimal("99999.99"),nullable:false)
		monthToDateEarnings(max:new BigDecimal("999999999.99"),nullable:false)
		quarterToDateHours(max:new BigDecimal("99999.99"),nullable:false)
		quarterToDateEarnings(max:new BigDecimal("999999999.99"),nullable:false)
		yearToDateHours(max:new BigDecimal("99999.99"),nullable:false)
		yearToDateEarnings(max:new BigDecimal("999999999.99"),nullable:false)
		endingLeaveHours(max:new BigDecimal("99999.99"),nullable:false)
		h2EnDol(max:new BigDecimal("999999999.99"),nullable:false)
		remainingLeaveHours(max:new BigDecimal("99999.99"),nullable:false)
		maximumCompanyLiabilityHours(max:new BigDecimal("99999.99"),nullable:false)
		accuralRate(max:new BigDecimal("999.99"),nullable:false)
		leaveEligibilityDate(nullable:true)
		leaveAccrualMethod(maxSize:1,nullable:false)
		checkNumber(max:999999,nullable:false)
		recordPreviouslyVoided(maxSize:1,nullable:false)
	}
	static final boolean ASSIGNEDKEY = true
	static final boolean COMPOSITEKEY  = true
	static mapping = {
		table name:'prph2earn', schema:CH.config.hr.schema
		version (false)
		id (generator:'assigned')
		id (composite:['empNo','earningsTypeCode'])
		columns {
			id (composite:['empNo','earningsTypeCode'])
			empNo (column:'H2EMP', type:'int')
			payPeriodBeginDate (column:'H2BEGD', type:'date')
			payPeriodEndingDate (column:'H2ENDD', type:'date')
			payPeriodCheckDate (column:'H2CHKD', type:'date')
			earningsTypeCode (column:'H2CODE', type:'string')
			currentHoursForPayPeriod (column:'H2CHRS', type:'big_decimal')
			currentEarningsForPayPeriod (column:'H2CEARN', type:'big_decimal')
			monthToDateHours (column:'H2MHRS', type:'big_decimal')
			monthToDateEarnings (column:'H2MEARN', type:'big_decimal')
			quarterToDateHours (column:'H2QHRS', type:'big_decimal')
			quarterToDateEarnings (column:'H2QEARN', type:'big_decimal')
			yearToDateHours (column:'H2YHRS', type:'big_decimal')
			yearToDateEarnings (column:'H2YEARN', type:'big_decimal')
			endingLeaveHours (column:'H2ENHR', type:'big_decimal')
			h2EnDol (column:'H2EN$$', type:'big_decimal')
			remainingLeaveHours (column:'H2RMNG', type:'big_decimal')
			maximumCompanyLiabilityHours (column:'H2MLIB', type:'big_decimal')
			accuralRate (column:'H2ARTE', type:'big_decimal')
			leaveEligibilityDate (column:'H2ELIG', type:'date')
			leaveAccrualMethod (column:'H2MTH', type:'string')
			checkNumber (column:'H2CKNO', type:'int')
			recordPreviouslyVoided (column:'H2VOID', type:'string')
		}
	}
	boolean newEntity = false
	static transients = ['newEntity']

	def beforeInsert () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  } 
	def beforeUpdate () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
	def beforeDelete () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
}
