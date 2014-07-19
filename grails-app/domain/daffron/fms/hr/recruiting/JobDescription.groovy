package daffron.fms.hr.recruiting

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class JobDescription {
	JobClassDescription jobClass
	String job
	String adInternal
	String adExternal
	Date dateCreated
	Date lastUpdated
	JobDescription prodJobD // if this association exists, then this object is a supervisor's temporary copy 
	String dList 
	boolean cdlRequired = false
	boolean unionJob
	String emailQuiz
	String phoneQuiz
	static hasMany = [yesNo:YesNo, 
		              techNeeds:TechNeed,
					  tests:Test] 

	static constraints = {
		adInternal nullable:true, maxSize:4096
		adExternal nullable:true, maxSize:4096
		job nullable:true, maxSize:4096
		prodJobD nullable:true, validator:{prodJob, jobD ->
			if (prodJob && JobDescription.countByProdJobD(prodJob)) {
				return false
			}
			return true
		}
		dList nullable:true
		emailQuiz nullable:true, maxSize:4096
		phoneQuiz nullable:true, maxSize:4096
	}

	static mapping = {
		table name:'hrpjobd', schema:CH.config.hr.schema
		unionJob type:'org.hibernate.type.YesNoType'
		cdlRequired type:'org.hibernate.type.YesNoType'
	}

	List diffProps(JobDescription jobD) {
		def diff = []
		(adExternal != jobD.adExternal)?diff << 'adExternal':null
		(adInternal != jobD.adInternal)?diff << 'adInternal':null
		(job != jobD.job)?diff << 'job':null
		(jobClass.id != jobD.jobClass.id)?diff << 'jobClass':null
		(techNeeds != jobD.techNeeds)?diff << 'techNeeds':null
		(tests != jobD.tests)?diff << 'tests':null
		(unionJob != jobD.unionJob)?diff << 'unionJob':null
		(yesNo != jobD.yesNo)?diff << 'yesNo':null
		/* not a real difference
		(dateCreated != jobD.dateCreated)?diff << 'dateCreated':null
		(lastUpdated != jobD.lastUpdated)?diff << 'lastUpdated':null
		(prodJobD != jobD.prodJobD)?diff << 'prodJobD':null
		*/
		diff
	}
	String toString() {jobClass?.title}
}

/*
insert into cudtahr.hrpjobd (version, ad_external, ad_internal, date_created, job, job_class_id, last_updated, union_job) 
	select 0, '', '', '2011-01-01 00:00:00.000', 'job', jcjcls, '2011-01-01 00:00:00.000', 'N' from cudtahr.hrpjcls;*/