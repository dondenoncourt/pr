package daffron.fms.hr
import daffron.fms.hr.recruiting.Candidate

class ResumeService {

	def grailsApplication
	
    File getResume(Candidate candidate) {
		File resume
		new File(grailsApplication.config.hr.resume.directory).eachFileMatch(~/${candidate.id}.*/){file ->
			resume = file
		}
		return resume
    }
}
