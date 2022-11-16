<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Add client list" scope="application" />
<t:wrapper>
<title>Add client</title>

<!-- Compiled and minified CSS -->

		<h1>Add client</h1>


		<div class="row">
				<div class="row">
					<div class="input-field col s6">
						<input id="Name" type="text"
							class="validate"> <label for="Name">Name</label>
					</div>
					<div class="input-field col s6">
						<input id="Surname" type="text" class="validate"> <label
							for="Surname">Surname</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input  id="Address" type="text" class="validate"> <label 
						for="Adress">Address</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input id="Phone" type="password" class="validate"> <label
							for="Phone">Phone</label>
					</div>
				</div>
				
					</div>
					<div class="col s12 input-field center-align">
				<a class="btn waves-effect waves-light red" href="list.jsp"><i class="material-icons left">List</i></a> <a class="btn waves-effect waves-light green"
					href="#"><i class="material-icons left">Save</i></a>
			</div>
<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</t:wrapper>
