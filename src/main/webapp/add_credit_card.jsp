<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Credit card edit" scope="application" />
<t:wrapper>
	<c:choose>
		<c:when test="${empty dto.id}">
			<h1>Create credit card</h1>
		</c:when>
		<c:otherwise>
			<h1>Edit credit card #${dto.id}</h1>
		</c:otherwise>
	</c:choose>
	<form class="col s12" method="post" action="/credit_card">
		<div class="row">
			<input type="hidden" name="id" value="${dto.id}" />
			<div class="row">
				<div class="input-field col s12">  
					<input type="text" name="number" value="${dto.number}" ${empty dto.id ? '' : 'disabled'} > <label for="number">number</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12">  
					<input type="text" name="expiry_date" value="${dto.expiryDate}" ${empty dto.id ? '' : 'disabled'} > <label for="expiry_date">expiryDate</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s6">
					<input type="text" name="client_id" value="${dto.clientId}"> <label for="client_id">ClientID</label>
				</div>
				<div class="input-field col s6">
					<input type="text" name="bank_account_id" value="${dto.bankAccountId}"> <label for="bankAccount_id">bankAccountID</label>
				</div>
				<div class="input-field col s6">
					<input type="text" name="comment" value="${dto.comment}"> <label for="comment">comment</label>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col s12 input-field center-align">
				<a class="btn waves-effect waves-light red" href="/credit_card"><i class="material-icons left">list</i>back</a>&nbsp;
				<button class="btn waves-effect waves-light" type="submit">
					<i class="material-icons left">save</i>save
				</button>
			</div>
		</div>
	</form>
</t:wrapper>
