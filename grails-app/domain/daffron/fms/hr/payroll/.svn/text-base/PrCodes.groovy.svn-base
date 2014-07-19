package daffron.fms.hr.payroll

import grails.util.Environment

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import org.systemitools.types.*

class PrCodes implements Serializable {
	String field
	String value
	String descOfValue
	static constraints = {
		field(maxSize:10,nullable:false)
		value(maxSize:15,nullable:false)
		descOfValue(maxSize:45,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = true
	static mapping = {
		table name:'prpf4', schema:CH.config.hr.schema
		version (false)
		id (generator:'assigned')
		id (composite:['field','value'])
		columns {
			id (composite:['field','value'])
			field (column:'F4FLD', type:'TrimString')
			value (column:'F4VALU', type:'TrimString')
			descOfValue (column:'F4DESC', type:'TrimString')
		}
	}
	boolean newEntity = false
	static transients = ['newEntity']

	def beforeInsert () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  } 
	def beforeUpdate () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
	def beforeDelete () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
	
	String toString() {"$field:$value:$descOfValue"}
}