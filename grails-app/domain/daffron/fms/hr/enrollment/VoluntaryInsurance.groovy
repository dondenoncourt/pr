package daffron.fms.hr.enrollment

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class VoluntaryInsurance {
	String name
	String coveredPersonType
	BigDecimal costPriorPerPay = 0g
	BigDecimal costPerPay = 0g
	String benefit = ''
	String benefitExtra = '' // for flat rate 
	String optionType 
	boolean waive = false
	boolean notApplicable = false

	static belongsTo = [enroll:Enroll]
	static COVERED_PERSON_TYPE_MAP = ['E':'Employee', 'S':'Spouse', 'C':'Child(ren)', 'D':'Dependants', 'U':'Standard']
	static OPTION_TYPE_MAP = ['C':'Continue', 'N':'Change', 'X':'Cancel']
	static constraints = {
		coveredPersonType  maxSize:1, nullable:false, blank:false, inList:COVERED_PERSON_TYPE_MAP.keySet() as List
		optionType  maxSize:1, nullable:false, blank:false, inList:OPTION_TYPE_MAP.keySet() as List
		costPriorPerPay nullable:true, blank:true
		costPerPay nullable:true, blank:true
		optionType nullable:true, blank:true
	}
	static mapping = {
		table name:'hrpvolins', schema:CH.config.hr.schema
		coveredPersonType  column:'persontype'
		costPriorPerPay    column:'costpripay', max: 9999999.99g 
		costPerPay         column:'costperpay', max: 9999999.99g
		optionType		   column:'optiontype'
		waive 			type:'org.hibernate.type.YesNoType'
	}
	String toString() {"$name:${(COVERED_PERSON_TYPE_MAP[coveredPersonType])}"}

}
