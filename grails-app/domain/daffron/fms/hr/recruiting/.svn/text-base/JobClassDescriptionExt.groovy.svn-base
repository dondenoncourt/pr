package daffron.fms.hr.recruiting

//use schema:CH.config.[config.groovy custom variable] to soft-code library
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import org.systemitools.types.*

class JobClassDescriptionExt implements Serializable {
	String jobClass
	int lineNumber
	String descriptionLine
	static constraints = {
		jobClass(maxSize:5,nullable:false)
		lineNumber(max:999,nullable:false)
		descriptionLine(maxSize:40,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = true
	static mapping = {
		table name:'hrpjedsc', schema:CH.config.hr.schema // note: this is a legacy iXp table
		version (false)
		id (generator:'assigned')
		id (composite:['jobClass','lineNumber'])
		columns {
			id (composite:['jobClass','lineNumber'])
			jobClass (column:'JEJCLS', type:'string')
			lineNumber (column:'JELNNO', type:'int')
			descriptionLine (column:'JEDSC', type:'string')
		}
	}
	boolean newEntity = false
	static transients = ['newEntity']
}