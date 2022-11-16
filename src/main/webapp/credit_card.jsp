<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Credit Card list" scope="application" />
<t:wrapper>
<title>Credit Card</title>
 

		<h1>Credit Card</h1>
		<table>
			<thead>
				<tr>
				    <th>ID</th>
					<th>Number</th>
					<th>Expiry_date</th>
					<th>Client_ID</th>
					<th>Bank_Account_ID</th>
				</tr>
			</thead>
			<tbody>
			    <tr>
				
					<td>32526352415442214</td>
					<td>09/25</td>
				</tr>
				<tr>
				    
					<td>9854756253142217</td>
					<td>07/23</td>
			    </tr>
			    <tr>
				   
					<td>5245789652335498</td>
					<td>01/24</td>
			    </tr>
			    <tr>
				    
					<td>2547854542199665</td>
					<td>06/26</td>
			    </tr>
			    <tr>
			
					<td>4758574868154295</td>
					<td>03/24</td>
			    </tr>
			    
			
			</tbody>
		</table>

<div class="row">
			<div class="col s12">
				<div class="center-align">
                   <a class="btn-floating btn-large waves-effect waves-light" href="credit_card_1.jsp"><i class="material-icons">add</i></a>
				
				</div>
			</div>
		</div>
<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
	
</t:wrapper>
