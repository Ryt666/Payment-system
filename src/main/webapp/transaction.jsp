<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>
<c:set var="pageTitle" value="Transaction" scope="application" />
<c:set var="pageUrl" value="/transaction" scope="page" />
<t:wrapper>
	<h1>Transaction</h1>
	<div class="row">
		<div class="col s12">
			<div class="center-align">
				<a class="btn-floating btn-large waves-effect waves-light"
					href="/transaction?view=edit"><i class="material-icons">add</i></a>
			</div>
		</div>
	</div>
	<table>
		<thead>
			<tr>
				<th><mytaglib:sort-link pageUrl="${pageUrl}" column="id">DB ID</mytaglib:sort-link></th>
				<th><mytaglib:sort-link pageUrl="${pageUrl}" column="bankAccountNumber">bank account number</mytaglib:sort-link></th>
				<th><mytaglib:sort-link pageUrl="${pageUrl}" column="amount">amount</mytaglib:sort-link></th>
				<th><mytaglib:sort-link pageUrl="${pageUrl}" column="currency">currency</mytaglib:sort-link></th>
				<th><mytaglib:sort-link pageUrl="${pageUrl}" column="type">type</mytaglib:sort-link></th>
				<th><mytaglib:sort-link pageUrl="${pageUrl}" column="Date">date</mytaglib:sort-link></th>
				<th><mytaglib:sort-link pageUrl="${pageUrl}" column="Comment">comment</mytaglib:sort-link></th>
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
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="edit" href="/transaction?view=edit&id=${entity.id}"><i
							class="material-icons">edit</i></a><a class="btn-small btn-floating waves-effect waves-light red" title="delete" onclick="sendHTTPDelete('/transaction?id=${entity.id}')"><i class="material-icons">delete</i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<t:paging />
</t:wrapper>