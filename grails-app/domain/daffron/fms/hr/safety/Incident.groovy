package daffron.fms.hr.safety

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import daffron.fms.hr.payroll.EmployeePayrollMaster
import daffron.fms.hr.recruiting.JobClassDescription

class Incident implements Serializable {
	EmployeePayrollMaster employee
	JobClassDescription notUsualJob
	Date incidentDate
	String injury
	String empDescInjury
	String injurySource
	String injuryCause
	boolean medCareRequired  = false
	boolean medCareOnScene  = false
	boolean medCareMoreRequired  = false
	Date 	death
	
	String transToCareType
	Date   transToCare
	Date   transFromCare
	boolean hospitalized  = false
	boolean careAtClinic  = false
	boolean careOutpatient  = false
	boolean careFirstAid  = false
	boolean careEmergencyRoom  = false
	
	Date lastWorked
	Date firstAway
	Date lastAway
	Date returnWork
	Date disabilityStart
	
	int restrictedDays = 0
	
	Doctor doctor
	Hospital hospital
	SortedSet injuryDetails // to be sure sorts by id
	static hasMany = [injuryDetails:InjuryDetail]
	
	static SOURCE_TYPES = ['I':'Injury', 'R':'Respiratory Condition', 'H':'Hearing Loss', 'P':'Poison','S':'Skin Disorder', 'O':'other']
	static constraints = {
		employee nullable:false
		notUsualJob nullable:true
		death nullable:true
		transToCare nullable:true
		transFromCare nullable:true
		lastWorked nullable:true
		firstAway nullable:true
		lastAway nullable:true
		returnWork nullable:true
		disabilityStart nullable:true
		doctor nullable:true
		hospital nullable:true
		injurySource nullable:false, blank:false, inList:SOURCE_TYPES.keySet() as List
	}
	static mapping = {
		table name:'hrpinci', schema:CH.config.hr.schema
		notUsualTask type:'org.hibernate.type.YesNoType'
		medCareRequired type:'org.hibernate.type.YesNoType'
		medCareOnScene type:'org.hibernate.type.YesNoType'
		medCareMoreRequired type:'org.hibernate.type.YesNoType'
		fatal type:'org.hibernate.type.YesNoType'
		hospitalized type:'org.hibernate.type.YesNoType'
		careAtClinic  type:'org.hibernate.type.YesNoType'
		careOutpatient  type:'org.hibernate.type.YesNoType'
		careFirstAid  type:'org.hibernate.type.YesNoType'
		careEmergencyRoom  type:'org.hibernate.type.YesNoType'
	}
}
