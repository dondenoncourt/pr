package daffron.fms.hr.recruiting

import grails.converters.JSON

import daffron.fms.hr.User
import daffron.fms.hr.AuthorizeOperation

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import org.codehaus.groovy.grails.commons.GrailsApplication

class CandidateController {
	def statusService
	def resumeService
    static allowedMethods = [save: "POST", update: "POST", delete: "POST",
		getTestInfo:"POST", addStandardTestScore:"POST", addBehaviorResult:"POST", rebuildBehaviorTable:"POST", 
		rebuildStandardTestTable:"POST", reject:"POST", setEmailQuizReply:"POST", setPhoneInterview :"POST", 
		setPhoneQuiz :"POST", setPhoneQuizReply:"POST", addNote:"POST", backgroundCheckInit:"POST", backgroundCheck:"POST",
		drugTestInit:"POST", drugTest:"POST", interviewDate:"POST", startDate:"POST", onlineTest:"POST",
		onsiteTestDate:"POST", //employmentHistory:"POST", 
		deleteHistory:"POST", updateRank:"POST", removeDriverAccident:"POST",
		promptViolations:"POST", promptAccidents:"POST", bubbleRank:"POST"]
	
	def beforeInterceptor = {
		log.debug("action: $actionName params: $params flash: $flash")
	}
	
    def index = {
        redirect(action: "list", params: params)
    }
	static def HOVER_MENU_STATUS_ACTION_MAP = [
		NEW:['list'],
		JOBDMOD:['list', 'create'],
		PREPOSTING:['create', 'list'],
		IPOSTED:['create', 'list', 'filter'],
		XPOSTED:['create', 'list', 'filter'],
		HRSELECT:['create', 'filter', 'list'],
		SUPERSELECT:['filter', 'list'],
		PRECONTACT:['list', 'contact'],
		TESTING:['list','testResults'],
		PICK:['testCompare', 'list'],
		SINTD:['list', 'contact'],
		INTERVIEW:['list', 'postInterview'],
		BCKGRDCHK:['list', 'postInterview'],
		OFFERDRUG:['list', 'postInterview'],
		OFFER:['list', 'postInterview'],
		DRUG:['list', 'postInterview'],
		SUPERSIGNHIRE:['list', 'personalAction'],
		NEWHIRE:['list'],
		PRESCREEN:['list','prescreen'],
		PHONEINTV:['list','phoneIntv']
		// SCHTEST:[''], not required
	]
	
	static List authorizedActionPages(User user) {
		if (user.hrAdmin) {
			['testResults', 'testCompare', 'list', 'filter', 'edit', 'contact', 'create', 'postInterview', 'prescreen', 'phoneIntv']
 		} else {
		 	['testCompare', 'list', 'filter', 'personalAction'] 
		}
	}
	@AuthorizeOperation( level='4', text='Review candidate test results' )
	def testResults = {
		Requisition req = Requisition.get(params.id)
		if (!req) {
			flash.message = "Invalid requistion id"
			redirect action:'list', controller:'requisition'
			return
		}
		def candidates = []
		req.candidates.findAll{(1..98).contains(it.rank)}.each {candidates << it.candidate}
		[req:req, candidates:candidates, nextStatus:getNextStatus(req)]
	}
	def getTestInfo = { // ajax
		render (Test.get(params.testId) as JSON)
	}
	def addStandardTestScore = { // Ajax
		Candidate candidate = Candidate.get(params.candidateId.toLong())
		assert candidate
		Test test = Test.get(params.testId)
		assert test
		TestScore score = TestScore.findByCandidateAndTest(candidate, test)
		if (score) {
			score.properties = params
		} else {
			score = new TestScore(params)
			score.test = test
			score.candidate = candidate
			score.created = new Date()
			score.updated = new Date()
		}
		if (!score.save(flush:true)) {
			score.errors.each{log.error it}	
			assert false
		}
		Requisition requisition = Requisition.get(params.reqId.toLong())
		assert requisition
		//statusService.activity(requisition)  
		render "OK"
	}
	def addBehaviorResult = { // ajax
		Candidate candidate = Candidate.get(params.candidateId)
		assert candidate
		Behavior behavior = Behavior.get(params.behaviorId)
		assert behavior
		BehaviorResult result = BehaviorResult.findByCandidateAndBehavior(candidate, behavior)
		if (result) {
			result.result = params.behaviorResult.toInteger()
			result.note = params.note
			if (!result.save()) {
				result.errors.each{log.error it}
				assert false
			}
		} else {
			candidate.addToBehaviors(new BehaviorResult(behavior:behavior, result:params.behaviorResult.toInteger(), note:params.note))
			if (!candidate.save()) {
				candidate.errors.each{log.error it}
				assert false
			}
		}
		Requisition requisition = Requisition.get(params.reqId.toLong())
		assert requisition
		//statusService.activity(requisition)  
		render "OK"
	}
	def rebuildBehaviorTable = { // ajax
		Candidate candidate = Candidate.get(params.candidateId)
		assert candidate
		render template:'behaviorRows', model:[candidate:candidate]
	}
	
