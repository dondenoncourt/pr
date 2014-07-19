package daffron.fms.hr



import grails.test.mixin.*
import org.junit.*

import daffron.fms.hr.recruiting.Candidate;

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ResumeService)
@Mock([Candidate])
class ResumeServiceTests {

	//def grailsApplication DO NOT INJECT DONE AUTOMATICALLY!!!
	def resumeService
	
    void testGetResume() {
		resumeService = new ResumeService()
		resumeService.grailsApplication = grailsApplication
		grailsApplication.config.hr.resume.directory = './target'
		[12, 15, 34].each {id ->
			File file = new File("${grailsApplication.config.hr.resume.directory}/${id}_don_denoncourt_just.txt")
			file.write("just text $id")
			def candi  = new Candidate()
			candi.id = id
			candi.save(validate:false)
		}
		File file = resumeService.getResume(Candidate.get(12))
		assert file.path ==~ /\..target.12_don_denoncourt_just.txt/
		def lines = file.readLines()
		assert lines[0] == 'just text 12'
    }
}
