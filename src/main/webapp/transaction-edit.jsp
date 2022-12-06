<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Transaction edit" scope="application" />
<t:wrapper>
	<c:choose>
		<c:when test="${empty dto.id}">
			<h1>Create Transaction</h1>
		</c:when>
		<c:otherwise>
			<h1>Edit Transaction #${dto.id}</h1>
		</c:otherwise>
	</c:choose>
	<form class="col s12" method="post" action="/transaction">
		<div class="row">
			<input type="hidden" name="id" value="${dto.id}" />
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
			<div class="row">
				<div class="input-field col s12">  
					<input type="number" name="amount" required minlength=4 maxlength=4 value="${dto.amount}" /> <label for="amount">amount</label>
				</div>
				<div class="input-field col s12">  
					<input type="text" name="currency" required minlength=1 maxlength=1 value="${dto.currency}" /> <label for="currency">currency</label>
				</div>
				<div class="input-field col s12">  
					<input type="text" name="type" value="${dto.type}" /> <label for="type">type</label>
				</div>
					<div class="input-field col s12">  
					<input type="date" name="date" value="${dto.date}" /> <label for="date">date</label>
				</div>
				<div class="input-field col s12">  
					<input type="text" name="comment" value="${dto.comment}" /> <label for="comment">comment</label>
				</div>
			</div>
				
		</div>
		<div class="row">
			<div class="col s12 input-field center-align">
				<a class="btn waves-effect waves-light red" href="/transaction"><i class="material-icons left">list</i>back</a>&nbsp;
				<button class="btn waves-effect waves-light" type="submit">
					<i class="material-icons left">save</i>save
				</button>
			</div>
		</div>
	</form>
</t:wrapper>

