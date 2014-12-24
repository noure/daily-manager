<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ include file="../layout/taglib.jsp"%>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal"
	data-target="#CatModal">Add category</button>



<form:form commandName="category" cssClass="form-horizontal" id="catForm">
	<!-- Modal -->
	<div class="modal fade" id="CatModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Gategory</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Name</label>
						<div class="col-sm-10">
							<form:input cssClass="form-control" path="name"
								placeholder="Name" />
							<form:errors path="name" />
						</div>
					</div>

					<div class="form-group">
						<label for="description" class="col-sm-2 control-label">Description</label>
						<div class="col-sm-10">
							<form:input cssClass="form-control" path="description"
								placeholder="Description" />
							<form:errors path="description" />
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


<script type="text/javascript">
<!--
	//-->
	$('#catForm').validate(
			{
				rules : {
					name : {
						required : true,
						minlength : 3
					},
					description : {
						required : true,
						minlength : 5
					}

				},
				highlight : function(element) {

					$(element).closest('.form-group')
							.removeClass('has-success').addClass('has-error');
				},
				unhighlight : function(element) {

					$(element).closest('.form-group').removeClass('has-error')
							.addClass('has-success');
				}

			});
</script>
<br />
<br />

