package daffron.fms.hr.payroll
//use schema:CH.config.[config.groovy custom variable] to soft-code library
import daffron.fms.hr.recruiting.JobClassDescription
import daffron.fms.gl.Department
import grails.util.Environment

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import org.systemitools.types.*

class EmployeePayrollMaster implements Serializable {
	int id
	int socialSecurityNo
	String name
	String address
	String city
	String state
	String zipCode
	String county
	Long phoneNo
	String maritalStatus
	String sex
	String race
	Date birthDate
	int federalDependants
	int stateDependants
//	BigDecimal openFieldNowMxfil2
//	BigDecimal openFieldNowMxfil3
	Date hireDate
	Date reHireDate
	Date adjustedHireDate
	Date terminationDate
	int terminationCode
	String terminationReason
	BigDecimal addlW2Earnings
	Date vacEligibilityDate
	BigDecimal vacationAccrualRate
	BigDecimal sickLeaveAccrualRate
	BigDecimal vacationRemaining
	BigDecimal sickLeaveRemaining
	int supervisorEmpNo
	boolean supervisor
	int shiftUsuallyWorked
	String insideOrOutside
	int eeoClass
	Date scheduledReviewDate
	String degree1
	String degree2
	String degree3
	String discipline1
	String discipline2
	String discipline3
	String bankIdForDirectDeposits
	String bankAcctNoForDirDeposit
	String handicappedDisabled
	boolean veteran
	Date payDate
	String salaryHistoryTransType
	BigDecimal payRate
	String payType
	String payStatus
	String companyCode
	String division
	String department
	String subDept
	int grade
	int shiftPremium
	String jobClass
	String job
	boolean defaultCharge
	BigDecimal regularGross
	BigDecimal overtimeGross
	BigDecimal doubleTimeGross
	BigDecimal vacationGross
	BigDecimal sickLeaveGross
	BigDecimal holidayGross
	BigDecimal absNo4
	BigDecimal absNo5
	BigDecimal absNo6
	BigDecimal absNo7
	BigDecimal otherGross8
	BigDecimal otherGross9
	BigDecimal otherGross10
	BigDecimal otherGross11
	BigDecimal otherGross12
	BigDecimal otherGross13
	BigDecimal otherGross14
	BigDecimal otherGross15
	BigDecimal otherGross16
	BigDecimal otherGross17
	BigDecimal otherGross18
	BigDecimal otherGross19
	BigDecimal otherTaxable
	BigDecimal otherNonTaxable
	BigDecimal fwt
	BigDecimal swt
	BigDecimal fica
	BigDecimal localTaxIfAny
	BigDecimal regularHours
	BigDecimal overtimeHours
	BigDecimal doubleTimeHours
	BigDecimal vacationHours
	BigDecimal sickLeaveHours
	BigDecimal holidayHours
	BigDecimal otherHours4
	BigDecimal otherHours5
	BigDecimal otherHours6
	BigDecimal otherHours7
	BigDecimal otherHours8
	BigDecimal otherHours9
	BigDecimal otherHours10
	BigDecimal otherHours11
	BigDecimal otherHours12
	BigDecimal otherHours13
	BigDecimal otherHours14
	BigDecimal otherHours15
	BigDecimal otherHours16
	BigDecimal otherHours17
	BigDecimal otherHours18
	BigDecimal otherHours19
	BigDecimal ytdShift2Hours
	BigDecimal ytdShift3Hours
	BigDecimal regularGross2
	BigDecimal overtimeGross2
	BigDecimal doubleTimeGross2
	BigDecimal vacationGross2
	BigDecimal sickLeaveGross2
	BigDecimal holidayGross2
	BigDecimal otherGross4
	BigDecimal otherGross5
	BigDecimal otherGross6
	BigDecimal otherGross7
	BigDecimal otherGross82
	BigDecimal otherGross92
	BigDecimal otherGross102
	BigDecimal otherGross112
	BigDecimal otherGross122
	BigDecimal otherGross132
	BigDecimal otherGross142
	BigDecimal otherGross152
	BigDecimal otherGross162
	BigDecimal otherGross172
	BigDecimal otherGross182
	BigDecimal otherGross192
	BigDecimal otherTaxable2
	BigDecimal otherNonTaxable2
	BigDecimal fwt2
	BigDecimal swt2
	BigDecimal fica2
	BigDecimal localTaxIfAny2
	BigDecimal regularHours2
	BigDecimal overtimeHours2
	BigDecimal doubleTimeHours2
	BigDecimal vacationHours2
	BigDecimal sickLeaveHours2
	BigDecimal holidayHours2
	BigDecimal otherHours42
	BigDecimal otherHours52
	BigDecimal otherHours62
	BigDecimal otherHours72
	BigDecimal otherHours82
	BigDecimal otherHours92
	BigDecimal otherHours102
	BigDecimal otherHours112
	BigDecimal otherHours122
	BigDecimal otherHours132
	BigDecimal otherHours142
	BigDecimal otherHours152
	BigDecimal otherHours162
	BigDecimal otherHours172
	BigDecimal otherHours182
	BigDecimal otherHours192
	BigDecimal qtdShift2Hours
	BigDecimal qtdShift3Hours
	BigDecimal regularGross3
	BigDecimal overtimeGross3
	BigDecimal doubleTimeGross3
	BigDecimal vacationGross3
	BigDecimal sickLeaveGross3
	BigDecimal holidayGross3
	BigDecimal otherGross42
	BigDecimal otherGross52
	BigDecimal otherGross62
	BigDecimal otherGross72
	BigDecimal otherGross83
	BigDecimal otherGross93
	BigDecimal otherGross103
	BigDecimal otherGross113
	BigDecimal otherGross123
	BigDecimal otherGross133
	BigDecimal otherGross143
	BigDecimal otherGross153
	BigDecimal otherGross163
	BigDecimal otherGross173
	BigDecimal otherGross183
	BigDecimal otherGross193
	BigDecimal otherTaxable3
	BigDecimal otherNonTaxable3
	BigDecimal fwt3
	BigDecimal swt3
	BigDecimal fica3
	BigDecimal localTaxIfAny3
	BigDecimal regularHours3
	BigDecimal overtimeHours3
	BigDecimal doubleTimeHours3
	BigDecimal vacationHours3
	BigDecimal sickLeaveHours3
	BigDecimal holidayHours3
	BigDecimal otherHours43
	BigDecimal otherHours53
	BigDecimal otherHours63
	BigDecimal otherHours73
	BigDecimal otherHours83
	BigDecimal otherHours93
	BigDecimal otherHours103
	BigDecimal otherHours113
	BigDecimal otherHours123
	BigDecimal otherHours133
	BigDecimal otherHours143
	BigDecimal otherHours153
	BigDecimal otherHours163
	BigDecimal otherHours173
	BigDecimal otherHours183
	BigDecimal otherHours193
	BigDecimal mtdShift2Hours
	BigDecimal mtdShift3Hours
	BigDecimal l_t_dSickLeaveUsed
	String coveredByPensionY_Yes
	BigDecimal msmvac
	BigDecimal vacationEndingHrs
	BigDecimal msmsic
	BigDecimal sickLeaveEndingHrs
	BigDecimal localTaxPct
	String localTaxCode
	String payFrequency
	String taxInState
	static constraints = {
		socialSecurityNo(max:999999999,nullable:true)
		name(maxSize:40,nullable:true)
		address(maxSize:30,nullable:true)
		city(maxSize:20,nullable:true)
		state(maxSize:2,nullable:true)
		zipCode(maxSize:9,nullable:true)
		county(maxSize:1,nullable:true)
		phoneNo(max:9999999999,nullable:true)
		maritalStatus(maxSize:1,nullable:true)
		sex(maxSize:1,nullable:true)
		race(maxSize:1,nullable:true)
		birthDate(nullable:true)
		federalDependants(max:99,nullable:true)
		stateDependants(max:99,nullable:true)
//		openFieldNowMxfil2(max:new BigDecimal("999.99"),nullable:true)
//		openFieldNowMxfil3(max:new BigDecimal("999.99"),nullable:true)
		hireDate(nullable:true)
		reHireDate(nullable:true)
		adjustedHireDate(nullable:true)
		terminationDate(nullable:true)
		terminationCode(max:99,nullable:true)
		terminationReason(maxSize:15,nullable:true)
		addlW2Earnings(max:new BigDecimal("9999999.99"),nullable:true)
		vacEligibilityDate(nullable:true)
		vacationAccrualRate(max:new BigDecimal("999.99"),nullable:true)
		sickLeaveAccrualRate(max:new BigDecimal("999.99"),nullable:true)
		vacationRemaining(max:new BigDecimal("9999999.99"),nullable:true)
		sickLeaveRemaining(max:new BigDecimal("9999999.99"),nullable:true)
		supervisorEmpNo(max:999999999,nullable:true)
		//supervisor(maxSize:1,nullable:true) 
		shiftUsuallyWorked(max:9,nullable:true)
		insideOrOutside(maxSize:1,nullable:true)
		eeoClass(max:99,nullable:true)
		scheduledReviewDate(nullable:true)
		degree1(maxSize:3,nullable:true)
		degree2(maxSize:3,nullable:true)
		degree3(maxSize:3,nullable:true)
		discipline1(maxSize:3,nullable:true)
		discipline2(maxSize:3,nullable:true)
		discipline3(maxSize:3,nullable:true)
		bankIdForDirectDeposits(maxSize:10,nullable:true)
		bankAcctNoForDirDeposit(maxSize:17,nullable:true)
		handicappedDisabled(maxSize:1,nullable:true) // D or H
		veteran(maxSize:1,nullable:true)
		payDate(nullable:true)
		salaryHistoryTransType(maxSize:1,nullable:true)
		payRate(max:new BigDecimal("99999.9999"),nullable:true)
		payType(maxSize:1,nullable:true)
		payStatus(maxSize:1,nullable:true)
		companyCode(maxSize:5,nullable:true)
		division(maxSize:5,nullable:true)
		department(maxSize:5,nullable:true)
		subDept(maxSize:5,nullable:true)
		grade(max:999,nullable:true)
		shiftPremium(max:99,nullable:true)
		jobClass(maxSize:5,nullable:true)
		job(maxSize:1,nullable:true)
		defaultCharge(maxSize:1,nullable:true)
		regularGross(max:new BigDecimal("9999999.99"),nullable:true)
		overtimeGross(max:new BigDecimal("9999999.99"),nullable:true)
		doubleTimeGross(max:new BigDecimal("9999999.99"),nullable:true)
		vacationGross(max:new BigDecimal("9999999.99"),nullable:true)
		sickLeaveGross(max:new BigDecimal("9999999.99"),nullable:true)
		holidayGross(max:new BigDecimal("9999999.99"),nullable:true)
		absNo4(max:new BigDecimal("9999999.99"),nullable:true)
		absNo5(max:new BigDecimal("9999999.99"),nullable:true)
		absNo6(max:new BigDecimal("9999999.99"),nullable:true)
		absNo7(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross8(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross9(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross10(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross11(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross12(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross13(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross14(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross15(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross16(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross17(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross18(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross19(max:new BigDecimal("9999999.99"),nullable:true)
		otherTaxable(max:new BigDecimal("9999999.99"),nullable:true)
		otherNonTaxable(max:new BigDecimal("9999999.99"),nullable:true)
		fwt(max:new BigDecimal("9999999.99"),nullable:true)
		swt(max:new BigDecimal("9999999.99"),nullable:true)
		fica(max:new BigDecimal("9999999.99"),nullable:true)
		localTaxIfAny(max:new BigDecimal("9999999.99"),nullable:true)
		regularHours(max:new BigDecimal("9999999.99"),nullable:true)
		overtimeHours(max:new BigDecimal("9999999.99"),nullable:true)
		doubleTimeHours(max:new BigDecimal("9999999.99"),nullable:true)
		vacationHours(max:new BigDecimal("9999999.99"),nullable:true)
		sickLeaveHours(max:new BigDecimal("9999999.99"),nullable:true)
		holidayHours(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours4(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours5(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours6(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours7(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours8(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours9(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours10(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours11(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours12(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours13(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours14(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours15(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours16(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours17(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours18(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours19(max:new BigDecimal("9999999.99"),nullable:true)
		ytdShift2Hours(max:new BigDecimal("9999999.99"),nullable:true)
		ytdShift3Hours(max:new BigDecimal("9999999.99"),nullable:true)
		regularGross2(max:new BigDecimal("9999999.99"),nullable:true)
		overtimeGross2(max:new BigDecimal("9999999.99"),nullable:true)
		doubleTimeGross2(max:new BigDecimal("9999999.99"),nullable:true)
		vacationGross2(max:new BigDecimal("9999999.99"),nullable:true)
		sickLeaveGross2(max:new BigDecimal("9999999.99"),nullable:true)
		holidayGross2(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross4(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross5(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross6(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross7(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross82(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross92(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross102(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross112(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross122(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross132(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross142(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross152(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross162(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross172(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross182(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross192(max:new BigDecimal("9999999.99"),nullable:true)
		otherTaxable2(max:new BigDecimal("9999999.99"),nullable:true)
		otherNonTaxable2(max:new BigDecimal("9999999.99"),nullable:true)
		fwt2(max:new BigDecimal("9999999.99"),nullable:true)
		swt2(max:new BigDecimal("9999999.99"),nullable:true)
		fica2(max:new BigDecimal("9999999.99"),nullable:true)
		localTaxIfAny2(max:new BigDecimal("9999999.99"),nullable:true)
		regularHours2(max:new BigDecimal("9999999.99"),nullable:true)
		overtimeHours2(max:new BigDecimal("9999999.99"),nullable:true)
		doubleTimeHours2(max:new BigDecimal("9999999.99"),nullable:true)
		vacationHours2(max:new BigDecimal("9999999.99"),nullable:true)
		sickLeaveHours2(max:new BigDecimal("9999999.99"),nullable:true)
		holidayHours2(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours42(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours52(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours62(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours72(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours82(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours92(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours102(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours112(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours122(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours132(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours142(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours152(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours162(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours172(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours182(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours192(max:new BigDecimal("9999999.99"),nullable:true)
		qtdShift2Hours(max:new BigDecimal("9999999.99"),nullable:true)
		qtdShift3Hours(max:new BigDecimal("9999999.99"),nullable:true)
		regularGross3(max:new BigDecimal("9999999.99"),nullable:true)
		overtimeGross3(max:new BigDecimal("9999999.99"),nullable:true)
		doubleTimeGross3(max:new BigDecimal("9999999.99"),nullable:true)
		vacationGross3(max:new BigDecimal("9999999.99"),nullable:true)
		sickLeaveGross3(max:new BigDecimal("9999999.99"),nullable:true)
		holidayGross3(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross42(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross52(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross62(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross72(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross83(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross93(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross103(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross113(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross123(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross133(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross143(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross153(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross163(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross173(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross183(max:new BigDecimal("9999999.99"),nullable:true)
		otherGross193(max:new BigDecimal("9999999.99"),nullable:true)
		otherTaxable3(max:new BigDecimal("9999999.99"),nullable:true)
		otherNonTaxable3(max:new BigDecimal("9999999.99"),nullable:true)
		fwt3(max:new BigDecimal("9999999.99"),nullable:true)
		swt3(max:new BigDecimal("9999999.99"),nullable:true)
		fica3(max:new BigDecimal("9999999.99"),nullable:true)
		localTaxIfAny3(max:new BigDecimal("9999999.99"),nullable:true)
		regularHours3(max:new BigDecimal("9999999.99"),nullable:true)
		overtimeHours3(max:new BigDecimal("9999999.99"),nullable:true)
		doubleTimeHours3(max:new BigDecimal("9999999.99"),nullable:true)
		vacationHours3(max:new BigDecimal("9999999.99"),nullable:true)
		sickLeaveHours3(max:new BigDecimal("9999999.99"),nullable:true)
		holidayHours3(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours43(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours53(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours63(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours73(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours83(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours93(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours103(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours113(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours123(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours133(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours143(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours153(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours163(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours173(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours183(max:new BigDecimal("9999999.99"),nullable:true)
		otherHours193(max:new BigDecimal("9999999.99"),nullable:true)
		mtdShift2Hours(max:new BigDecimal("9999999.99"),nullable:true)
		mtdShift3Hours(max:new BigDecimal("9999999.99"),nullable:true)
		l_t_dSickLeaveUsed(max:new BigDecimal("9999999.99"),nullable:true)
		coveredByPensionY_Yes(maxSize:1,nullable:true)
		msmvac(max:new BigDecimal("9999999.99"),nullable:true)
		vacationEndingHrs(max:new BigDecimal("9999999.99"),nullable:true)
		msmsic(max:new BigDecimal("9999999.99"),nullable:true)
		sickLeaveEndingHrs(max:new BigDecimal("9999999.99"),nullable:true)
		localTaxPct(max:new BigDecimal(".99999"),nullable:true)
		localTaxCode(maxSize:2,nullable:true)
		payFrequency(maxSize:1,nullable:true)
		taxInState(maxSize:2,nullable:true)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = false
	static mapping = {
		table name:'prpmst', schema:CH.config.hr.schema
		version (false)
		id (generator:'assigned')
		columns {
			id (column:'MSEMP',type:'int')
			socialSecurityNo (column:'MSSSN', type:'int')
			name (column:'MSNAME', type:'TrimString')
			address (column:'MSADDR', type:'TrimString')
			city (column:'MSCITY', type:'TrimString')
			state (column:'MSST', type:'TrimString')
			zipCode (column:'MSZIP', type:'TrimString')
			county (column:'MSCNTY', type:'TrimString')
			phoneNo (column:'MSPHON', type:'long')
			maritalStatus (column:'MSMS', type:'TrimString')
			sex (column:'MSSEX', type:'TrimString')
			race (column:'MSRACE', type:'TrimString')
			birthDate (column:'MSBDT', type:'date')
			federalDependants (column:'MSFEDP', type:'int')
			stateDependants (column:'MSSDEP', type:'int')
//			openFieldNowMxfil2 (column:'MSFADD', type:'big_decimal')
//			openFieldNowMxfil3 (column:'MSSADD', type:'big_decimal')
			hireDate (column:'MSHDT', type:'date')
			reHireDate (column:'MSRHDT', type:'date')
			adjustedHireDate (column:'MSAHDT', type:'date')
			terminationDate (column:'MSTDT', type:'date')
			terminationCode (column:'MSTCD', type:'int')
			terminationReason (column:'MSTREA', type:'TrimString')
			addlW2Earnings (column:'MSAW2', type:'big_decimal')
			vacEligibilityDate (column:'MSVACE', type:'date')
			vacationAccrualRate (column:'MSVRT', type:'big_decimal')
			sickLeaveAccrualRate (column:'MSSLRT', type:'big_decimal')
			vacationRemaining (column:'MSVRM', type:'big_decimal')
			sickLeaveRemaining (column:'MSSLRM', type:'big_decimal')
			supervisorEmpNo (column:'MSSUP', type:'int')
			supervisor (column:'MSSUPF', type:'YesBlankType')
			shiftUsuallyWorked (column:'MSSHFT', type:'int')
			insideOrOutside (column:'MSINOT', type:'TrimString')
			eeoClass (column:'MSEEO', type:'int')
			scheduledReviewDate (column:'MSSCHD', type:'date')
			degree1 (column:'MSDEG1', type:'TrimString')
			degree2 (column:'MSDEG2', type:'TrimString')
			degree3 (column:'MSDEG3', type:'TrimString')
			discipline1 (column:'MSDSP1', type:'TrimString')
			discipline2 (column:'MSDSP2', type:'TrimString')
			discipline3 (column:'MSDSP3', type:'TrimString')
			bankIdForDirectDeposits (column:'MSBANK', type:'TrimString')
			bankAcctNoForDirDeposit (column:'MSBACT', type:'TrimString')
			handicappedDisabled (column:'MSHAND', type:'TrimString')
			veteran (column:'MSVET', type:'YesBlankType')
			payDate (column:'MSPDT', type:'date')
			salaryHistoryTransType (column:'MSTRAN', type:'TrimString')
			payRate (column:'MSRTE', type:'big_decimal')
			payType (column:'MSTYP', type:'TrimString')
			payStatus (column:'MSSTAT', type:'TrimString')
			companyCode (column:'MSCOMP', type:'TrimString')
			division (column:'MSDIV', type:'TrimString')
			department (column:'MSDEPT', type:'TrimString')
			subDept (column:'MSSDPT', type:'TrimString')
			grade (column:'MSGRD', type:'int')
			shiftPremium (column:'MSSTEP', type:'int')
			jobClass (column:'MSJCLS', type:'TrimString')
			job (column:'MSJOB', type:'TrimString')
			defaultCharge (column:'MSCHG', type:'YesBlankType')
			regularGross (column:'MSYRGG', type:'big_decimal')
			overtimeGross (column:'MSYOTG', type:'big_decimal')
			doubleTimeGross (column:'MSYDTG', type:'big_decimal')
			vacationGross (column:'MSYVG', type:'big_decimal')
			sickLeaveGross (column:'MSYSLG', type:'big_decimal')
			holidayGross (column:'MSYHG', type:'big_decimal')
			absNo4 (column:'MSYO4G', type:'big_decimal')
			absNo5 (column:'MSYO5G', type:'big_decimal')
			absNo6 (column:'MSYO6G', type:'big_decimal')
			absNo7 (column:'MSYO7G', type:'big_decimal')
			otherGross8 (column:'MSYO8G', type:'big_decimal')
			otherGross9 (column:'MSYO9G', type:'big_decimal')
			otherGross10 (column:'MSYOAG', type:'big_decimal')
			otherGross11 (column:'MSYO11G', type:'big_decimal')
			otherGross12 (column:'MSYO12G', type:'big_decimal')
			otherGross13 (column:'MSYO13G', type:'big_decimal')
			otherGross14 (column:'MSYO14G', type:'big_decimal')
			otherGross15 (column:'MSYO15G', type:'big_decimal')
			otherGross16 (column:'MSYO16G', type:'big_decimal')
			otherGross17 (column:'MSYO17G', type:'big_decimal')
			otherGross18 (column:'MSYO18G', type:'big_decimal')
			otherGross19 (column:'MSYO19G', type:'big_decimal')
			otherTaxable (column:'MSYOTX', type:'big_decimal')
			otherNonTaxable (column:'MSYONT', type:'big_decimal')
			fwt (column:'MSYFWT', type:'big_decimal')
			swt (column:'MSYSWT', type:'big_decimal')
			fica (column:'MSYFCA', type:'big_decimal')
			localTaxIfAny (column:'MSYLWT', type:'big_decimal')
			regularHours (column:'MSYRGH', type:'big_decimal')
			overtimeHours (column:'MSYOTH', type:'big_decimal')
			doubleTimeHours (column:'MSYDTH', type:'big_decimal')
			vacationHours (column:'MSYVH', type:'big_decimal')
			sickLeaveHours (column:'MSYSLH', type:'big_decimal')
			holidayHours (column:'MSYHH', type:'big_decimal')
			otherHours4 (column:'MSYO4H', type:'big_decimal')
			otherHours5 (column:'MSYO5H', type:'big_decimal')
			otherHours6 (column:'MSYO6H', type:'big_decimal')
			otherHours7 (column:'MSYO7H', type:'big_decimal')
			otherHours8 (column:'MSYO8H', type:'big_decimal')
			otherHours9 (column:'MSYO9H', type:'big_decimal')
			otherHours10 (column:'MSYOAH', type:'big_decimal')
			otherHours11 (column:'MSYU1H', type:'big_decimal')
			otherHours12 (column:'MSYU2H', type:'big_decimal')
			otherHours13 (column:'MSYO13H', type:'big_decimal')
			otherHours14 (column:'MSYO14H', type:'big_decimal')
			otherHours15 (column:'MSYO15H', type:'big_decimal')
			otherHours16 (column:'MSYO16H', type:'big_decimal')
			otherHours17 (column:'MSYO17H', type:'big_decimal')
			otherHours18 (column:'MSYO18H', type:'big_decimal')
			otherHours19 (column:'MSYO19H', type:'big_decimal')
			ytdShift2Hours (column:'MSYS2H', type:'big_decimal')
			ytdShift3Hours (column:'MSYS3H', type:'big_decimal')
			regularGross2 (column:'MSQRGG', type:'big_decimal')
			overtimeGross2 (column:'MSQOTG', type:'big_decimal')
			doubleTimeGross2 (column:'MSQDTG', type:'big_decimal')
			vacationGross2 (column:'MSQVG', type:'big_decimal')
			sickLeaveGross2 (column:'MSQSLG', type:'big_decimal')
			holidayGross2 (column:'MSQHG', type:'big_decimal')
			otherGross4 (column:'MSQO4G', type:'big_decimal')
			otherGross5 (column:'MSQO5G', type:'big_decimal')
			otherGross6 (column:'MSQO6G', type:'big_decimal')
			otherGross7 (column:'MSQO7G', type:'big_decimal')
			otherGross82 (column:'MSQO8G', type:'big_decimal')
			otherGross92 (column:'MSQO9G', type:'big_decimal')
			otherGross102 (column:'MSQOAG', type:'big_decimal')
			otherGross112 (column:'MSQO11G', type:'big_decimal')
			otherGross122 (column:'MSQO12G', type:'big_decimal')
			otherGross132 (column:'MSQO13G', type:'big_decimal')
			otherGross142 (column:'MSQO14G', type:'big_decimal')
			otherGross152 (column:'MSQO15G', type:'big_decimal')
			otherGross162 (column:'MSQO16G', type:'big_decimal')
			otherGross172 (column:'MSQO17G', type:'big_decimal')
			otherGross182 (column:'MSQO18G', type:'big_decimal')
			otherGross192 (column:'MSQO19G', type:'big_decimal')
			otherTaxable2 (column:'MSQOTX', type:'big_decimal')
			otherNonTaxable2 (column:'MSQONT', type:'big_decimal')
			fwt2 (column:'MSQFWT', type:'big_decimal')
			swt2 (column:'MSQSWT', type:'big_decimal')
			fica2 (column:'MSQFCA', type:'big_decimal')
			localTaxIfAny2 (column:'MSQLWT', type:'big_decimal')
			regularHours2 (column:'MSQRGH', type:'big_decimal')
			overtimeHours2 (column:'MSQOTH', type:'big_decimal')
			doubleTimeHours2 (column:'MSQDTH', type:'big_decimal')
			vacationHours2 (column:'MSQVH', type:'big_decimal')
			sickLeaveHours2 (column:'MSQSLH', type:'big_decimal')
			holidayHours2 (column:'MSQHH', type:'big_decimal')
			otherHours42 (column:'MSQO4H', type:'big_decimal')
			otherHours52 (column:'MSQO5H', type:'big_decimal')
			otherHours62 (column:'MSQO6H', type:'big_decimal')
			otherHours72 (column:'MSQO7H', type:'big_decimal')
			otherHours82 (column:'MSQO8H', type:'big_decimal')
			otherHours92 (column:'MSQO9H', type:'big_decimal')
			otherHours102 (column:'MSQOAH', type:'big_decimal')
			otherHours112 (column:'MSQU1H', type:'big_decimal')
			otherHours122 (column:'MSQU2H', type:'big_decimal')
			otherHours132 (column:'MSQO13H', type:'big_decimal')
			otherHours142 (column:'MSQO14H', type:'big_decimal')
			otherHours152 (column:'MSQO15H', type:'big_decimal')
			otherHours162 (column:'MSQO16H', type:'big_decimal')
			otherHours172 (column:'MSQO17H', type:'big_decimal')
			otherHours182 (column:'MSQO18H', type:'big_decimal')
			otherHours192 (column:'MSQO19H', type:'big_decimal')
			qtdShift2Hours (column:'MSQS2H', type:'big_decimal')
			qtdShift3Hours (column:'MSQS3H', type:'big_decimal')
			regularGross3 (column:'MSMRGG', type:'big_decimal')
			overtimeGross3 (column:'MSMOTG', type:'big_decimal')
			doubleTimeGross3 (column:'MSMDTG', type:'big_decimal')
			vacationGross3 (column:'MSMVG', type:'big_decimal')
			sickLeaveGross3 (column:'MSMSLG', type:'big_decimal')
			holidayGross3 (column:'MSMHG', type:'big_decimal')
			otherGross42 (column:'MSMO4G', type:'big_decimal')
			otherGross52 (column:'MSMO5G', type:'big_decimal')
			otherGross62 (column:'MSMO6G', type:'big_decimal')
			otherGross72 (column:'MSMO7G', type:'big_decimal')
			otherGross83 (column:'MSMO8G', type:'big_decimal')
			otherGross93 (column:'MSMO9G', type:'big_decimal')
			otherGross103 (column:'MSMOAG', type:'big_decimal')
			otherGross113 (column:'MSMO11G', type:'big_decimal')
			otherGross123 (column:'MSMO12G', type:'big_decimal')
			otherGross133 (column:'MSMO13G', type:'big_decimal')
			otherGross143 (column:'MSMO14G', type:'big_decimal')
			otherGross153 (column:'MSMO15G', type:'big_decimal')
			otherGross163 (column:'MSMO16G', type:'big_decimal')
			otherGross173 (column:'MSMO17G', type:'big_decimal')
			otherGross183 (column:'MSMO18G', type:'big_decimal')
			otherGross193 (column:'MSMO19G', type:'big_decimal')
			otherTaxable3 (column:'MSMOTX', type:'big_decimal')
			otherNonTaxable3 (column:'MSMONT', type:'big_decimal')
			fwt3 (column:'MSMFWT', type:'big_decimal')
			swt3 (column:'MSMSWT', type:'big_decimal')
			fica3 (column:'MSMFCA', type:'big_decimal')
			localTaxIfAny3 (column:'MSMLWT', type:'big_decimal')
			regularHours3 (column:'MSMRGH', type:'big_decimal')
			overtimeHours3 (column:'MSMOTH', type:'big_decimal')
			doubleTimeHours3 (column:'MSMDTH', type:'big_decimal')
			vacationHours3 (column:'MSMVH', type:'big_decimal')
			sickLeaveHours3 (column:'MSMSLH', type:'big_decimal')
			holidayHours3 (column:'MSMHH', type:'big_decimal')
			otherHours43 (column:'MSMO4H', type:'big_decimal')
			otherHours53 (column:'MSMO5H', type:'big_decimal')
			otherHours63 (column:'MSMO6H', type:'big_decimal')
			otherHours73 (column:'MSMO7H', type:'big_decimal')
			otherHours83 (column:'MSMO8H', type:'big_decimal')
			otherHours93 (column:'MSMO9H', type:'big_decimal')
			otherHours103 (column:'MSMOAH', type:'big_decimal')
			otherHours113 (column:'MSMU1H', type:'big_decimal')
			otherHours123 (column:'MSMU2H', type:'big_decimal')
			otherHours133 (column:'MSMO13H', type:'big_decimal')
			otherHours143 (column:'MSMO14H', type:'big_decimal')
			otherHours153 (column:'MSMO15H', type:'big_decimal')
			otherHours163 (column:'MSMO16H', type:'big_decimal')
			otherHours173 (column:'MSMO17H', type:'big_decimal')
			otherHours183 (column:'MSMO18H', type:'big_decimal')
			otherHours193 (column:'MSMO19H', type:'big_decimal')
			mtdShift2Hours (column:'MSMS2H', type:'big_decimal')
			mtdShift3Hours (column:'MSMS3H', type:'big_decimal')
			l_t_dSickLeaveUsed (column:'MSLDSL', type:'big_decimal')
			coveredByPensionY_Yes (column:'MSPNSN', type:'TrimString')
			msmvac (column:'MSMVAC', type:'big_decimal')
			vacationEndingHrs (column:'MSPRVC', type:'big_decimal')
			msmsic (column:'MSMSIC', type:'big_decimal')
			sickLeaveEndingHrs (column:'MSPRSL', type:'big_decimal')
			localTaxPct (column:'MSLTXP', type:'big_decimal')
			localTaxCode (column:'MSLOCD', type:'TrimString')
			payFrequency (column:'MSFREQ', type:'TrimString')
			taxInState (column:'MSTXST', type:'TrimString')
		}
	}
	boolean newEntity = false
	static transients = ['msemp', 'newEntity', 'empNo', 'jobClassDescription', 'departmentDescription', 'boss']
	def getMsemp() {
		if (id) return id
		return 0
	}
	void setMsemp (def vlu) { id = vlu }
	def getEmpNo() {
		if (id) return id
		return 0
	}
	void setEmpNo (def vlu) { id = vlu }
	EmployeePayrollMaster getBoss() {
		EmployeePayrollMaster.get(supervisorEmpNo)
	}
	private void setBoss(int ignore) {/*ignore*/}

	JobClassDescription getJobClassDescription() {
		return JobClassDescription.get(jobClass)
	}
	private setJobClassDescription(JobClassDescription ignore) {/* ignore */}
	String formatSSN() {
		def ssn = new java.text.DecimalFormat('000000000').format(socialSecurityNo)
		return ssn[0..2]+'-'+ssn[4..5]+'-'+ssn[6..8]
	}

	/* per Kevin:
	 department description could come from two different places. Either PR or GL. 
	 To determine which to use you would retrieve the following constant –
	Select data from cudtahr.prpconst where name = 'PR_UseGLDepartment'
	If equal ‘Y’ then the dept should be retrieved from the GL application –
	Select DEDESC from cudtahr.glpdept where DEDEPT = ‘xx’
	If equal ‘N’ then the dept should be retrieved from PR –
	Select F4DESC from cudtahr.prpf4 where F4FLD = 'EDPT' and F4VALU = 'xx'
	 */
	String getDepartmentDescription() {
		if (GeneralConstants.findByConstantName('PR_UseGLDepartment')?.constantData == 'Y') {
			return Department.findByDepartmentCode(department)?.description?:'Not Found'
		}
		return PrCodes.findByFieldAndValue('EDPT', department)?.descOfValue?:'Not Found'
	}	
	private setDepartmentDescription(String ignore) {}
	
	String toString() {"$name:$id"}
	
	def beforeInsert () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  } 
	def beforeUpdate () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
	def beforeDelete () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
	
}