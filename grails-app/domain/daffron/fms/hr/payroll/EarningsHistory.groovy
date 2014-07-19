package daffron.fms.hr.payroll

//use schema:CH.config.[config.groovy custom variable] to soft-code library
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import org.systemitools.types.*


// Note: do not read by key (get()) as there is no unique index on the table
class EarningsHistory implements Serializable {
	int empNo
	Date payPeriodBeginDate
	Date payPeriodEndingDate
	Date payPeriodCheckDate
	Date earningsDate
	String employeeName
	BigDecimal regularHours
	BigDecimal overtimeHours
	BigDecimal double_timeHours
	BigDecimal regularPay
	BigDecimal overtimePay
	BigDecimal doubletimePay
	String payType
	BigDecimal totalMiles_hours
	String heabs
	BigDecimal rateOfPay
	BigDecimal otherPay
	String otherEarningsTaxableQuestionY_n
	String hetax1
	String hetax2
	String hetax3
	String hetax4
	String hetax5
	String hetax6
	String hetax7
	int hewo
	int heeqno
	BigDecimal hefuel
	int heoil
	BigDecimal hebeg
	BigDecimal heend
	BigDecimal shift2Hours
	BigDecimal shift3Hours
	int acctYyyymm
	String recordPreviouslyVoided
	String companyCode
	BigDecimal g_lNo
	String division
	String dept
	String sub_dept
	String activity
	String budId
	String trCode
	static constraints = {
		empNo(max:999999999,nullable:false)
		payPeriodBeginDate(nullable:false)
		payPeriodEndingDate(nullable:false)
		payPeriodCheckDate(nullable:false)
		earningsDate(nullable:false)
		employeeName(maxSize:40,nullable:false)
		regularHours(max:new BigDecimal("99999.99"),nullable:false)
		overtimeHours(max:new BigDecimal("99999.99"),nullable:false)
		double_timeHours(max:new BigDecimal("99999.99"),nullable:false)
		regularPay(max:new BigDecimal("99999.99"),nullable:false)
		overtimePay(max:new BigDecimal("99999.99"),nullable:false)
		doubletimePay(max:new BigDecimal("99999.99"),nullable:false)
		payType(maxSize:1,nullable:false)
		totalMiles_hours(max:new BigDecimal("9999.9"),nullable:false)
		heabs(maxSize:3,nullable:false)
		rateOfPay(max:new BigDecimal("99999.9999"),nullable:false)
		otherPay(max:new BigDecimal("99999.99"),nullable:false)
		otherEarningsTaxableQuestionY_n(maxSize:1,nullable:false)
		hetax1(maxSize:1,nullable:false)
		hetax2(maxSize:1,nullable:false)
		hetax3(maxSize:1,nullable:false)
		hetax4(maxSize:1,nullable:false)
		hetax5(maxSize:1,nullable:false)
		hetax6(maxSize:1,nullable:false)
		hetax7(maxSize:1,nullable:false)
		hewo(max:9999999,nullable:false)
		heeqno(max:999999,nullable:false)
		hefuel(max:new BigDecimal("99.9"),nullable:false)
		heoil(max:999,nullable:false)
		hebeg(max:new BigDecimal("999999.9"),nullable:false)
		heend(max:new BigDecimal("999999.9"),nullable:false)
		shift2Hours(max:new BigDecimal("99999.99"),nullable:false)
		shift3Hours(max:new BigDecimal("99999.99"),nullable:false)
		acctYyyymm(max:999999,nullable:false)
		recordPreviouslyVoided(maxSize:1,nullable:false)
		companyCode(maxSize:5,nullable:false)
		g_lNo(max:new BigDecimal("9999.999"),nullable:false)
		division(maxSize:5,nullable:false)
		dept(maxSize:5,nullable:false)
		sub_dept(maxSize:5,nullable:false)
		activity(maxSize:5,nullable:false)
		budId(maxSize:5,nullable:false)
		trCode(maxSize:10,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = true
	static mapping = {
		table name:'prphearn', schema:CH.config.hr.schema
		version (false)
		id (generator:'assigned')
		id (composite:['empNo','payPeriodBeginDate','payPeriodEndingDate','payPeriodCheckDate','earningsDate']) // do not use
		columns {
			id (composite:['empNo','payPeriodBeginDate','payPeriodEndingDate','payPeriodCheckDate','earningsDate'])
			empNo (column:'HEEMP', type:'int')
			payPeriodBeginDate (column:'HEBEGD', type:'date')
			payPeriodEndingDate (column:'HEENDD', type:'date')
			payPeriodCheckDate (column:'HECHKD', type:'date')
			earningsDate (column:'HEDATE', type:'date')
			employeeName (column:'HENAME', type:'string')
			regularHours (column:'HERGH', type:'big_decimal')
			overtimeHours (column:'HEOTH', type:'big_decimal')
			double_timeHours (column:'HEDTH', type:'big_decimal')
			regularPay (column:'HERGP', type:'big_decimal')
			overtimePay (column:'HEOTP', type:'big_decimal')
			doubletimePay (column:'HEDTP', type:'big_decimal')
			payType (column:'HETYP', type:'string')
			totalMiles_hours (column:'HEMIHR', type:'big_decimal')
			heabs (column:'HEABS', type:'string')
			rateOfPay (column:'HEROP', type:'big_decimal')
			otherPay (column:'HEOTHR', type:'big_decimal')
			otherEarningsTaxableQuestionY_n (column:'HETAX', type:'string')
			hetax1 (column:'HETAX1', type:'string')
			hetax2 (column:'HETAX2', type:'string')
			hetax3 (column:'HETAX3', type:'string')
			hetax4 (column:'HETAX4', type:'string')
			hetax5 (column:'HETAX5', type:'string')
			hetax6 (column:'HETAX6', type:'string')
			hetax7 (column:'HETAX7', type:'string')
			hewo (column:'HEWO', type:'int')
			heeqno (column:'HEEQNO', type:'int')
			hefuel (column:'HEFUEL', type:'big_decimal')
			heoil (column:'HEOIL', type:'int')
			hebeg (column:'HEBEG', type:'big_decimal')
			heend (column:'HEEND', type:'big_decimal')
			shift2Hours (column:'HES2H', type:'big_decimal')
			shift3Hours (column:'HES3H', type:'big_decimal')
			acctYyyymm (column:'HEAMO', type:'int')
			recordPreviouslyVoided (column:'HEVOID', type:'string')
			companyCode (column:'HECOMP', type:'string')
			g_lNo (column:'HEGL', type:'big_decimal')
			division (column:'HEDIV', type:'string')
			dept (column:'HEDEPT', type:'string')
			sub_dept (column:'HESDPT', type:'string')
			activity (column:'HEACTV', type:'string')
			budId (column:'HEBDID', type:'string')
			trCode (column:'HETRCDE', type:'string')
		}
	}
	boolean newEntity = false
	static transients = ['newEntity']

	def beforeInsert () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  } 
	def beforeUpdate () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
	def beforeDelete () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
}