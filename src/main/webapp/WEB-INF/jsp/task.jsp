<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="../layout/taglib.jsp"%>


<form:form action="task.do" commandName="task"
	cssClass="form-horizontal" method="POST" id="taskForm">

	<div class="form-group">
		<div class="col-sm-10">
			<form:hidden cssClass="form-control" path="id" placeholder="Task ID" />
		</div>
	</div>
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Task Name: </label>
		<div class="col-sm-10">
			<form:input cssClass="form-control" path="taskName"
				placeholder="Task name" />
			<form:errors path="taskName" />
		</div>
	</div>

	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Task
			Description: </label>
		<div class="col-sm-10">
			<form:input cssClass="form-control" path="taskDescription"
				placeholder="Task Description" />
			<form:errors path="taskDescription" />
		</div>
	</div>


	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Task
			Priority: </label>
		<div class="col-sm-10">
			<form:select cssClass="form-control" path="taskPriority">
				<c:forEach items="${priorities}" var="pr">
					<form:option value="${pr }"
						selected='${task.taskPriority eq  pr ? "selected" :""}' />
				</c:forEach>
			</form:select>

		</div>
	</div>

	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Task Status:
		</label>
		<div class="col-sm-10">
			<form:select cssClass="form-control" path="taskStatus">
				<c:forEach items="${stt}" var="st">
					<form:option value="${st }"
						selected='${task.taskStatus eq  st ? "selected" :""}' />
				</c:forEach>

			</form:select>
		</div>
	</div>

	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Task
			Archived: </label>
		<div class="col-sm-2">
			<form:checkbox cssClass="form-control" path="taskArchived" />
		</div>
	</div>


	<div class="form-group">
		<input id="addButton" type="submit" class="btn btn-primary"
			name="action" value="Add" /> <input type="submit"
			class="btn btn-primary" name="action" value="Edit" /> <input
			type="submit" class="btn btn-primary" name="action" value="Delete" />
		<input type="submit" class="btn btn-primary" name="action"
			value="Search" />
	</div>

</form:form>



<table class="table table-bordered table-hover table-striped"
	id="tabTask">
	<thead>
		<tr>

			<th>Task Name</th>
			<th>Task Description</th>
			<th>Task Priority</th>
			<th>Task Archived</th>
			<th>Task Status</th>
	</thead>

	<tbody>
		<c:forEach items="${tasks}" var="task">
			<tr>
				<td><c:out value="${task.taskName}" /></td>
				<td><c:out value="${task.taskDescription }" /></td>
				<td><c:out value="${task.taskPriority}" /></td>
				<td><c:out value="${task.taskArchived}" /></td>
				<td><c:out value="${task.taskStatus}" /></td>
			</tr>
		</c:forEach>
	</tbody>

</table>





<script type="text/javascript">
	$(document)
			.ready(
					function() {
						//alert("test");
						$('#tabTask').DataTable({
							"sPaginationType" : "full_numbers",
						});

						$('#addButton')
								.click(
										function() {

											$('#taskForm')
													.validate(
															{
																rules : {
																	taskName : {
																		required : true,
																		minlength : 3,
																		remote : {
																			url : "<spring:url  value='/task/available.html' />",
																			type : "get",
																			data : {
																				taskName : function() {
																					return $(
																							'#taskName')
																							.val();
																				},
																				action : "add"

																			}
																		}
																	},
																	taskDescription : {
																		required : true,
																		minlength : 5
																	}

																},
																highlight : function(
																		element) {

																	$(element)
																			.closest(
																					'.form-group')
																			.removeClass(
																					'has-success')
																			.addClass(
																					'has-error');
																},
																unhighlight : function(
																		element) {

																	$(element)
																			.closest(
																					'.form-group')
																			.removeClass(
																					'has-error')
																			.addClass(
																					'has-success');
																}

															});
										});

					});
</script>

