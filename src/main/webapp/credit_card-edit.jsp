<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Credit Card edit" scope="application" />
<t:wrapper>
	<c:choose>
		<c:when test="${empty dto.id}">
			<h1>Create Credit Card</h1>
		</c:when>
		<c:otherwise>
			<h1>Edit Credit Card #${dto.id}</h1>
		</c:otherwise>
	</c:choose>
	<form class="col s12" method="post" action="/creditCard">
		<div class="row">
			<input type="hidden" name="id" value="${dto.id}" />
			<div class="row">
				<div class="input-field col s12">  
					<input type="text" name="number" required minlength=20 maxlength=20 value="${dto.number}" > <label for="number">number</label>
				</div>
					<div class="input-field col s12">  
					<input type="date" name="expiryDate" value="${dto.expiryDate}" > <label for="expiryDate">expiry date</label>
				</div>
				
			</div>
			<div class="row">
				<div class="col s6">
					<label for="clientId">Client ID</label> 
					<select name="clientId" class="browser-default" required>
						<option value="">--select client--</option>
						<c:forEach items="${allClients}" var="client">
							<option value="${client.id}" <c:if test="${client.id eq dto.clientId}">selected="selected"</c:if>>${client.name}</option>
						</c:forEach>
					</select>
				</div>
				</div>
				<div class="row">
				<div class="col s6">
					<label for="bankAccountId">Bank Account ID</label> 
					<select name="bankAccountId" class="browser-default" required>
						<option value="">--select bank_account--</option>
						<c:forEach items="${allBankAccounts}" var="bankAccount">
							<option value="${bankAccount.id}" <c:if test="${bankAccount.id eq dto.bankAccountId}">selected="selected"</c:if>>${bankAccount.number}</option>
						</c:forEach>
					</select>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col s12 input-field center-align">
				<a class="btn waves-effect waves-light red" href="/creditCard"><i class="material-icons left">list</i>back</a>&nbsp;
				<button class="btn waves-effect waves-light" type="submit">
					<i class="material-icons left">save</i>save
				</button>
			</div>
		</div>
	</form>
</t:wrapper>

