package daffron.fms.hr.payroll
//use schema:CH.config.[config.groovy custom variable] to soft-code library
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import org.systemitools.types.*

class Earning2 implements Serializable {
	String id
	String typeDesc
	String etaclv
	String etpay
	String etapoh
	int printPrioritySequence
	String typeOfEarnings
	int nonPaidTaxableBenefitDeductionCode
	String etcd01
	String etcd02
	String etcd03
	String etcd04
	String etcd05
	String glCompanyCode
	BigDecimal glAccountNumber
	String glDivision
	String glDepartment
	String glSubDepartment
	String glActivityCode
	String glBudgetId
	String transactionCode
	String etovrco
	String etovrgl
	String etovrdv
	String etovrdp
	String etovrsd
	String etovrav
	String etovrbd
	String etinclot
	BigDecimal earningsRateMultiplier
	BigDecimal otherEarningsMultiplier
	String ettax1
	String ettax2
	String ettax3
	String ettax4
	String ettax5
	String ettax6
	String ettax7
	String ettax8
	String ettax9
	String ettax10
	static constraints = {
		typeDesc(maxSize:20,nullable:true)
		etaclv(maxSize:1,nullable:true)
		etpay(maxSize:1,nullable:true)
		etapoh(maxSize:1,nullable:true)
		printPrioritySequence(max:99,nullable:true)
		typeOfEarnings(maxSize:1,nullable:true)
		nonPaidTaxableBenefitDeductionCode(max:99,nullable:true)
		etcd01(maxSize:3,nullable:true)
		etcd02(maxSize:3,nullable:true)
		etcd03(maxSize:3,nullable:true)
		etcd04(maxSize:3,nullable:true)
		etcd05(maxSize:3,nullable:true)
		glCompanyCode(maxSize:5,nullable:true)
		glAccountNumber(max:new BigDecimal("9999.999"),nullable:true)
		glDivision(maxSize:5,nullable:true)
		glDepartment(maxSize:5,nullable:true)
		glSubDepartment(maxSize:5,nullable:true)
		glActivityCode(maxSize:5,nullable:true)
		glBudgetId(maxSize:5,nullable:true)
		transactionCode(maxSize:10,nullable:true)
		etovrco(maxSize:1,nullable:true)
		etovrgl(maxSize:1,nullable:true)
		etovrdv(maxSize:1,nullable:true)
		etovrdp(maxSize:1,nullable:true)
		etovrsd(maxSize:1,nullable:true)
		etovrav(maxSize:1,nullable:true)
		etovrbd(maxSize:1,nullable:true)
		etinclot(maxSize:1,nullable:true)
		earningsRateMultiplier(max:new BigDecimal("9999.99999"),nullable:true)
		otherEarningsMultiplier(max:new BigDecimal("9999.99999"),nullable:true)
		ettax1(maxSize:1,nullable:true)
		ettax2(maxSize:1,nullable:true)
		ettax3(maxSize:1,nullable:true)
		ettax4(maxSize:1,nullable:true)
		ettax5(maxSize:1,nullable:true)
		ettax6(maxSize:1,nullable:true)
		ettax7(maxSize:1,nullable:true)
		ettax8(maxSize:1,nullable:true)
		ettax9(maxSize:1,nullable:true)
		ettax10(maxSize:1,nullable:true)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = false
	static mapping = {
		table name:'prpernt', schema:CH.config.hr.schema
		version (false)
		id (generator:'assigned')
		columns {
			id (column:'ETCODE',type:'string')
			typeDesc (column:'ETDSC', type:'string')
			etaclv (column:'ETACLV', type:'string')
			etpay (column:'ETPAY', type:'string')
			etapoh (column:'ETAPOH', type:'string')
			printPrioritySequence (column:'ETPPRTY', type:'int')
			typeOfEarnings (column:'ETTYPE', type:'string')
			nonPaidTaxableBenefitDeductionCode (column:'ETDNO', type:'int')
			etcd01 (column:'ETCD01', type:'string')
			etcd02 (column:'ETCD02', type:'string')
			etcd03 (column:'ETCD03', type:'string')
			etcd04 (column:'ETCD04', type:'string')
			etcd05 (column:'ETCD05', type:'string')
			glCompanyCode (column:'ETCOMP', type:'string')
			glAccountNumber (column:'ETGL', type:'big_decimal')
			glDivision (column:'ETDIV', type:'string')
			glDepartment (column:'ETDEPT', type:'string')
			glSubDepartment (column:'ETSDPT', type:'string')
			glActivityCode (column:'ETACTV', type:'string')
			glBudgetId (column:'ETBDID', type:'string')
			transactionCode (column:'ETTRCDE', type:'string')
			etovrco (column:'ETOVRCO', type:'string')
			etovrgl (column:'ETOVRGL', type:'string')
			etovrdv (column:'ETOVRDV', type:'string')
			etovrdp (column:'ETOVRDP', type:'string')
			etovrsd (column:'ETOVRSD', type:'string')
			etovrav (column:'ETOVRAV', type:'string')
			etovrbd (column:'ETOVRBD', type:'string')
			etinclot (column:'ETINCLOT', type:'string')
			earningsRateMultiplier (column:'ETRATE', type:'big_decimal')
			otherEarningsMultiplier (column:'ETORATE', type:'big_decimal')
			ettax1 (column:'ETTAX1', type:'string')
			ettax2 (column:'ETTAX2', type:'string')
			ettax3 (column:'ETTAX3', type:'string')
			ettax4 (column:'ETTAX4', type:'string')
			ettax5 (column:'ETTAX5', type:'string')
			ettax6 (column:'ETTAX6', type:'string')
			ettax7 (column:'ETTAX7', type:'string')
			ettax8 (column:'ETTAX8', type:'string')
			ettax9 (column:'ETTAX9', type:'string')
			ettax10 (column:'ETTAX10', type:'string')
		}
	}
	boolean newEntity = false
	static transients = ['earningsTypeCode', 'newEntity']
	def getEarningsTypeCode() {
		if (id) return id
		return 
	}
	void setEarningsTypeCode (def vlu) { id = vlu }
	
	def beforeInsert () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  } 
	def beforeUpdate () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
	def beforeDelete () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
}
