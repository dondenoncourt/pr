package daffron.fms.hr.recruiting

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class BehaviorResult implements Comparable { 
	Behavior behavior
	int result
	String note
	static belongsTo = [candidate:Candidate]

	static RESULT_MAP = [1:'SLA', 2:'LA', 3:'A', 4:'HA', 5:'SHA'] 
	static RESULT_MAP_NAMES = ['SLA':'Significantly lower than average', 
								'LA':'Lower than average', 
								'A':'Average', 
								'HA':'Higher than average', 
								'SHA':'Significantly higher than average']
	
	String toString() {"$behavior.name: $result"}
	static constraints = {
		result   inList: RESULT_MAP.keySet() as List
		note nullable:true, blank:true
	}
	static mapping = {
		table name:'hrpbhvrs', schema:CH.config.hr.schema
	}
	int compareTo(obj) {
		behavior.name.compareTo(obj.behavior.name)
	}
} 