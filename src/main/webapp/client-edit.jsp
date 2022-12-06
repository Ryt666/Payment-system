<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Client" scope="application" />
<t:wrapper>
	<c:choose>
		<c:when test="${empty dto.id}">
			<h1>Create Client</h1>
		</c:when>
		<c:otherwise>
			<h1>Edit Client #${dto.id}</h1>
		</c:otherwise>
	</c:choose>
	<form class="col s12" method="post" action="/client">
		<div class="row">
			<input type="hidden" name="id" value="${dto.id}" />
			<div class="row">
				<div class="input-field col s12">  
					<input type="text" name="name" value="${dto.name}" > <label for="name">name</label>
				</div>
				<div class="input-field col s12">
					<input type="text" name="surname" value="${dto.surname}" > <label for="surname">surname</label>
				</div>
				<div class="input-field col s12">
					<input type="text" name="address" value="${dto.address}" > <label for="address">address</label>
				</div>
				<div class="input-field col s12">
					<input type="tel" name="phone" required pattern="[0-9]{3}-[0-9]{2}-[0-9]{3}-[0-9]{2}-[0-9]{2}"  value="${dto.phone}" > <label for="phone">phone</label>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col s12 input-field center-align">
				<a class="btn waves-effect waves-light red" href="/client"><i class="material-icons left">list</i>back</a>&nbsp;
				<button class="btn waves-effect waves-light" type="submit">
					<i class="material-icons left">save</i>save
				</button>
			</div>
		</div>
	</form>	
</t:wrapper>


