<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<c:set var="pageTitle" value="Client list" scope="application" />
<t:wrapper>
		<h1>Client</h1>
		
		
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Surname</th>
					<th>Address</th>
					<th>Phone</th>
					
				</tr>
			</thead>
			
			<tbody>
			
				<tr>
					<td>Alvin</td>
					<td>Borisov</td>
					<td>Krasnogvardejska,11</td>
					<td>+375298624393</td>
					
				</tr>
				<tr>
				    <td>Egor</td>
					<td>Kunicki</td>
					<td>Dubko,20</td>
					<td>+375298624393</td>
					
			    </tr>
			    <tr>
				    <td>Masha</td>
					<td>Ivanova</td>
					<td>Saveckia, 23</td>
					<td>+375336529848</td>
					
			    </tr>
			    <tr>
				    <td>Kirill</td>
					<td>Melnik</td>
					<td>Gaspodarchia,14</td>
					<td>+375333307779</td>
				
			    </tr>
			    <tr>
				    <td>Maxim</td>
					<td>Kishinev</td>
					<td>Limozha,43</td>
					<td>+375295279914</td>
					
					
			    </tr>
			    
			
			</tbody>
		</table>


<!-- Compiled and minified JavaScript -->
<div class="row">
			<div class="col s12">
				<div class="center-align">
                   <a class="btn-floating btn-large waves-effect waves-light" href="add_client.jsp"><i class="material-icons">add</i> 
                 
            
                   </a>
				
				</div>
			</div>
		</div>		
		
		
		
		<!-- Page body will be here -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</t:wrapper>
