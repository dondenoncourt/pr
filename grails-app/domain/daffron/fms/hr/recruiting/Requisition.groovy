package daffron.fms.hr.recruiting

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

import daffron.fms.hr.User;
import daffron.fms.hr.payroll.EmployeePayrollMaster
import java.util.Date;

@SuppressWarnings("deprecation")
class Requisition {
	JobDescription jobD
	RequisitionStatus status  
	Date dateNeeded
	int noPositions = 1
	EmployeePayrollMaster replacing
	String workSite
	boolean fullTime
	boolean partTime
	boolean regular 
	boolean temporary
	String misc
	EmployeePayrollMaster supervisor
	Date dateCreated
	Date lastUpdated
	Date interview
	Date approvedForHire
	Date internalPosted
	Date externalPosted
	String hireComment
	Date hrFiltered // HR has selected what candidates to move forward to super filtering
	Date superFiltered // the super has selected what candidates to move forward with testing
	Date picked // the candidates have been picked for interview
	
	def grailsApplication 
	
	static hasMany = [interviewTeam:Interviewer, 
		              approvedBy:ApproveRequisition, 
					  candidates:RequisitionCandidate
					 ]
	
	static constraints = {
		interview nullable:true
		supervisor nullable:false, blank:false
		approvedForHire nullable:true
		misc nullable:true
		replacing nullable:true
		internalPosted nullable:true
		externalPosted nullable:true
		hireComment nullable:true, blank:true
		hrFiltered nullable:true
		superFiltered nullable:true
		picked nullable:true
	}

	static mapping = {
		table name:'hrpreq', schema:CH.config.hr.schema
		fullTime  type:'org.hibernate.type.YesNoType'
		partTime  type:'org.hibernate.type.YesNoType'
		regular   type:'org.hibernate.type.YesNoType'
		temporary  type:'org.hibernate.type.YesNoType'
		approvedForHire column:'okhire' 
		interviewTeam cascade:'all-delete-orphan'
		approvedBy cascade:'all-delete-orphan'
		candidates cascade:'all-delete-orphan'
	}
	static transients = ['jobDChanged', 'elapsedDays', //'candidates', 
		'allContactedForTesting', 'allTestScoresIn', 'allContactedForInterview',
		'allBackgroundChecksComplete', 'allBackgroundChecksInitiated', 'allDrugTestsComplete',
		'allStartDatesSet', 'approved', 'filtered', 'allEmailQuizRepliesIn', 'allPhoneInterviewsComplete',
		'candidateEmails', 'approverEmails', 'interviewTeamPicked', 'interviewTeamEmails', 'offerAccepted',
		'statusRulesError', 'editLink'
		]
	String statusRulesError // transient 
	
	int getElapsedDays() {
		groovy.time.TimeCategory.minus( new Date(), dateCreated).days
	}
	private void setElapsedDays(int ignore) {/*ignore*/}
	
	boolean isJobDChanged() {
		return JobDescription.where {prodJobD == jobD}.find() as boolean
	}
	private def setJobDChanged(boolean ignore) {/* ignore */}
	
	boolean getAllContactedForTesting() {
		boolean allContacted = this.candidates as boolean
		this.candidates?.each {reqCandi ->
			if ((1..98).contains(reqCandi.rank) && !reqCandi.contactedForTest) {
				allContacted = false
			}
		}
		allContacted
	}
	private def setApproved(boolean ignore) {/* ignore */}
	boolean getApproved() {
		boolean approved = true
		approvedBy.each {approver ->
			if (approver.mustOk && !approver.approved) {
				approved = false
			}
		}
		approved
	}
	private def setAllContactedForTesting(boolean ignore) {/* ignore */}
	boolean getAllContactedForInterview() {
		boolean allContacted = this.candidates as boolean
		this.candidates?.each {candi ->
			if ((1..98).contains(candi.rank) && !candi.interview) {
				allContacted = false
			}
		}
		allContacted
	}
	private def setAllContactedForInterview(boolean ignore) {/* ignore */}
	
	boolean getAllTestScoresIn() {
		boolean allTestScoresIn = true
		this.candidates?.each {reqCandi ->
			if ((1..98).contains(reqCandi.rank)) {
				jobD?.tests?.each {test ->
					if (!TestScore.findByCandidateAndTest(reqCandi.candidate, test)) {
						allTestScoresIn = false
					}
				}	
				if (!BehaviorResult.findByCandidate(reqCandi.candidate)) {
					allTestScoresIn = false
				}
			}
		}
		allTestScoresIn
	}	
	private def setAllTestScoresIn(boolean ignore) {/* ignore */}
	
