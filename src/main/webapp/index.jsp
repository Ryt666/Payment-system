<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Client" scope="application" />
<t:wrapper>
	<h1>Client</h1>
	<div class="row">
		<div class="col s12">
			<div class="center-align">
				<a class="btn-floating btn-large waves-effect waves-light" href="/add_client?view=edit"><i class="material-icons">add</i></a>
			</div>
		</div>
	</div>
	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>surname</th>
				<th>address</th>
				<th>phone</th>
				<th>actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="entity" items="${list}" varStatus="loopCounter">
				<tr>
					<td><c:out value="${entity.id}" /></td>
					<td><c:out value="${entity.name}" /></td>
					<td><c:out value="${entity.surname}" /></td>
					<td><c:out value="${entity.address}" /></td>
					<td><c:out value="${entity.phone}" /></td>
					<td><a class="btn-small btn-floating waves-effect waves-light blue" title="edit" href="/client?view=edit&id=${entity.id}"><i
							class="material-icons">edit</i></a><a class="btn-small btn-floating waves-effect waves-light red" title="delete" onclick="sendHTTPDelete('/client?id=${entity.id}')"><i class="material-icons">delete</i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</t:wrapper>
