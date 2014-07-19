<%@ page import="org.codehaus.groovy.grails.commons.ConfigurationHolder" %>
<%@ page import="daffron.fms.hr.recruiting.Candidate" %>
<%@ page import="daffron.fms.hr.recruiting.Candidate" %>
<%@ page import="daffron.fms.hr.recruiting.DriverExperience" %>
<%@ page import="daffron.fms.hr.recruiting.Requisition" %>
<%@ page import="daffron.fms.hr.recruiting.YesNo" %>
<%@ page import="daffron.fms.hr.recruiting.YesNoAns" %>
<%@ page import="grails.util.Environment" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="application/xhtml+xml; charset=UTF-8" />
        <g:set var="entityName" value="${message(code: 'candidate.label', default: 'Candidate')}" />
        <link rel="stylesheet" href="${resource(dir:'css',file:'printApp.css')}" type="text/css" media="all"></link>
        <title>Print Application</title>   
        <% if (params.pdf) {%>
        <link rel="stylesheet" href="${resource(dir:'css',file:'pdfPrintApp.css')}"  media="print"/>
        <% } %>            
    </head>
    <body>
        <g:hiddenField name="requisitionId" value="${req?.id}" />
        <g:hiddenField name="id" value="${candidate?.id}" />
        <g:hiddenField name="version" value="${candidate?.version}" />
        <div id="mainContent">
            <div class="logo">
                <g:if test="${params.pdf}">
                    <img src="${resource(dir:'images/recruitment',file:ConfigurationHolder.config.hr.company.replaceAll(' ', '-')+'Logo_GS.jpg')}" />
                </g:if>
                <g:else>
                    <img src="/hr/plugins/payrolldb-0.1/images/recruitment/${ConfigurationHolder.config.hr.company.replaceAll(' ', '-')}Logo_GS.jpg" width="528px" height="96px" align="left" style="margin-bottom: 10px; border: 0;" />
                </g:else>
            </div>
            <h1>APPLICATION FOR EMPLOYMENT</h1>
            <p>We appreciate your interest in ${ConfigurationHolder.config.hr.company}.  The following information is required to help 
                us make the best possible placement within the Company.  Please print and complete all portions of the application that 
                pertain to you.  Failure to complete all applicable information may disqualify you from consideration</p>
            <p><b>${ConfigurationHolder.config.hr.company} is an Equal Opportunity Employer and, in accordance with Federal, State, and 
                Local laws, considers all qualified applicants regardless of race, color, religion, gender (including pregnancy), national 
                origin, age, height, weight, sexual orientation, political beliefs, marital or veteran status or any disability that does 
                not prevent the individual from performing the essential functions of the position with or without reasonable accommodation.</b></p>
            <p>If mailing, please return to: Human Resources, ${ConfigurationHolder.config.hr.company}, ${ConfigurationHolder.config.hr.address}</p>
            <table cellspacing="0" cellpadding="0">
                <tr>
                    <td colspan="3">Position(s) applied for (be specific)<br />${req?.jobD}</td>
                    <td>Date<br />${candidate?.created?g.formatDate(format:'MM/dd/yyyy', date:candidate?.created):'&#160;'}</td>
                </tr>
                <tr>
                    <td colspan="2">Type of employment desired (check all that apply)<br />   
                        <img src="../../images/YesNo/${req.regular}_check.jpg" alt="" width="10px" height="10px" />&#160;Regular&#160;&#160;&#160;
                        <img src="../../images/YesNo/${req.fullTime}_check.jpg" alt="" width="10px" height="10px" />&#160;Full Time&#160;&#160;&#160;
                        <img src="../../images/YesNo/${req.partTime}_check.jpg" alt="" width="10px" height="10px" />&#160;Part Time&#160;&#160;&#160;
                        <img src="" alt="../../images/YesNo/${req.temporary}_check.jpg" width="10px" height="10px" />&#160;Temporary
                    </td>
                    <td colspan="2">Salary Range Desired<br />&#160;</td>
                </tr>
                <tr>
                    <td colspan="4">
                        Which of the following worksites are you considering? (check all that apply)<br />
                        ${req?.workSite?:'&#160;'}
                    </td>
                </tr>
            </table>
            <table cellspacing="0" cellpadding="0">
                <tr>
                    <td colspan="5" class="bg"><span class="h2">Personal Data</span></td>
                </tr>
                <tr>
                    <td colspan="5">Name (Last*, First, MI)<br />${candidate?.name}</td>
                </tr>
                <tr>
                    <td colspan="5">*Is any additional information relative to a different name necessary to check your work record 
                        or references? <br />
                        If yes, please explain: </td>
                </tr>
                <tr>
                    <td colspan="3">Mailing Address<br />${candidate?.addr?.line1}</td>
                    <td>Preferred Contact Number<br /><daffron:formatPhone phone="${candidate?.phoneNo}" /></td>
                    <td>Alternate Contact Number<br /><daffron:formatPhone phone="${candidate?.altPhoneNo}" /></td>
                </tr>
                <tr>
                    <td>City<br />${candidate?.addr?.city}</td>
                    <td>State<br />${candidate?.addr?.state}</td>
                    <td>Zip<br />${candidate?.addr?.zip}</td>
                    <td colspan="2"><g:set var="question" value="${YesNo.findByShortName('over18')}" />
                        ${question?.question}<br />
                        <img src="../../images/YesNo/${candidate?.yesNoAns.find{it.yesNo?.id == question?.id}?.answer}.jpg" alt="" width="80px" height="11px" />
                    </td>
                </tr>
                <tr>
                    <td colspan="3">E-mail Address (if available)<br />${candidate?.email}</td>
                    <td colspan="2"><g:set var="question" value="${YesNo.findByShortName('us citizen')}" />
	                    ${question?.question}<br />
	                    <img src="../../images/YesNo/${candidate?.yesNoAns.find{it.yesNo?.id == question?.id}?.answer}.jpg" alt="" width="80px" height="11px" />
                    </td>
                </tr>
                <tr>
                    <td colspan="5">How were you referred to the Company?<br />${candidate?.refer?:'&#160;'}</td>
                </tr>
                <tr>
                    <td colspan="5">Please list any relatives or friends currently employed with the Company and your relationship 
                        to them.<br />${candidate?.relations?:'&#160;'}                        
                    </td>
                </tr>
                <tr>
                    <td colspan="5">Have you ever worked for the Company before? <br />
                        If yes, when? </td>
                </tr>
                <g:if test="${Environment.current != 'DAFFRON'}">
                    <g:set var="question" value="${YesNo.findByShortName('MO driver')}" />
                    <g:if test="question">
		                <tr>
		                    <td colspan="5">
				                    ${question?.question}<br />
				                    <img src="../../images/YesNo/${candidate?.yesNoAns.find{it.yesNo?.id == question?.id}?.answer}.jpg" alt="" width="80px" height="11px" />
		                    </td>
		                </tr>
	                </g:if>
                </g:if>
                <tr>
                    <td><g:set var="question" value="${YesNo.findByShortName('overtime')}" />
	                    ${question?.question}<br />
	                    <img src="../../images/YesNo/${candidate?.yesNoAns.find{it.yesNo?.id == question?.id}?.answer}.jpg" alt="" width="80px" height="11px" />
                    </td>
                    <td colspan="4"><g:set var="question" value="${YesNo.findByShortName('holidays')}" />
	                    ${question?.question}<br />
	                    <img src="../../images/YesNo/${candidate?.yesNoAns.find{it.yesNo?.id == question?.id}?.answer}.jpg" alt="" width="80px" height="11px" />
                    </td>
                </tr>
                <tr>
                    <td>If selected for employment, on what date can you start?<br />
                        ${candidate?.ableStart?g.formatDate(format:'MM/dd/yyyy', date:candidate?.ableStart):'&#160;'}
                    </td>
                    <g:if test="${!ConfigurationHolder.config.hr.company == "Daffron &#38; Associates Inc"}">
	                    <td colspan="4"><g:set var="question" value="${YesNo.findByShortName('on call')}" />
		                    ${question?.question}<br />
		                    <img src="../../images/YesNo/${candidate?.yesNoAns.find{it.yesNo?.id == question?.id}?.answer}.jpg" alt="" width="80px" height="11px" />
	                    </td>
                    </g:if>
                </tr>
            </table>            
            <div class="break"></div>
            <table cellspacing="0" cellpadding="0">
                <tr>
                    <td><g:set var="question" value="${YesNo.findByShortName('convicted of crime')}" />
                        ${question?.question} &#160;&#160;
                        <img src="../../images/YesNo/${candidate?.yesNoAns.find{it.yesNo?.id == question?.id}?.answer}.jpg" alt="" width="80px" height="11px" />
                        <br />
                        If yes, please explain fully on a separate sheet of paper including jurisdiction (state and county) where such 
                        convictions occurred.<br />
                        (Conviction of a crime is not an automatic bar to employment - all circumstances will be considered.  However, 
                        failure to disclose a conviction will exclude you from further consideration.)
                    </td>
                </tr>
                <tr>
                    <td><g:set var="question" value="${YesNo.findByShortName('criminal charges')}" />
                        ${question?.question} &#160;&#160;
                        <img src="../../images/YesNo/${candidate?.yesNoAns.find{it.yesNo?.id == question?.id}?.answer}.jpg" alt="" width="80px" height="11px" />
                        <br />
                        If yes, please explain fully on a separate sheet of paper.
                    </td>
                </tr>
                <g:if test="${!ConfigurationHolder.config.hr.company == "Daffron &#38; Associates Inc"}">
	                <tr>
	                    <td><g:set var="question" value="${YesNo.findByShortName('convicted power diversion')}" />
	                        ${question?.question} &#160;&#160;
	                        <img src="../../images/YesNo/${candidate?.yesNoAns.find{it.yesNo?.id == question?.id}?.answer}.jpg" alt="" width="80px" height="11px" />
	                        <br />
	                        If yes, please explain fully on a separate sheet of paper including jurisdiction (state and county) where such 
	                        conviction(s) occurred.<br />
	                        (Conviction of a crime is not an automatic bar to employment - all circumstances will be considered.  However, 
	                        failure to disclose a conviction will exclude you from further consideration.)
	                    </td>
	                </tr>
                </g:if>
            </table>
            <table cellspacing="0" cellpadding="0">
                <tr>
                    <td colspan="4" class="bg"><span class="h2">Education</span></td>
                </tr>
                <tr>
                    <td>Name and Location of School (City &#38; State)</td>
                    <td>Circle Last Grade or Year Completed</td>
                    <td>Major/Field of Study</td>
                    <td>List Diploma or Degree</td>
                </tr>
                <tr>
                    <g:set var="highSchoolEdu" value="${candidate.education?.find{it.highOrGED}}"/>
                    <td>${highSchoolEdu?highSchoolEdu.descr:'High School or GED'}</td>
                    <td>
                        <g:each var="y" in="${ (9..12) }">
                            <g:if test="${highSchoolEdu?.years == y}">
                                <img src="../../images/edu/${highSchoolEdu?.years}_circle.jpg" alt="" width="20px" height="18px" />
                           </g:if>
                           <g:else>
                                <img src="../../images/edu/${y}.jpg" alt="" width="20px" height="18px" />
                           </g:else>
                        </g:each>                        
                    </td>
                    <td>${highSchoolEdu?.study}</td>
                    <td>${highSchoolEdu?.degree}</td>
                </tr>
                <g:set var="edu" value="${candidate.education?.findAll{!it.highOrGED}?.toArray()?.sort{it.years}?.reverse()}"/>
                <g:each var="i" in="${ (1..3) }">
                    <tr>
                        <td>${(edu?.size() >= i)?edu[i-1].descr:'&#160;'}</td>
                        <td>
                            <g:each var="y" in="${ (1..4) }">
                                <g:if test="${(edu?.size() >= i && edu[i-1].years == y)}">
                                    <img src="../../images/edu/${edu[i-1].years}_circle.jpg" alt="" width="20px" height="18px" />
                                </g:if>
                                <g:else>
                                    <img src="../../images/edu/${y}.jpg" alt="" width="20px" height="18px" />
                                </g:else>
                            </g:each>
                        </td>
                        <td>${(edu?.size() >= i)?edu[i-1].study:'&#160;'}</td>
                        <td>${(edu?.size() >= i)?edu[i-1].degree:'&#160;'}</td>
                    </tr>
                </g:each>
                <tr>
                    <td colspan="4" class="bg"><span class="h2">United States Military Service</span></td>
                </tr>
                <tr>
                    <td>Branch<br />
                        ${candidate?.military?.branch}
                    </td>
                    <td>Rank<br />
                        ${candidate?.military?.rank}
                    </td>
                    <td>Years Served<br />
                        ${candidate?.military?.years}
                    </td>
                    <td>Date of Discharge<br />
                        ${date?g.formatDate(format:'yyyy', date:date):'&#160;'}
                    </td>
                </tr>
                <tr>
                    <td colspan="4">Please list relevant skills acquired during your service in the U.S. Military, if applicable.</td>                    
                </tr>
                <tr>
                    <td colspan="4">${candidate?.military?.skills?:'&#160;'}</td>
                </tr>
                <tr>
                    <td colspan="4">List any training or special skills you have that are relevant to the position for which you are 
                        applying, such as: proficiency in software programs,<g:if test="${!ConfigurationHolder.config.hr.company == "Daffron &#38; Associates Inc"}"> 
                        journeyman certificates,</g:if> self-employment experiences, 
                        licensing or self-improvement courses.                    
                    </td>
                </tr>
                <tr>
                    <td colspan="4">&#160;</td>
                </tr>
                <tr>
                    <td colspan="4">List your membership in any professional or technical organizations that are related to the job 
                        requirements of the position for which you are applying.  Exclude those that may disclose your race, color, 
                        religion, gender (including pregnancy), national origin, age, height, weight, marital or veteran status, 
                        disability, or political or union affiliations.                    
                    </td>
                </tr>
                <tr>
                    <td colspan="4">&#160;</td>
                </tr>
            </table>
            <div class="break"></div>
            <table cellspacing="0" cellpadding="0">                
                <tr>
                    <td colspan="4" class="bg"><span class="h2">Employment History</span> (List below last three employers, starting with the most recent.  CDL 
                        applicants MUST include all positions held within the last 10 years.  Additional space is available on page 5 
                        of application.)</td>
                </tr>                
                <g:set var="jobCount" value="${candidate?.history?.size()?:0}"/>                
                <g:if test="${candidate.id}">
                    <tr> 
                        <td colspan="4">No Prior Employment History&#160;
                        <img src="../../images/YesNo/${jobCount == 0}_check.jpg" alt="" width="10px" height="10px" /></td> 
                    </tr>	                
                          <g:each var="iHist" in="${(0..3)}">
                          <g:set var="hist" value="${(candidate?.history?.size() >= (iHist+1))?candidate?.history.toArray()[iHist]:null}"/>                            
                            <tr>
						        <td style="width: 32%;" class="<g:if test="${hist && candidate?.errors.getFieldError('history.position')?.rejectedValue == hist?.position}">errors</g:if>" >
						          <label for="history[${iHist}].position">
					              <g:if test="${iHist == 0}">Present or Last</g:if>
						          <g:else>Next Previous</g:else>
				                    Position Held</label><br />
						          ${hist?.position?:'&#160;'}
						        </td>
						        <td style="width: 18%;" class="<g:if test="${hist && candidate?.errors.getFieldError('history.fromMMYY')?.rejectedValue == hist?.fromMMYY}">errors</g:if>" >
						          <label for="history[${iHist}].fromMMYY">From Month/Year</label><br />
						              ${hist?.fromMMYY?daffron.formatMMYY(number:hist.fromMMYY):'&#160;'}
						       </td>
						       <td style="width: 18%;" class="<g:if test="${hist && candidate?.errors.getFieldError('history.toMMYY')?.rejectedValue == hist?.toMMYY}">errors</g:if>" >
						         <label for="history[${iHist}].toMMYY">To Month/Year</label><br />
						             ${hist?.toMMYY?daffron.formatMMYY(number:hist.toMMYY):'&#160;'}
						       </td>
						       <td style="width: 32%;" class="<g:if test="${hist && candidate?.errors.getFieldError('history.ending')?.rejectedValue == hist?.ending}">errors</g:if>" >
						         <label for="history[${iHist}].ending">Ending Salary/Rate of Pay</label><br />
						             ${hist?.ending?:'&#160;'}
						       </td>
						   </tr>
						   <tr>
						      <td colspan="2" <g:if test="${hist && candidate?.errors.getFieldError('history.supervisor')?.rejectedValue == hist?.supervisor}">class="errors"</g:if> >
                                 <label for="history[${iHist}].supervisor">Name and Title of Supervisor</label><br />
                                     ${hist?.supervisor?:'&#160;'}
                               </td>
                               <td colspan="2" <g:if test="${hist && candidate?.errors.getFieldError('history.contactPhone')?.rejectedValue == hist?.contactPhone}">class="errors"</g:if> >
                                 <label for="history[${iHist}].contactPhone">Supervisor Contact Number</label><br />
                                     <daffron:formatPhone phone="${hist?.contactPhone?:'&#160;'}" />
                               </td>
						   </tr>
						   <tr>
						       <td colspan="2" <g:if test="${hist && candidate?.errors.getFieldError('history.company')?.rejectedValue == hist?.company}">class="errors"</g:if> >
						         <label for="history[${iHist}].company">Company Name</label><br />
						         ${hist?.company?:'&#160;'}
						       </td>
						       <td colspan="2" <g:if test="${hist && candidate?.errors.getFieldError('history.business')?.rejectedValue == hist?.business}">class="errors"</g:if> >
						         <label for="history[${iHist}].business">Type of Business</label><br />
					             ${hist?.business?:'&#160;'}
						       </td>						       
					       </tr>
						   <tr>
						       <td colspan="2" <g:if test="${hist && candidate?.errors.getFieldError('history.addr.line1')?.rejectedValue == hist?.addr?.line1}">class="errors"</g:if> >
						         <label for="history[${iHist}].addr.line1">Address</label><br />
						             ${hist?.addr?.line1?:'&#160;'}
						         </td>
						       <td colspan="2" <g:if test="${hist && candidate?.errors.getFieldError('history.addr.city')?.rejectedValue == hist?.addr?.city}">class="errors"</g:if> >
						         <label for="history[${iHist}].addr.city">City, State and Zip</label><br />
						             ${hist?.addr?.city?:'&#160;'}, ${hist?.addr?.state?:'&#160;'} ${hist?.addr?.zip?:'&#160;'}
						       </td>
						     </tr>
						     <tr>
						       <td colspan="2" <g:if test="${hist && candidate?.errors.getFieldError('history.duties')?.rejectedValue == hist?.duties}">class="errors"</g:if> >
						         <label for="history[${iHist}].duties">Briefly describe your duties</label><br />
						             ${hist?.duties?:'&#160;'}
						       </td>
						       <td colspan="2" <g:if test="${hist && candidate?.errors.getFieldError('history.whyLeft')?.rejectedValue == hist?.whyLeft}">class="errors"</g:if> >
						         <label for="history[${iHist}].whyLeft">What were your reasons for leaving?</label><br />
						             ${hist?.whyLeft?:'&#160;'}
						       </td>
						     </tr>
						     <tr>
						       <td colspan="4" <g:if test="${hist && candidate?.errors.getFieldError('history.whyNoContact')?.rejectedValue == hist?.whyNoContact}">class="errors"</g:if> >
					            May we contact this employer?&#160; 
					              <img src="../../images/YesNo/${hist?.contact}.jpg" alt="" width="80px" height="11px" />
					            &#160;&#160;&#160;
				              If not, please explain:&#160;${hist?.whyNoContact?:'&#160;'}
					       </td>
					     </tr>
					     <tr>
					      <td colspan="4" class="break">&#160;</td>
					     </tr>
                        </g:each>
                    </g:if>
                <tr>
                    <td colspan="4">Please explain any gaps in employment: 
                    
                    </td>
                </tr>
            </table>   
            <g:if test="${!ConfigurationHolder.config.hr.company == "Daffron &#38; Associates Inc"}">                     
	            <div class="break"></div>
	            <table cellspacing="0" cellpadding="0">
	                <tr>
	                    <td><g:set var="question" value="${YesNo.findByShortName('cdlEligible')}" />
	                        <g:set var="answer" value="${candidate?.yesNoAns.find{it.yesNo?.id == question?.id}}" />
	                        ${question?.question}<br />
	                            Yes <input type="radio" name="yesNoWithIdOf${question?.id}" id="yesNoWithIdOf${question?.id}" 
	                                value="${answer?.answer == true?'checked="checked"':''}" />
	                            No <input type="radio" name="yesNoWithIdOf${question?.id}" id="yesNoWithIdOf${question?.id}" 
	                                value="${answer?.answer == false?'checked="checked"':''}" />
	                            N/A <input type="radio" name="yesNoWithIdOf${question?.id}" id="yesNoWithIdOf${question?.id}" value="notapplicable" />
	                    
	                    </td>
	                    <td><g:set var="question" value="${YesNo.findByShortName('cdl')}" />
	                        <g:set var="answer" value="${candidate?.yesNoAns.find{it.yesNo?.id == question?.id}}" />
	                        ${question?.question}<br />
	                            Yes <input type="radio" name="yesNoWithIdOf${question?.id}" id="yesNoWithIdOf${question?.id}" 
	                                value="${answer?.answer == true?'checked="checked"':''}" />
	                            No <input type="radio" name="yesNoWithIdOf${question?.id}" id="yesNoWithIdOf${question?.id}" 
	                                value="${answer?.answer == false?'checked="checked"':''}" />
	                            N/A <input type="radio" name="yesNoWithIdOf${question?.id}" id="yesNoWithIdOf${question?.id}" value="notapplicable" />
	                    
	                    </td>
	                </tr>
	            </table>
	            <table cellspacing="0" cellpadding="0" class="colorBG">
	                <tr>
	                    <td colspan="5" class="bg"><span class="h2">Commercial Driver's License</span> (Complete ONLY if position for which you are applying requires 
	                        CDL.)&#160;<b>NON-CDL applicants, please skip to Personal References section on page 6.</b></td>
	                </tr>
	                <tr>
	                    <td colspan="5">Accident record for past 3 years or more (attach sheet if more space is needed).  If none, write &#34;none&#34;: 
	                        <g:if test="${candidate?.noAccidents}"><b>none</b></g:if>
	                    </td>
	                </tr>
	                <tr>
			            <td>Date</td>
			            <td>Nature of Accident</td>
			            <td>Fatalities</td>
			            <td>Injuries</td>
			            <td>Hazardous Material Spill</td>
			        </tr>
			        <g:each var="iAccident" in="${ (0..(candidate?.accidents?.size()?candidate.accidents.size()-1:2)) }">
			        <g:set var="acci" value="${(candidate?.accidents?.size())?candidate?.accidents?.toArray()[iAccident]:null}" />
			          <tr>
			            <td>
			                <% def date = acci?.date?:'' %>
			                ${date?g.formatDate(format:'MM/dd/yyyy', date:date):''}
			                <g:hiddenField name="ajax${iAccident}" class="ajaxInfo" action="removeDriverAccident" rowId="${acci?.id?:0}"/>
			            </td>
			            <td>${acci?.nature?:'&#160;'}</td>
			            <td>${acci?.fatalities?:'&#160;'}</td>
			            <td>${acci?.injuries?:'&#160;'}</td>
			            <td>${acci?.hasMat?:'&#160;'}</td>
			          </tr>
			        </g:each>
		        </table>
		        <table cellpadding="0" cellspacing="0" class="colorBG">
	                <tr>
	                    <td colspan="4">Traffic convictions and forfeitures for the past 3 years (attach sheet if more space is needed) other than
	                        parking violations.  If none, write &#34;none&#34;: <g:if test=""></g:if></td>
	                </tr>
	                <tr>
			            <td class="fourCol">Date</td>
			            <td class="fourCol">Location</td>
			            <td class="fourCol">Charge</td>
			            <td class="fourCol">Penalty</td>
			        </tr>
			        <g:each var="iViolation" in="${ (0..(candidate?.violations?.size()?candidate.violations.size()-1:2)) }">
		            <g:set var="viola" value="${(candidate?.violations?.size())?candidate?.violations?.toArray()[iViolation]:null}" />
		               <tr>
		                   <td>
				                <% def date = viola?.date?:'' %>
				                ${date?g.formatDate(format:'MM/dd/yyyy', date:date):'&#160;'}
				           </td>
				           <td>${viola?.location?:'&#160;'}</td>
				           <td>${viola?.charge?:'&#160;'}</td>
				           <td>${viola?.penalty?:'&#160;'}</td>
		               </tr>
		        </g:each>
		        </table>
		        <table cellpadding="0" cellspacing="0" class="colorBG">
	                <tr>
	                    <td colspan="4">List all driver's licenses held in the past 3 years</td>
	                </tr>
	                <tr>
	                    <td>State</td>
	                    <td>License No.</td>
	                    <td>Type</td>
	                    <td>Expireation Date</td>
	                </tr>
	                <tr>
	                    <td>&#160;</td>
	                    <td>&#160;</td>
	                    <td>&#160;</td>
	                    <td>&#160;</td>
	                </tr>
	                <tr>
	                    <td>&#160;</td>
	                    <td>&#160;</td>
	                    <td>&#160;</td>
	                    <td>&#160;</td>
	                </tr>
	                <tr>
	                    <td>&#160;</td>
	                    <td>&#160;</td>
	                    <td>&#160;</td>
	                    <td>&#160;</td>
	                </tr>
	            </table>
	            <table cellpadding="0" cellspacing="0" class="colorBG">
	                <tr>
	                    <td>Have you ever been denied a license, permit or priviledge to operate a motor 
	                        vehicle? &#160;&#160;If yes, please provide details:</td>
	                </tr>
	                <tr>
	                    <td>&#160;</td>
	                </tr>
	                <tr>
	                    <td>Has any license, permit or priviledge ever been suspended or revoked? &#160;&#160;
	                        If yes, please provide details:</td>
	                </tr>
	                <tr>
	                    <td>&#160;</td>
	                </tr>
	            </table>
	            <table cellpadding="0" cellspacing="0" class="colorBG">
	                <tr>
	                    <td colspan="5">Driving Experience:</td>
	                </tr>
	                <tr>
	                     <td class="noBorder">Class of Equipment</td>
	                     <td class="noBorder">Type of Equipment</td>
	                     <td colspan="2" class="noBorder">Dates</td>
	                     <td class="noBorder">Approx. No. of Miles (total)</td>
	                </tr>
	                <tr>
	                    <td class="noBorder">(check yes or no)</td>
	                    <td class="noBorder">(circle)</td>
	                    <td class="noRight">From (M/Y)</td>
	                    <td class="noBorder">To (M/Y)</td>
	                    <td class="noBorder">&#160;</td>
	                </tr>
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
	                        ${exp?daffron.formatMMYY(number:exp.fromMMYY):'&#160;'}
	                    </td>
	                    <td <g:if test="${exp && candidate?.errors.getFieldError('driverExperience.toMMYY')?.rejectedValue == exp.toMMYY}">class="errors"</g:if> >
	                        ${exp?daffron.formatMMYY(number:exp.toMMYY):'&#160;'}
	                    </td>
	                    <td <g:if test="${exp && candidate?.errors.getFieldError('driverExperience.miles')?.rejectedValue == exp.miles}">class="errors"</g:if> >
	                        ${exp?g.formatNumber(number:exp.miles,format:'###,###,##0'):'&#160;'}
	                    </td>
	                </tr>
	            </g:each>
	            </table>
	            <table cellpadding="0" cellspacing="0" class="colorBG">
	                <tr>
	                    <td>List states operated in for last five (5) years:</td>
	                </tr>
	                <tr>
	                    <td>&#160;</td>
	                </tr>
	                <tr>
	                    <td>List special courses or trainging that will help you as a driver:</td>
	                </tr>
	                <tr>
	                    <td>&#160;</td>
	                </tr>
	                <tr>
	                    <td>List any safe driving awards you have and who they are from:</td>
	                </tr>
	                <tr>
	                    <td>&#160;</td>
	                </tr>
	                <tr>
	                    <td>List any trucking, transportation or other experience that may help in your work for this company:</td>
	                </tr>
	                <tr>
	                    <td>&#160;</td>
	                </tr>
	                <tr>
	                    <td>List special equipment or technical materials you can work with (other than those already indicated):</td>
	                </tr>
	                <tr>
	                    <td>&#160;</td>
	                </tr>
	            </table>
            </g:if>
            <div class="break"></div>
            <table cellspacing="0" cellpadding="0">
                <tr>
                    <td colspan="4" class="bg"><span class="h2">Personal References</span> (List three references that are able to objectively evaluate your 
                        training/capabilities.)</td>
                </tr>
                <tr>
                    <td>Name &#38; Relationship to You<br />&#160;</td>
                    <td>City<br />&#160;</td>
                    <td>State<br />&#160;</td>
                    <td>Contact Number<br />&#160;</td>
                </tr>
                <tr>
                    <td>Name &#38; Relationship to You<br />&#160;</td>
                    <td>City<br />&#160;</td>
                    <td>State<br />&#160;</td>
                    <td>Contact Number<br />&#160;</td>
                </tr>
                <tr>
                    <td>Name &#38; Relationship to You<br />&#160;</td>
                    <td>City<br />&#160;</td>
                    <td>State<br />&#160;</td>
                    <td>Contact Number<br />&#160;</td>
                </tr>
                <tr>
                    <td colspan="4" class="bg"><span class="h2">Additional Information</span> (List any additional information relevant to your application and 
                        background)</td>
                </tr>
                <tr>
                    <td colspan="4">
                        &#160;
                    </td>
                </tr>
                <tr>
                    <td colspan="4" class="bg"><span class="h2">Acknowledgement</span></td>
                </tr>
            </table>
            <p><b>(Please read carefully and sign below)</b></p>
            <p>I certify that the information contained in this application is true and complete to the best of my knowledge.  I 
                understand that false or misleading statements or omissions from this application, or during the pre-employment 
                process, may result in denial of employment or in discharge from employment at any time.<br /><br />
                I also understand and agree to the following:
            </p>
            <ol>
                <li>I understand that this application is not an offer or a contract of employment.  I agree to conform to the 
                    rules, policies, regulations, terms and conditions of the Company and that my employment and compensation can 
                    be terminated, with or without cause, and with or without notice, at any time, at the option of the Company or 
                    myself.  I further understand that no person is authorized to make any representation contrary to the above 
                    statement unless such representation is approved by the Board of Directors and is embodied in a written agreement 
                    signed by the Chief Executive Officer of the Company.</li>
                <li><g:if test="${!ConfigurationHolder.config.hr.company == "Daffron &#38; Associates Inc"}">
                    I further understand that the Company may require a medical examination by a Company-designated physician (1) 
                    after I have received an offer of employment and prior to my commencement of employment duties; and (2) during the 
                    course of my employment as required by business necessity and for job-related purposes.  I hereby consent to such 
                    examinations and recognize that employment is contingent upon receipt of a satisfactory medical evaluation.</g:if>
                    I further understand and agree that prior to commencing employment or after I am employed, I may be requested to submit 
                    to random and/or reasonable suspicion tests to determine the presence of alcohol or drugs, and agree to the release 
                    of any such test results to appropriate Company personnel, and agree that if I refuse and/or fail such tests before 
                    commencing employment, my offer of employment will be revoked, of if I refuse and/or fail such tests after being 
                    employed, my employment will be terminated.</li>
                <li>I understand that if offered employment<g:if test="${ConfigurationHolder.config.hr.company == "Daffron &#38; Associates Inc"}"> 
                    at a United States location</g:if> I will be required to provide proof that I am a United States Citizen or alien lawfully 
                    authorized to work in the United States, within the time frame specified by the Company.</li>
                <li>No offer of benefits which I may have discussed with a Company representative is binding.  Any entitlement of 
                    benefits will be based only on the terms of any benefits plan.</li>
                <li>The Company strongly discourages its employees from engaging in paid outside work or jobs.  If offered employment, I 
                    understand that I must obtain prior approval from management before any outside employment or other paid work activity 
                    is undertaken.  Furthermore, I understand that I am permitted to engage in outside work only under the restrictions 
                    and procedures of company policy.</li>
                <li>I understand that this application will be considered active for a period of one (1) year from the date indicated 
                    below, after which it will be destroyed.  If I have not heard from the Company at the conclusion of this one year 
                    period, it is my responsibility to complete a new application if I still wish to be considered for employment by the 
                    Company.</li>
            </ol>
            <p><b>I agree that any claim or lawsuit, including, but not limited to, claims or lawsuits arising under federal or 
                state civil rights laws, relating to my employment and/or application for employment with ${ConfigurationHolder.config.hr.company} 
                must be filed no more than six (6) months after the date of the employment action that is the subject of the claim or 
                lawsuit.  I waive any statute of limitations to the contrary.</b></p>
            <p>In the event that I am offered and accept employment with the Company, the information contained herein will become 
                merged with the employment offer and my signature below indicates my understanding of and agreement to the terms above.</p>
            <br /><br /><br />
            <table class="sign">
                <tr>
                    <td class="sig"><hr /><br /><p style="margin-top: -15px;">Signature</p></td>
                    <td class="spacer">&#160;</td>
                    <td class="date"><hr /><br /><p style="margin-top: -15px;">Date</p></td>
                </tr>
                <tr>
                    <td colspan="3" style="border: none; height: 40px;">&#160;</td>
                </tr>
                <tr>
                    <td class="sig"><hr /><br /><p style="margin-top: -15px;">Printed Name</p></td>
                    <td class="spacer">&#160;</td>
                    <td class="date">&#160;</td>
                </tr>
            </table>
        </div>
    </body>
</html>