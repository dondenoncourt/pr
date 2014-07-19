package daffron.fms

//use schema:CH.config.[config.groovy custom variable] to soft-code library
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import org.systemitools.types.*

class AuthorizedUserOperations implements Serializable {
	Long authorityOperationId
	String userId
	String permission
	static constraints = {
		authorityOperationId(nullable:false)
		userId(maxSize:20,nullable:false)
		permission(maxSize:1,nullable:false, inList:['G','D'])
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = true
	static mapping = {
		table name:'xxpauusrop', schema:CH.config.hr.schema
		version (false)
		id (generator:'assigned')
		id (composite:['authorityOperationId','userId'])
		columns {
			id (composite:['authorityOperationId','userId'])
			authorityOperationId (column:'APAUOPID', type:'long')
			userId (column:'APUSER', type:'string')
			permission (column:'APPERM', type:'string')
		}
	}
	boolean newEntity = false
	static transients = ['newEntity', 'give', 'deny']
	boolean getGive() {permission == 'G'}
	private setGive(String ignore) {}
	boolean getDeny() {permission == 'D'}
	private setDeny(String ignore) {}
	String toString() {"${authorityOperationId}:${userId}:${permission}"}
}