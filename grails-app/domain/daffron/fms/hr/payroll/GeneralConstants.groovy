package daffron.fms.hr.payroll
//use schema:CH.config.[config.groovy custom variable] to soft-code library
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import grails.util.Environment
import org.systemitools.types.*


// Note: do not read by key (get()) as there is no unique index on the table
class GeneralConstants implements Serializable {
	String constantName
	String userId = ''
	String constantData
	static constraints = {
		constantName(maxSize:20,nullable:false)
		userId(maxSize:15,nullable:false)
		constantData(maxSize:50,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = true
	static mapping = {
		table name:'prpconst', schema:CH.config.hr.schema
		version (false)
		id (generator:'assigned')
		id (composite:['constantName','userId'])
		columns {
			id (composite:['constantName','userId'])
			constantName (column:'NAME', type:'TrimString')
			userId (column:'USERID', type:'TrimString')
			constantData (column:'DATA', type:'TrimString')
		}
	}
	boolean newEntity = false
	static transients = ['newEntity']
	
	def beforeInsert () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  } 
	def beforeUpdate () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
	def beforeDelete () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
	String toString() {"$constantName:$userId:$constantData"}
}