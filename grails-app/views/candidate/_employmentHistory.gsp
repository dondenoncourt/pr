<g:set var="hist" value="${(candidate?.history?.size() >= (iHist+1))?candidate?.history.toArray()[iHist]:null}"/>
<table class="historyTable" id="historyTable${iHist}">
 	<tbody>
 	 <g:if test="${iHist == 0 && jobCount == 0}"> 
 	      <tr> 
 	          <td class="emphasis" colspan="4"> No Prior Employment History <input type="checkbox" class="removeHistory"  iHist="${iHist}" employmentId="${iHist}"/> </td> 
          </tr> 
 	 </g:if>
     <tr>
		<td class="fourCol <g:if test="${hist && candidate?.errors?.getFieldError('history['+iHist+'].position')?.rejectedValue == hist?.position}">errors</g:if>" >
         <dl>
             <dt><label for="history[${iHist}].position">
              	<g:if test="${iHist == 0}">Present or Last</g:if>
              	<g:else>Next Previous</g:else>
              	Position Held
              	</label>
             </dt>
             <dd><g:textField name="history[${iHist}].position" value="${hist?.position?:''}" /></dd>
         </dl>
       </td>
       <td class="fourCol <g:if test="${hist && candidate?.errors?.getFieldError('history['+iHist+'].fromMMYY')?.rejectedValue == hist?.fromMMYY}">errors</g:if>" >
         <dl>
             <dt><label for="history[${iHist}].fromMMYY">From Month/Year</label></dt>
             <dd><g:textField name="history[${iHist}].fromMMYY" value="${hist?.fromMMYY?daffron.formatMMYY(number:hist.fromMMYY):''}" size="4" class="mmyy"/></dd>
         </dl>
       </td>
	   <td class="fourCol <g:if test="${hist && candidate?.errors?.getFieldError('history['+iHist+'].toMMYY')?.rejectedValue == hist?.toMMYY}">errors</g:if>" >
         <dl>
             <dt><label for="history[${iHist}].toMMYY">To Month/Year</label></dt>
             <dd>
                <g:textField name="history[${iHist}].toMMYY" id="history_${iHist}_toMMYY" value="${hist?.toMMYY?daffron.formatMMYY(number:hist?.toMMYY):''}" size="4" 
                    class="mmyy ${hist?.toMMYY == 9999?'hide':''}"/>
			 	<g:if test="${iHist == 0}"> 
	                Present <input type="checkbox" id="stillEmployed" ${hist?.toMMYY == 9999?'checked="checked"':''}/>
	            </g:if>
             </dd>
         </dl>
       </td>
       <td class="fourCol <g:if test="${hist && candidate?.errors?.getFieldError('history['+iHist+'].ending')}">errors</g:if>" >
         <dl>
             <dt><label for="history[${iHist}].ending">Ending Salary/Rate of Pay</label></dt>
             <dd><g:textField name="history[${iHist}].ending" value="${hist?.ending?:''}"/></dd>
         </dl>
       </td>
     </tr>
     <tr>
       <td <g:if test="${hist && candidate?.errors?.getFieldError('history['+iHist+'].company')}">class="errors"</g:if> >
         <dl>
             <dt><label for="history[${iHist}].company">Company Name</label></dt>
             <dd><g:textField name="history[${iHist}].company" value="${hist?.company?:''}" /></dd>
         </dl>
       </td>
       <td <g:if test="${hist && candidate?.errors?.getFieldError('history['+iHist+'].business')}">class="errors"</g:if> >
         <dl>
             <dt><label for="history[${iHist}].business">Type of Business</label></dt>
             <dd><g:textField name="history[${iHist}].business" value="${hist?.business?:''}" /></dd>
         </dl>
       </td>
       <td>
         <dl>
             <dt><label for="history[${iHist}].supervisor">Name and Title of Supervisor</label></dt>
             <dd><g:textField name="history[${iHist}].supervisor" value="${hist?.supervisor?:''}"  /></dd>
         </dl>
       </td>
       <td >
         <dl>
             <dt><label for="history[${iHist}].contactPhone">Supervisor Contact Number</label></dt>
             <dd>
                 <g:textField name="history[${iHist}].contactPhone" maxlength="13" class="phone" value="${daffron.formatPhone(phone:hist?.contactPhone)}" />
	         </dd>
         </dl>
       </td>
     </tr>
     <% def addrError = candidate?.errors?.getFieldError('history['+iHist+'].addr') %>
     <tr>
       <td <g:if test="${hist && (addrError && !hist?.addr?.line1 || candidate?.errors?.getFieldError('history['+iHist+'].addr.line1'))}">class="errors"</g:if> >
         <dl>
             <dt class="name"><label for="history[${iHist}].addr.line1">Address</label></dt>
             <dd class="value">
                 <g:textField name="history[${iHist}].addr.line1"  size="25" value="${hist?.addr?.line1?:''}" />
             </dd>
           </dl>
         </td>
       <td <g:if test="${hist && (addrError && !hist?.addr?.city || candidate?.errors?.getFieldError('history['+iHist+'].addr.city'))}">class="errors"</g:if> >
         <dl>
             <dt><label for="history[${iHist}].addr.city">City</label></dt>
             <dd>
           <g:textField name="history[${iHist}].addr.city" maxlength="15" value="${hist?.addr?.city?:''}" />
             </dd>
         </dl>
       </td>
       <td <g:if test="${hist && (addrError && !hist?.addr?.state || candidate?.errors?.getFieldError('history['+iHist+'].addr.state'))}">class="errors"</g:if> >
         <dl>
             <dt class="name"><label for="history[${iHist}].addr.state">State</label></dt>
             <dd class="value">
                 <g:textField name="history[${iHist}].addr.state" maxlength="2" size="2" value="${hist?.addr?.state?:''}"  />
             </dd>
         </dl>
       </td>
       <td <g:if test="${hist && (addrError && !hist?.addr?.zip || candidate?.errors?.getFieldError('history['+iHist+'].addr.zip'))}">class="errors"</g:if> >
         <dl>
             <dt class="name"><label for="addr.zip">Zip</label></dt>
             <dd class="value ${hasErrors(bean: candidate, field: 'addr.zip', 'errors')}">
                 <g:textField name="history[${iHist}].addr.zip" maxlength="10" size="10"  value="${hist?.addr?.zip?:''}"  />
             </dd>
         </dl>
       </td>
     </tr>
     <tr>
       <td colspan="2" <g:if test="${hist && candidate?.errors?.getFieldError('history['+iHist+'].duties')}">class="errors"</g:if> >
         <dl>
             <dt><label for="history[${iHist}].duties">Briefly describe your duties</label></dt>
             <dd><g:textArea name="history[${iHist}].duties" value="${hist?.duties?:''}" rows="1" cols="80"/> </dd>
         </dl>
       </td>
       <td colspan="2" <g:if test="${hist && candidate?.errors?.getFieldError('history['+iHist+'].whyLeft')}">class="errors"</g:if> >
         <dl>
             <dt><label for="history[${iHist}].whyLeft">What were your reasons for leaving?</label></dt>
             <dd><g:textArea name="history[${iHist}].whyLeft" value="${hist?.whyLeft?:''}" rows="1" cols="80"/></dd>
         </dl>
       </td>
     </tr>
     <tr>
       <td <g:if test="${hist && candidate?.errors?.getFieldError('history.['+iHist+']whyNoContact')}">class="errors"</g:if> >
            <b>May we contact this employer?</b>&#160; 
  		  <g:checkBox name="history[${iHist}].contact" class="contactEmployer" value="${hist?.contact?:false}" />
	   </td>
	   <td colspan="3">
           <span id="history_${iHist}_whyNoContactPrompt" class="${hist?.contact?'hide':''}" >
              <b>If not, please explain:</b>
             <g:textField name="history[${iHist}].whyNoContact" size="70"  value="${hist?.whyNoContact?:''}"  />
           </span>
       </td>
     </tr>
     
	   <tr>
	       <td>
           	  <g:if test="${params.action != 'show'}">
		           <div class="linkBtns">
		               <a class="delete button removeHistory" iHist="${iHist}" employmentId="${hist?.id}">Remove</a>
		           </div> 				
		      </g:if>
	       </td>
	   </tr>
	</tbody>
</table>