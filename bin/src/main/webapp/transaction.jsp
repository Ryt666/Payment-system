<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Transaction list" scope="application" />
<t:wrapper>
<title>Transaction</title>

<!-- Compiled and minified CSS -->
		<h1>Transaction</h1>
		
		<table>
			<thead>
				<tr>
				    <th>ID</th>
				    <th>Bank_Account_ID</th>
					<th>Amount</th>
					<th>Currency</th>
					<th>Date</th>
					<th>Comment</th>
				</tr>
			</thead>
			<tbody>
			
				<tr>
					
			    </tr>
			    
			
			</tbody>
		</table>


<div class="row">
			<div class="col s12">
				<div class="center-align">
                   <a class="btn-floating btn-large waves-effect waves-light" href="transaction_1.jsp"><i class="material-icons">add</i> 
                 
            
                   </a>
				
				</div>
			</div>
		</div>
<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</t:wrapper>
