package daffron.fms.gl

//use schema:CH.config.[config.groovy custom variable] to soft-code library
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import grails.util.Environment
import org.systemitools.types.*

class Department implements Serializable {
	String companyCode = ''
	String divisionCode = ''
	String departmentCode = ''
	String description
	Long contactId
	String note = ''
	static constraints = {
		companyCode(maxSize:5,nullable:false)
		divisionCode(maxSize:5,nullable:false)
		departmentCode(maxSize:5,nullable:false)
		description(maxSize:50,nullable:false)
		contactId(nullable:true)
		note(maxSize:500,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = true
	static mapping = {
		table name:'glpdept', schema:CH.config.gl.schema
		version (false)
		id (generator:'assigned')
		id (composite:['companyCode','divisionCode','departmentCode'])
		columns {
			id (composite:['companyCode','divisionCode','departmentCode'])
			companyCode (column:'DECOMP', type:'string')
			divisionCode (column:'DEDIV', type:'string')
			departmentCode (column:'DEDEPT', type:'string')
			description (column:'DEDESC', type:'string')
			contactId (column:'DECONTID', type:'long')
			note (column:'DENOTE', type:'string')
		}
	}
	boolean newEntity = false
	static transients = ['newEntity']
	def beforeInsert () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  } 
	def beforeUpdate () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
	def beforeDelete () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
	String toString() {"$departmentCode:$description"}
}
