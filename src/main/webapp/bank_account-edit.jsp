<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Bank Account" scope="application" />
<t:wrapper>
	<c:choose>
		<c:when test="${empty dto.id}">
			<h1>Create Bank Account</h1>
		</c:when>
		<c:otherwise>
			<h1>Edit Bank Account #${dto.id}</h1>
		</c:otherwise>
	</c:choose>
	<form class="col s12" method="post" action="/bankAccount">
		<div class="row">
			<input type="hidden" name="id" value="${dto.id}" />
			<div class="row">
				<div class="input-field col s12">  
					<input type="text" name="number" required minlength=35 maxlength=35 value="${dto.number}" > <label for="number">number</label>
				</div>
				<div class="input-field col s12">
					<label><input type="checkbox" name="blocked" ${dto.blocked ? 'checked' : ''} value="true" /> <span>blocked</span>
					</label>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col s12 input-field center-align">
				<a class="btn waves-effect waves-light red" href="/bankAccount"><i class="material-icons left">list</i>back</a>&nbsp;
				
				<button class="btn waves-effect waves-light" type="submit">
					<i class="material-icons left">save</i>save
				</button>
			</div>
		</div>
	</form>
</t:wrapper>


