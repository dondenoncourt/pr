package daffron.fms.hr

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import org.systemitools.types.*

class HrCodes implements Serializable {
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
		table name:'hrpf4', schema:CH.config.hr.schema// note: this is a legacy iXp table
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
}