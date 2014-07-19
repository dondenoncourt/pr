package daffron.fms.hr.recruiting

import static org.junit.Assert.*

import grails.test.mixin.*
import grails.test.mixin.support.*
import org.junit.*

import daffron.fms.hr.User
import daffron.fms.hr.payroll.EmployeePayrollMaster

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
@Mock([Requisition, User, EmployeePayrollMaster, JobDescription, Interviewer])
class RequisitionTests {

    void setUp() {
		def emp = new EmployeePayrollMaster(name:'Gmail, Don')
		emp.id = 1
		emp.save(validate:false)
		emp = new EmployeePayrollMaster(name:'Comcast, Don')
		emp.id = 2
		emp.save(validate:false)
		def usr = new User(email:'dondenoncourt@gmail.com', fullName:'gmail', employeeNo:1)
		usr.id = 1
		usr.save(validate:false)
		usr = new User(email:'dondenoncourt@comcast.net', fullName:'comcast', employeeNo:2)
		usr.id = 2
		usr.save(validate:false)
		usr = new User(email:'dondenoncourt@comcast.net', fullName:'dup comcast', employeeNo:2) // messy xxpuser has the same empNo in many rows
		usr.id = 3
		usr.save(validate:false)
		def req = new Requisition(title:'hr')
		req.id = 1
		req.save(validate:false)
		def itv = new Interviewer(emp:EmployeePayrollMaster.get(1))
		itv.save()
		req.addToInterviewTeam itv
		itv = new Interviewer(emp:EmployeePayrollMaster.get(2))
		itv.save()
		req.addToInterviewTeam itv
    }

    void tearDown() {
        // Tear down logic here
    }

    void testInterviewTeamEmails() {
        assert Requisition.count() == 1
        assert EmployeePayrollMaster.count() == 2
		assert EmployeePayrollMaster.list()[0].id == 1
        assert User.count() == 3
		// note: finders don't seem to work in unit tests...
		assert User.where{employeeNo == 1}.find()?.fullName == 'gmail'
		assert User.where{employeeNo == 2}.find()?.fullName == 'comcast'
		
		def req = Requisition.get(1)
		assert req.interviewTeam.size() == 2
		assert User.where{employeeNo == 2}.find()?.fullName == 'comcast'
		assert req.interviewTeamEmails.sort() == ['dondenoncourt@gmail.com', 'dondenoncourt@comcast.net'].sort()
    }
}
