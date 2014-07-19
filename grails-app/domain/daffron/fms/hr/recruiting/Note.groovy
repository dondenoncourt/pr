package daffron.fms.hr.recruiting

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import java.util.Date;

class Note { 
	String note
	String toString() {note}
	Date dateCreated
	Date lastUpdated
	RequisitionStatus reqStatus
	static belongsTo = [candidate:Candidate]
	static mapping = {
		table name:'hrpcdnot', schema:CH.config.hr.schema
	}
}