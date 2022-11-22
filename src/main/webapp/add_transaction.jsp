<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Add Transaction list" scope="application" />
<t:wrapper>
<title>Add Transaction</title>

<!-- Compiled and minified CSS -->

		<h1>Add Transaction</h1>


		<div class="row">
			
				<div class="row">
				<div class="input-field col s12">
						<input id="Number" type="text" class="validate"> <label
							for="Number">Number</label>
					</div>
				<div class="input-field col s12">
						<input id="Bank_Account_Id" type="text" class="validate"> <label
							for="Bank_Account_Id">Bank_Account_Id</label>
					</div>
					<div class="input-field col s12">
						<input id="Name" type="text"
							class="validate"> <label for="Name">Amount</label>
					</div>
					<div class="input-field col s12">
						<input id="Currency" type="text" class="validate"> <label
							for="Currency">Currency</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input  id="Type" type="text" class="validate"> <label 
						for="Type">Type</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input id="Date" type="password" class="validate"> <label
							for="Date">Date</label>
					</div>
				</div>
				<div class="row">
					<div class="input-field col s12">
						<input id="Comment" type="password" class="validate"> <label
							for="Comment">Comment</label>
							<div></div>
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
