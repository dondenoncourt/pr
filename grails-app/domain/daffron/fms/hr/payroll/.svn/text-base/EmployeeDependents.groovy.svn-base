package daffron.fms.hr.payroll
//use schema:CH.config.[config.groovy custom variable] to soft-code library
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import org.systemitools.types.*

class EmployeeDependents implements Serializable {
	int employeeNo
	int seqNo
	String name
	int ssn
	String relationship
	String gender
	Date birthdate
	String schoolEmplName
	String schoolEmplAddr
	String schoolEmplCitySt
	String schoolEmplZipCode
	String schoolEmplPhoneNo
	String positionGrade
	boolean otherIns
	String otherInsCoName
	String otherInsCoPhone
	Date effDateOtherCoverage
	static constraints = {
		employeeNo(max:999999999,nullable:false)
		seqNo(max:99,nullable:false)
		name(maxSize:35,nullable:false)
		ssn(max:999999999,nullable:false)
		relationship(maxSize:1,nullable:false)
		gender(maxSize:1,nullable:false)
		birthdate(nullable:false)
		schoolEmplName(maxSize:30,nullable:false)
		schoolEmplAddr(maxSize:30,nullable:false)
		schoolEmplCitySt(maxSize:30,nullable:false)
		schoolEmplZipCode(maxSize:9,nullable:false)
		schoolEmplPhoneNo(maxSize:10,nullable:false)
		positionGrade(maxSize:20,nullable:false)
		otherIns(maxSize:1,nullable:false)
		otherInsCoName(maxSize:30,nullable:false)
		otherInsCoPhone(maxSize:10,nullable:false)
		effDateOtherCoverage(nullable:true)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = true
	static mapping = {
		table name:'hrpdeps', schema:CH.config.hr.schema
		version (false)
		id (generator:'assigned')
		id (composite:['employeeNo','seqNo'])
		columns {
			id (composite:['employeeNo','seqNo'])
			employeeNo (column:'DEEMP', type:'int')
			seqNo (column:'DESEQ', type:'int')
			name (column:'DEDPNME', type:'TrimString')
			ssn (column:'DEDEPSSN', type:'int')
			relationship (column:'DEDEPREL', type:'TrimString')
			gender (column:'DESEX', type:'TrimString')
			birthdate (column:'DEBIRDTE', type:'date')
			schoolEmplName (column:'DESCHEMP', type:'TrimString')
			schoolEmplAddr (column:'DESESTR', type:'TrimString')
			schoolEmplCitySt (column:'DESEADDR', type:'TrimString')
			schoolEmplZipCode (column:'DESEZIP', type:'TrimString')
			schoolEmplPhoneNo (column:'DESEPHN', type:'TrimString')
			positionGrade (column:'DEPOSGR', type:'TrimString')
			otherIns (column:'DEOTHINS', type:'YesBlankType')
			otherInsCoName (column:'DEOINSNM', type:'TrimString')
			otherInsCoPhone (column:'DEOINSPH', type:'TrimString')
			effDateOtherCoverage (column:'DEOINSED', type:'date')
		}
	}
	boolean newEntity = false
	static transients = ['newEntity']

	def beforeInsert () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  } 
	def beforeUpdate () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
	def beforeDelete () { if (Environment.current != Environment.TEST) throw new UnsupportedOperationException(this.class+' is a read-only domain')  }
}
