<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.project_3.util.HTMLUtility"%>
<%@page import="in.co.rays.project_3.controller.ShopingCtl"%>
<%@page import="in.co.rays.project_3.util.ServletUtility"%>
<%@page import="in.co.rays.project_3.util.DataUtility"%>
<%@page import="in.co.rays.project_3.controller.ORSView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<title>Stock view</title>
</head>
<body class="p4">
	<div class="header">
		<%@include file="Header.jsp"%>
		<%@include file="calendar.jsp"%>
		<div>

			<main>
			<form action="<%=ORSView.STOCK_CTL%>" method="post">

				<div class="row pt-3 pb-4">
					<!-- Grid column -->
					<jsp:useBean id="dto" class="in.co.rays.project_3.dto.StockDTO"
						scope="request"></jsp:useBean>
					<div class="col-md-4 mb-4"></div>
					<div class="col-md-4 mb-4">
						<div class="card">
							<div class="card-body">
								<%
									long id = DataUtility.getLong(request.getParameter("id"));

									if (dto.getId() != null) {
								%>
								<h3 class="text-center text-primary">update Stock</h3>
								<%
									} else {
								%>
								<h3 class="text-center text-primary">Add Stock</h3>
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
									<span class="pl-sm-5"><b>Quantity</b><span
										style="color: red;">*</span></span> </br>
									<div class="col-sm-12">
										<div class="input-group">
											<div class="input-group-prepend">
												<div class="input-group-text">
													<i class="fa fa-university grey-text"
														style="font-size: 1rem;"></i>
												</div>
											</div>
											<input type="text" name="quantity" class="form-control"
												id="defaultForm-email" placeholder="Enter quantity"
												value="<%=DataUtility.getStringData(dto.getQuantity())%>">
										</div>
									</div>
									<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("quantity", request)%></font></br>



									<span class="pl-sm-5"><b>purchase price</b><span
										style="color: red;">*</span></span> </br>
									<div class="col-sm-12">
										<div class="input-group">
											<div class="input-group-prepend">
												<div class="input-group-text">
													<i class="fa fa-address-book grey-text"
														style="font-size: 1rem;"></i>
												</div>
											</div>
											<input type="text" name="purchasePrice" class="form-control"
												placeholder="Enter purchasePrice"
												value="<%=DataUtility.getStringData(dto.getPurchasePrice())%>">
										</div>
									</div>
									<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("purchasePrice", request)%></font></br>


							<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("category", request)%></font></br>
							<span class="pl-sm-5"><b>PurchaseDate</b> <span
								style="color: red;">*</span></span></br>
							<div class="col-sm-12">
								<div class="input-group">
									<div class="input-group-prepend">
										<div class="input-group-text">
											<i class="fa fa-calendar grey-text" style="font-size: 1rem;"></i>
										</div>
									</div>
									<input type="text" id="datepicker2" name="purchaseDate"
										class="form-control" placeholder="purchaseDate"
										readonly="readonly"
										value="<%=DataUtility.getDateString(dto.getPurchaseDate())%>">
								</div>
						<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("purchaseDate", request)%></font></br>
								
								
								<div class="md-form">
									<span class="pl-sm-5"><b>OrderType</b><span
										style="color: red;">*</span></span> </br>
									<div class="col-sm-12">
										<div class="input-group">
											<div class="input-group-prepend">
												<div class="input-group-text">
													<i class="fa fa-university grey-text"
														style="font-size: 1rem;"></i>
												</div>
											</div>
											<input type="text" name="orderType" class="form-control"
												id="defaultForm-email" placeholder="Enter orderType"
												value="<%=DataUtility.getStringData(dto.getQuantity())%>">
										</div>
									</div>
									<font color="red" class="pl-sm-5"> <%=ServletUtility.getErrorMessage("orderType", request)%></font></br>
							</div>
						</div>
						</br>
						<%
							if (id > 0) {
						%>
						<div class="text-center">

							<input type="submit" name="operation"
								class="btn btn-success btn-md" style="font-size: 17px"
								value="<%=ShopingCtl.OP_UPDATE%>"> <input type="submit"
								name="operation" class="btn btn-warning btn-md"
								style="font-size: 17px" value="<%=ShopingCtl.OP_CANCEL%>">
						</div>
						<%
							} else {
						%>
						<div class="text-center">

							<input type="submit" name="operation"
								class="btn btn-success btn-md" style="font-size: 17px"
								value="<%=ShopingCtl.OP_SAVE%>"> <input type="submit"
								name="operation" class="btn btn-warning btn-md"
								style="font-size: 17px" value="<%=ShopingCtl.OP_RESET%>">
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
</html>