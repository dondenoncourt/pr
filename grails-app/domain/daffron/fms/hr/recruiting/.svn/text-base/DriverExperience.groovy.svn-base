package daffron.fms.hr.recruiting

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
   
class DriverExperience implements Serializable { 
	String klass
	String typ
	String other = ''
	int fromMMYY = 0
	int toMMYY = 0
	int miles = 0
	static belongsTo = [candidate:Candidate]
	
	static CLASS_MAP = [
						'1':'Straight Truck',
						'2':'Tractor - Two Trailers',
						'3':'Tractor - Three Trailers',
		 				'4':'Tractor and Semi-Trailer', 
						'M':'Motorcoach - School Bus (more than 15 passengers',
						'O':'Other'
						]
	static TYPE_MAP = ['V':'Van',
						'T':'Tank',
						'F':'Flat',
						'D':'Dump',
						'R':'Refer'
					]				
	static constraints = {
		klass maxSize:1, inList:CLASS_MAP.keySet() as List, 
			validator:{ klass, exp ->
			if (klass && exp.has && !exp.typ) {
				return "driverExperience.klass.invalid"
			}
			return true
		}
		typ nullable:true
		other nullable:true
		miles validator:{ miles, exp ->
			if (!exp.has) {
				return true
			}
			if (miles < 100) {
				return "driverExperience.miles.min.notmet"
			}
			return true
		}  
		fromMMYY validator:{ fromMMYY, exp ->
			if (!exp.has) {
				return true
			}
			int mm = fromMMYY / 100
			if (!(1..12).contains(mm)) {
				return "driverExperience.fromMMYY.invalid.date"
			}
			return true
		} 
		toMMYY validator:{ toMMYY, exp ->
			if (!exp.has) {
				return true
			}
			int mm = toMMYY / 100
			if (!(1..12).contains(mm)) {
				return "driverExperience.toMMYY.invalid.date"
			}
			if ((toMMYY && !exp.fromMMYY) || (!toMMYY && exp.fromMMYY)) {
				return "driverExperience.toMMYY.invalid.daterange"
			}
			int toYYMM = (toMMYY % 100) * 100 + (toMMYY / 100)
			int fromYYMM = (exp.fromMMYY % 100) * 100 + (exp.fromMMYY / 100)
			if (fromYYMM >= toYYMM) {
				return "driverExperience.toMMYY.invalid.daterange"
			}
			return true
		} 
	}
	static mapping = {
		table name:'hrpdrvexp', schema:CH.config.hr.schema
	}
	static transients = ['has']
	boolean getHas() {return fromMMYY && toMMYY && miles}
	private void setHas(boolean ignore) {}
}