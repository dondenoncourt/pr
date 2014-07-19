package daffron.fms.hr

import static org.junit.Assert.*
import grails.test.mixin.support.*

@TestMixin(GrailsUnitTestMixin)
@Mock([User])
class UserTests {

    void setUp() {
		
	}
    void testEncryptPassword() {
		def u = new User(id:'don', password:'secret')
		println u.password
		u.save(validate:false)
		println u.password
		u.encryptPassword()
		assert u.password != 'secret'
		assert u.isValidPassword('secret')
	}
}
