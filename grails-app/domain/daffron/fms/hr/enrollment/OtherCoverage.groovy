package daffron.fms.hr.enrollment
import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

public class OtherCoverage {
	String name
	String carrier
	String policyNo
	static belongsTo = [enroll:Enroll]
	
	static constraints = {
		name nullable:false, blank:false
		carrier nullable:false, blank:false
		policyNo nullable:false, blank:false
	}
	static mapping = {
		table name:'hrpothcvg', schema:CH.config.hr.schema
	}
	String toString() {"$name:$carrier:$policyNo"}
}
