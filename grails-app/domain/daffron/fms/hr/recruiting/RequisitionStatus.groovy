package daffron.fms.hr.recruiting;

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

public class RequisitionStatus {
	String 	id
	String 	code
	String 	desc
	String nextPageSuper
	String nextPageHr
	def grailsApplication
	// consider adding a level or something to show progress
	static mapping = {
		table name:'hrpreqst', schema:CH.config.hr.schema
		version false
		id 				column:'code', generator:'assigned', type:'string'
		desc 			column:'descr'
		code 			insert:"false", update:"false"
		nextPageSuper	nullable:true
		nextPageHr 		nullable:true
	}
	def getCode() { 
		if (id) return id
		return 
	}
	void setCode (def vlu) { id = vlu }
	static transients = ['code']
	
	String toString() {"$id:$desc"}
	
	static List activeStatuses() {
		// create instance so we can use grailsApplication
		def rs = new RequisitionStatus()
		rs.discard()
		List statuses = []
		rs.grailsApplication.config.requisition.status.order.each {status ->
			statuses << RequisitionStatus.get(status)
		}
		statuses
	}

}