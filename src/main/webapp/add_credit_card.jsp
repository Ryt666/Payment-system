<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Add Credit Card list" scope="application" />
<t:wrapper>
<title>Add Credit Card</title>

<!-- Compiled and minified CSS -->

		<h1>Add Credit Card</h1>


		<div class="row">
			
				<div class="row">
				
					</div>
					<div class="input-field col s12">
						<input id="Number" type="text"
							class="validate"> <label for="Number">Number</label>
					</div>
					<div class="input-field col s12:">
						<input id="expiry_date" type="text" class="validate"> <label
							for="expiry_date">Expiry_Date</label>
					</div>
					<div class="input-field col s12">
						<input id="Client_ID" type="text" class="validate"> <label
							for="Client_ID">Client_ID</label>
					</div>
					<div class="input-field col s12">
						<input id="Bank_account_ID" type="text" class="validate"> <label
							for="Bank_account_ID">Bank_account_ID</label>
					</div>
				</div>
				
				</div>
				<div class="row">
			<div class="col s12 input-field center-align">
				<a class="btn waves-effect waves-light red" href="list.jsp"><i class="material-icons left">List</i></a> <a class="btn waves-effect waves-light green"
					href="#"><i class="material-icons left">Save</i></a>
			</div>
		</div>
<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
	
</t:wrapper>
