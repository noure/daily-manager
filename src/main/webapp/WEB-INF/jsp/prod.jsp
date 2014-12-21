<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="../layout/taglib.jsp"%>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal"
	data-target="#prodModal">Add product</button>



<form:form commandName="product" cssClass="form-horizontal">
	<!-- Modal -->
	<div class="modal fade" id="prodModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Product</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Name: </label>
						<div class="col-sm-10">
							<form:input cssClass="form-control" path="name"
								placeholder="Name" />
							<form:errors path="name" />
						</div>
					</div>

					<div class="form-group">
						<label for="price" class="col-sm-2 control-label">Price: </label>
						<div class="col-sm-10">
							<form:input cssClass="form-control" path="price"
								placeholder="Price" />
							<form:errors path="price" />
						</div>
					</div>

					<div class="form-group">
						<label for="category" class="col-sm-2 control-label">Category:
						</label>
						<div class="col-sm-10">
							<form:select cssClass="form-control" path="category.id"
								placeholder="Category">


								<form:options items="${categories}" itemLabel="name"
									itemValue="id" />
							</form:select>

							<form:errors path="category" />
						</div>
					</div>

				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">Save</button>
				</div>
			</div>
		</div>
	</div>
</form:form>
<br />


<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>poduct id</th>
			<th>poduct name</th>
			<th>poduct price</th>
			<th>poduct belong to</th>
			<th>poduct quantity</th>
	</thead>

	<tbody>
		<c:forEach items="${products}" var="prod">


			<tr>
				<td><c:out value="${prod.id}" /></td>
				<td><c:out value="${prod.name}" /></td>
				<td><c:out value="${prod.price }" /></td>
				<td><c:out value="${prod.category.name}" /></td>
				<td><div class="form-group">
						<label for="quantity" class="col-sm-2 control-label">Quantity: </label>
						<div class="col-sm-10">
							<%-- <form:input cssClass="form-control" path="quantity"
								placeholder="Quantity" />
							<form:errors path="quantity" /> --%>
						</div>
					</div></td>

			</tr>




		</c:forEach>
	</tbody>

</table>




