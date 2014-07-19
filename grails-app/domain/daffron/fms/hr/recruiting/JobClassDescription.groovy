package daffron.fms.hr.recruiting

import org.systemitools.types.*
import daffron.fms.gl.Department
import daffron.fms.hr.payroll.GeneralConstants
import daffron.fms.hr.payroll.PrCodes
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class JobClassDescription implements Serializable {
	String id
	int jobGradeLevel
	String payType
	String companyCode
	String division
	String dept
	String title
	String jobFunctionDesc
	String minimumQualification
	String supervisorsTitleOrClass
	static constraints = {
		jobGradeLevel(max:99,nullable:false)
		payType(maxSize:1,nullable:false)
		companyCode(maxSize:5,nullable:false)
		division(maxSize:5,nullable:false)
		dept(maxSize:5,nullable:false)
		title(maxSize:40,nullable:false)
		jobFunctionDesc(maxSize:60,nullable:false)
		minimumQualification(maxSize:60,nullable:false)
		supervisorsTitleOrClass(maxSize:5,nullable:false)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = false
	static mapping = {
		table name:'hrpjcls', schema:CH.config.hr.schema // note: this is a legacy iXp table
		version (false)
		id (generator:'assigned')
		columns {
			id (column:'JCJCLS',type:'TrimString')
			jobGradeLevel (column:'JCGRD', type:'int')
			payType (column:'JCTYPE', type:'TrimString')
			companyCode (column:'JCCOMP', type:'TrimString')
			division (column:'JCDIV', type:'TrimString')
			dept (column:'JCDEPT', type:'TrimString')
			title (column:'JCTTL', type:'TrimString')
			jobFunctionDesc (column:'JCFUNC', type:'TrimString')
			minimumQualification (column:'JCMINQ', type:'TrimString')
			supervisorsTitleOrClass (column:'JCSUPR', type:'TrimString')
		}
	}
	boolean newEntity = false
	static transients = ['jobClass', 'newEntity', 'deptDesc']
	def getJobClass() {
		if (id) return id
		return 
	}
	void setJobClass (def vlu) { id = vlu }
	String toString() {title}
	String getDeptDesc() {
		if (GeneralConstants.findByConstantName('PR_UseGLDepartment')?.constantData == 'Y') {
			return Department.findByDepartmentCode(dept)?.description?:'Not Found'
		}
		return PrCodes.findByFieldAndValue('EDPT', dept)?.descOfValue?:'Not Found'
	}	
	private setDeptDesc(String ignore) {/* ignore */}
}