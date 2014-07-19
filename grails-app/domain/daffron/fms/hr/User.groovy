package daffron.fms.hr

import daffron.fms.hr.payroll.EmployeePayrollMaster

//use schema:CH.config.[config.groovy custom variable] to soft-code library
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import org.systemitools.types.*

import planetj.util.CoderUtility;

class User implements Serializable {
	String id
	String fullName
	String password
	Long contactId = 0
	Integer defaultSecurityLevel = 0
	Integer glSecurityLevel = 0
	Integer cisSecurityLevel = 0
	Integer apSecurityLevel = 0
	Integer arSecurityLevel = 0
	Integer faSecurityLevel = 0
	Integer ivSecurityLevel = 0
	Integer prSecurityLevel = 0
	Integer hrSecurityLevel = 0
	Integer trSecurityLevel = 0
	Integer woSecurityLevel = 0
	Date expireDate
	Integer retryLimit = 0
	Integer retryCount = 0
	String note
	Integer employeeNo = 0
	String email
	
	String getPassword() {password}
//	void setPassword(String pwd) {
////		password = CoderUtility.getInstance().encode (new String (java.security.MessageDigest.getInstance("SHA-1").digest (pwd.getBytes())))
//		password = CoderUtility.getInstance().encodeUserIdAndPassword(id, pwd)
//	}
	void encryptPassword() {
		println CoderUtility.getInstance().encodeUserIdAndPassword(id, password)
		password = CoderUtility.getInstance().encodeUserIdAndPassword(id, password)
	}
	boolean isValidPassword(String loginPwd) {
		def pwd = CoderUtility.getInstance().encodeUserIdAndPassword(id, loginPwd)
		password == pwd
	}
	
	static def HR_SEC_LVL_MAP = [0:'none', 1:'basic', 4:'edit', 9:'all']
	static constraints = {
		fullName(maxSize:60,nullable:true)
		password(maxSize:30,nullable:true)
		contactId(nullable:true)
		defaultSecurityLevel(nullable:true)
		glSecurityLevel(nullable:true)
		cisSecurityLevel(nullable:true)
		apSecurityLevel(nullable:true)
		arSecurityLevel(nullable:true)
		faSecurityLevel(nullable:true)
		ivSecurityLevel(nullable:true)
		prSecurityLevel(nullable:true)
		hrSecurityLevel(nullable:true)
		trSecurityLevel(nullable:true)
		woSecurityLevel(nullable:true)
		expireDate(nullable:true)
		retryLimit(max:99,nullable:true)
		retryCount(max:99,nullable:true)
		note(maxSize:500,nullable:true)
		employeeNo(max:999999999,nullable:true)
		email(maxSize:50,nullable:true,email:true)
	}
	static final boolean ASSIGNED_KEY = true
	static final boolean COMPOSITE_KEY  = false
	static mapping = {
		table name:'xxpuser', schema:CH.config.hr.schema// note: this is a legacy iXp table
		version (false)
		id (generator:'assigned')
		columns {
			id (column:'USUSER',type:'string')
			fullName (column:'USNAME', type:'string')
			password (column:'USPWD', type:'string')
			contactId (column:'USCONTID', type:'long')
			defaultSecurityLevel (column:'USSECLEVEL', type:'int')
			glSecurityLevel (column:'USGLSECL', type:'int')
			cisSecurityLevel (column:'USCISSECL', type:'int')
			apSecurityLevel (column:'USAPSECL', type:'int')
			arSecurityLevel (column:'USARSECL', type:'int')
			faSecurityLevel (column:'USFASECL', type:'int')
			ivSecurityLevel (column:'USIVSECL', type:'int')
			prSecurityLevel (column:'USPRSECL', type:'int')
			hrSecurityLevel (column:'USHRSECL', type:'int')
			trSecurityLevel (column:'USTRSECL', type:'int')
			woSecurityLevel (column:'USWOSECL', type:'int')
			expireDate (column:'USPWDEXP', type:'date')
			retryLimit (column:'USPWDRETRY', type:'int')
			retryCount (column:'USPWDRCNT', type:'int')
			note (column:'USNOTE', type:'string')
			employeeNo (column:'USPRID', type:'int')
			email (column:'USEMAIL', type:'string')
		}
	}
	boolean newEntity = false
	static transients = ['userId', 'newEntity', 'employee', 'hrAdmin', 'hrSuperAdmin']
	def getUserId() {
		if (id) return id
		return 
	}
	void setUserId (def vlu) { id = vlu }
	boolean getHrAdmin() { return hrSecurityLevel >= 4}
	private void setHrAdmin(boolean ignore) {/* ignore */}
	boolean getHrSuperAdmin() { return hrSecurityLevel == 9}
	void setHrSuperAdmin(boolean ignore) {/* ignore */}
	EmployeePayrollMaster getEmployee() {
		EmployeePayrollMaster.get(employeeNo)
	}
	private void setEmployee(EmployeePayrollMaster epm) {}
	
	String toString() {fullName}
}
