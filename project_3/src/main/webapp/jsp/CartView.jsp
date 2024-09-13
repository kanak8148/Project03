
<%@page import="java.util.Map"%>
<%@page import="in.co.rays.project_3.controller.CartCtl"%>
<%@page import="in.co.rays.project_3.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.project_3.util.DataUtility"%>
<%@page import="in.co.rays.project_3.util.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bus View</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<style type="text/css">
i.css {
	border: 2px solid #8080803b;
	padding-left: 10px;
	padding-bottom: 11px;
	background-color: #ebebe0;
}

.p4 {
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
	<div>

		<main>
		<form action="<%=ORSView.CART_CTL%>" method="post">

			<%
				Map<Integer, String> product1 = (Map<Integer, String>) request.getAttribute("productl");
			%>
			<div class="row pt-3 pb-4">
				<!-- Grid column -->
				<jsp:useBean id="dto" class="in.co.rays.project_3.dto.CartDTO"
					scope="request"></jsp:useBean>
				<div class="col-md-4 mb-4"></div>
				<div class="col-md-4 mb-4">
					<div class="card">
						<div class="card-body">
							<%
								long id = DataUtility.getLong(request.getParameter("id"));

								if (dto.getId() != null) {
							%>
							<h3 class="text-center text-primary">Update Cart</h3>
							<%
								} else {
							%>
							<h3 class="text-center text-primary">Add Cart</h3>
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
								<span class="pl-sm-5"><b>Customer Name</b><span
									style="color: red;">*</span></span> </br>
								<div class="col-sm-12">
									<div class="input-group">
										<div class="input-group-prepend">
											<div class="input-group-text">
												<i class="fa fa-user grey-text" style="font-size: 1rem;"></i>
											</div>
										</div>
										<input type="text" name="customerName" class="form-control"
											id="defaultForm-email" placeholder="Enter customerName"
											value="<%=DataUtility.getStringData(dto.getCustomerName())%>">
									</div>
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("customerName", request)%></font></br>

								<span class="pl-sm-5"><b>Product</b><span
									style="color: red;">*</span></span></br>
								<div class="col-sm-12">
									<div class="input-group">
										<div class="input-group-prepend">
											<div class="input-group-text">
												<i class="fa fa-user grey-text" style="font-size: 1rem;"></i>
											</div>
										</div>
										<%=HTMLUtility.getList2("product", String.valueOf(dto.getProduct()), product1)%>
									</div>
								</div>
								<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("product", request)%></font></br>

								<span class="pl-sm-5"><b>Transaction</b><span
									style="color: red;">*</span></span> </br>
								<div class="col-sm-12">
									<div class="input-group">
										<div class="input-group-prepend">
											<div class="input-group-text">
												<i class="fa fa-address-book grey-text"
													style="font-size: 1rem;"></i>
											</div>
										</div>
										<input type="text" name="transaction" class="form-control"
											placeholder="Enter transaction"
											value="<%=DataUtility.getStringData(dto.getTransaction())%>">
									</div>
									<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("transaction", request)%></font></br>

									<span class="pl-sm-5"><b>Quantity Orderd</b><span
										style="color: red;">*</span></span> </br>
									<div class="col-sm-12">
										<div class="input-group">
											<div class="input-group-prepend">
												<div class="input-group-text">
													<i class="fa fa-address-book grey-text"
														style="font-size: 1rem;"></i>
												</div>
											</div>
											<input type="number" name="quantity" class="form-control"
												placeholder="Enter quantity"
												value="<%=DataUtility.getStringData(dto.getQuantity())%>">
										</div>
										<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("quantity", request)%></font></br>



										<%
											if (id > 0) {
										%>
										<div class="text-center">

											<input type="submit" name="operation"
												class="btn btn-success btn-md" style="font-size: 17px"
												value="<%=CartCtl.OP_UPDATE%>"> <input type="submit"
												name="operation" class="btn btn-warning btn-md"
												style="font-size: 17px" value="<%=CartCtl.OP_CANCEL%>">
										</div>
										<%
											} else {
										%>
										<div class="text-center">

											<input type="submit" name="operation"
												class="btn btn-success btn-md" style="font-size: 17px"
												value="<%=CartCtl.OP_SAVE%>"> <input type="submit"
												name="operation" class="btn btn-warning btn-md"
												style="font-size: 17px" value="<%=CartCtl.OP_RESET%>">
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