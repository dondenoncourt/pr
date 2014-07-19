package daffron.fms.hr.payroll

import daffron.fms.gl.Department

import static org.junit.Assert.*
import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*
import groovy.sql.Sql

// this is in integration only because, for some unknown reason, the Department creation doesn't seem to work 
class EmployeePayrollMasterTests extends GroovyTestCase  {
    void setUp() {
		assert new Department(companyCode:'',divisionCode:'',note:'',departmentCode:' ', description:'BLANK').save(validate:false)
		new Department(companyCode:'',divisionCode:'',note:'',departmentCode:'0', description:'MISC').save(validate:false)
		new Department(companyCode:'',divisionCode:'',note:'',departmentCode:'1', description:'ADMIN').save(validate:false)
		new Department(companyCode:'',divisionCode:'',note:'',departmentCode:'2', description:'IT').save(validate:false)
		new Department(companyCode:'',divisionCode:'',note:'',departmentCode:'3', description:'ENG').save(validate:false)
		new Department(companyCode:'',divisionCode:'',note:'',departmentCode:'4', description:'MKTG').save(validate:false)
		new Department(companyCode:'',divisionCode:'',note:'',departmentCode:'5', description:'OPER').save(validate:false)
		new Department(companyCode:'',divisionCode:'',note:'',departmentCode:'6', description:'ACCTG').save(validate:false)
		new Department(companyCode:'',divisionCode:'',note:'',departmentCode:'7', description:'MGMT').save(validate:false)
		

		// note, as of 3/6/2012, cudtahr.prpf4 didn't have any EDPT descriptions
		new PrCodes(field:'EDPT', value:'1', descOfValue:'admin').save(validate:false)
		new PrCodes(field:'EDPT', value:'2', descOfValue:'it').save(validate:false)
		new PrCodes(field:'EDPT', value:'3', descOfValue:'eng').save(validate:false)
		
		def glc = new GeneralConstants( constantData:'Y')
		glc.constantName = 'PR_UseGLDepartment'
		glc.userId = ''
		assert glc.save(validate:false)
		
		def e = new EmployeePayrollMaster(name:'bilbo', department:'1')
		e.id = 1
		e.save(validate:false, flush:true)
		e = new EmployeePayrollMaster(name:'bilbo', department:'2')
		e.id = 2
		e.save(validate:false, flush:true)
		e = new EmployeePayrollMaster(name:'bilbo', department:'3')
		e.id = 3
		e.save(validate:false, flush:true)
		e = new EmployeePayrollMaster(name:'bilbo', department:'4')
		e.id = 4
		e.save(validate:false, flush:true)
		e = new EmployeePayrollMaster(name:'bilbo', department:'99')
		e.id = 99
		e.save(validate:false, flush:true)
		
	}
	

    void tearDown() {
        // Tear down logic here
    }
    void testF4Tables() {
		assert Department.count() == 9
		assert GeneralConstants.count() == 1
		assert EmployeePayrollMaster.count() == 5
		assert PrCodes.count() == 3
    }

    void testGetDepartmentDescription() {
		assert Department.findByDescription('BLANK')?.description == 'BLANK'
		// GL so department should be from Department:
		assert EmployeePayrollMaster.get(1).department == '1'
		assert Department.findByDepartmentCode('1').description == 'ADMIN'
		assert EmployeePayrollMaster.get(1)
		assert EmployeePayrollMaster.get(1).name == 'bilbo'
		assert EmployeePayrollMaster.get(1).departmentDescription == Department.findByDepartmentCode('1').description
		[1,2,3].each {empNo ->
			assert EmployeePayrollMaster.get(empNo).departmentDescription == Department.findByDepartmentCode(empNo.toString()).description
		}
		assert EmployeePayrollMaster.get(99).departmentDescription == 'Not Found'
		// turn off GL so department should be from PrCodes
		def glc = GeneralConstants.findByConstantName('PR_UseGLDepartment')
		assert glc
		glc.constantData = 'N'
		glc.save(flush:true, validate:false)
		[1,2,3].each {empNo ->
			assert EmployeePayrollMaster.get(empNo).departmentDescription == PrCodes.findByFieldAndValue('EDPT', empNo.toString()).descOfValue
		}
		assert EmployeePayrollMaster.get(99).departmentDescription == 'Not Found'
		
		
	}
    void testFindBySupervisor() {
		try {
			EmployeePayrollMaster.findAllBySupervisor(true)
		} catch (e) {
			println e.toString()
			assert false // should never get here
		}
    }
}
