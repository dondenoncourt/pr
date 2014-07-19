import org.codehaus.groovy.grails.orm.hibernate.cfg.GrailsDomainBinder

class DaffronTagLib {
	static namespace = 'daffron'
	def stateDropDown = { attrs ->
		def stateList = [ AL:"Alabama", AK:"Alaska", AZ:"Arizona", AR:"Arkansas", CA:"California", CO:"Colorado", CT:"Connecticut", DC:"District of Columbia", DE:"Delaware", FL:"Florida", GA:"Georgia", HI:"Hawaii", ID:"Idaho", IL:"Illinois", IN:"Indiana", IA:"Iowa", KS:"Kansas", KY:"Kentucky", LA:"Louisiana", ME:"Maine", MD:"Maryland", MA:"Massachusetts", MI:"Michigan", MN:"Minnesota", MS:"Mississippi", MO:"Missouri", MT:"Montana", NE:"Nebraska", NV:"Nevada", NH:"New Hampshire", NJ:"New Jersey", NM:"New Mexico", NY:"New York", NC:"North Carolina", ND:"North Dakota", OH:"Ohio", OK:"Oklahoma", OR:"Oregon", PA:"Pennsylvania", RI:"Rhode Island", SC:"South Carolina", SD:"South Dakota", TN:"Tennessee", TX:"Texas", UT:"Utah", VT:"Vermont", VA:"Virginia", WA:"Washington", WI:"Wisconsin", WV:"West Virginia", WY:"Wyoming"]
		out << "<select name='${attrs.name}' id='${attrs.id}'>"
		out << "<option value=''>Pick a state...</option>"
		stateList.each {
			out << "<option value='${it.key}'"
			if(attrs.value == it.key) {
				out << " selected='selected'"
			}
			out << ">${it.value}</option>"
		}
		out << "</select>"
	}
	// @see http://www.dariopardo.com/grails/jquerydatepickergrailstag/
	def jqDatePicker = {attrs, body ->
		def out = out
		def name = attrs.name    //The name attribute is required for the tag to work seamlessly with grails
		def id = attrs.id ?: name.replaceAll(/\[|\]/,'_').replaceAll(/\./, 'DOT')
		def minDate = attrs.minDate
		def showDay = attrs.showDay
		
		def value = attrs.value //denoncourt
		

		//Create date text field and supporting hidden text fields need by grails
		out.println "<input type=\"text\" name=\"${name}\" id=\"${id}\" value=\"${value}\"/>"
		out.println "<input type=\"hidden\" name=\"${name}_day\" id=\"${id}_day\" value=\"${value?value[3..4]:''}\"/>"
		out.println "<input type=\"hidden\" name=\"${name}_month\" id=\"${id}_month\"  value=\"${value?value[0..1]:''}\"/>"
		out.println "<input type=\"hidden\" name=\"${name}_year\" id=\"${id}_year\"  value=\"${value?value[6..9]:''}\"/>"

		//Code to parse selected date into hidden fields required by grails
		out.println "<script type=\"text/javascript\"> \$(document).ready(function(){"
		out.println "\$(\"#${id}\").datepicker({"
		out.println "onClose: function(dateText, inst) {"
		out.println "\$(\"#${id}_month\").attr(\"value\",new Date(dateText).getMonth() +1);"
		out.println "\$(\"#${id}_day\").attr(\"value\",new Date(dateText).getDate());"
		out.println "\$(\"#${id}_year\").attr(\"value\",new Date(dateText).getFullYear());"
		out.println "}"

		//If you want to customize using the jQuery UI events add an if block an attribute as follows
		if(minDate != null){
			out.println ","
			out.println "minDate: ${minDate}"
		}

		if(showDay != null){
			out.println ","
			out.println "beforeShowDay: function(date){"
			out.println	"var day = date.getDay();"
			out.println	"return [day == ${showDay},\"\"];"
			out.println "}"
		}

		out.println "});"
		out.println "})</script>"

	}	
	def formatPhone = { attrs ->
		String phone = attrs['phone']
		String formatted = ''
		if (phone?.size() >= 9) {
			formatted+='('+phone.substring(0,3)+')'+phone.substring(3,6)+'-'+phone.substring(6)
		}
		out <<formatted

	}
	def formatSSN = { attrs ->
		String ssn = attrs['ssn']
		String formatted = ''
		formatted+=ssn.substring(0,3)+'-'+ssn.substring(3,5)+'-'+ssn.substring(5)
		
		out <<formatted
	}
	def formatMMYY = { attrs ->
		String number = attrs['number']
		String formatted = ''
		formatted+=number.replaceAll("(\\d\\d)\$") {'/'+it[0]}
		
		out <<formatted
	}
	def yesNoHrQuestion = { attrs ->
		def yesNoId = attrs.yesNoId
		def yes = attrs.yes
		def name = "yesNoWithIdOf${yesNoId}"
		String radioGroup = "Yes <input type=\"radio\" name=\"${name}\" id=\"${name}\" value=\"true\" class=\"yesNo\""
		if (yes.toString() == 'true') {
			radioGroup += ' checked="checked"'	
		}
        radioGroup += "/>\n"
		radioGroup += "No <input type=\"radio\" name=\"${name}\" id=\"${name}\" value=\"false\" class=\"yesNo\""
		if (yes.toString() == 'false') {
			radioGroup += ' checked="checked"'	
		}
        radioGroup += "/>\n"
		out << radioGroup
	}
	def jasperReport = { attrs ->
		String jasper = attrs['jasper']
		String rootPath = grailsApplication.parentContext.getServletContext().getRealPath("/")
		rootPath = rootPath.replaceAll(/Daffron - HR/, 'reports') // development path name for hr
		println "grailsApplication.metadata['app.name']"+grailsApplication.metadata['app.name']
		rootPath = rootPath.replaceAll(grailsApplication.metadata['app.name'], 'reports') 
		out << "<a href='${createLink(controller:'singleSignon',action:'jasper')}?jasper=${jasper}&SUBREPORT_DIR=${rootPath}reports/' class='pdf'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </a>"
	}
	def hiddenInputKey = {attrs ->
		attrs.tagName = "hiddenInputKeys"
		if (!attrs.domain)          {throwTagError("Tag [$attrs.tagName] is missing required attribute [domain]") }

		if (attrs.domain.class.COMPOSITE_KEY) {
			GrailsDomainBinder.getMapping(attrs.domain.class).identity.propertyNames.each{
				def value =  attrs.domain."$it"
				out << "<input type=\"hidden\" name=\"${it}\" value=\"$value\" id=\"${it}\"  />"
			}
		} else {
			def id = attrs.domain.id
			if (attrs.domain.id.class.name == "java.lang.String") {
				id = attrs.domain.id.trim()
			}
			out << "<input type=\"hidden\" name=\"id\" value=\"${id}\" id=\"id\"  />"
		}
	}
	
	def linkWithKey = {attrs ->
		attrs.tagName = "hiddenInputKeys"
		if (!attrs.domain)          {throwTagError("Tag [$attrs.tagName] is missing required attribute [domain]") }
		if (!attrs.action)          {throwTagError("Tag [$attrs.tagName] is missing required attribute [action]") }
		
		def action = attrs.action
		
		out <<  "<a href=\""+createLink(attrs).encodeAsHTML()+"?"
		 if (attrs.domain.COMPOSITE_KEY) {
			GrailsDomainBinder.getMapping(attrs.domain.class).identity.propertyNames.each{
				out << it
				out << "="
				out << attrs.domain."$it"
				out << "&"
			}
			out << "\">$action</a>"
		 } else {
			 out << "id=${attrs.domain.id}+\">${attrs.domain.id}</a>"
		 }
	}

}
