package daffron.fms.hr.payroll
//use schema:CH.config.[config.groovy custom variable] to soft-code library
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import org.systemitools.types.*

class EmployeePayrollAuxDeductions implements Serializable {
	int aeemp
	int aedno
	String sourceOfContributionMoney
	Date effDateOfContribution
	Date expireDateOfContribution
	BigDecimal openField1
	BigDecimal openField2
	BigDecimal openField3
	String openField4
	String openField5
	static constraints = {
		aeemp(max:999999999,nullable:false)
		aedno(max:99,nullable:false)
		sourceOfContributionMoney(maxSize:1,nullable:false)
		effDateOfContribution(nullable:true)
		expireDateOfContribution(nullable:true)
		openField1(max:new BigDecimal("999999999.99"),nullable:false)
		openField2(max:new BigDecimal("999999999.99"),nullable:false)
		openField3(max:new BigDecimal("9999999999999.99"),nullable:false)
		openField4(maxSize:1,nullable:false)
		openField5(maxSize:1,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = true
	static mapping = {
		table name:'prpaeded', schema:CH.config.hr.schema
		version (false)
		id (generator:'assigned')
		id (composite:['aeemp','aedno','sourceOfContributionMoney'])
		columns {
			id (composite:['aeemp','aedno','sourceOfContributionMoney'])
			aeemp (column:'AEEMP', type:'int')
			aedno (column:'AEDNO', type:'int')
			sourceOfContributionMoney (column:'AESRC', type:'TrimString')
			effDateOfContribution (column:'AEEDTE', type:'date')
			expireDateOfContribution (column:'AEEXDTE', type:'date')
			openField1 (column:'AEFIL1', type:'big_decimal')
			openField2 (column:'AEFIL2', type:'big_decimal')
			openField3 (column:'AEFIL3', type:'big_decimal')
			openField4 (column:'AEFIL4', type:'TrimString')
			openField5 (column:'AEFIL5', type:'TrimString')
		}
	}
	boolean newEntity = false
	static transients = ['newEntity']

	def beforeInsert () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  } 
	def beforeUpdate () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
	def beforeDelete () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
}