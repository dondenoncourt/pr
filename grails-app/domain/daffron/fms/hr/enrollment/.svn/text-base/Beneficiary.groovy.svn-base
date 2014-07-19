package daffron.fms.hr.enrollment
import java.util.Date;

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

public class Beneficiary {
	String type
	boolean sameAsPrimary = false
	String name
	String relationship
	Date birth
	Long ssn
	BigDecimal share
	
	static belongsTo = [enroll:Enroll]
	
	static RELATIONSHIP_TYPES = ['S':'Subscriber', 'P':'Spouse','C':'Child', 'O':'other']
	static BENEFICIARY_TYPES = ['PRI':'Primary - Trans America 401k', 'SEC':'Secondary Plan', 'NRECA':'NRECA RS Pension Plan','UNUM':'UNUM Group Life']
	static constraints = {
		type maxSize:5, nullable:false, blank:false, inList:BENEFICIARY_TYPES.keySet() as List
		name nullable:true, blank:true, validator: {name, beneficiary ->
				if (!beneficiary.sameAsPrimary && !name) {
					return false
				}
		}
		relationship maxSize:1, nullable:true, blank:true, 
			inList:RELATIONSHIP_TYPES.keySet() as List, 
			validator: {relationship, beneficiary ->
				if (!beneficiary.sameAsPrimary && !relationship) {
					return false
				}
		} 
			
		share nullable:true, validator: {share, beneficiary ->
				if (!beneficiary.sameAsPrimary && !share) {
					return false
				}
		} 
 
		birth nullable:true, validator: {birth, beneficiary ->
				if (!beneficiary.sameAsPrimary && !birth) {
					return false
				}
		} 
		ssn nullable:true, matches:/\d{9}/, validator: {ssn, beneficiary ->
				if (!beneficiary.sameAsPrimary && !ssn) {
					return false
				}
		}
	}
	static mapping = {
		table name:'hrpbenef', schema:CH.config.hr.schema
		type            	column:'betype'
		sameAsPrimary       column:'besame', type:'org.hibernate.type.YesNoType'
		name				column:'bename' 
		relationship 		column:'berltn' 
		birth 			 	column:'bebdate'
		ssn 			 	column:'bessn' 
		share			 	column:'beshare', max:999.99g
		
	}
	String toString() {"$name:$type"}
}
