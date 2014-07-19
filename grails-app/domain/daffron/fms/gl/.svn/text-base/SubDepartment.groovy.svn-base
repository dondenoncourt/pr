//use schema:CH.config.[config.groovy custom variable] to soft-code library
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import org.systemitools.types.*

class SubDepartment implements Serializable {
	String companyCode = ''
	String divisionCode = ''
	String subDeptCode = ''
	String description
	String note
	static constraints = {
		companyCode(maxSize:5,nullable:false)
		divisionCode(maxSize:5,nullable:false)
		subDeptCode(maxSize:5,nullable:false)
		description(maxSize:50,nullable:false)
		note(maxSize:500,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = true
	static mapping = {
		table name:'glpsdpt', schema:CH.config.gl.schema
		version (false)
		id (generator:'assigned')
		id (composite:['companyCode','divisionCode','subDeptCode'])
		columns {
			id (composite:['companyCode','divisionCode','subDeptCode'])
			companyCode (column:'SDCOMP', type:'string')
			divisionCode (column:'SDDIV', type:'string')
			subDeptCode (column:'SDSDPT', type:'string')
			description (column:'SDDESC', type:'string')
			note (column:'SDNOTE', type:'string')
		}
	}
	boolean newEntity = false
	static transients = ['newEntity']
	def beforeInsert () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  } 
	def beforeUpdate () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
	def beforeDelete () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
	String toString() {"$subDeptCode:$subDeptCode"}
    
}