	def rebuildStandardTestTable = { // ajax
		Candidate candidate = Candidate.get(params.candidateId)
		assert candidate
		render template:'standardTestRows', model:[candidate:candidate]
	}
	@AuthorizeOperation( level='4', text='Prescreen candidates from email questionaire' )
	def prescreen = {
		def req = Requisition.get(params.id)
        [candidateList:req.candidates.findAll{(1..99).contains(it.rank)}, req:req, nextStatus:getNextStatus(req)]
	}
	@AuthorizeOperation( level='4', text='Candidates phone interview' )
	def phoneIntv = {
		def req = Requisition.get(params.id)
        [candidateList:req.candidates.findAll{(1..99).contains(it.rank)}, req:req, nextStatus:getNextStatus(req)]
	}
	@AuthorizeOperation( level='4', text='Candidate test comparison' )
    def testCompare = {
		def req = Requisition.get(params.id)
		if (!req) {
			flash.message = "please select a valid requisition ID"
			redirect action:'list', controller:'requisition'
		}
        [candidateList:req.candidates.findAll{(1..98).contains(it.rank)}, req:req, nextStatus:getNextStatus(req)]
    }
	def reject = { // ajax
		RequisitionCandidate reqCandi = RequisitionCandidate.get(params.id)
		assert reqCandi 
		reqCandi.rank = -1
		reqCandi.save()
		render "OK"
	}
	@AuthorizeOperation( level='1', text='List candidates for a requisition' )
    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
		def candidateList = []
		def candidateTotal  
		def req = Requisition.get(params.id)
        [req:req]
    }
	@AuthorizeOperation( level='1', text='Candidate search' )
    def search = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
		params.offset = params.offset?params.int('offset'):0
		def crit = Candidate.createCriteria()
		def candidateList
		if (params.name || params.military || params.driverExpClass || params.collegeEdu || 
			params.yesNo || params.degree) {
			candidateList = crit.list(params) {
				if (params.name)		like("name",  	   		"%${params.name}%".toUpperCase())
                if (params.military)	gt("military.years",  	   		0)
				if (params.collegeEdu) {
					education {
						eq("highOrGED", false)
						gt("years", 0)
					}
				}
		        if (params.yesNo)   { 
					params.yesNo.each {yesNo ->
						yesNoAns  { eq('yesNo.id', yesNo as Long) } 
					}
				}
				if (params.driverExpClass) { 
					driverExperience { 
						eq("klass", params.driverExpClass) 
						ne("miles", 0)
					} 
				}
                if (params.degree)	       { education        {like("degree", "%${params.degree}%".toUpperCase()) } }
			}
		} else {
			candidateList = crit.list(params) {}
		} 
        [candidateList:candidateList, params:params]
    }

	@AuthorizeOperation( level='4', text='Filter/seletect candidates' )
	def filter = {
		Requisition req = Requisition.get(params.id)
		if (!req) {
			flash.message = "Invalid requistion id"
			redirect action:'list', controller:'requisition'
			return
		}
		boolean supervisor = req.candidates.find{(1..98).contains(it.rank)} // see if any ranks are set 
		
		def unfiltered = req.candidates.findAll{it.rank == 0}.sort{it.candidate.matchPercent()}
		def top = req.candidates.findAll{it.rank > 0}.sort{it.rank}
		def rejected = req.candidates.findAll{it.rank < 0}
		
		[req:req, supervisor:supervisor, unfiltered:unfiltered, top:top, rejected:rejected, nextStatus:getNextStatus(req)]
	}
	@AuthorizeOperation( level='1', text='Edit candidate application form' )
    def edit = {
		render view:'edit', model:[candidate:Candidate.get(params.id), req:Requisition.get(params.reqId),  action:'edit']
    }
	@AuthorizeOperation( level='1', text='Formatted candidate application form' )
	def editTable = {
		render view:'editTable', model:[candidate:Candidate.get(params.id), req:Requisition.get(params.reqId), action:'editTable']
	}
	@AuthorizeOperation( level='1', text='Display candidate application form' )
	def show = {
		if (params.pdf || params.excel) {
			params.max = null
			params.offset = null
		}
		def candidate = Candidate.get(params.id)
		assert candidate
		render view:'edit', model:[candidate:candidate, req:Requisition.get(params.reqId), resume:resumeService.getResume(candidate), action:(session.user.hrSecurityLevel>1)?'edit':'show']
	}
	def setPhoneInterview = { // ajax
		def reqCandi = RequisitionCandidate.get(params.id.toInteger())
		reqCandi.phoneInterview = new Date()
		reqCandi.hrRank = params.hrRank.toInteger()
		if (reqCandi.hrRank < 0) {
			reqCandi.rank = -1
		}
		//statusService.activity(reqCandi.requisition)
		render "OK"
	}
	def setEmailQuizReply = { // ajax
		def reqCandi = RequisitionCandidate.get(params.id.toInteger())
		reqCandi.emailQuizReply = params.emailQuizReply
		assert reqCandi.candidate.save()
		//statusService.activity(reqCandi.requisition)
		render "OK"
	}
	def setPhoneQuiz = { // ajax
		def reqCandi = RequisitionCandidate.get(params.id.toInteger())
		reqCandi.phoneQuiz = params.phoneQuiz
		assert reqCandi.candidate.save()
		render "OK"
	}
	def setPhoneQuizReply = { // ajax
		def reqCandi = RequisitionCandidate.get(params.id.toInteger())
		reqCandi.phoneQuizReply = params.phoneQuizReply
		assert reqCandi.candidate.save()
		render "OK"
	}
	def addNote = { // ajax
		def reqCandi = RequisitionCandidate.get(params.id)
		assert reqCandi
		Note note = new Note(note:params.note, reqStatus:reqCandi.requisition.status)
		reqCandi.candidate.addToNotes note
		if (!reqCandi.candidate.save()) {
			reqCandi.candidate.errors.each{println it}
			assert false
		}
		render "OK"
	}
	def backgroundCheckInit = { // ajax
		def reqCandi = RequisitionCandidate.get(params.id)
		assert reqCandi
		reqCandi.backgroundCheckInitiated = new Date()
		if (!reqCandi.save()) {
			reqCandi.errors.each{println it}
			assert false
		}
		//statusService.activity(reqCandi.requisition)
		render "OK"
	}
	def backgroundCheck = { // ajax
		def reqCandi = RequisitionCandidate.get(params.id)
		assert reqCandi
		reqCandi.backgroundCheck = (params.result == 'true')
		reqCandi.backgroundCheckComplete = new Date()
		if (!reqCandi.save()) {
			reqCandi.errors.each{println it}
			assert false
		}
		//statusService.activity(reqCandi.requisition)
		render "OK"
	}
	def drugTestInit = { // ajax
		def reqCandi = RequisitionCandidate.get(params.id)
		assert reqCandi
		reqCandi.drugTestInitiated = new Date()
		if (!reqCandi.save()) {
			reqCandi.errors.each{println it}
			assert false
		}
		//statusService.activity(reqCandi.requisition)
		render "OK"
	}
	def drugTest = { // ajax
		def reqCandi = RequisitionCandidate.get(params.id)
		assert reqCandi
		reqCandi.drugTest = (params.result == 'true')
		reqCandi.drugTestComplete = new Date()
		if (!reqCandi.save()) {
			reqCandi.errors.each{println it}
			assert false
		}
		//statusService.activity(reqCandi.requisition)
		render "OK"
	}
	@AuthorizeOperation( level='4', text='Post interview candidate review' )
	def postInterview = {
		Requisition req = Requisition.get(params.id)
		if (!req) {
			flash.message = "Invalid requistion id"
			redirect action:'list', controller:'requisition'
			return
		}
		[candidateList:req.candidates.findAll{it.rank > 0}.sort{it.rank}, req:req, nextStatus:getNextStatus(req)]
	}
	@AuthorizeOperation( level='4', text='Contact candidate for various stages such as drug test, offer letter...' )
	def contact = {
		Requisition req = Requisition.get(params.id)
		if (!req) {
			flash.message = "Invalid requistion id"
			redirect action:'list', controller:'requisition'
			return
		}
		if (req.status.id == 'SINTD' && !req.interviewTeam) {
			flash.message = "Note: Please add interview team members before contacting the candidates."
			redirect controller:'requisition', action:'pickInterviewTeam', id:req.id
			return
		}
		[candidateList:req.candidates.findAll{it.rank > 0}.sort{it.rank}, req:req, nextStatus:getNextStatus(req)]
	}
	def interviewDate = { // ajax
		def reqCandi = RequisitionCandidate.get(params.id)
		assert reqCandi
		reqCandi.interview = params.interview
		if (!reqCandi.save(flush:true)) {
			reqCandi.errors.each{log.error it}
			assert false
		}
		if (!reqCandi.requisition.interview) {
			reqCandi.requisition.interview = reqCandi.interview
			assert reqCandi.requisition.save(flush:true)
		}
		//statusService.activity(reqCandi.requisition)  
		render g.formatDate (date:reqCandi.interview, format:"MM-dd-yyyy HH:mm").toString()
	}
	def startDate = { // ajax
		def reqCandi = RequisitionCandidate.get(params.id)
		assert reqCandi
		reqCandi.start = params.start
		if (!reqCandi.save(flush:true)) {
			reqCandi.errors.each{log.error it}
			assert false
		}
		//statusService.activity(reqCandi.requisition)  
		render g.formatDate (date:reqCandi.start, format:"MM-dd-yyyy").toString()
	}
	def onlineTest = { // ajax
		def reqCandi = RequisitionCandidate.get(params.id)
		assert reqCandi
		reqCandi.contactedForTest = new Date()
		reqCandi.onsiteTest = null
		if (!reqCandi.save()) {
			reqCandi.errors.each{println it}
			assert false
		}
		//statusService.activity(reqCandi.requisition)  
		render template:'precontactDates', model:[reqCandi:reqCandi]
	}
	def onsiteTestDate = { //ajax 
		def reqCandi = RequisitionCandidate.get(params.id)
		assert reqCandi
		reqCandi.onsiteTest = params.onsiteTest 
		reqCandi.contactedForTest = new Date()
		if (!reqCandi.save(flush:true)) {
			reqCandi.errors.each{log.error it}
			assert false
		}
		//statusService.activity(reqCandi.requisition)  
		render template:'precontactDates', model:[reqCandi:reqCandi]
	}
	@AuthorizeOperation( level='1', text='Create application form' )
    def create = {
		Requisition req = Requisition.get(params.id)
		if (!req && params.id) {
			flash.message = "A valid requisition ID must be passed to create a new candidate"
			redirect action:'list', controller:'requisition'
			return
		}
        def candidate = new Candidate()
        render view:'edit', model:[req:req, candidate: candidate, yesNoAns: []]
    }

	private setterHacks(Candidate candidate, def params) {
		/* hack to set the association dates as grails magic fails */
		candidate.accidents.eachWithIndex {accident, i ->
			accident.date = params["accidents[$i].date"]?java.sql.Date.parse('MM/dd/yyyy', params["accidents[$i].date"]):null
		}
		candidate.violations.eachWithIndex {violation, i ->
			violation.date = params["violations[$i].date"]?java.sql.Date.parse('MM/dd/yyyy', params["violations[$i].date"]):null
		}
		if (params['military.branch'] && params['military.discharge_year']) {
			candidate.military.discharge = params['military.discharge']
		}
	}
	@AuthorizeOperation( level='1', text='Save application form' )
    def save = {
		def req
		if (params.requisitionId) {
			req = Requisition.get(params.requisitionId)
			assert req
		}
        def candidate = new Candidate(params)
		setterHacks(candidate, params)
		candidate.validate() // hack to remove date unwarranted validation errors
		
		candidate.yesNoAns.each { it.answer = false }
		def yesNoIds = []
		
		params.findAll {it.key ==~ /yesNoWithIdOf\d*/}.each {key, val -> 
			def matcher = key =~ /yesNoWithIdOf(\d*)/
			yesNoIds << matcher[0][1]
		}
		def yesNoAns = []
		yesNoIds.each {id ->
			def answer = candidate?.yesNoAns.find{it.yesNo.id == id}
			if (!answer) {
				answer = new YesNoAns(yesNo:YesNo.get(id), answer:(params["yesNoWithIdOf${id}"] == "true")?true:false)
				candidate.addToYesNoAns answer
				yesNoAns << answer
			} else {
				answer.answer = params["yesNoWithIdOf${id}"] as boolean
			}
		}
		
        if (candidate.validate()) {
			candidate.driverExperience.each {exp ->
				if (!exp.has) {
					exp.delete()
				}
			}
			candidate.save(flush: true, validate:false)
			assert candidate.id
			if (req) {
				def reqCandi = new RequisitionCandidate(requisition:req, candidate:candidate, rank:0)
				assert reqCandi.save()
				req.addToCandidates(reqCandi)
				assert req.save()
			}

			def resume = request.getFile('resume') // property file for url/path and use candidate.id for name and upload file for suffix
			if (resume?.size) {
				if (resume.size < CH.config.hr.resume.max.len.megabytes * 100000) {
					resume.transferTo(new File("${CH.config.hr.resume.directory}/${candidate.id}_${candidate.name.replaceAll(/ /, '_')}_${resume.getOriginalFilename()}"))
				} else {
					flash.message = "Resume upload exceeds max size of ${CH.config.hr.resume.max.len.megabytes}MB"
		            render view: "edit", model: [candidate: candidate, req:req, yesNoAns:yesNoAns, action:'edit']
					return
				}
			}
			
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'candidate.label', default: 'Candidate'), candidate.id])}"
			if (grailsApplication.metadata['app.name'] == 'jobs') {
				redirect url:'http://www.daffron.com/company/careers.aspx'
			} else {
				redirect action:'list', controller:'requisition'
			}
        } else {
			//candidate.errors.each { println it }	
            render view: "edit", model: [candidate: candidate, req:req, yesNoAns:yesNoAns]
        }
    }

	def employmentHistory = { // ajax
		render template:'employmentHistory', model:[iHist:params.iHist, ajax:true]
	} 
	def deleteHistory = { // ajax
		def hist = Employment.get(params.employmentId)
		if (hist) { // must be transient
			def candi = hist.candidate
			assert candi
			candi.refresh()
			candi.removeFromHistory(hist)
			hist.delete()
			candi.save(flush:true)
		}
		render 'OK'
	}

	@AuthorizeOperation( level='1', text='Update application form' )
    def update = {
		def req
		if (params.requisitionId) {
			req = Requisition.get(params.requisitionId)
			assert req
		}
        def candidate = Candidate.get(params.id)
        if (candidate) {
			candidate.violations.eachWithIndex {violation, i ->
				params["violations[0].date"] = params["violations[$i].date"]?java.sql.Date.parse('MM/dd/yyyy', params["violations[$i].date"]):null
			}
			candidate.accidents.eachWithIndex {accident, i ->
				params["accidents[$i].date"] = params["accidents[$i].date"]?java.sql.Date.parse('MM/dd/yyyy', params["accidents[$i].date"]):null
			}
            bindData(candidate, params, [exclude:['military.discharge']])
			if (params['military.branch'] && params['military.discharge_year']) {
				candidate.military.discharge = params['military.discharge']
			} else if (candidate.military){
				candidate.military.discharge = null
			}
			if (params.noAccidents) {
				candidate.accidents.each{acci ->
					candidate.removeFromAccidents(acci)
					acci.delete()
				}
			}
			if (params.noViolations) {
				candidate.violations.each{viola ->
					candidate.removeFromViolations(viola)
					viola.delete()
				}
			}
			def yesNoIds = []
			params.findAll {it.key ==~ /yesNoWithIdOf\d*/}.each {key, val -> 
				def matcher = key =~ /yesNoWithIdOf(\d*)/
				yesNoIds << matcher[0][1]
			}
			yesNoIds.each {id ->
				def answer = candidate.yesNoAns.find{it.yesNo?.id == id.toInteger()}
				if (!answer) {
					YesNo yesNo = YesNo.get(id)
					if (!yesNo) {
						log.error("YesNo $id not found")
					}
					answer = new YesNoAns(yesNo:yesNo)
					candidate.addToYesNoAns answer
				}
				answer.answer = (params["yesNoWithIdOf${id}"] == "true")?true:false
			}
			// clean education with no description
			candidate.education.each{edu ->
				if (!edu.descr.trim()) {
					edu.years = 0
					edu.study = ''
					edu.degree = ''
				}
			}
			def resume = request.getFile('resume') // property file for url/path and use candidate.id for name and upload file for suffix
			if (resume?.size) {
				if (resume.size < CH.config.hr.resume.max.len.megabytes * 100000) {
					resume.transferTo(new File("${CH.config.hr.resume.directory}/${candidate.id}_${candidate.name.replaceAll(/ /, '_')}_${resume.getOriginalFilename()}"))
				} else {
					flash.message = "Resume upload exceeds max size of ${CH.config.hr.resume.max.len.megabytes}MB"
			        render view: "edit", model: [candidate: candidate, req:req, action:'edit']
					return
				}
			}
            if (candidate.save(flush: true)) {
				if (req) {
					if (!RequisitionCandidate.findByRequisitionAndCandidate(req, candidate)) {
						def reqCandi = new RequisitionCandidate(requisition:req, candidate:candidate, rank:0)
						assert reqCandi.save()
						req.addToCandidates(reqCandi)
						assert req.save()
					}
				}
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'candidate.label', default: 'Candidate'), candidate.id])}"
				redirect action:'list', controller:'requisition'
            } else {
				candidate.errors.each{println it}
                render(view: "edit", model: [candidate: candidate, req:req])
            }
        } else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'candidate.label', default: 'Candidate'), params.id])}"
            redirect(action: "list")
        }
    }

	@AuthorizeOperation( level='4', text='Delete application form' )
    def delete = {
        def candidate = Candidate.get(params.id)
        if (candidate) {
            try {
				def reqCandi = RequisitionCandidate.findByCandidate(candidate)
				if (reqCandi) {
					reqCandi.delete()
				}
                candidate.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'candidate.label', default: 'Candidate'), params.id])}"
				redirect action:'list', controller:'requisition'
            } catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'candidate.label', default: 'Candidate'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        } else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'candidate.label', default: 'Candidate'), params.id])}"
			redirect action:'list', controller:'requisition'
        }
    }
	def updateRank = { // ajax
        def reqCandi = RequisitionCandidate.get(params.id)
		assert reqCandi
		reqCandi.rank = params.rank.toInteger()
		reqCandi.errors.each{
		if (!reqCandi.save()) {
				println it
			}
		}
		if (reqCandi.rank == 99) {
			reqCandi.requisition.hrFiltered = new Date()
			assert reqCandi.requisition.save()
		}
		render "OK"
	}
	def removeDriverAccident = { // ajax
		DriverAccident acci = DriverAccident.get(params.id)
		Candidate candidate = acci.candidate
		candidate.removeFromAccidents(acci)
		acci.delete()
		assert candidate.save(flush:true)
		render "OK"
	}
	def promptViolations = { render template:'violations', model:[candidate:new Candidate()]	}
	def promptAccidents = { render template:'accidents', model:[candidate:new Candidate()]	}
	def bubbleRank = { // ajax
		def reqCandi = RequisitionCandidate.get(params.id)
		assert reqCandi
		/*
		 * find previous (or next if down) and toggle rank
		 * if previous is 99, set rank to 1
		 * 		
		 */
		def adjacents = RequisitionCandidate.withCriteria() {
		    eq 'requisition', reqCandi.requisition
			between 'rank', 1, 98
			if (params.direction == 'up') {
				lt 'rank', reqCandi.rank
				order 'rank', 'desc'
			} else { 
				gt 'rank', reqCandi.rank
				order 'rank', 'asc'
			}
		}		
		if (!adjacents) {
			reqCandi.rank = 1
		} else {
			def priorRank = adjacents[0].rank
			adjacents[0].rank = reqCandi.rank
			reqCandi.rank = priorRank
			if (reqCandi.rank == 99) {
				reqCandi.rank = 1
			}
		}
		reqCandi.save(flush:true)
		
		RequisitionCandidate.findAllByRequisitionAndRankGreaterThan(reqCandi.requisition, 0, [sort:'rank']).eachWithIndex{rq, index ->
			rq.rank = ++index
			rq.save(flush:true)
		}
		reqCandi.requisition.superFiltered = new Date()
		assert reqCandi.requisition.save()
		def top = reqCandi.requisition.candidates.findAll{it.rank > 0}.sort{it.rank}
		render template:'topCandidates', model:[req:reqCandi.requisition, supervisor:true, top:top]
	}
	@AuthorizeOperation( level='1', text='Download a candidate resume' )
	def downloadResume = { 
		params.qualifiedResume 
	    File file = new File(params.qualifiedResume)
		response.setContentType("application/varies")
		response.setHeader("Content-disposition", "attachment;filename=${file.getName()}")
        response.setContentLength(file.size() as int)
		response.outputStream << file.newInputStream() // Performing a binary stream copy
		response.outputStream.flush()
		response.outputStream.close()
	}
	
	String getNextStatus(Requisition req) {
		List statusOrder = grailsApplication.config.requisition.status.order
		int currentStatusIndex = statusOrder.indexOf(req.status.id)
		if (statusOrder.size() > currentStatusIndex ) {
			statusOrder[statusOrder.indexOf(req.status.id)+1]
		} else {
			null
		}
	}
}
