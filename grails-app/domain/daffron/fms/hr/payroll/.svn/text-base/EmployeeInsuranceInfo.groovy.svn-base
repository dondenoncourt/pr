package daffron.fms.hr.payroll
//use schema:CH.config.[config.groovy custom variable] to soft-code library
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import org.systemitools.types.*

class EmployeeInsuranceInfo implements Serializable {
	int id
	String jobClass = ''
	String groupNo = ''
	BigDecimal dmnsalr = 0g
	BigDecimal dmlisalr = 0g
	BigDecimal amtOfTermLifeInsCoverage = 0g
	int termLifeInsDeductionNo = 0
	String emergencyContactName = ''
	String emergencyContactPhoneNo = ''
	String doctorPreferred = ''
	String doctorPhoneNo = ''
	Date effDateMedical = new Date()
	String typeOfMedicalCoverage = ''
	String dmmptyp = ''
	int medicalInsDeductionNo = 0
	Date effDateDental = new Date()
	String typeOfDentalCoverage = ''
	String dmdptyp = ''
	int dentalInsDeductionNo = 0
	Date effDateVision = new Date()
	String typeOfVisionCoverage = ''
	String dmvptyp = ''
	int visionInsDeductionNo = 0
	Date effDateMedicareCoverage = new Date()
	String typeOfMedicareCoverage = ''
	Date begDateCobraCoverage = new Date()
	Date endDateCobraCoverage = new Date()
	String typeOfCobraCoverage = ''
	Date dateLastPhysical = new Date()
	Date dateLastDrugTest = new Date()
	String locOfLastDrugTest = ''
	static constraints = {
		jobClass(maxSize:5,nullable:false)
		groupNo(maxSize:15,nullable:false)
		dmnsalr(max:new BigDecimal("999999999.99"),nullable:false)
		dmlisalr(max:new BigDecimal("999999999.99"),nullable:false)
		amtOfTermLifeInsCoverage(max:new BigDecimal("999999999.99"),nullable:false)
		termLifeInsDeductionNo(max:99,nullable:false)
		emergencyContactName(maxSize:35,nullable:false)
		emergencyContactPhoneNo(maxSize:10,nullable:false)
		doctorPreferred(maxSize:35,nullable:false)
		doctorPhoneNo(maxSize:10,nullable:false)
		effDateMedical(nullable:true)
		typeOfMedicalCoverage(maxSize:1,nullable:false)
		dmmptyp(maxSize:5,nullable:false)
		medicalInsDeductionNo(max:99,nullable:false)
		effDateDental(nullable:true)
		typeOfDentalCoverage(maxSize:1,nullable:false)
		dmdptyp(maxSize:5,nullable:false)
		dentalInsDeductionNo(max:99,nullable:false)
		effDateVision(nullable:true)
		typeOfVisionCoverage(maxSize:1,nullable:false)
		dmvptyp(maxSize:5,nullable:false)
		visionInsDeductionNo(max:99,nullable:false)
		effDateMedicareCoverage(nullable:true)
		typeOfMedicareCoverage(maxSize:1,nullable:false)
		begDateCobraCoverage(nullable:true)
		endDateCobraCoverage(nullable:true)
		typeOfCobraCoverage(maxSize:1,nullable:false)
		dateLastPhysical(nullable:true)
		dateLastDrugTest(nullable:true)
		locOfLastDrugTest(maxSize:20,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = false
	static mapping = {
		table name:'hrpeins', schema:CH.config.hr.schema
		version (false)
		id (generator:'assigned')
		columns {
			id (column:'DMEMP',type:'int')
			jobClass (column:'DMJCLSS', type:'string')
			groupNo (column:'DMGRPNO', type:'string')
			dmnsalr (column:'DMNSALR', type:'big_decimal')
			dmlisalr (column:'DMLISALR', type:'big_decimal')
			amtOfTermLifeInsCoverage (column:'DMLICOV', type:'big_decimal')
			termLifeInsDeductionNo (column:'DMLDNO', type:'int')
			emergencyContactName (column:'DMENME', type:'string')
			emergencyContactPhoneNo (column:'DMPHONE', type:'string')
			doctorPreferred (column:'DMDOCTR', type:'string')
			doctorPhoneNo (column:'DMDPHNE', type:'string')
			effDateMedical (column:'DMMEDTE', type:'date')
			typeOfMedicalCoverage (column:'DMMCVTYP', type:'string')
			dmmptyp (column:'DMMPTYP', type:'string')
			medicalInsDeductionNo (column:'DMMDNO', type:'int')
			effDateDental (column:'DMDEDTE', type:'date')
			typeOfDentalCoverage (column:'DMDCVTYP', type:'string')
			dmdptyp (column:'DMDPTYP', type:'string')
			dentalInsDeductionNo (column:'DMDDNO', type:'int')
			effDateVision (column:'DMVEDTE', type:'date')
			typeOfVisionCoverage (column:'DMVCVTYP', type:'string')
			dmvptyp (column:'DMVPTYP', type:'string')
			visionInsDeductionNo (column:'DMVDNO', type:'int')
			effDateMedicareCoverage (column:'DMCEDTE', type:'date')
			typeOfMedicareCoverage (column:'DMCCVTYP', type:'string')
			begDateCobraCoverage (column:'DMBBDTE', type:'date')
			endDateCobraCoverage (column:'DMBEDTE', type:'date')
			typeOfCobraCoverage (column:'DMBCVTYP', type:'string')
			dateLastPhysical (column:'DMPHDTE', type:'date')
			dateLastDrugTest (column:'DMDTDTE', type:'date')
			locOfLastDrugTest (column:'DMDTLOC', type:'string')
		}
	}
	boolean newEntity = false
	static transients = ['employeeNo', 'newEntity']
	def getEmployeeNo() {
		if (id) return id
		return 0
	}
	void setEmployeeNo (def vlu) { id = vlu }

	def beforeInsert () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  } 
	def beforeUpdate () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
	def beforeDelete () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
}