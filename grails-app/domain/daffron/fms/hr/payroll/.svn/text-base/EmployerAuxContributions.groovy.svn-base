package daffron.fms.hr.payroll
//use schema:CH.config.[config.groovy custom variable] to soft-code library
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import org.systemitools.types.*

class EmployerAuxContributions implements Serializable {
	int employeeNo
	int deductionNo
	String paysFuiOnEmprCnt
	String paysSuiOnEmprCnt
	String paysWcmpOnEmprCnt
	String paysOth1OnEmprCnt
	String paysOth2OnEmprCnt
	String ecothra
	String ecothrb
	static constraints = {
		employeeNo(max:999999999,nullable:false)
		deductionNo(max:99,nullable:false)
		paysFuiOnEmprCnt(maxSize:1,nullable:false)
		paysSuiOnEmprCnt(maxSize:1,nullable:false)
		paysWcmpOnEmprCnt(maxSize:1,nullable:false)
		paysOth1OnEmprCnt(maxSize:1,nullable:false)
		paysOth2OnEmprCnt(maxSize:1,nullable:false)
		ecothra(maxSize:3,nullable:false)
		ecothrb(maxSize:3,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = true
	static mapping = {
		table name:'prpecntax', schema:CH.config.hr.schema
		version (false)
		id (generator:'assigned')
		id (composite:['employeeNo','deductionNo'])
		columns {
			id (composite:['employeeNo','deductionNo'])
			employeeNo (column:'EFEMP', type:'int')
			deductionNo (column:'EFDNO', type:'int')
			paysFuiOnEmprCnt (column:'EFFUI', type:'TrimString')
			paysSuiOnEmprCnt (column:'EFSUI', type:'TrimString')
			paysWcmpOnEmprCnt (column:'EFWCMP', type:'TrimString')
			paysOth1OnEmprCnt (column:'EFFLAG1', type:'TrimString')
			paysOth2OnEmprCnt (column:'EFFLAG2', type:'TrimString')
			ecothra (column:'EFOTHRA', type:'TrimString')
			ecothrb (column:'EFOTHRB', type:'TrimString')
		}
	}
	boolean newEntity = false
	static transients = ['newEntity']

	def beforeInsert () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  } 
	def beforeUpdate () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
	def beforeDelete () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
}