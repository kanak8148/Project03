
<%@page import="in.co.rays.project_3.controller.CustomerCtl"%>
<%@page import="in.co.rays.project_3.util.HTMLUtility"%>
<%@page import="java.util.Map"%>
<%@page import="in.co.rays.project_3.util.ServletUtility"%>
<%@page import="in.co.rays.project_3.util.DataUtility"%>
<%@page import="in.co.rays.project_3.controller.ORSView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>customer</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
i.css {
	border: 2px solid #8080803b;
	padding-left: 10px;
	padding-bottom: 11px;
	background-color: #ebebe0;
}

.input-group-addon {
	box-shadow: 9px 8px 7px #001a33;
}

.hm {
	background-image: url('<%=ORSView.APP_CONTEXT%>/img/user1.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	padding-top: 75px;

	/* background-size: 100%; */
}
</style>
</head>
<body class="p4">
	<div class="header">
		<%@include file="Header.jsp"%>
		<%@include file="calendar.jsp"%>

	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div>

		<main>
		<form action="<%=ORSView.CUSTUMER_CTL%>" method="post">

			<%
				Map<Integer, String> map = (Map<Integer, String>) request.getAttribute("prolist");
			%>

			<div class="row pt-3 pb-4">
				<!-- Grid column -->
				<jsp:useBean id="dto" class="in.co.rays.project_3.dto.CustomerDTO"
					scope="request"></jsp:useBean>
				<div class="col-md-4 mb-4"></div>
				<div class="col-md-4 mb-4">
					<div class="card">
						<div class="card-body">
							<%
								long id = DataUtility.getLong(request.getParameter("id"));

								if (dto.getId() != null) {
							%>
							<h3 class="text-center text-primary">Update Customer</h3>
							<%
								} else {
							%>
							<h3 class="text-center text-primary">Add Customer</h3>
							<%
								}
							%>
							<!--Body-->
							<div>

								<H4 align="center">
									<%
										if (!ServletUtility.getSuccessMessage(request).equals("")) {
									%>
									<div class="alert alert-success alert-dismissible">
										<button type="button" class="close" data-dismiss="alert">&times;</button>
										<%=ServletUtility.getSuccessMessage(request)%>
									</div>
									<%
										}
									%>
								</H4>

								<H4 align="center">
									<%
										if (!ServletUtility.getErrorMessage(request).equals("")) {
									%>
									<div class="alert alert-danger alert-dismissible">
										<button type="button" class="close" data-dismiss="alert">&times;</button>
										<%=ServletUtility.getErrorMessage(request)%>
									</div>
									<%
										}
									%>

								</H4>

								<input type="hidden" name="id" value="<%=dto.getId()%>">
								<input type="hidden" name="createdBy"
									value="<%=dto.getCreatedBy()%>"> <input type="hidden"
									name="modifiedBy" value="<%=dto.getModifiedBy()%>"> <input
									type="hidden" name="createdDatetime"
									value="<%=DataUtility.getTimestamp(dto.getCreatedDatetime())%>">
								<input type="hidden" name="modifiedDatetime"
									value="<%=DataUtility.getTimestamp(dto.getModifiedDatetime())%>">
							</div>
							<div class="md-form">
								<span class="pl-sm-5"><b>Clinet Name</b><span
									style="color: red;">*</span></span> </br>
								<div class="col-sm-12">
									<div class="input-group">
										<div class="input-group-prepend">
											<div class="input-group-text">
												<i class="fa fa-university grey-text"
													style="font-size: 1rem;"></i>
											</div>
										</div>
										<input type="text" name="clintName" class="form-control"
											id="defaultForm-email" placeholder="Enter clintName"
											value="<%=DataUtility.getStringData(dto.getClintName())%>">
									</div>
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("clintName", request)%></font></br>



								<span class="pl-sm-5"><b>Location</b><span
									style="color: red;">*</span></span> </br>
								<div class="col-sm-12">
									<div class="input-group">
										<div class="input-group-prepend">
											<div class="input-group-text">
												<i class="fa fa-address-book grey-text"
													style="font-size: 1rem;"></i>
											</div>
										</div>
										<input type="text" name="location" class="form-control"
											placeholder="Enter location"
											value="<%=DataUtility.getStringData(dto.getLocation())%>">
									</div>
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("location", request)%></font></br>
								<span class="pl-sm-5"><b> Contact Number</b> <span
									style="color: red;">*</span></span></br>
								<div class="col-sm-12">
									<div class="input-group">
										<div class="input-group-prepend">
											<div class="input-group-text">
												<i class="fa fa-calendar grey-text" style="font-size: 1rem;"></i>
											</div>
										</div>
										<input type="number" name="contactNumber" class="form-control"
											placeholder="contactNumber"
											value="<%=DataUtility.getStringData(dto.getContactNumber())%>">
									</div>
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("contactNumber", request)%></font></br>
							</div>
							<span class="pl-sm-5"><b>important</b><span
								style="color: red;">*</span></span></br>
							<div class="col-sm-12">
								<div class="input-group">
									<div class="input-group-prepend">
										<div class="input-group-text">
											<i class="fa fa-user grey-text" style="font-size: 1rem;"></i>
										</div>
									</div>
									<%=HTMLUtility.getList2("importance", String.valueOf(dto.getImportance()), map)%>
								</div>
							</div>
							<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("importance", request)%></font></br>




							<%
								if (id > 0) {
							%>
							<div class="text-center">

								<input type="submit" name="operation"
									class="btn btn-success btn-md" style="font-size: 17px"
									value="<%=CustomerCtl.OP_UPDATE%>"> <input
									type="submit" name="operation" class="btn btn-warning btn-md"
									style="font-size: 17px" value="<%=CustomerCtl.OP_CANCEL%>">
							</div>
							<%
								} else {
							%>
							<div class="text-center">

								<input type="submit" name="operation"
									class="btn btn-success btn-md" style="font-size: 17px"
									value="<%=CustomerCtl.OP_SAVE%>"> <input type="submit"
									name="operation" class="btn btn-warning btn-md"
									style="font-size: 17px" value="<%=CustomerCtl.OP_RESET%>">
							</div>
							<%
								}
							%>
						</div>
					</div>
				</div>
				<div class="col-md-4 mb-4"></div>
			</div>
		</form>
		</main>


	</div>

</body>
<%@include file="FooterView.jsp"%>




</body>
</html>