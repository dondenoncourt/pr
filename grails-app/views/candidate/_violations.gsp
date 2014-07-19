<table id="violations" class="candidate">
    <thead>
        <tr>
            <th style="width: 22%;">Date</th>
            <th style="width: 22%;">Location</th>
            <th style="width: 22%;">Charge</th>
            <th style="width: 22%;">Penalty</th>
            <th style="width: 12%;">Remove</th>
        </tr>
    </thead>
    <tbody>
          <g:each var="iViolation" in="${ (0..(candidate?.violations?.size()?candidate.violations.size()-1:0)) }">
          <g:set var="viola" value="${(candidate?.violations?.size())?candidate?.violations?.toArray()[iViolation]:null}" />
          <tr>
            <td>
                <% def date = viola?.date?:'' %>
                <g:textField name="violations[${iViolation}].date" value="${date?g.formatDate(format:'MM/dd/yyyy', date:date):''}" class="date"/>
            </td>
            <td><g:textField name="violations[${iViolation}].location" value="${viola?.location?:''}" /></td>
            <td><g:textField name="violations[${iViolation}].charge" value="${viola?.charge?:''}" /></td>
            <td><g:textField name="violations[${iViolation}].penalty" value="${viola?.penalty?:''}" /></td>
            <td><a class="remove">Remove</a></td>
          </tr>
        </g:each>
    </tbody>
</table>
<div class="appBtns linkBtns">
    <a id="addViolation" class="add button">Add Additional Violations</a>
</div>
<g:if test="${!params.pdf}">
<g:javascript>
	$('.date').datepicker();
	$('#addViolation').click(function() {
		var newRow = $('#violations tr').length - 1; // consider header
		$('#violations').append(
			'<tr>'+
				'<td><input type="text" name="violations['+newRow+'].date" id="violations_'+newRow+'_DOTdate" /></td>'+
				'<td><input type="text" name="violations['+newRow+'].location" /></td>'+
				'<td><input type="text" name="violations['+newRow+'].charge" /></td>'+
				'<td><input type="text" name="violations['+newRow+'].penalty" /></td>'+
				'<td><a class="remove">Remove</a></td>'+
			'</tr>');
		$('#violations_'+newRow+'_DOTdate').datepicker();
		setReindexInputArray();
	});
</g:javascript>
</g:if>