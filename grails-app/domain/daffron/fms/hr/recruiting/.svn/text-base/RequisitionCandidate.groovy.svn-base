
package daffron.fms.hr.recruiting

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import java.util.Date;

@SuppressWarnings("deprecation")
class RequisitionCandidate {
	Requisition requisition
	Candidate candidate
	int rank = 0 // 99 is HR select
	int hrRank = 0
	String emailQuizReply
	Date phoneInterview
	
	Date contactedForTest
	Date drugTestInitiated
	Date drugTestComplete
	boolean drugTest = false
	Date backgroundCheckInitiated
	Date backgroundCheckComplete
	boolean backgroundCheck = false
	Date onsiteTest
	Date interview
	Date start
	String phoneQuiz
	String phoneQuizReply
	Date offerLetter
	boolean offerAccepted = false
	Date offerResponse
	
	static mapping = {
		table name:'hrpreqcnd', schema:CH.config.hr.schema
		phoneInterview nullable:false
		
		contactedForTest column:'calltest'
		drugTestInitiated column:'drugtesti'
		drugTestComplete column:'drugtestc'
		drugTest		 column:'drugtest', type:'org.hibernate.type.YesNoType'
		backgroundCheckInitiated column:'bckgndchki'
		backgroundCheckComplete column:'bckgndchkc'
		backgroundCheck  column:'bckgndchk', type:'org.hibernate.type.YesNoType'
		onsiteTest column:'onsitetest'
		offerAccepted  type:'org.hibernate.type.YesNoType'
		offerResponse column:'offerresp'
	}
	static constraints = {
		emailQuizReply nullable:true, maxSize:4096
		phoneInterview nullable:true
		
		contactedForTest nullable:true
		drugTestInitiated nullable:true
		drugTestComplete nullable:true
		backgroundCheckInitiated nullable:true
		backgroundCheckComplete nullable:true
		onsiteTest nullable:true
		interview nullable:true
		start nullable:true
		phoneQuiz nullable:true, maxSize:4096
		phoneQuizReply nullable:true, maxSize:4096
		offerLetter nullable:true
		offerResponse nullable:true
	}
}