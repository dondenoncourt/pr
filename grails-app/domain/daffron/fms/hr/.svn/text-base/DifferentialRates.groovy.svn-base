package daffron.fms.hr

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import org.systemitools.types.*

class DifferentialRates implements Serializable {
	String jobClass
	String code
	Date effective
	BigDecimal rate
	String addOnToExistingRatesTypeA
	String earningsCode
	static constraints = {
		jobClass(maxSize:5,nullable:true)
		code(maxSize:2,nullable:true)
		effective(nullable:true)
		rate(max:new BigDecimal("99999.9999"),nullable:true)
		addOnToExistingRatesTypeA(maxSize:1,nullable:true)
		earningsCode(maxSize:3,nullable:true)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = true
	static mapping = {
		table name:'hrpjdiff', schema:CH.config.hr.schema
		version (false)
		id (generator:'assigned')
		id (composite:['jobClass','earningsCode'])
		columns {
			id (composite:['jobClass','earningsCode'])
			jobClass (column:'JDJCLS', type:'string')
			code (column:'JDDIFF', type:'string')
			effective (column:'JDEFDT', type:'date')
			rate (column:'JDRTE', type:'big_decimal')
			addOnToExistingRatesTypeA (column:'JDDFTP', type:'string')
			earningsCode (column:'JDECODE', type:'string')
		}
	}
	boolean newEntity = false
	static transients = ['newEntity']
	
	def beforeInsert () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  } 
	def beforeUpdate () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
	def beforeDelete () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
}
