package daffron.fms.hr.payroll
//use schema:CH.config.[config.groovy custom variable] to soft-code library
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import org.systemitools.types.*

class EmployerContributions implements Serializable {
	int employeeNo
	int deductionNo
	BigDecimal percentage
	BigDecimal ecamt
	BigDecimal mtdContribution
	BigDecimal qtdContribution
	BigDecimal ytdContribution
	BigDecimal ltdContribution
	BigDecimal ltdForEmployee
	String basePayMethod
	String ecabs4
	String ecabs5
	String ecabs6
	String ecabs7
	String ecabs8
	String ecabs9
	String ecabsa
	BigDecimal currentEmprContribution
	String otherEarningsCode1
	String otherEarningsCode2
	String otherEarningsCode3
	String otherEarningsCode4
	String otherEarningsCode5
	String otherEarningsCode6
	String otherEarningsCode7
	String paysFwtOnEmprCnt
	String paysSwtOnEmprCnt
	String paysFicaOnEmprCnt
	String paysLoclTxOnEmprCnt
	static constraints = {
		employeeNo(max:999999999,nullable:false)
		deductionNo(max:99,nullable:false)
		percentage(max:new BigDecimal("9.99999"),nullable:false)
		ecamt(max:new BigDecimal("9999999.99"),nullable:false)
		mtdContribution(max:new BigDecimal("9999999.99"),nullable:false)
		qtdContribution(max:new BigDecimal("9999999.99"),nullable:false)
		ytdContribution(max:new BigDecimal("999999999.99"),nullable:false)
		ltdContribution(max:new BigDecimal("999999999.99"),nullable:false)
		ltdForEmployee(max:new BigDecimal("999999999.99"),nullable:false)
		basePayMethod(maxSize:1,nullable:false)
		ecabs4(maxSize:3,nullable:false)
		ecabs5(maxSize:3,nullable:false)
		ecabs6(maxSize:3,nullable:false)
		ecabs7(maxSize:3,nullable:false)
		ecabs8(maxSize:3,nullable:false)
		ecabs9(maxSize:3,nullable:false)
		ecabsa(maxSize:3,nullable:false)
		currentEmprContribution(max:new BigDecimal("999999999.99"),nullable:false)
		otherEarningsCode1(maxSize:3,nullable:false)
		otherEarningsCode2(maxSize:3,nullable:false)
		otherEarningsCode3(maxSize:3,nullable:false)
		otherEarningsCode4(maxSize:3,nullable:false)
		otherEarningsCode5(maxSize:3,nullable:false)
		otherEarningsCode6(maxSize:3,nullable:false)
		otherEarningsCode7(maxSize:3,nullable:false)
		paysFwtOnEmprCnt(maxSize:1,nullable:false)
		paysSwtOnEmprCnt(maxSize:1,nullable:false)
		paysFicaOnEmprCnt(maxSize:1,nullable:false)
		paysLoclTxOnEmprCnt(maxSize:1,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = true
	static mapping = {
		table name:'prpecnt', schema:CH.config.hr.schema
		version (false)
		id (generator:'assigned')
		id (composite:['employeeNo','deductionNo'])
		columns {
			id (composite:['employeeNo','deductionNo'])
			employeeNo (column:'ECEMP', type:'int')
			deductionNo (column:'ECDNO', type:'int')
			percentage (column:'ECPCT', type:'big_decimal')
			ecamt (column:'ECAMT', type:'big_decimal')
			mtdContribution (column:'ECMTD', type:'big_decimal')
			qtdContribution (column:'ECQTD', type:'big_decimal')
			ytdContribution (column:'ECYTD', type:'big_decimal')
			ltdContribution (column:'ECLTD', type:'big_decimal')
			ltdForEmployee (column:'ECELTD', type:'big_decimal')
			basePayMethod (column:'ECTYP', type:'TrimString')
			ecabs4 (column:'ECABS4', type:'TrimString')
			ecabs5 (column:'ECABS5', type:'TrimString')
			ecabs6 (column:'ECABS6', type:'TrimString')
			ecabs7 (column:'ECABS7', type:'TrimString')
			ecabs8 (column:'ECABS8', type:'TrimString')
			ecabs9 (column:'ECABS9', type:'TrimString')
			ecabsa (column:'ECABSA', type:'TrimString')
			currentEmprContribution (column:'ECCURAMT', type:'big_decimal')
			otherEarningsCode1 (column:'ECOTHR1', type:'TrimString')
			otherEarningsCode2 (column:'ECOTHR2', type:'TrimString')
			otherEarningsCode3 (column:'ECOTHR3', type:'TrimString')
			otherEarningsCode4 (column:'ECOTHR4', type:'TrimString')
			otherEarningsCode5 (column:'ECOTHR5', type:'TrimString')
			otherEarningsCode6 (column:'ECOTHR6', type:'TrimString')
			otherEarningsCode7 (column:'ECOTHR7', type:'TrimString')
			paysFwtOnEmprCnt (column:'ECFWT', type:'TrimString')
			paysSwtOnEmprCnt (column:'ECSWT', type:'TrimString')
			paysFicaOnEmprCnt (column:'ECFICATAX', type:'TrimString')
			paysLoclTxOnEmprCnt (column:'ECLOCLTAX', type:'TrimString')
		}
	}
	boolean newEntity = false
	static transients = ['newEntity']

	def beforeInsert () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  } 
	def beforeUpdate () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
	def beforeDelete () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
}