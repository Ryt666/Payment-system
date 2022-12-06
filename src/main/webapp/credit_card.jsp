<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>
<c:set var="pageTitle" value="Credit Card" scope="application" />
<c:set var="pageUrl" value="/creditCard" scope="page" />
<t:wrapper>
	<h1>Credit Card</h1>
	<div class="row">
		<div class="col s12">
			<div class="center-align">
				<a class="btn-floating btn-large waves-effect waves-light"
					href="/creditCard?view=edit"><i class="material-icons">add</i></a>
			</div>
		</div>
	</div>
	<table>
		<thead>
			<tr>
				<th><mytaglib:sort-link pageUrl="${pageUrl}" column="id">DB ID</mytaglib:sort-link></th>
				<th><mytaglib:sort-link pageUrl="${pageUrl}" column="number">number</mytaglib:sort-link></th>
				<th><mytaglib:sort-link pageUrl="${pageUrl}" column="expiry date">expiry date</mytaglib:sort-link></th>
				<th><mytaglib:sort-link pageUrl="${pageUrl}" column="bank account number">bank account number</mytaglib:sort-link></th>
				<th><mytaglib:sort-link pageUrl="${pageUrl}" column="client name">client name</mytaglib:sort-link></th>
				
				<th>actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="entity" items="${list}" varStatus="loopCounter">
				<tr>
					<td><c:out value="${entity.id}" /></td>
					<td><c:out value="${entity.number}" /></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value="${entity.expiryDate}" /></td>
					<td><c:out value="${entity.bankAccountNumber}" /></td>
					<td><c:out value="${entity.clientName}" /></td>
					
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="edit" href="/creditCard?view=edit&id=${entity.id}"><i
							class="material-icons">edit</i></a><a class="btn-small btn-floating waves-effect waves-light red" title="delete" onclick="sendHTTPDelete('/creditCard?id=${entity.id}')"><i class="material-icons">delete</i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<t:paging />
</t:wrapper>