	boolean getAllBackgroundChecksComplete() {
		int bkgChkCount = 0
		this.candidates?.each {reqCandi ->
			if ((1..98).contains(reqCandi.rank) && reqCandi.backgroundCheckComplete) {
				bkgChkCount++
			}
		}
		bkgChkCount >= noPositions
	}	
	private def getAllBackgroundChecksComplete(boolean ignore) {/* ignore */}
	
	boolean getAllBackgroundChecksInitiated() {
		int bkgChkCount = 0
		this.candidates?.each {reqCandi ->
			if ((1..98).contains(reqCandi.rank) && reqCandi.backgroundCheckInitiated) {
				bkgChkCount++
			}
		}
		bkgChkCount >= noPositions
	}
	private def getAllBackgroundChecksInitiated(boolean ignore) {/* ignore */}

	boolean getFiltered() {
		return candidates.find{(1..99).contains(it.rank)} // someone must have changed the rank
	}
	private setFiltered(boolean ignore) {/* ignore */}
	
	boolean getAllDrugTestsComplete() {
		int drugTestsCount = 0
		this.candidates?.each {reqCandi ->
			if ((1..98).contains(reqCandi.rank) && reqCandi.drugTestComplete) {
				drugTestsCount++ 
			}
		}
		drugTestsCount >= noPositions
	}
	private def setAllDrugTestsComplete(boolean ignore) {/* ignore */}
	
	boolean getAllEmailQuizRepliesIn() {
		boolean allIn = this.candidates as boolean
		this.candidates?.findAll{(1..98).contains(it.rank)}?.each {candi ->
			if (!candi.emailQuizReply) {
				allIn = false
			}
		}
		allIn
	}
	private def setAllEmailQuizRepliesIn(boolean ignore) {/* ignore */}
	
	boolean getAllPhoneInterviewsComplete() {
		boolean allIn = this.candidates as boolean
		candidates.findAll{(1..99).contains(it.rank)}?.each {reqCandi ->
			if (!reqCandi.phoneInterview) {
				allIn = false
			}
		}
		allIn
	}
	private def setAllPhoneInterviewsComplete (boolean ignore) {/* ignore */}
	
	boolean getAllStartDatesSet() {
		int startDateCount = 0
		this.candidates?.each {reqCandi ->
			if ((1..98).contains(reqCandi.rank) && reqCandi.start) {
				startDateCount++
			}
		}
		startDateCount >= noPositions
	}
	private def setAllStartDatesSet(boolean ignore) {/* ignore */}

	String getEditLink() {
		def g = grailsApplication.mainContext.getBean('org.codehaus.groovy.grails.plugins.web.taglib.ApplicationTagLib')
		"${g.createLink(action:'edit', controller:'requisition', absolute:'true')}/${id}"
	}
	
	private def setEditLink(String ignore) {/* ignore */}

	List getCandidateEmails() {
		candidates.findAll{(1..99).contains(it.rank)}*.candidate.email
	}
	
	private def setCandidateEmails(boolean ignore) {}
	
	List getApproverEmails() {
		def team = []
		approvedBy.each { approver ->
			def user = User.findByEmployeeNo(approver.employee.id)
			if (user) {
				team << user.email 
			}
		}
		team
	}
	
	private def setApproverEmails (boolean ignore) {}
	
	boolean getInterviewTeamPicked() {
		interviewTeam
	}
	private def setInterviewTeamPicked(boolean ignore) {}
	
	List getInterviewTeamEmails() {
		def team = []
		interviewTeam.each {itv ->
			def list = User.where{employeeNo == itv.emp.id}.list()
			if (list) { // handle duplicate empNos in xxpuser by getting the first one
				team << (list[0]?.email)
			}
		}
		team	
	}
	private def setInterviewTeamEmails(boolean ignore) {}
	
	boolean getOfferAccepted() {
		candidates.find{(1..99).contains(it.rank) && it.offerAccepted}
	}
	private def setOfferAccepted (boolean ignore) {/* ignore */}
	
	def nextStatus(String key) {
		statusRulesError = null
		status = RequisitionStatus.get(key)
	}
	def statusRulesError(String error) {
		statusRulesError = error
	}
	
	String toString() {jobD}
}
