package daffron.fms.hr.payroll
//use schema:CH.config.[config.groovy custom variable] to soft-code library
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import org.systemitools.types.*


// Note: do not read by key (get()) as there is no unique index on the table
class PayrollConstants implements Serializable {
	String companyName
	String addressLine1
	String addressLine2
	String city
	String state
	String zipCode
	String federalIdNo
	String stateIdNo
	int payrollRunIndicator
	int payPeriodHours
	Date prBeginDate
	Date payPeriodEndingDate
	Date payPeriodCheckDate
	Date payPeriodMonthEndingDate
	String payPeriodBeingProcessed
	String lastPeriodProccesed
	Date lastDateWeeklyPrClosed
	Date lastDateSemimonthClosed
	Date lastDateBiweeklyClosed
	Date lastDateMonthlyPrClosed
	String monthCloseInd
	String quarterCloseIndyQtrNeedsToBeClosed
	String yearCloseIndyYearNeedsToBeClosed
	String prenumberedChecksUsedYYes
	String partialEomAccruedYn
	String glInterfaceYYes
	String woInterfaceYYes
	String vehicleInterfaceYyes
	String checkReconActiveYn
	String bankcompany
	BigDecimal bankGlNo
	String bankdivision
	String bankDept
	String banksubdept
	String bankActvty
	String bankBudId
	String bankTrcde
	String fwtCompany
	BigDecimal fwtGlNo
	String fwtDivision
	String fwtDept
	String fwtSubdept
	String fwtActvty
	String fwtBudId
	String fwtTrcde
	String swtCompany
	BigDecimal swtGlNo
	String swtDivision
	String swtDept
	String swtSubdept
	String swtActvty
	String swtBudId
	String swtTrcde
	String ficacompany
	BigDecimal ficaGlNo
	String ficaDiv
	String ficaDept
	String ficaSubdpt
	String ficaActvty
	String ficaBudId
	String ficaTrcde
	String locCompany
	BigDecimal localGlNo
	String localDiv
	String localDept
	String locSubdpt
	String locActvty
	String locBudId
	String locTrcde
	String slAccrualToGl
	String fuiCompany
	BigDecimal fuiGlNo
	String fuiDiv
	String fuiDept
	String fuiSubdpt
	String fuiActvty
	String fuiBudId
	String fuiTrcde
	String vehCompany
	BigDecimal vehicleGlNo
	String vehicleDiv
	String vehicleDpt
	String vehSubdpt
	String vehActvty
	String vehBudId
	String vehTrcde
	String prAccrCo
	BigDecimal prAccrGlNo
	String prAccrDiv
	String prAccrDpt
	String prAccrSdp
	String prAccrAct
	String prAccrBid
	String prAccrtcd
	String vacationAccrualMethod
	int maxHrsVacAccrued
	String sickLeaveAccrualMethod
	int maxHrsSickLeaveAccred
	String mileageEnteredWithTimeRecordsYn
	BigDecimal pc2nd
	BigDecimal pc3rd
	int ficaLimitDollarsOnly
	BigDecimal ficaEmployeePctExp75PctIsKeyed07500
	BigDecimal ficaEmployerPctExp75PctIsKeyed07500
	int stateUnemploymentLimitKeyedAsWholeDollars
	BigDecimal stateUnemploymentPctExp25PctKeyedAs02500
	int fedUnempLimitdollars
	BigDecimal fedUnempPctExp25PctKeyedAs02500
	BigDecimal localTaxPctExp25PctKeyedAs02500
	int lastSequenceUsedInTimeFile
	String editGlNumbersYOrN
	String editWoNumbersYOrN
	int lastSequenceUsedInMdistFile
	BigDecimal thisMonthLaborAccrualAmt
	BigDecimal lastMonthLaborAccrualAmt
	Long bankAcctNoForDirDep
	BigDecimal tempFldToHoldMoLbrAccr
	String exceptionPayProcessingYExceptionPayProcess
	Date accrualFromDate
	Date accrualToDate
	int acctYyyymmBeingClosed
	String isDirectDepositActiveYn
	int lastCheckNoUsedInLastPayPeriod
	int lastCheckNoUsedInThisPayPeriod
	String keyeditDept
	String keyeditSdept
	String keyeditBudgetId
	String earningsRegisterSeq
	String glEntriesDetailOrSum
	String stateUnemploymentNumber
	static constraints = {
		companyName(maxSize:35,nullable:true)
		addressLine1(maxSize:20,nullable:true)
		addressLine2(maxSize:20,nullable:true)
		city(maxSize:20,nullable:true)
		state(maxSize:2,nullable:true)
		zipCode(maxSize:9,nullable:true)
		federalIdNo(maxSize:12,nullable:true)
		stateIdNo(maxSize:15,nullable:true)
		payrollRunIndicator(max:9,nullable:true)
		payPeriodHours(max:999,nullable:true)
		prBeginDate(nullable:true)
		payPeriodEndingDate(nullable:true)
		payPeriodCheckDate(nullable:true)
		payPeriodMonthEndingDate(nullable:true)
		payPeriodBeingProcessed(maxSize:1,nullable:true)
		lastPeriodProccesed(maxSize:1,nullable:true)
		lastDateWeeklyPrClosed(nullable:true)
		lastDateSemimonthClosed(nullable:true)
		lastDateBiweeklyClosed(nullable:true)
		lastDateMonthlyPrClosed(nullable:true)
		monthCloseInd(maxSize:1,nullable:true)
		quarterCloseIndyQtrNeedsToBeClosed(maxSize:1,nullable:true)
		yearCloseIndyYearNeedsToBeClosed(maxSize:1,nullable:true)
		prenumberedChecksUsedYYes(maxSize:1,nullable:true)
		partialEomAccruedYn(maxSize:1,nullable:true)
		glInterfaceYYes(maxSize:1,nullable:true)
		woInterfaceYYes(maxSize:1,nullable:true)
		vehicleInterfaceYyes(maxSize:1,nullable:true)
		checkReconActiveYn(maxSize:1,nullable:true)
		bankcompany(maxSize:5,nullable:true)
		bankGlNo(max:new BigDecimal("9999.999"),nullable:true)
		bankdivision(maxSize:5,nullable:true)
		bankDept(maxSize:5,nullable:true)
		banksubdept(maxSize:5,nullable:true)
		bankActvty(maxSize:5,nullable:true)
		bankBudId(maxSize:5,nullable:true)
		bankTrcde(maxSize:10,nullable:true)
		fwtCompany(maxSize:5,nullable:true)
		fwtGlNo(max:new BigDecimal("9999.999"),nullable:true)
		fwtDivision(maxSize:5,nullable:true)
		fwtDept(maxSize:5,nullable:true)
		fwtSubdept(maxSize:5,nullable:true)
		fwtActvty(maxSize:5,nullable:true)
		fwtBudId(maxSize:5,nullable:true)
		fwtTrcde(maxSize:10,nullable:true)
		swtCompany(maxSize:5,nullable:true)
		swtGlNo(max:new BigDecimal("9999.999"),nullable:true)
		swtDivision(maxSize:5,nullable:true)
		swtDept(maxSize:5,nullable:true)
		swtSubdept(maxSize:5,nullable:true)
		swtActvty(maxSize:5,nullable:true)
		swtBudId(maxSize:5,nullable:true)
		swtTrcde(maxSize:10,nullable:true)
		ficacompany(maxSize:5,nullable:true)
		ficaGlNo(max:new BigDecimal("9999.999"),nullable:true)
		ficaDiv(maxSize:5,nullable:true)
		ficaDept(maxSize:5,nullable:true)
		ficaSubdpt(maxSize:5,nullable:true)
		ficaActvty(maxSize:5,nullable:true)
		ficaBudId(maxSize:5,nullable:true)
		ficaTrcde(maxSize:10,nullable:true)
		locCompany(maxSize:5,nullable:true)
		localGlNo(max:new BigDecimal("9999.999"),nullable:true)
		localDiv(maxSize:5,nullable:true)
		localDept(maxSize:5,nullable:true)
		locSubdpt(maxSize:5,nullable:true)
		locActvty(maxSize:5,nullable:true)
		locBudId(maxSize:5,nullable:true)
		locTrcde(maxSize:10,nullable:true)
		slAccrualToGl(maxSize:1,nullable:true)
		fuiCompany(maxSize:5,nullable:true)
		fuiGlNo(max:new BigDecimal("9999.999"),nullable:true)
		fuiDiv(maxSize:5,nullable:true)
		fuiDept(maxSize:5,nullable:true)
		fuiSubdpt(maxSize:5,nullable:true)
		fuiActvty(maxSize:5,nullable:true)
		fuiBudId(maxSize:5,nullable:true)
		fuiTrcde(maxSize:10,nullable:true)
		vehCompany(maxSize:5,nullable:true)
		vehicleGlNo(max:new BigDecimal("9999.999"),nullable:true)
		vehicleDiv(maxSize:5,nullable:true)
		vehicleDpt(maxSize:5,nullable:true)
		vehSubdpt(maxSize:5,nullable:true)
		vehActvty(maxSize:5,nullable:true)
		vehBudId(maxSize:5,nullable:true)
		vehTrcde(maxSize:10,nullable:true)
		prAccrCo(maxSize:5,nullable:true)
		prAccrGlNo(max:new BigDecimal("9999.999"),nullable:true)
		prAccrDiv(maxSize:5,nullable:true)
		prAccrDpt(maxSize:5,nullable:true)
		prAccrSdp(maxSize:5,nullable:true)
		prAccrAct(maxSize:5,nullable:true)
		prAccrBid(maxSize:5,nullable:true)
		prAccrtcd(maxSize:10,nullable:true)
		vacationAccrualMethod(maxSize:1,nullable:true)
		maxHrsVacAccrued(max:99999,nullable:true)
		sickLeaveAccrualMethod(maxSize:1,nullable:true)
		maxHrsSickLeaveAccred(max:99999,nullable:true)
		mileageEnteredWithTimeRecordsYn(maxSize:1,nullable:true)
		pc2nd(max:new BigDecimal("999.9999"),nullable:true)
		pc3rd(max:new BigDecimal("999.9999"),nullable:true)
		ficaLimitDollarsOnly(max:99999,nullable:true)
		ficaEmployeePctExp75PctIsKeyed07500(max:new BigDecimal(".99999"),nullable:true)
		ficaEmployerPctExp75PctIsKeyed07500(max:new BigDecimal(".99999"),nullable:true)
		stateUnemploymentLimitKeyedAsWholeDollars(max:99999,nullable:true)
		stateUnemploymentPctExp25PctKeyedAs02500(max:new BigDecimal(".99999"),nullable:true)
		fedUnempLimitdollars(max:99999,nullable:true)
		fedUnempPctExp25PctKeyedAs02500(max:new BigDecimal(".99999"),nullable:true)
		localTaxPctExp25PctKeyedAs02500(max:new BigDecimal(".99999"),nullable:true)
		lastSequenceUsedInTimeFile(max:99999,nullable:true)
		editGlNumbersYOrN(maxSize:1,nullable:true)
		editWoNumbersYOrN(maxSize:1,nullable:true)
		lastSequenceUsedInMdistFile(max:99999,nullable:true)
		thisMonthLaborAccrualAmt(max:new BigDecimal("9999999.99"),nullable:true)
		lastMonthLaborAccrualAmt(max:new BigDecimal("9999999.99"),nullable:true)
		bankAcctNoForDirDep(max:9999999999,nullable:true)
		tempFldToHoldMoLbrAccr(max:new BigDecimal("9999999.99"),nullable:true)
		exceptionPayProcessingYExceptionPayProcess(maxSize:1,nullable:true)
		accrualFromDate(nullable:true)
		accrualToDate(nullable:true)
		acctYyyymmBeingClosed(max:999999,nullable:true)
		isDirectDepositActiveYn(maxSize:1,nullable:true)
		lastCheckNoUsedInLastPayPeriod(max:999999,nullable:true)
		lastCheckNoUsedInThisPayPeriod(max:999999,nullable:true)
		keyeditDept(maxSize:1,nullable:true)
		keyeditSdept(maxSize:1,nullable:true)
		keyeditBudgetId(maxSize:1,nullable:true)
		earningsRegisterSeq(maxSize:1,nullable:true)
		glEntriesDetailOrSum(maxSize:1,nullable:true)
		stateUnemploymentNumber(maxSize:20,nullable:true)
	}
	static final boolean ASSIGNEDKEY = true
	static final boolean COMPOSITEKEY  = true
	static mapping = {
		table name:'prppcon', schema:CH.config.hr.schema
		version (false)
		id (generator:'assigned')
		id (composite:['companyName','addressLine1']) // do not use, no unique key on table
		columns {
			id (composite:['companyName','addressLine1'])
			companyName (column:'PCNAME', type:'string')
			addressLine1 (column:'PCADR1', type:'string')
			addressLine2 (column:'PCADR2', type:'string')
			city (column:'PCCITY', type:'string')
			state (column:'PCST', type:'string')
			zipCode (column:'PCZIP', type:'string')
			federalIdNo (column:'PCFED', type:'string')
			stateIdNo (column:'PCSTID', type:'string')
			payrollRunIndicator (column:'PCPRUN', type:'int')
			payPeriodHours (column:'PCHRS', type:'int')
			prBeginDate (column:'PCBEGD', type:'date')
			payPeriodEndingDate (column:'PCENDD', type:'date')
			payPeriodCheckDate (column:'PCCHKD', type:'date')
			payPeriodMonthEndingDate (column:'PCMEND', type:'date')
			payPeriodBeingProcessed (column:'PCPAYP', type:'string')
			lastPeriodProccesed (column:'PCLSTP', type:'string')
			lastDateWeeklyPrClosed (column:'PCWDT', type:'date')
			lastDateSemimonthClosed (column:'PCSDT', type:'date')
			lastDateBiweeklyClosed (column:'PCBDT', type:'date')
			lastDateMonthlyPrClosed (column:'PCMDT', type:'date')
			monthCloseInd (column:'PCMCL', type:'string')
			quarterCloseIndyQtrNeedsToBeClosed (column:'PCQCL', type:'string')
			yearCloseIndyYearNeedsToBeClosed (column:'PCYCL', type:'string')
			prenumberedChecksUsedYYes (column:'PCPRE', type:'string')
			partialEomAccruedYn (column:'PCACCR', type:'string')
			glInterfaceYYes (column:'PCGLIF', type:'string')
			woInterfaceYYes (column:'PCWOIF', type:'string')
			vehicleInterfaceYyes (column:'PCTRIF', type:'string')
			checkReconActiveYn (column:'PCRCON', type:'string')
			bankcompany (column:'PCBKCO', type:'string')
			bankGlNo (column:'PCBANK', type:'big_decimal')
			bankdivision (column:'PCBKDV', type:'string')
			bankDept (column:'PCBKDP', type:'string')
			banksubdept (column:'PCBKSD', type:'string')
			bankActvty (column:'PCBKAC', type:'string')
			bankBudId (column:'PCBKBD', type:'string')
			bankTrcde (column:'PCBKTCD', type:'string')
			fwtCompany (column:'PCFWCO', type:'string')
			fwtGlNo (column:'PCFWT', type:'big_decimal')
			fwtDivision (column:'PCFWDV', type:'string')
			fwtDept (column:'PCFWDP', type:'string')
			fwtSubdept (column:'PCFWSD', type:'string')
			fwtActvty (column:'PCFWAC', type:'string')
			fwtBudId (column:'PCFWBD', type:'string')
			fwtTrcde (column:'PCFWTCD', type:'string')
			swtCompany (column:'PCSWCO', type:'string')
			swtGlNo (column:'PCSWT', type:'big_decimal')
			swtDivision (column:'PCSWDV', type:'string')
			swtDept (column:'PCSWDP', type:'string')
			swtSubdept (column:'PCSWSD', type:'string')
			swtActvty (column:'PCSWAC', type:'string')
			swtBudId (column:'PCSWBD', type:'string')
			swtTrcde (column:'PCSWTCD', type:'string')
			ficacompany (column:'PCFCCO', type:'string')
			ficaGlNo (column:'PCFIC', type:'big_decimal')
			ficaDiv (column:'PCFCDV', type:'string')
			ficaDept (column:'PCFCDP', type:'string')
			ficaSubdpt (column:'PCFCSD', type:'string')
			ficaActvty (column:'PCFCAC', type:'string')
			ficaBudId (column:'PCFCBD', type:'string')
			ficaTrcde (column:'PCFCTCD', type:'string')
			locCompany (column:'PCLOCO', type:'string')
			localGlNo (column:'PCLOC', type:'big_decimal')
			localDiv (column:'PCLODV', type:'string')
			localDept (column:'PCLODP', type:'string')
			locSubdpt (column:'PCLOSD', type:'string')
			locActvty (column:'PCLOAC', type:'string')
			locBudId (column:'PCLOBD', type:'string')
			locTrcde (column:'PCLOTCD', type:'string')
			slAccrualToGl (column:'PCSLGL', type:'string')
			fuiCompany (column:'PCSLCO', type:'string')
			fuiGlNo (column:'PCSLAC', type:'big_decimal')
			fuiDiv (column:'PCSLDV', type:'string')
			fuiDept (column:'PCSLDP', type:'string')
			fuiSubdpt (column:'PCSLSD', type:'string')
			fuiActvty (column:'PCSLAV', type:'string')
			fuiBudId (column:'PCSLBD', type:'string')
			fuiTrcde (column:'PCSLTCD', type:'string')
			vehCompany (column:'PCVCCO', type:'string')
			vehicleGlNo (column:'PCVCAC', type:'big_decimal')
			vehicleDiv (column:'PCVCDV', type:'string')
			vehicleDpt (column:'PCVCDP', type:'string')
			vehSubdpt (column:'PCVCSD', type:'string')
			vehActvty (column:'PCVCAV', type:'string')
			vehBudId (column:'PCVCBD', type:'string')
			vehTrcde (column:'PCVCTCD', type:'string')
			prAccrCo (column:'PCACCO', type:'string')
			prAccrGlNo (column:'PCPRCA', type:'big_decimal')
			prAccrDiv (column:'PCACDV', type:'string')
			prAccrDpt (column:'PCACDP', type:'string')
			prAccrSdp (column:'PCACSD', type:'string')
			prAccrAct (column:'PCACAC', type:'string')
			prAccrBid (column:'PCACBD', type:'string')
			prAccrtcd (column:'PCACTCD', type:'string')
			vacationAccrualMethod (column:'PCVACM', type:'string')
			maxHrsVacAccrued (column:'PCVMAX', type:'int')
			sickLeaveAccrualMethod (column:'PCSICK', type:'string')
			maxHrsSickLeaveAccred (column:'PCSMAX', type:'int')
			mileageEnteredWithTimeRecordsYn (column:'PCMILE', type:'string')
			pc2nd (column:'PC2ND', type:'big_decimal')
			pc3rd (column:'PC3RD', type:'big_decimal')
			ficaLimitDollarsOnly (column:'PCFIL', type:'int')
			ficaEmployeePctExp75PctIsKeyed07500 (column:'PCFIEP', type:'big_decimal')
			ficaEmployerPctExp75PctIsKeyed07500 (column:'PCFIEE', type:'big_decimal')
			stateUnemploymentLimitKeyedAsWholeDollars (column:'PCSUL', type:'int')
			stateUnemploymentPctExp25PctKeyedAs02500 (column:'PCSUP', type:'big_decimal')
			fedUnempLimitdollars (column:'PCFUL', type:'int')
			fedUnempPctExp25PctKeyedAs02500 (column:'PCFUP', type:'big_decimal')
			localTaxPctExp25PctKeyedAs02500 (column:'PCLTXP', type:'big_decimal')
			lastSequenceUsedInTimeFile (column:'PCTMSQ', type:'int')
			editGlNumbersYOrN (column:'PCEDGL', type:'string')
			editWoNumbersYOrN (column:'PCEDWO', type:'string')
			lastSequenceUsedInMdistFile (column:'PCMDSQ', type:'int')
			thisMonthLaborAccrualAmt (column:'PCMOAC', type:'big_decimal')
			lastMonthLaborAccrualAmt (column:'PCLSAC', type:'big_decimal')
			bankAcctNoForDirDep (column:'PCACCT', type:'long')
			tempFldToHoldMoLbrAccr (column:'PCWRCC', type:'big_decimal')
			exceptionPayProcessingYExceptionPayProcess (column:'PCACCL', type:'string')
			accrualFromDate (column:'PCFDT', type:'date')
			accrualToDate (column:'PCTDT', type:'date')
			acctYyyymmBeingClosed (column:'PCAMO', type:'int')
			isDirectDepositActiveYn (column:'PCDDA', type:'string')
			lastCheckNoUsedInLastPayPeriod (column:'PCLCHK', type:'int')
			lastCheckNoUsedInThisPayPeriod (column:'PCCCHK', type:'int')
			keyeditDept (column:'PCEDPT', type:'string')
			keyeditSdept (column:'PCESDP', type:'string')
			keyeditBudgetId (column:'PCEBUD', type:'string')
			earningsRegisterSeq (column:'PCRSEQ', type:'string')
			glEntriesDetailOrSum (column:'PCGLEN', type:'string')
			stateUnemploymentNumber (column:'"PCSUI#"', type:'string')
		}
	}
	boolean newEntity = false
	static transients = ['newEntity']

	def beforeInsert () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  } 
	def beforeUpdate () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
	def beforeDelete () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }

}