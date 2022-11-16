<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Add Bank Account list" scope="application" />
<t:wrapper>
<title>Add Bank Account</title>

		<h1>Add Bank Account</h1>


		<div class="row">
			
				<div class="row">
					<div class="input-field col s6">
						<input id="Number" type="text"
							class="validate"> <label for="Number">Number</label>
					</div>
					<div 
					class="input-field col s6">
						<label> 
						<input id="Blocked" type="checkbox" />
						<span>Blocked</span>
							</label>
					
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