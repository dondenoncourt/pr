package daffron.fms.hr.payroll
//use schema:CH.config.[config.groovy custom variable] to soft-code library
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import org.systemitools.types.*


// Note: do not read by key (get()) as there is no unique index on the table
class PayCalcHistory implements Serializable {
	int empNo
	Date payPeriodBeginDate
	Date payPeriodEndingDate
	Date payPeriodCheckDate
	BigDecimal regularHours
	BigDecimal overtimeHours
	BigDecimal doubleTimeHours
	BigDecimal vacationHours
	BigDecimal sickLeaveHours
	BigDecimal holidayHours
	BigDecimal otherPaidHours4
	BigDecimal otherPaidHours5
	BigDecimal otherPaidHours6
	BigDecimal otherPaidHours7
	BigDecimal otherPaidHours8
	BigDecimal otherPaidHours9
	BigDecimal otherPaidHours10
	BigDecimal otherPaidHours11
	BigDecimal otherPaidHours12
	BigDecimal otherPaidHours13
	BigDecimal otherPaidHours14
	BigDecimal otherPaidHours15
	BigDecimal otherPaidHours16
	BigDecimal otherPaidHours17
	BigDecimal otherPaidHours18
	BigDecimal otherPaidHours19
	BigDecimal regularEarnings
	BigDecimal overtimeEarnings
	BigDecimal doubleTimeEarnings
	BigDecimal otherTaxableEarnings
	BigDecimal otherNontaxableEarnings
	BigDecimal vacationEarnings
	BigDecimal sickLeaveEarnings
	BigDecimal holidayEarnings
	BigDecimal otherPaidEarnings4
	BigDecimal otherPaidEarnings5
	BigDecimal otherPaidEarnings6
	BigDecimal otherPaidEarnings7
	BigDecimal otherPaidEarnings8
	BigDecimal otherPaidEarnings9
	BigDecimal otherPaidEarnings10
	BigDecimal otherPaidEarnings13
	BigDecimal otherPaidEarnings132
	BigDecimal otherPaidEarnings133
	BigDecimal otherPaidEarnings14
	BigDecimal otherPaidEarnings15
	BigDecimal otherPaidEarnings16
	BigDecimal otherPaidEarnings17
	BigDecimal otherPaidEarnings18
	BigDecimal otherPaidEarnings19
	BigDecimal fedWitholdingTax
	BigDecimal stateWitholdingTax
	BigDecimal socialSecurity
	BigDecimal localTax
	BigDecimal miscDed1_notUsed
	BigDecimal miscDed2_notUsed
	BigDecimal miscDed3_notUsed
	BigDecimal miscDed4_notUsed
	BigDecimal miscDed5_notUsed
	BigDecimal miscDed6_notUsed
	BigDecimal miscDed7_notUsed
	BigDecimal miscDed8_notUsed
	BigDecimal miscDed9_notUsed
	BigDecimal miscDed10_notUsed
	BigDecimal miscDed11_notUsed
	BigDecimal miscDed12_notUsed
	BigDecimal miscDed13_notUsed
	BigDecimal miscDed14_notUsed
	BigDecimal miscDed15_notUsed
	BigDecimal totalMiles_hours
	BigDecimal shift2Hours
	BigDecimal shift3Hours
	String adjToGrossTaxableQuestion1Fwt
	String adjToGrossTaxableQuestion2Swt
	String adjToGrossTaxableQuestion3Fica
	String adjToGrossTaxableQuestion4Loc
	String adjToGrossTaxableQuestion5Fui
	String adjToGrossTaxableQuestion6Sui
	String adjToGrossTaxableQuestion7Wc
	String adjToGrossCode3
	String adjToGrossCode4
	String adjToGrossCode5
	String hpaam1
	String hpaam2
	String hpaam3
	String hpaam4
	String hpaam5
	String recordPreviouslyVoided
	static constraints = {
		empNo(max:999999999,nullable:false)
		payPeriodBeginDate(nullable:false)
		payPeriodEndingDate(nullable:false)
		payPeriodCheckDate(nullable:false)
		regularHours(max:new BigDecimal("99999.99"),nullable:false)
		overtimeHours(max:new BigDecimal("99999.99"),nullable:false)
		doubleTimeHours(max:new BigDecimal("99999.99"),nullable:false)
		vacationHours(max:new BigDecimal("99999.99"),nullable:false)
		sickLeaveHours(max:new BigDecimal("99999.99"),nullable:false)
		holidayHours(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidHours4(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidHours5(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidHours6(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidHours7(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidHours8(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidHours9(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidHours10(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidHours11(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidHours12(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidHours13(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidHours14(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidHours15(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidHours16(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidHours17(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidHours18(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidHours19(max:new BigDecimal("99999.99"),nullable:false)
		regularEarnings(max:new BigDecimal("99999.99"),nullable:false)
		overtimeEarnings(max:new BigDecimal("99999.99"),nullable:false)
		doubleTimeEarnings(max:new BigDecimal("99999.99"),nullable:false)
		otherTaxableEarnings(max:new BigDecimal("99999.99"),nullable:false)
		otherNontaxableEarnings(max:new BigDecimal("99999.99"),nullable:false)
		vacationEarnings(max:new BigDecimal("99999.99"),nullable:false)
		sickLeaveEarnings(max:new BigDecimal("99999.99"),nullable:false)
		holidayEarnings(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidEarnings4(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidEarnings5(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidEarnings6(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidEarnings7(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidEarnings8(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidEarnings9(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidEarnings10(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidEarnings13(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidEarnings132(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidEarnings133(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidEarnings14(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidEarnings15(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidEarnings16(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidEarnings17(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidEarnings18(max:new BigDecimal("99999.99"),nullable:false)
		otherPaidEarnings19(max:new BigDecimal("99999.99"),nullable:false)
		fedWitholdingTax(max:new BigDecimal("99999.99"),nullable:false)
		stateWitholdingTax(max:new BigDecimal("99999.99"),nullable:false)
		socialSecurity(max:new BigDecimal("99999.99"),nullable:false)
		localTax(max:new BigDecimal("99999.99"),nullable:false)
		miscDed1_notUsed(max:new BigDecimal("99999.99"),nullable:false)
		miscDed2_notUsed(max:new BigDecimal("99999.99"),nullable:false)
		miscDed3_notUsed(max:new BigDecimal("99999.99"),nullable:false)
		miscDed4_notUsed(max:new BigDecimal("99999.99"),nullable:false)
		miscDed5_notUsed(max:new BigDecimal("99999.99"),nullable:false)
		miscDed6_notUsed(max:new BigDecimal("99999.99"),nullable:false)
		miscDed7_notUsed(max:new BigDecimal("99999.99"),nullable:false)
		miscDed8_notUsed(max:new BigDecimal("99999.99"),nullable:false)
		miscDed9_notUsed(max:new BigDecimal("99999.99"),nullable:false)
		miscDed10_notUsed(max:new BigDecimal("99999.99"),nullable:false)
		miscDed11_notUsed(max:new BigDecimal("99999.99"),nullable:false)
		miscDed12_notUsed(max:new BigDecimal("99999.99"),nullable:false)
		miscDed13_notUsed(max:new BigDecimal("99999.99"),nullable:false)
		miscDed14_notUsed(max:new BigDecimal("99999.99"),nullable:false)
		miscDed15_notUsed(max:new BigDecimal("99999.99"),nullable:false)
		totalMiles_hours(max:new BigDecimal("9999.9"),nullable:false)
		shift2Hours(max:new BigDecimal("99999.99"),nullable:false)
		shift3Hours(max:new BigDecimal("99999.99"),nullable:false)
		adjToGrossTaxableQuestion1Fwt(maxSize:1,nullable:false)
		adjToGrossTaxableQuestion2Swt(maxSize:1,nullable:false)
		adjToGrossTaxableQuestion3Fica(maxSize:1,nullable:false)
		adjToGrossTaxableQuestion4Loc(maxSize:1,nullable:false)
		adjToGrossTaxableQuestion5Fui(maxSize:1,nullable:false)
		adjToGrossTaxableQuestion6Sui(maxSize:1,nullable:false)
		adjToGrossTaxableQuestion7Wc(maxSize:1,nullable:false)
		adjToGrossCode3(maxSize:1,nullable:false)
		adjToGrossCode4(maxSize:1,nullable:false)
		adjToGrossCode5(maxSize:1,nullable:false)
		hpaam1(maxSize:1,nullable:false)
		hpaam2(maxSize:1,nullable:false)
		hpaam3(maxSize:1,nullable:false)
		hpaam4(maxSize:1,nullable:false)
		hpaam5(maxSize:1,nullable:false)
		recordPreviouslyVoided(maxSize:1,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = true
	static mapping = {
		table name:'prphpay', schema:CH.config.hr.schema
		version (false)
		id (generator:'assigned')
		id (composite:['empNo','payPeriodBeginDate','payPeriodEndingDate','payPeriodCheckDate','regularHours','regularEarnings','socialSecurity'])
		columns {
			id (composite:['empNo','payPeriodBeginDate','payPeriodEndingDate','payPeriodCheckDate','regularHours','regularEarnings','socialSecurity'])
			empNo (column:'HPEMP', type:'int')
			payPeriodBeginDate (column:'HPBEGD', type:'date')
			payPeriodEndingDate (column:'HPENDD', type:'date')
			payPeriodCheckDate (column:'HPCHKD', type:'date')
			regularHours (column:'HPRGH', type:'big_decimal')
			overtimeHours (column:'HPOTH', type:'big_decimal')
			doubleTimeHours (column:'HPDTH', type:'big_decimal')
			vacationHours (column:'HPVH', type:'big_decimal')
			sickLeaveHours (column:'HPSLH', type:'big_decimal')
			holidayHours (column:'HPHH', type:'big_decimal')
			otherPaidHours4 (column:'HPOH4', type:'big_decimal')
			otherPaidHours5 (column:'HPOH5', type:'big_decimal')
			otherPaidHours6 (column:'HPOH6', type:'big_decimal')
			otherPaidHours7 (column:'HPOH7', type:'big_decimal')
			otherPaidHours8 (column:'HPOH8', type:'big_decimal')
			otherPaidHours9 (column:'HPOH9', type:'big_decimal')
			otherPaidHours10 (column:'HPOHA', type:'big_decimal')
			otherPaidHours11 (column:'HPUNP1', type:'big_decimal')
			otherPaidHours12 (column:'HPUNP2', type:'big_decimal')
			otherPaidHours13 (column:'HPOH13', type:'big_decimal')
			otherPaidHours14 (column:'HPOH14', type:'big_decimal')
			otherPaidHours15 (column:'HPOH15', type:'big_decimal')
			otherPaidHours16 (column:'HPOH16', type:'big_decimal')
			otherPaidHours17 (column:'HPOH17', type:'big_decimal')
			otherPaidHours18 (column:'HPOH18', type:'big_decimal')
			otherPaidHours19 (column:'HPOH19', type:'big_decimal')
			regularEarnings (column:'HPRGE', type:'big_decimal')
			overtimeEarnings (column:'HPOTE', type:'big_decimal')
			doubleTimeEarnings (column:'HPDTE', type:'big_decimal')
			otherTaxableEarnings (column:'HPTAXE', type:'big_decimal')
			otherNontaxableEarnings (column:'HPNTAX', type:'big_decimal')
			vacationEarnings (column:'HPVE', type:'big_decimal')
			sickLeaveEarnings (column:'HPSLE', type:'big_decimal')
			holidayEarnings (column:'HPHE', type:'big_decimal')
			otherPaidEarnings4 (column:'HPOE4', type:'big_decimal')
			otherPaidEarnings5 (column:'HPOE5', type:'big_decimal')
			otherPaidEarnings6 (column:'HPOE6', type:'big_decimal')
			otherPaidEarnings7 (column:'HPOE7', type:'big_decimal')
			otherPaidEarnings8 (column:'HPOE8', type:'big_decimal')
			otherPaidEarnings9 (column:'HPOE9', type:'big_decimal')
			otherPaidEarnings10 (column:'HPOEA', type:'big_decimal')
			otherPaidEarnings13 (column:'HPOE11', type:'big_decimal')
			otherPaidEarnings132 (column:'HPOE12', type:'big_decimal')
			otherPaidEarnings133 (column:'HPOE13', type:'big_decimal')
			otherPaidEarnings14 (column:'HPOE14', type:'big_decimal')
			otherPaidEarnings15 (column:'HPOE15', type:'big_decimal')
			otherPaidEarnings16 (column:'HPOE16', type:'big_decimal')
			otherPaidEarnings17 (column:'HPOE17', type:'big_decimal')
			otherPaidEarnings18 (column:'HPOE18', type:'big_decimal')
			otherPaidEarnings19 (column:'HPOE19', type:'big_decimal')
			fedWitholdingTax (column:'HPFWT', type:'big_decimal')
			stateWitholdingTax (column:'HPSWT', type:'big_decimal')
			socialSecurity (column:'HPFICA', type:'big_decimal')
			localTax (column:'HPLOCL', type:'big_decimal')
			miscDed1_notUsed (column:'HPDED1', type:'big_decimal')
			miscDed2_notUsed (column:'HPDED2', type:'big_decimal')
			miscDed3_notUsed (column:'HPDED3', type:'big_decimal')
			miscDed4_notUsed (column:'HPDED4', type:'big_decimal')
			miscDed5_notUsed (column:'HPDED5', type:'big_decimal')
			miscDed6_notUsed (column:'HPDED6', type:'big_decimal')
			miscDed7_notUsed (column:'HPDED7', type:'big_decimal')
			miscDed8_notUsed (column:'HPDED8', type:'big_decimal')
			miscDed9_notUsed (column:'HPDED9', type:'big_decimal')
			miscDed10_notUsed (column:'HPDE10', type:'big_decimal')
			miscDed11_notUsed (column:'HPDE11', type:'big_decimal')
			miscDed12_notUsed (column:'HPDE12', type:'big_decimal')
			miscDed13_notUsed (column:'HPDE13', type:'big_decimal')
			miscDed14_notUsed (column:'HPDE14', type:'big_decimal')
			miscDed15_notUsed (column:'HPDE15', type:'big_decimal')
			totalMiles_hours (column:'HPMIHR', type:'big_decimal')
			shift2Hours (column:'HPS2H', type:'big_decimal')
			shift3Hours (column:'HPS3H', type:'big_decimal')
			adjToGrossTaxableQuestion1Fwt (column:'HPATX1', type:'string')
			adjToGrossTaxableQuestion2Swt (column:'HPATX2', type:'string')
			adjToGrossTaxableQuestion3Fica (column:'HPATX3', type:'string')
			adjToGrossTaxableQuestion4Loc (column:'HPATX4', type:'string')
			adjToGrossTaxableQuestion5Fui (column:'HPATX5', type:'string')
			adjToGrossTaxableQuestion6Sui (column:'HPACD1', type:'string')
			adjToGrossTaxableQuestion7Wc (column:'HPACD2', type:'string')
			adjToGrossCode3 (column:'HPACD3', type:'string')
			adjToGrossCode4 (column:'HPACD4', type:'string')
			adjToGrossCode5 (column:'HPACD5', type:'string')
			hpaam1 (column:'HPAAM1', type:'string')
			hpaam2 (column:'HPAAM2', type:'string')
			hpaam3 (column:'HPAAM3', type:'string')
			hpaam4 (column:'HPAAM4', type:'string')
			hpaam5 (column:'HPAAM5', type:'string')
			recordPreviouslyVoided (column:'HPVOID', type:'string')
		}
	}
	boolean newEntity = false
	static transients = ['newEntity']

	def beforeInsert () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  } 
	def beforeUpdate () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
	def beforeDelete () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
}