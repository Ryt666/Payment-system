<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>
<c:set var="pageTitle" value="Bank Account" scope="application" />
<c:set var="pageUrl" value="/bankAccount" scope="page" />
<t:wrapper>
	<h1>Bank Account</h1>
	<div class="row">
		<div class="col s12">
			<div class="center-align">
				<a class="btn-floating btn-large waves-effect waves-light"
					href="/bankAccount?view=edit"><i class="material-icons">add</i></a>
			</div>
		</div>
	</div>
	<table>
		<thead>
			<tr>
				<th><mytaglib:sort-link pageUrl="${pageUrl}" column="id">DB ID</mytaglib:sort-link></th>
				<th><mytaglib:sort-link pageUrl="${pageUrl}" column="number">number</mytaglib:sort-link></th>
				<th><mytaglib:sort-link pageUrl="${pageUrl}" column="blocked">blocked</mytaglib:sort-link></th>
				<th>actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="entity" items="${list}" varStatus="loopCounter">
				<tr>
					<td><c:out value="${entity.id}" /></td>
					<td><c:out value="${entity.number}" /></td>
					<td><c:out value="${entity.blocked}" /></td>
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="edit" href="/bankAccount?view=edit&id=${entity.id}"><i
							class="material-icons">edit</i></a><a class="btn-small btn-floating waves-effect waves-light red" title="delete" onclick="sendHTTPDelete('/bankAccount?id=${entity.id}')"><i class="material-icons">delete</i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<t:paging />
</t:wrapper>