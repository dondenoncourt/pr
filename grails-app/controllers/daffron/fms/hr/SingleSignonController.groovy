package daffron.fms.hr

import groovy.sql.Sql
import planetj.util.CoderUtility

import  org.codehaus.groovy.grails.commons.ConfigurationHolder as CH
import grails.util.Environment
import daffron.fms.hr.User

@SuppressWarnings("deprecation")
class SingleSignonController {
	
	def sessionFactory
	
	def beforeInterceptor = {
		log.debug("action: $actionName params: $params flash: $flash")
	}


    def wowOut() { 
		def session1 = encryptLogin(session.user?.password)
//		log.debug "base64:"+session1
		redirect uri:CH.config.prixp.protocol+'://'+CH.config.prixp.ip+':'+CH.config.prixp.port+'/'+CH.config.prixp.context.root+'/runapp?'+request.queryString+'&SESSION='+session1+'&CALLING_USERID='+session.user?.id
	}
	def wowIn() {
		if (!params.SESSION || !params.CALLING_USERID) {
			render "Error: no WOW SESSION or CALLING_USERID passed"
			return
		}
		def password = getPassword(params.CALLING_USERID)
		def session1 = encryptLogin(password)
		if (session1 == params.SESSION.replaceAll(/\s/, '+')) {
			session.user = User.get(params.CALLING_USERID)
			redirect uri:"/$params.hrController/$params.hrAction/${params.id?:''}?${request.queryString}"
			return
		}
		println params.SESSION + ' != ' +session1
		redirect(controller:'login', action:"login")
	}
    def jasper() { 
		assert session.user
		def session1 = encryptLogin(session.user?.password)
		log.debug "base64:"+session1
		// http://localhost:8888/reports/jasper/?_format=PDF&_name=Parameter+Example&_file=provare&CALLING_USERID=hr
		log.debug "${grailsApplication.config.hr.jasper.protocol}://${grailsApplication.config.hr.jasper.serverName}:${grailsApplication.config.hr.jasper.serverPort}/reports/jasper?_format=PDF&_file="+params.jasper+'&'+request.queryString+'&SESSION='+session1+'&CALLING_USERID='+session.user?.id
		redirect uri:"${grailsApplication.config.hr.jasper.protocol}://${grailsApplication.config.hr.jasper.serverName}:${grailsApplication.config.hr.jasper.serverPort}/reports/jasper?_format=PDF&_file="+params.jasper+'&'+request.queryString+'&SESSION='+session1+'&CALLING_USERID='+session.user?.id
	}
	
	private String encryptLogin(String password) {
		long now = System.currentTimeMillis() / 1000;
		now = now + 10 - (now % 5);
		CoderUtility.getInstance().encode (new String (java.security.MessageDigest.getInstance("SHA-1").digest ("$password;$now".getBytes())))
	}
	private String getPassword(String userId) {
		Sql sql = new Sql(sessionFactory.getCurrentSession().connection())
		def rs = sql.firstRow("SELECT USPWD FROM ${Environment.DEVELOPMENT?CH.config.hr.schema:CH.config.wow.wolib}.xxpuser WHERE USUSER = ?", [params.CALLING_USERID]) 
		println "password for $params.CALLING_USERID:"+rs?.USPWD
		rs.USPWD
	}
}
