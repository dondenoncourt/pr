package daffron.fms

//use schema:CH.config.[config.groovy custom variable] to soft-code library
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import org.systemitools.types.*

class AuthorizedOperations implements Serializable {
	Long id
	Long authorityOperationId
	String controller
	String action
	Long securityLevel
	String text
	static constraints = {
		authorityOperationId(nullable:false)
		controller(maxSize:50,nullable:false)
		action(maxSize:50,nullable:false)
		securityLevel(nullable:false)
		text(maxSize:100,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = false
	static mapping = {
		table name:'xxpauops', schema:CH.config.hr.schema
		version (false)
		id (generator:'assigned')
		columns {
			id (column:'AOOPID',type:'long')
			authorityOperationId (column:'AOAUOPID', type:'long')
			controller (column:'AOMENU', type:'string')
			action (column:'AOMENUITEM', type:'string')
			securityLevel (column:'AOSECLEVEL', type:'long')
			text (column:'AOTEXT', type:'string')
		}
	}
	boolean newEntity = false
	static transients = ['operationId', 'newEntity', 'uri']
	def getOperationId() {
		if (id) return id
		return 0
	}
	void setOperationId (def vlu) { id = vlu }
	static Long maxId() {
		Long max = AuthorizedOperations.withCriteria (uniqueResult:true) {
			projections {max('id')}
		}
	}
	static Long maxAuthorityOperationId() {
		Long max = AuthorizedOperations.withCriteria (uniqueResult:true) {
			between ( 'authorityOperationId',  
					grailsApplication.config.xxauops.min.op.id as Long, 
					grailsApplication.config.xxauops.max.op.id as Long 
					)
			projections {max('authorityOperationId')}
		}
	}
	String getUri() {"$controller/$action"}
	private void setUri(String ignore) {}
	static List authorizedOperationsHR() {
		AuthorizedOperations.findAllByAuthorityOperationIdBetween(CH.config.xxauops.min.op.id,
																	CH.config.xxauops.max.op.id,
																	[sort:'controller', order:'desc'])
	}
	String toString() {"${id}:${authorityOperationId}:${controller}:${action}:${securityLevel}:${text}"}
}
