<table id="accidents" class="candidate">
    <thead>
        <tr>
            <th style="width: 17%;">Date</th>
            <th style="width: 18%;">Nature of Accident</th>
            <th style="width: 17%;">Fatalities</th>
            <th style="width: 18%;">Injuries</th>
            <th style="width: 18%;">Hazardous Material Spill</th>
            <th style="width: 12%;">Remove</th>
        </tr>
    </thead>
    <tbody>
      <g:each var="iAccident" in="${ (0..(candidate?.accidents?.size()?candidate.accidents.size()-1:0)) }">
          <g:set var="acci" value="${(candidate?.accidents?.size())?candidate?.accidents?.toArray()[iAccident]:null}" />
          <tr>
            <td>
                <% def date = acci?.date?:'' %>
	            <g:textField name="accidents[${iAccident}].date" value="${date?g.formatDate(format:'MM/dd/yyyy', date:date):''}" class="date"/>
	            <g:hiddenField name="ajax${iAccident}" class="ajaxInfo" action="removeDriverAccident" rowId="${acci?.id?:0}"/>
            </td>
            <td><g:textField name="accidents[${iAccident}].nature" value="${acci?.nature?:''}" /></td>
            <td><g:textField name="accidents[${iAccident}].fatalities" value="${acci?.fatalities?:''}" class="checkNumeric" /></td>
            <td><g:textField name="accidents[${iAccident}].injuries" value="${acci?.injuries?:''}"  class="checkNumeric"/></td>
            <td><g:textField name="accidents[${iAccident}].hasMat" value="${acci?.hasMat?:''}" /></td>
            <td><a class="remove">Remove</a></td>
          </tr>
    </g:each>
    </tbody>
</table>
<div class="appBtns linkBtns">
    <a id="addAccident" class="add button">Add Additional Accidents</a>
</div>
<g:if test="${!params.pdf}">
<g:javascript>
	$('.date').datepicker();
   	$('#addAccident').click(function() {
   		var newRow = $('#accidents tr').length - 1; // consider header
      	$('#accidents').append(
        	'<tr>'+
		      	'<td><input type="text" name="accidents['+newRow+'].date" id="accidents_'+newRow+'_DOTdate" /></td>'+
            	'<td><input type="text" name="accidents['+newRow+'].nature"/></td>'+
            	'<td><input type="text" name="accidents['+newRow+'].fatalities" class="checkNumeric"/></td>'+
            	'<td><input type="text" name="accidents['+newRow+'].injuries" class="checkNumeric"/></td>'+
            	'<td><input type="text" name="accidents['+newRow+'].hasMat"/></td>'+
            	'<td><a class="remove">Remove</a></td>'+
            	'</tr>'
            );
		$('#accidents_'+newRow+'_DOTdate').datepicker();
        setReindexInputArray();
   	});
</g:javascript>
</g:if>