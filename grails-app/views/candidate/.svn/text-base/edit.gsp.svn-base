<%@ page import="daffron.fms.hr.recruiting.Candidate"%>
<%@ page import="daffron.fms.hr.recruiting.DriverExperience" %>
<%@ page import="daffron.fms.hr.recruiting.Requisition" %>
<%@ page import="daffron.fms.hr.recruiting.RequisitionCandidate" %>
<%@ page import="daffron.fms.hr.recruiting.YesNo" %>
<%@ page import="daffron.fms.hr.recruiting.YesNoAns" %>
<%@ page import="grails.util.Environment" %>

<html>
	<head>
        <meta http-equiv="Content-Type" content="application/xhtml+xml; charset=UTF-8" />
        <meta name="layout" content="recruiting" />        
        <title>Application Form</title>
        <% if (params.pdf) {%>
        <link rel="stylesheet" href="${resource(dir:'css',file:'reportsPDF.css')}"  media="print"/>
        <% } %>
        <g:javascript>
            $(document).ready( function () {checkForValue('education_0_descr');});
            
        	function setReindexInputArray() {
	        	$('.remove').click(function() {
	        	   var id = $('.ajaxInfo', $(this).parent().parent()).attr('rowId');
	        	   if (id > 0) { // then delete that row
		        	   var action = $('.ajaxInfo', $(this).parent().parent()).attr('action');
				       $.ajax({
				            url: '${g.resource()}/candidate/'+action, 
				            data: "id="+id,
				            type: "POST",
				            error: function(XMLHttpRequest, textStatus, errorThrown) {alert(textStatus);}
				        });
				    }
	        		$(this).parent().parent().remove();
	        		var tableId = $(this).parent().parents('table').attr('id');
	        		// resequence the GORM-based input name 
	        		$('#'+tableId+' tbody tr').each(function(i, tr) {
	        			$('input', $(tr)).each(function(j, input) {
		        			var name = $(input).attr('name').replace(/\[\d\]/, '['+i+']');
		        			$(input).attr('name', name);
	        			});
	        		}); 
	        	});
	        }
	        
        function makeBlank(elem) {
	        var inputBox = document.getElementById(elem).value
	        if (inputBox == "High School or GED")
	        {
	        document.getElementById(elem).style.color = "#000000"
	        document.getElementById(elem).value = ""
	        }
	    }
	    function resetValue(elem) {
	        var inputBox = document.getElementById(elem).value
	        if (inputBox == "" || inputBox == null) {
	            document.getElementById(elem).style.color = "#969595"
	            document.getElementById(elem).value = "High School or GED"
	        }
	    }
	    function checkForValue(elem) {
	       var inputBox = document.getElementById(elem).value
	       if (inputBox != "High School or GED") {
               document.getElementById(elem).style.color = "#000000"
	       }
	    }
	    function goBack()
	    {
	       window.history.back()
	    }
	    function setHistoryRemoveHandlers() {
		   	$('.removeHistory').unbind('click').click(function() {
			   	var histId = $(this).attr('employmentId');
			   	var iHist = $(this).attr('iHist');
			   	$('#historyTable'+iHist).remove();
			   	if (histId == null) {
			   	   return;
			   	}
			   	
			    $.ajax({
		            url: "${createLink(action:'deleteHistory')}", 
		            data: "employmentId="+histId,
		            type: "POST",
		            dataFilter: function(data) { return data; },
		            success: function(data) {
		            		if (window.console) console.log("Employment History id:"+histId+" deleted");
		           	},
		            error: function(XMLHttpRequest, textStatus, errorThrown) {alert(textStatus);}
		         });
		   	});
		   	$('#stillEmployed').click(function () { 
		   	    if ($(this).is(":checked")) {
		   	        $('#history_0_toMMYY').hide();
		   	        $('#history_0_toMMYY').val('9999');
		   	    } else {
		   	        $('#history_0_toMMYY').val('');
		   	        $('#history_0_toMMYY').show();
		   	    }
		   	});
		}
	        </g:javascript>
    </head>
    <body>
        <div class="iXpStd">
            <g:if test="${params.jobs}">
                <h1>Employment Application ${req?.jobD?" for $req.jobD":''}</h1>
            </g:if>
            <g:else>
                <h1>${(candidate.id?(action == 'show'?'Display':'Edit'):'Add')} Candidate ${req?.jobD?" for $req.jobD":''}</h1>
            </g:else>
	            <g:if test="${flash.message}">
	            <div class="message">${flash.message}</div>
	            </g:if>
	            <g:hasErrors bean="${candidate}">
	            <div class="errors">
	                <g:renderErrors bean="${candidate}" as="list" />
	            </div>
	            </g:hasErrors>
            <g:if test="${!params.jobs}">
	            <% if (!params.pdf) { %>            
	            <div class="icons">
	                <g:link controller="pdf" action="show" params="[url:'/candidate/editTable/'+candidate?.id+'?reqId='+req?.id]" class="pdf" title="Export to PDF" />
	            </div> 
	            <% } %>
            </g:if>
            <g:form method="post" name="empAppForm" action="${candidate.id?'update':'save'}" enctype="multipart/form-data">
                <g:hiddenField name="requisitionId" value="${req?.id}" />
                <g:hiddenField name="id" value="${candidate?.id}" />
                <g:hiddenField name="version" value="${candidate?.version}" />
                
      			<fieldset class="empapp">
      				<legend><a><img src="${resource(dir:'images/skin',file:'collapse.png')}"/></a><span>Personal Data</span></legend>
		                <div>
	                    <table class="candidate">
	                    	<tbody>
	                    		<tr>
	                    			<td colspan="5" class="value ${hasErrors(bean: candidate, field: 'name', 'errors')}">
		                    			<dl>
					                        <dt class="name"><label for="name">Name (Last, First, MI)</label></dt>
					                        <dd>
					                            <g:textField name="name" value="${candidate?.name}" size="53" />
					                        </dd>
				                        </dl>
			                        </td>
			                    </tr>
			                    <tr>
			                        <td colspan="3" class="value ${hasErrors(bean: candidate, field: 'addr.line1', 'errors')} ${hasErrors(bean: candidate, field: 'addr', 'errors')}">
		                    			<dl>
					                        <dt class="name"><label for="addr.line1">Mailing Address</label></dt>
					                        <dd>
					                            <g:textField name="addr.line1" value="${candidate?.addr?.line1}" size="53"/>
					                        </dd>
				                        </dl>
			                        </td>
			                    	<td style="width: 25%;" class="value ${hasErrors(bean: candidate, field: 'phoneNo', 'errors')}">
		                    			<dl>
					                        <dt class="name" stlye="float:none;"><label for="phoneNo">Preferred Contact Number</label></dt>
					                        <dd>
					                            <g:textField name="phoneNo" maxlength="13" class="phone" value="${daffron.formatPhone(phone:candidate?.phoneNo)}" />
					                        </dd>
					                    </dl>
					               </td>
					               <td style="width: 25%;" class="value ${hasErrors(bean: candidate, field: 'altPhoneNo', 'errors')}">
					               		<dl>
					                        <dt class="name"><label for="phoneNo">Alternate Contact Number</label></dt>
					                        <dd>
					                            <g:textField name="altPhoneNo" maxlength="13" class="phone" value="${daffron.formatPhone(phone:candidate?.altPhoneNo)}" />
					                        </dd>
				                        </dl>
			                        </td>
			                    </tr>	        
			                    <tr>
			                        <td style="width: 212px;" class="value ${hasErrors(bean: candidate, field: 'addr.city', 'errors')} ${hasErrors(bean: candidate, field: 'addr', 'errors')}">
		                    			<dl>
					                        <dt><label for="addr.city">City</label></dt>
					                        <dd>
							                	<g:textField name="addr.city" maxlength="25" value="${candidate?.addr?.city}" />
					                        </dd>
					                    </dl>
					               </td>
					               <td style="width: 86px;" class="value ${hasErrors(bean: candidate, field: 'addr.state', 'errors')} ${hasErrors(bean: candidate, field: 'addr', 'errors')}">
					               		<dl>
					                        <dt class="name"><label for="addr.state">State</label></dt>
					                        <dd>
					                            <%--<g:textField name="addr.state" maxlength="2" size="2" value="${candidate?.addr?.state}" />--%>
												<daffron:stateDropDown name="addr.state" value="${candidate?.addr?.state}" />
					                        </dd>
					                    </dl>
					               </td>
					               <td style="width: 197px;" class="value ${hasErrors(bean: candidate, field: 'addr.zip', 'errors')} ${hasErrors(bean: candidate, field: 'addr', 'errors')}">
					               		<dl>
					                        <dt class="name"><label for="addr.zip">Zip</label></dt>
					                        <dd>
					                            <g:textField name="addr.zip" maxlength="10" size="10" value="${candidate?.addr?.zip}" />
					                        </dd>
					                    </dl>
			                        </td>
			                    	<td colspan="2">
		                    			<dl>
		                    				<g:set var="question" value="${YesNo.findByShortName('over18')}" />
					                        <dt class="name" style="float:none;">${question?.question}</dt>
					                        <dd class="value ">
					                           <daffron:yesNoHrQuestion yesNoId="${question.id}" yes="${candidate?.yesNoAns.find{it.yesNo?.id == question.id}?.answer}" />
					                        </dd>
					                    </dl>
					               </td>
			                    </tr>		        
			                    <tr>
			                    	<td colspan="3" class="value ${hasErrors(bean: candidate, field: 'email', 'errors')}">
		                    			<dl>
					                        <dt class="name"><label for="email">E-mail Address</label></dt>
					                        <dd>
					                            <g:textField name="email" value="${candidate?.email}" size="53"/>
					                        </dd>
				                        </dl>
			                        </td>
			                    	<td colspan="2">
		                    			<dl>
		                    				<g:set var="question" value="${YesNo.findByShortName('us citizen')}" />
					                        <dt class="name" style="float:none;">${question?.question}</dt>
					                        <dd class="value ">
					                           <daffron:yesNoHrQuestion yesNoId="${question.id}" yes="${candidate?.yesNoAns.find{it.yesNo?.id == question.id}?.answer}" />
					                        </dd>
					                    </dl>
					               </td>
					        	</tr>	        
					        	<tr>
					        		<td colspan="5" class="value ${hasErrors(bean: candidate, field: 'refer', 'errors')}">
		                    			<dl>
					                        <dt class="name"><label for="refer">How were you referred to the Company</label></dt>
					                        <dd>
					                            <g:textField name="refer" value="${candidate?.refer}" size="126"/>
					                        </dd>
				                        </dl>
					        		</td>
					        	</tr>
					        	<tr>
					        		<td colspan="5" class="value ${hasErrors(bean: candidate, field: 'relations', 'errors')}">
		                    			<dl>
					                        <dt class="name"><label for="relations">Please list any relatives or friends currently employed with the Company and your relationship to them.</label></dt>
					                        <dd>
					                            <g:textField name="relations" value="${candidate?.relations}" size="126"/>
					                        </dd>
				                        </dl>
					        		</td>
					        	</tr>
					        	<g:if test="${['GLE', 'GLE_DEV'].find{it == Environment.getCurrent().name}}">
						        	<tr>
						        		<td colspan="5">
			                    			<dl>
			                    				<g:set var="question" value="${YesNo.findByShortName('able')}" />
						                        <dt class="name" style="float:none;">${question?.question}
						                        		                    				 (DO NOT ANSWER THIS QUESTION UNLESS YOU HAVE BEEN INFORMED ABOUT THE REQUIREMENTS OF THE JOB FOR WHICH YOU ARE APPLYING.)
						                        
						                        </dt>
						                        <dd class="value ">
						                           <daffron:yesNoHrQuestion yesNoId="${question.id}" yes="${candidate?.yesNoAns.find{it.yesNo?.id == question.id}?.answer}" />
						                           <g:javascript>
			                                          $('input[name=yesNoWithIdOf${question.id}]').removeClass('yesNo');
						                           </g:javascript>
						                        </dd>
					                        </dl>
						        		</td>
						        	</tr>
						        	<tr>
						        		<td colspan="3">
			                    			<dl>
			                    				<g:set var="question" value="${YesNo.findByShortName('michigan driver')}" />
						                        <dt class="name" style="float:none;">${question?.question}</dt>
						                        <dd class="value ">
						                           <daffron:yesNoHrQuestion yesNoId="${question.id}" yes="${candidate?.yesNoAns.find{it.yesNo?.id == question.id}?.answer}" />
						                        </dd>
					                        </dl>
						        		</td>
						        		<td colspan="2" class="value ${hasErrors(bean: candidate, field: 'ableStart', 'errors')}">
			                    			<dl>
						                        <dt class="name"><label for="ableStart">If selected for employment, on what date can you start?</label></dt>
						                        <dd>
						                       		 <daffron:jqDatePicker name="ableStart" value="${candidate?.ableStart?g.formatDate(format:'MM/dd/yyyy', date:candidate?.ableStart):''}" />
						                        </dd>
					                        </dl>
						        		</td>
					        		</tr>
					        		<tr>
						        		<td colspan="3">
			                    			<dl>
			                    				<g:set var="question" value="${YesNo.findByShortName('holidays')}" />
						                        <dt class="name" style="float:none;">${question?.question}</dt>
						                        <dd class="value ">
						                           <daffron:yesNoHrQuestion yesNoId="${question.id}" yes="${candidate?.yesNoAns.find{it.yesNo?.id == question.id}?.answer}" />
						                        </dd>
					                        </dl>
						        		</td>
						        		<td colspan="2" class="top">
			                    			<dl>
			                    				<g:set var="question" value="${YesNo.findByShortName('overtime')}" />
						                        <dt class="name" style="float:none;">${question?.question}</dt>
						                        <dd class="value ">
						                           <daffron:yesNoHrQuestion yesNoId="${question.id}" yes="${candidate?.yesNoAns.find{it.yesNo?.id == question.id}?.answer}" />
						                        </dd>
					                        </dl>
						        		</td>
					        		</tr>
					        		<tr>
						        		<td colspan="3">
						        			<dl>
			                    				<g:set var="question" value="${YesNo.findByShortName('on call')}" />
						                        <dt class="name" style="float:none;">${question?.question}</dt>
						                        <dd class="value ">
						                           <daffron:yesNoHrQuestion yesNoId="${question.id}" yes="${candidate?.yesNoAns.find{it.yesNo?.id == question.id}?.answer}" />
						                        </dd>
					                        </dl>
						        		</td>
						        		<td colspan="2" class="top">
			                    			<dl>
			                    				<g:set var="question" value="${YesNo.findByShortName('convicted of crime')}" />
						                        <dt class="name" style="float:none;">${question?.question}</dt>
						                        <dd class="value ">
						                           <daffron:yesNoHrQuestion yesNoId="${question.id}" yes="${candidate?.yesNoAns.find{it.yesNo?.id == question.id}?.answer}"
									                	title="If yes, please explain fully on a separate sheet of paper including jurisdiction (state and county) where such conviction occurred. (Conviction of a crime is not an automatic bar to employment-all circumstances will be considered. However, failure to disclose a conviction will exclude you from further consideration.)"
								                	/>
						                        </dd>
					                        </dl>
						        		</td>
					        		</tr>
					        		<tr>
						        		<td colspan="3" class="top">
						        			<dl>
			                    				<g:set var="question" value="${YesNo.findByShortName('criminal charges')}" />
						                        <dt class="name" style="float:none;">${question?.question}</dt>
						                        <dd class="value ">
						                           <daffron:yesNoHrQuestion yesNoId="${question.id}" yes="${candidate?.yesNoAns.find{it.yesNo?.id == question.id}?.answer}"
														title="If yes, please explain fully on a separate sheet of paper."
								                	/>
						                        </dd>
					                        </dl>
						        		</td>
						        		<td colspan="2">
			                    			<dl>
			                    				<g:set var="question" value="${YesNo.findByShortName('convicted power diversion')}" />
						                        <dt class="name" style="float:none;">${question?.question}</dt>
						                        <dd class="value ">
						                           <daffron:yesNoHrQuestion yesNoId="${question.id}" yes="${candidate?.yesNoAns.find{it.yesNo?.id == question.id}?.answer}"
									                	title="If yes, please explain fully on a separate sheet of paper including jurisdiction (state and county) where such conviction occurred. (Conviction of a crime is not an automatic bar to employment-all circumstances will be considered. However, failure to disclose a conviction will exclude you from further consideration.)"
								                	/>
						                        </dd>
					                        </dl>
						        		</td>
						        	</tr>
					        	</g:if>
	                    	</tbody>
	                	</table>
	                </div>
                </fieldset>
                
      			<fieldset class="empapp">
      				<legend><a><img src="${resource(dir:'images/skin',file:'collapse.png')}"/></a><span>Education</span></legend>
      				<div>
	                    <table class="candidate">
	                    	<thead>
	                    		<tr>
	                    		     <th style="width: 34%;">Name and Location of School (City &#38; State)</th>
	                    		     <th style="width: 22%;">Last Grade or Years Completed</th>
	                    		     <th style="width: 22%;">Major/Field of Study</th>
	                    		     <th style="width: 22%;">List Diploma or Degree</th>
                   		        </tr>
	                    	</thead>
	                    	<tbody>
	                    		<tr>
	              				    <g:set var="highSchoolEdu" value="${candidate.education?.find{it.highOrGED}}"/>
							        <td>
			                            <g:textField size="40" name="education[0].descr" id="education_0_descr" style="color: #969595;"
			                                 onfocus="javascript: makeBlank('education_0_descr')" onblur="javascript: resetValue('education_0_descr')" 
			                                 value="${highSchoolEdu?highSchoolEdu.descr:'High School or GED'}"/>
	                    			</td>
	                    			<td>
			                    		<g:each var="y" in="${ (9..12) }"> ${y}&#160;
			                    		   <g:radio name="education[0].years" id="education_0_years${y}" value="${y}" checked="${(highSchoolEdu?.years == y)}" />
										</g:each>
									</td>
	                    			<td><g:textField name="education[0].study" id="education_0_study" value="${highSchoolEdu?.study}"/></td>
	                    			<td>
	                    			    <g:textField name="education[0].degree" id="education_0_degree" value="${highSchoolEdu?.degree}"/>
		                    			<g:hiddenField name="education[0].highOrGED" value="${true}"/>
	                    			</td>
	                    		</tr>
              				    <g:set var="edu" value="${candidate.education?.findAll{!it.highOrGED}?.toArray()?.sort{it.years}?.reverse()}"/>
	                    		<g:each var="i" in="${ (1..3) }">
		                    		<tr>
		                    			<td>
				                            <g:textField size="40" name="education[${i}].descr" id="education_${i}_descr" value="${(edu?.size() >= i)?edu[i-1].descr:''}"/> 
				                        </td>
		                    			<td>
				                    		<g:each var="y" in="${ (1..4) }"> &#160;${y}&#160;
				                    		  <g:radio name="education[${i}].years" id="education_${i}_years${y}" value="${y}"
			                    					checked="${(edu?.size() >= i && edu[i-1].years == y)}" />
											</g:each>
		                    			</td>
		                    			<td><g:textField name="education[${i}].study" id="education_${i}_study" value="${(edu?.size() >= i)?edu[i-1].study:''}"/></td>
		                    			<td><g:textField name="education[${i}].degree" id="education_${i}_degree" value="${(edu?.size() >= i)?edu[i-1].degree:''}"/></td>
		                    			<g:hiddenField name="education[${i}].highOrGED" value="${false}"/>
		                    		</tr>
		                    	</g:each>
	                    	</tbody>
                    	</table><br /><br />
                    	<table class="candidate">
                    	   <thead>
                    	       <tr>
                    	           <th style="width: 34%;">United Stated Military Service</th>
                    	           <th style="width: 22%;">Rank</th>
                    	           <th style="width: 22%;">Years Served</th>
                    	           <th style="width: 22%;">Date of Discharge</th>
                    	       </tr>
                   	       </thead>
                   	       <tbody>
	                    		<tr>
	                    			<td>
			                            <b>Branch:</b>&#160;<g:textField name="military.branch" value="${candidate?.military?.branch}"/>					                       
	                    			</td>
	                    			<td>
	                    				<g:textField name="military.rank" value="${candidate?.military?.rank}"/>
	                    			</td>
	                    			<td>
		                    			<g:textField name="military.years" value="${candidate?.military?.years?:0}" size="3"/>
	                    			</td>
	                    			<td>
		                    			<% def date = candidate?.military?.discharge?:'' %>
                                        <g:datePicker name="military.discharge" value="${date}" precision="year" relativeYears="${-50..1}" noSelection="['':'-Choose-']"/>
	                    			</td>
	                    		</tr>		        
			                    <tr>
			                    	<td colspan="4">
		                    			<dl>
					                        <dt><label for="military.skills">Please list skills acquired during your service in the U.S. Military, if applicable.</label></dt>
					                        <dd><g:textArea name="military.skills" value="${candidate?.military?.skills}" rows="3" columns="80"/></dd>
					                    </dl>
					               </td>
	                    		</tr>
	                    	</tbody>
	                    </table>
	            	</div>
                </fieldset>
                
      			<fieldset class="empapp">
      				<legend><a><img src="${resource(dir:'images/skin',file:'collapse.png')}"/></a><span>Employment History</span></legend>
		                <div>
		                    <!-- on create, have one blank entry otherwise only show existing (if any) -->
           				    <g:set var="jobCount" value="${candidate?.history?.size()?:0}"/>
		                    <g:if test="${candidate.id}">
			                    <g:if test="${jobCount}">
				      				<g:each var="iHist" in="${ (0..(jobCount-1)) }">
				      					<g:render template="employmentHistory" model="[candidate:candidate, iHist:iHist, jobCount:jobCount, action:params.action]"/>
				                    </g:each>
			                    </g:if>
		                    </g:if>
		                    <g:else>
		                        <!--  don't show blank first if it hasErrors as it must be an error cycle  -->
			                    <g:if test="${jobCount && candidate.hasErrors() || !candidate.hasErrors()}">
				      				<g:each var="iHist" in="${ (0..(jobCount?jobCount-1:0)) }">
				      					<g:render template="employmentHistory" model="[candidate:candidate, iHist:iHist, jobCount:jobCount]"/>
				                    </g:each>
			                    </g:if>
		      				</g:else>
                   	    <g:if test="${params.action != 'show'}">
		                    <div id="addHistoryDiv" class="appBtns linkBtns">
		      				   <a id="addHistory" class="add button">Add Additional Employment Record</a>
		      				</div>
		      			</g:if>
                    </div>
                </fieldset>
                <g:if test="${req?.jobD?.cdlRequired}">
	      			<fieldset id="cdl" class="empapp">
	      				<legend><a><img src="${resource(dir:'images/skin',file:'collapse.png')}"/></a><span>Commercial Driver's License</span></legend>
		                <div>
			                <table>
			                   <tbody>
			                       <tr>
				                       <td>
							         		<dl>
								         		<g:set var="question" value="${YesNo.findByShortName('cdlEligible')}" />
								         		<g:set var="answer" value="${candidate?.yesNoAns.find{it.yesNo?.id == question.id}}" />
								                <dt class="name" style="float:none;">${question?.question}</dt>
								                <dd class="value ">
													Yes <input type="radio" name="yesNoWithIdOf${question.id}" id="yesNoWithIdOf${question.id}" value="true" 
													            ${answer?.answer == true?'checked="checked"':''}
													    />
													No <input type="radio" name="yesNoWithIdOf${question.id}" id="yesNoWithIdOf${question.id}" value="false" 
													            ${answer?.answer == false?'checked="checked"':''}
													    />
													N/A <input type="radio" name="yesNoWithIdOf${question.id}" id="yesNoWithIdOf${question.id}" value="notapplicable" />
								                </dd>
								            </dl>
				                       <td>
							         		<dl>
								         		<g:set var="question" value="${YesNo.findByShortName('cdl')}" />
								         		<g:set var="answer" value="${candidate?.yesNoAns.find{it.yesNo?.id == question.id}}" />
								                <dt class="name" style="float:none;">${question?.question}</dt>
								                <dd class="value ">
													Yes <input type="radio" name="yesNoWithIdOf${question.id}" id="yesNoWithIdOf${question.id}" value="true" 
													            ${answer?.answer == true?'checked="checked"':''}
													    />
													No <input type="radio" name="yesNoWithIdOf${question.id}" id="yesNoWithIdOf${question.id}" value="false" 
													            ${answer?.answer == false?'checked="checked"':''}
													    />
													N/A <input type="radio" name="yesNoWithIdOf${question.id}" id="yesNoWithIdOf${question.id}" value="notapplicable" />
								                </dd>
								            </dl>
							            </td>
							           </td>
							      </tr>
							  </tbody>
							</table>
						</div>
	      				<h2>(Complete this section ONLY if the position applying for requires a CDL.)</h2>
		                <div>
		      				<h3>Accident record for past 3 years or more:</h3>
		      				No Accidents <g:checkBox id="noAccidents" name="noAccidents" checked="${candidate?.noAccidents}"/>
		      				<g:if test="${!candidate?.noAccidents}">
		                        <g:render template="accidents" model="[candidate:candidate]"/><br /><br />
	                        </g:if>
		      				<h3>Traffic convictions and forfeitures for the past 3 years other than parking violations:</h3>
		      				No convictions or forfeitures <g:checkBox id="noViolations" name="noViolations" checked="${candidate?.noViolations}"/>
		      				<g:if test="${!candidate.noViolations}">
		                        <g:render template="violations" model="[candidate:candidate]"/><br /><br />
		                    </g:if>
		      				<h3>Driving Experience:</h3>
		                    <table class="candidate">
		                    	<thead>
		                    		<tr>
		                    		     <th>Class of Equipment</th>
		                    		     <th>Type of Equipment</th>
		                    		     <th>From MMYY</th>
		                    		     <th>To MMYY</th>
		                    		     <th>Approx. No. of Miles (total)</th>
	                   		        </tr>
		                    	</thead>
		                    	<tbody>
		                    		<g:each in="${DriverExperience.CLASS_MAP.sort{it.key}}" var="klassMap" status="iExp">
		                    		    <g:set var="exp" value="${candidate?.driverExperience?.find{it.has && it.klass == klassMap.key}}"/>
			                    		<tr>
			                    			<td>
			                    				${klassMap.value} 
			                    				<g:checkBox name="driverExperience[${iExp}].has" id="driverExperience_${iExp}_has" checked="${exp}" />
			                    				<g:hiddenField name="driverExperience[${iExp}].klass" id="driverExperience_${iExp}_klass" value="${klassMap.key}"/>
			                    			</td>
			                    			<td>
					                    		<g:each in="${DriverExperience.TYPE_MAP}" var="typeMap" >
					                    			${typeMap.value} 
					                    			<g:radio name="driverExperience[${iExp}].typ" id="driverExperience_${iExp}_typ" 
					                    					value="${typeMap.key}" 
	        		                    					checked="${exp?.typ == typeMap.key}"
					                    			/>
					                    		</g:each>
				                    		</td>
				                        	<td <g:if test="${exp && candidate?.errors.getFieldError('driverExperience.fromMMYY')?.rejectedValue == exp.fromMMYY}">class="errors"</g:if> >
				                    			<g:textField name="driverExperience[${iExp}].fromMMYY" size="5" class="mmyy"
				                    			  value="${exp?daffron.formatMMYY(number:exp.fromMMYY):''}"
				                    		    />
				                    		</td>
				                        	<td <g:if test="${exp && candidate?.errors.getFieldError('driverExperience.toMMYY')?.rejectedValue == exp.toMMYY}">class="errors"</g:if> >
				                    			<g:textField name="driverExperience[${iExp}].toMMYY" size="5" class="mmyy"
				                    			  value="${exp?daffron.formatMMYY(number:exp.toMMYY):''}"
	                                            />
		  		                    		</td> 
				                        	<td <g:if test="${exp && candidate?.errors.getFieldError('driverExperience.miles')?.rejectedValue == exp.miles}">class="errors"</g:if> >
				                    			<g:textField name="driverExperience[${iExp}].miles" size="7" class="miles"
				                    			  value="${exp?g.formatNumber(number:exp.miles,format:'###,###,##0'):''}"
				                    			/>
				                    		</td>
				                    	</tr>
		                    		</g:each>
		                    	</tbody>
		                    </table>
		            	</div>
	      			</fieldset>
      			</g:if>
      			
      			<fieldset class="empapp">
      				<legend><a><img src="${resource(dir:'images/skin',file:'collapse.png')}"/></a><span>General Questions</span></legend>
	                <div>
	                    <table id="generalQuestions">
	                    	<tbody>
				              <g:each in="${req?.jobD?.yesNo?.findAll{!it.shortName}?.sort{it.id}}" var="question">
								  	<tr> 
								  		<td>
								  			<dl> 
							                     <dt class="name"> ${question?:'No question found'} </dt>
							                     <dd class="value">
							                         <g:set var="answer" value="${candidate.yesNoAns.find{it.yesNo.id == question.id}}"/>
							                         <daffron:yesNoHrQuestion yesNoId="${question.id}" yes="${answer?answer.answer:''}" />
							                     </dd>
					                     	</dl>
					                    </td>
				                    </tr>
				              </g:each>
                          	  <g:if test="${params.action != 'show'}">
								<tr>
									<td>
										<dl>
						                    <dt class="name">
						                      <label for="resume">Upload Resume</label>
						                    </dt>
						                    <dd class="value}">
						               			<input type="file" name="resume"/>       
						                    </dd>
						               </dl>
									</td>
								</tr>
							  </g:if>
            			    </tbody>
            			</table>
            		</div>
            	</fieldset>
            	<g:if test="${action != 'show'}">
	                <div class="buttons">
	                    <g:submitButton class="save button" name="${(candidate.id?'update':'save')}"  id="updateOrSave" value="${(candidate.id?'Update':'Save')}" />
	                    <g:if test="${candidate.id}">
	                    	<g:actionSubmit class="delete button" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
	                    </g:if>
				        <a class="back button" onclick="goBack()" title="Go Back">Back</a>
	                </div>
	            </g:if>
                <g:hiddenField name="saveIt" value="true"/>
            </g:form>
          	<g:if test="${params.action == 'show'}">
          	    <p> Resume created: ${candidate.created} </p><br/>
          	    <g:if test="${resume}">
	                <g:link action="downloadResume" params="[qualifiedResume:resume]" title="Download resume" >Resume</g:link>
                </g:if>
	          	<g:if test="${req}">
		            <% def reqCandi = req.candidates.find{it.candidate = candidate} %>
		            
		        	<g:if test="${'DAFFRON' == Environment.getCurrent().name}">
			            <h2>Pre-Screen Questions:</h2>
			            ${req.jobD.emailQuiz.encodeAsHTML().replaceAll(/&.*;/,' ').replaceAll(/\n/, '<br/>')}
			            <h3>Response:</h3>
			            ${reqCandi?.emailQuizReply?.encodeAsHTML()?.replaceAll(/&.*;/,' ')?.replaceAll(/\n/, '<br/>')}
			            <h2>Phone Interview Questions:</h2>
			            ${req.jobD.phoneQuiz.encodeAsHTML().replaceAll(/&.*;/,' ').replaceAll(/\n/, '<br/>')}
			            ${reqCandi?.phoneQuiz?.encodeAsHTML()?.replaceAll(/&.*;/,' ')?.replaceAll(/\n/, '<br/>')}
			            <h3>Response:</h3>
			            ${reqCandi?.phoneQuizReply?.encodeAsHTML()?.replaceAll(/&.*;/,' ')?.replaceAll(/\n/, '<br/>')}
			        </g:if>
	          	</g:if>
          	</g:if>
        </div>
        <g:if test="${!params.pdf}">
        <g:javascript>
          $('#empAppForm').submit(function() { 
            $('.phone').each(function() {
                var phone = $(this);
                phone.val(phone.val().replace(/[-\D]/g,''));
            });
            $('.mmyy').each(function() {
                var mmyy = $(this);
                mmyy.val(mmyy.val().replace(/\D/,''));
                if (mmyy.val() == '') {
                    mmyy.val('0'); // otherwise get a String to int conversion error
                }
            });
            $('.miles').each(function() {
                if ($(this).val() == '') {
                    $(this).val('0'); // otherwise get a String to int conversion error
                }
            });
            var allYesNoChecked = true;
            $('.yesNo').each(function() {
                var id = this.name; 
                if (!$('input[name='+id+']').is(':checked')) {
                    alert('Please answer the question: '+$('dt', $(this).parent().parent()).html());
                    this.focus();
                    allYesNoChecked = false;
                    return false;
                }
            });
            if (!allYesNoChecked) {
                return false;
            }
	        var allAccidentNumericsSet = true;
	        $('.checkNumeric').each( function() {
	           var inp = $(this);
	           inp.val(inp.val().replace(/\D*/,''));
	           if  (inp.val().length == 0) {
			     inp.attr('name').match(/accidents\[\d\].(.*)/);
			     var fieldName = RegExp.$1;  
	             alert('Please provide a numeric value for '+ fieldName);
	             inp.focus();
	             allAccidentNumericsSet = false;
	             return false;
	           }
	        });
            if (!allAccidentNumericsSet) {
                return false;
            }
            // for any education record with a description, there should be a study and years
            var allEduOk = true
            $.each( $('input').filter(function() {return this.name.match(/^education\[\d\].descr/)}),
                    function() {
                        var descr = $(this).val();
                        if (descr) {
                            $(this).attr('id').match(/^education.(\d).*/);
                            var index = RegExp.$1;
                            var study = $('#education_'+index+'_study');
                            if (study == null || study.val() == null || study.val() == '' || $.trim(study.val()) == '') {
                                alert('Please enter acourse of study for all education entries');
                                study.parent().addClass('errors');
                                study.focus();
                                allEduOk = false;
                            } else {
                                study.parent().removeClass('errors');
                            }
                            var yearsOk = false;
                            for (y = 1; y <= 12; y++) {  // years 1-4 and 9-12
                                if (y > 4 && y < 9) continue;
	                            var years = $('#education_'+index+'_years'+y);
	                            if (years.is(':checked')) {
	                               yearsOk = true;
	                               break;
	                            } 
                            } 
                            if (!yearsOk) {
                                alert('Please select a Grade or Year Completed for all education entries');
                                allEduOk = false;
                            }
                        }
                    }
            ); 
            if (!allEduOk) {
                return false;
            }
            return true;
          }); // end of submit form event 
          
          $(".date" ).datepicker(); // jquery datePicker init
          
          $('fieldset.empapp legend a').click(function() {
          	var imgUrl = $('img', this).attr('src');
          	var div = $('+ div', $(this).parent());
          	if (div.is(":visible")) {
          		$('img', this).attr('src', imgUrl.replace('collapse', 'expand'));
          		div.hide();
          	} else {
          		$('img', this).attr('src', imgUrl.replace('expand', 'collapse'));
          		div.show();
          	}
          });
          $('.contactEmployer').click(function() { 
            var id = this.id.toString()
            id = id.replace("].contact", '_whyNoContactPrompt');
            id = id.replace("[", '_');
            if ($(this).is(':checked')) {
              $('#'+id).hide();
            } else {
              $('#'+id).show();
            }
          });
          
			$('#addHistory').click(function() {
		       $.ajax({
		            url: "${createLink(action:'employmentHistory')}", 
		            data: "iHist="+$('table.historyTable').length,
		            type: "POST",
		            success: function(resp) {
		            		$('#addHistoryDiv').before(resp);
                        	setHistoryRemoveHandlers(); 
		           	},
		            error: function(XMLHttpRequest, textStatus, errorThrown) {alert(textStatus);}
		        });
        	});
        	$('#noAccidents').click(function() {
        	   if ($('#noAccidents').is(':checked')) {
	        		$('#accidents').remove();
	        		$('#addAccident').remove();
        		} else {
			       $.ajax({
			            url: "${createLink(action:'promptAccidents')}", 
			            type: "POST",
			            success: function(data) { $('#noAccidents').after(data); },
			            error: function(XMLHttpRequest, textStatus, errorThrown) {alert(textStatus);}
			        });
        		}
        	});
        	$('#noViolations').click(function() {
        	   if ($('#noViolations').is(':checked')) {
	        		$('#violations').remove();
	        		$('#addViolation').remove();
        		} else {
			       $.ajax({
			            url: "${createLink(action:'promptViolations')}", 
			            type: "POST",
			            success: function(data) { $('#noViolations').after(data); },
			            error: function(XMLHttpRequest, textStatus, errorThrown) {alert(textStatus);}
			        });
        		}
        	});
	        setReindexInputArray();
			$('.date').datepicker();
		    $('input[value=notapplicable]').click(function() {
		      $('#cdl').remove(); 
		    });
		    
		    // remove duplicate errors cause by history[0].toMMYY and history[0][1].toMMYY strangeness 
		    var lastError = ''
		    $('div.errors > ul').children().each(function (index, element) {
		      if ($(element).html() == lastError) {
		         $(element).remove(); 
		      } 
		      lastError = $(element).html();
		    });
			setHistoryRemoveHandlers(); 
		    <g:if test="${action == 'show'}">
			      $('form input').attr('disabled', true);
			      $('form .buttons input').attr('disabled', false);
		    </g:if>
        </g:javascript>
        </g:if>
    </body>
</html>
