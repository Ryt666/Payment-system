<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Transaction" scope="application" />
<t:wrapper>
	<h1>Transaction</h1>
	<div class="row">
		<div class="col s12">
			<div class="center-align">
				<a class="btn-floating btn-large waves-effect waves-light" href="/transaction?view=edit"><i class="material-icons">add</i></a>
			</div>
		</div>
	</div>
	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>bank account</th>
				<th>amount</th>
				<th>currency</th>
				<th>type</th>
				<th>date</th>
				<th>comment</th>
				<th>actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="entity" items="${list}" varStatus="loopCounter">
				<tr>
					<td><c:out value="${entity.id}" /></td>
					<td><c:out value="${entity.bankAccountNumber}" /></td>
				    <td><c:out value="${entity.amount}" /></td>
				    <td><c:out value="${entity.currency}" /></td>
				    <td><c:out value="${entity.type}" /></td>
		            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${entity.date}" /></td>
				    <td><c:out value="${entity.comment}" /></td>
				    <td><c:out value="${entity.actions}" /></td>
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="edit" href="/add_transaction?view=edit&id=${entity.id}"><i
							class="material-icons">edit</i></a><a class="btn-small btn-floating waves-effect waves-light red" title="delete" onclick="sendHTTPDelete('/transaction?id=${entity.id}')"><i class="material-icons">delete</i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</t:wrapper>
