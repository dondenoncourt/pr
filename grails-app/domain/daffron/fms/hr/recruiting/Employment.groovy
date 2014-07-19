package daffron.fms.hr.recruiting

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import daffron.fms.hr.Address

class Employment implements Serializable {
	int fromMMYY
	int toMMYY // 9999 means still employed at this company
	String position
	BigDecimal ending
	int years
	String supervisor
	String company
	String business
	Address addr
	String duties
	String whyLeft 
	boolean contact
	String contactPhone = ''
	String whyNoContact
	static belongsTo = [candidate:Candidate]
	static embedded = ['addr']
	
	static constraints = {
		whyNoContact (nullable:true, validator:{ whyNoContact, emp ->
			if (!emp.contact && !whyNoContact) {
				return false
			}
			return true
		})
		position nullable:false, blank:false
		business nullable:false, blank:false
		company nullable:false, blank:false
		duties nullable:false, blank:false
		whyLeft validator:{whyLeft, hist ->
			if (hist.toMMYY < 9999 && !whyLeft) {
				return "employment.whyLeft.blank"
			}
		}
		contactPhone maxSize:10,nullable:true, blank:true
		//addr nullable:true
		fromMMYY validator:{ fromMMYY, hist ->
			int mm = fromMMYY / 100
			if (fromMMYY.toString().size() > 4) {
				return "employment.fromMMYY.invalid.year"
			}
			if (!(1..12).contains(mm)) {
				return "employment.fromMMYY.invalid.date"
			}
			return true
		} 
		toMMYY validator:{ toMMYY, hist ->
			if (toMMYY != 9999) {
				int mm = toMMYY / 100
				if (toMMYY.toString().size() > 4) {
					return "employment.toMMYY.invalid.year"
				}
				if (!(1..12).contains(mm)) {
					return "employment.toMMYY.invalid.date"
				}
//				if ((toMMYY && !hist.fromMMYY) || (!toMMYY && hist.fromMMYY)) {
//					return "employment.toMMYY.invalid.daterange"
//				}
//				int toYYMM = (toMMYY % 100) * 100 + (toMMYY / 100)
//				int fromYYMM = (hist.fromMMYY % 100) * 100 + (hist.fromMMYY / 100)
//				if (fromYYMM >= toYYMM) {
//					return "employment.toMMYY.invalid.daterange"
//				}
			}
			return true
		} 
	}
	static mapping = {
		table name:'hrpemphst', schema:CH.config.hr.schema
		contact  type:'org.hibernate.type.YesNoType'
	}
	String toString() {"$company $fromMMYY - $toMMYY $position"}
}