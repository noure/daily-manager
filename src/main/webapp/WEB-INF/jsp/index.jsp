<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="../layout/taglib.jsp"%>


<script type="text/javascript">
	$(document).ready(function() {
		//alert("test");
		$('#productTab').DataTable({
			"sPaginationType": "full_numbers",
		});
	});
</script>


<table id="productTab" class="table table-bordered table-hover table-striped" >
	<thead>
		<tr>

			<th>id</th>
			<th>name</th>
			<th>price</th>
			<th>quantity</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach items="${products}" var="prod">

			<tr>

				<th><c:out value="${prod.id}" /></th>
				<th><c:out value="${prod.name}" /></th>
				<th><c:out value="${prod.price}" /></th>
				<th><c:out value="${prod.quantity}" /></th>
			</tr>

		</c:forEach>

	</tbody>
</table>

