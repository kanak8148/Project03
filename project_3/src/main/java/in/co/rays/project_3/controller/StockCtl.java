package in.co.rays.project_3.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.project_3.dto.BaseDTO;
import in.co.rays.project_3.dto.StockDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.ModelFactory;
import in.co.rays.project_3.model.StockModelInt;
import in.co.rays.project_3.util.DataUtility;
import in.co.rays.project_3.util.DataValidator;
import in.co.rays.project_3.util.PropertyReader;
import in.co.rays.project_3.util.ServletUtility;

@WebServlet(urlPatterns = { "/ctl/StockCtl" })

public class StockCtl extends BaseCtl{
	
	protected void preload(HttpServletRequest request) {
		StockModelInt model = ModelFactory.getInstance().getStockModel();

		
		Map<Integer , String>map =new HashMap<Integer, String>();
		map.put(1,"near");
		map.put(2,"along");
		request.setAttribute("prolist", map);
		
		Map<Integer , String>map1 =new HashMap<Integer, String>();
		map1.put(1,"good");
		map.put(2,"bad");
		request.setAttribute("prolist1", map1);
		
	}
	
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		if (DataValidator.isNull(request.getParameter("quantity"))) {
			request.setAttribute("quantity", PropertyReader.getValue("error.require", "quantity"));
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("quantity"))) {
			request.setAttribute("quantity", "quantity must contain alphabets only");
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("purchasePrice"))) {
			request.setAttribute("purchasePrice", PropertyReader.getValue("error.require", "purchasePrice"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("purchaseDate"))) {
			request.setAttribute("purchaseDate", PropertyReader.getValue("error.require", "purchaseDate"));
			pass = false;
		}
		if (DataValidator.isNull(request.getParameter("orderType"))) {
			request.setAttribute("orderType", PropertyReader.getValue("error.require", "orderType"));
			pass = false;

		}
		return pass;
	}

	protected BaseDTO populateDTO(HttpServletRequest request) {
		StockDTO dto = new StockDTO();
		dto.setQuantity(DataUtility.getInt(request.getParameter("quantity")));
		dto.setPurchasePrice(DataUtility.getDouble(request.getParameter("purchasePrice")));
		dto.setPurchaseDate(DataUtility.getDate(request.getParameter("purchaseDate")));
		dto.setOrderType(request.getParameter("orderType"));

		populateBean(dto, request);
		return dto;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String op = request.getParameter("operation");
		long id = DataUtility.getLong(request.getParameter("id"));
		StockModelInt model = ModelFactory.getInstance().getStockModel();
		if (id > 0 || op != null) {
			StockDTO dto;
			try {
				dto = model.findByPK(id);

				ServletUtility.setDto(dto, request);

			} catch (ApplicationException e) {

				ServletUtility.handleException(e, request, response);
				return;
			}

		}
		ServletUtility.forward(getView(), request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		System.out.println("in project dopost method");

		String op = request.getParameter("operation");
		long id = DataUtility.getLong(request.getParameter("id"));

		StockModelInt model = ModelFactory.getInstance().getStockModel();

		if (OP_SAVE.equalsIgnoreCase(op) || OP_UPDATE.equalsIgnoreCase(op)) {

			StockDTO dto = (StockDTO) populateDTO(request);

			try {
				if (id > 0) {
					dto.setId(id);
					model.update(dto);
					ServletUtility.setDto(dto, request);

					ServletUtility.setSuccessMessage("Record Successfully Updated", request);

				} else {
					System.out.println("college add" + dto + "id...." + id);
					// long pk
					model.add(dto);
					ServletUtility.setSuccessMessage("Record Successfully Saved", request);
				}
				ServletUtility.setDto(dto, request);
			} catch (ApplicationException e) {
				e.printStackTrace();

				ServletUtility.handleException(e, request, response);
				return;
			} catch (DuplicateRecordException e) {
				ServletUtility.setDto(dto, request);
				ServletUtility.setErrorMessage("ProductName Already Exists", request);
			}
		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.STOCK_CTL, request, response);
			return;
		} else if (OP_CANCEL.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.STOCK_LIST_CTL, request, response);
			return;

		}
		ServletUtility.forward(getView(), request, response);
	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.STOCK_VIEW;
	}
}





