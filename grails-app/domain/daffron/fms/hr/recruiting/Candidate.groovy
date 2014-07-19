package daffron.fms.hr.recruiting

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import java.util.Date
import daffron.fms.hr.Address

class Candidate {
	String name
	String email
	String phoneNo
	String altPhoneNo
	Date created
	Date updated
	Address addr
	String refer
	String relations
	Date priorWorkTo
	Date priorWorkFrom
	String able
	String ableExplain
	Date ableStart
	String skills
	String memberships
	Military military
	String reasonEmpGaps
	Driver driver
	int totalYearsEdu = 0
	
//	SortedSet yesNoAns
	SortedSet testScores
	SortedSet behaviors
	static hasMany = [yesNoAns:YesNoAns,
						notes:Note,
						testScores:TestScore,
						behaviors:BehaviorResult,
						education:Education,
						history:Employment,
						accidents:DriverAccident,
						licenses:DriverLicense,
						violations:DriverViolation,
						driverExperience:DriverExperience,
						requisitions:RequisitionCandidate]
	
	boolean getNoAccidents() {return id?!accidents:this.hasErrors() && !accidents}
	private void setNoAccidents(boolean ignore) {}
	boolean getNoViolations() {return id?!violations:this.hasErrors() && !violations}
	private void setNoViolations(boolean ignore) {}
	
	static constraints = {
		email email:true, blank:false, nullable:false
		name blank:false, nullable:false
		phoneNo maxSize:10,nullable:false, blank:false
		altPhoneNo maxSize:10,nullable:false
		updated nullable:true
		created nullable:true
		priorWorkFrom nullable:true
		priorWorkTo nullable:true
		able nullable:true, maxSize:1, inList:['Y', 'N', ' ']
		ableExplain nullable:true
		ableStart nullable:true
		skills nullable:true
		memberships nullable:true
		reasonEmpGaps nullable:true
		driver nullable:true
		military nullable:true
		driverExperience nullable:true
		
	}
	static mapping = {
		table name:'hrpcandi', schema:CH.config.hr.schema
		altPhoneNo column:'altphone'
		priorWorkFrom column:'priwrkfrom'
		priorWorkTo column:'priwrkto'
		ableExplain column:'ableexpl'
		memberships column:'mbrships'
		reasonEmpGaps column:'empgaps'
		history sort:'id'
		education sort:'id'
	}
	static embedded = ['addr', 'military', 'driver']
	static transients = ['noAccidents', 'noViolations']

	public int matchPercent() {
		int yes = yesNoAns.findAll{it.answer}.size()
		if (yes) {
			return (yes/(yesNoAns.size())) * 100
		}
		return 0
	}
	
	def beforeInsert = {
		created = new Date()
		education.each{totalYearsEdu += it.years}
	}
	def beforeUpdate = {
		updated = new Date()
		totalYearsEdu = 0
		education.each{totalYearsEdu += it.years}
	}
	String toString() {name}
}
class Military {
	String branch
	String rank
	int years = 0
	Date discharge
	String skills
	static constraints = {
		branch nullable:true
		rank nullable:true
		discharge nullable:true
		skills nullable:true
	}
}
class Driver {
	String statesOp
	String training
	String awards
	String experience
	String special
	static constraints = {
		statesOp nullable:true
		training nullable:true
		awards nullable:true
		experience nullable:true
		special nullable:true
	}
}
